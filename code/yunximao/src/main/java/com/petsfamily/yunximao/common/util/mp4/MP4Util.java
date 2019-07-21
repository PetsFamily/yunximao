package com.petsfamily.yunximao.common.util.mp4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.googlecode.mp4parser.authoring.container.mp4.MovieCreator;
import com.googlecode.mp4parser.authoring.tracks.AACTrackImpl;
import com.googlecode.mp4parser.authoring.tracks.CroppedTrack;

import ws.schild.jave.AudioAttributes;
import ws.schild.jave.AudioInfo;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.VideoAttributes;
import ws.schild.jave.VideoSize;

public class MP4Util {
	static Integer max = 10;
	/**
     * 裁剪视频
     * @param srcPath 需要裁剪的原视频路径
     * @param outPath 裁剪后的视频输出路径
     * @param startTimeMs 裁剪的起始时间
     * @param endTimeMs 裁剪的结束时间
     */
    public static boolean clip(Movie srcMovie, double startTime, double endTime){
        if (startTime >= endTime) {
            throw new IllegalArgumentException("the startTimeMs is larger than endTimeMs!!!!");
        }
        List<Track> tracks = srcMovie.getTracks();
        //移除旧的track
        srcMovie.setTracks(new LinkedList<Track>());
        //计算剪切时间，视频的采样间隔大，以视频为准
        for (Track track : tracks) {
            if (track.getSyncSamples() != null && track.getSyncSamples().length > 0) {
                startTime = correctTimeToSyncSample(track, startTime, false);
                endTime = correctTimeToSyncSample(track, endTime, true);
                if (track.getHandler().equals("vide")) {
                    break;
                }
            }
        }
        long currentSample;
        double currentTime;
        double lastTime;
        long startSample;
        long endSample;
        long delta;

        for (Track track : tracks) {
            currentSample = 0;
            currentTime = 0;
            lastTime = -1;
            startSample = -1;
            endSample = -1;
            //根据起始时间和截止时间获取起始sample和截止sample的位置
            for (int i = 0; i < track.getSampleDurations().length; i++) {
                delta = track.getSampleDurations()[i];
                if (currentTime > lastTime && currentTime <= startTime) {
                    startSample = currentSample;
                }
                if (currentTime > lastTime && currentTime <= endTime) {
                    endSample = currentSample;
                }
                lastTime = currentTime;
                currentTime += (double)delta / (double)track.getTrackMetaData().getTimescale();
                currentSample++;
            }
            if (startSample <= 0 && endSample <= 0) {
                throw new RuntimeException("clip failed !!");
            }
            srcMovie.addTrack(new CroppedTrack(track, startSample, endSample));// 添加截取的track
        }
        return true;
    }
	
	public static double getTracklength(Track track) {
		  double[] timeOfSyncSamples = new double[track.getSyncSamples().length];
          long currentSample = 0;
          double currentTime = 0;
          for (int i = 0; i < track.getSampleDurations().length; i++) {
              long delta = track.getSampleDurations()[i];
              if (Arrays.binarySearch(track.getSyncSamples(), currentSample + 1) >= 0) {
                  timeOfSyncSamples[Arrays.binarySearch(track.getSyncSamples(),
                          currentSample + 1)] = currentTime;
              }
              currentTime += (double) delta
                      / (double) track.getTrackMetaData().getTimescale();
              currentSample++;
          }
          return currentTime;
	 }
	 
	public static double correctTimeToSyncSample(Track track, double cutHere, boolean next) {
        double[] timeOfSyncSamples = new double[track.getSyncSamples().length];
        long currentSample = 0;
        double currentTime = 0;
        for (int i = 0; i < track.getSampleDurations().length; i++) {
            long delta = track.getSampleDurations()[i];
            int index = Arrays.binarySearch(track.getSyncSamples(), currentSample + 1);
            if (index >= 0) {
                timeOfSyncSamples[index] = currentTime;
            }
            currentTime += ((double)delta / (double)track.getTrackMetaData().getTimescale());
            currentSample++;
        }
        double previous = 0;
        for (double timeOfSyncSample : timeOfSyncSamples) {
            if (timeOfSyncSample > cutHere) {
                if (next) {
                    return timeOfSyncSample;
                } else {
                    return previous;
                }
            }
            previous = timeOfSyncSample;
        }
        return timeOfSyncSamples[timeOfSyncSamples.length - 1];
    }
	
	 public static boolean joinVideo(File mp4,File mp3,File outMap4) {
	        boolean result = false;
	        if (mp4 == null || mp4.length() <= 0 || mp3 == null || mp3.length() <= 0) {
	            throw new IllegalArgumentException();
	        }
	        try {
	            Movie mp4Movie = MovieCreator.build(mp4.getPath());
	            // 取出视频
	            Track mp4Track = null;
                for (Track t : mp4Movie.getTracks()) {
                    if (t.getHandler().equals("vide")) {
                    	mp4Track = t;
                    }
                }                
                // 取出音频
                AACTrackImpl aacTrack = new AACTrackImpl(new FileDataSourceImpl(mp3));
	            // 合并到最终的视频文件
	            Movie outMovie = new Movie();
	            if (mp4Track != null) {
	                outMovie.addTrack(mp4Track);
	            }
	            if (aacTrack != null) {
	                outMovie.addTrack(aacTrack);
	            }
	            MP4Util.clip(outMovie,0,MP4Util.getTracklength(mp4Track)>max?max:MP4Util.getTracklength(mp4Track));
	            Container mp4file = new DefaultMp4Builder().build(outMovie);
	            // 将文件输出
	            if (outMap4.exists() && outMap4.isFile()) {
	            	outMap4.delete();
	            }
	            FileChannel fc = new RandomAccessFile(outMap4, "rw").getChannel();
	            mp4file.writeContainer(fc);
	            fc.close();
	            result = true;
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
	 
	 public static VideoSize getVideoSize(File source) {
		 try {
			 File out = File.createTempFile(UUID.randomUUID().toString(),"mp4");
			 MultimediaObject multimediaObject = new MultimediaObject(source);
             VideoAttributes video = new VideoAttributes();
             video.setCodec("mpeg4");
             video.setBitRate(new Integer(800000));
             video.setFrameRate(new Integer(15));
             EncodingAttributes attrs = new EncodingAttributes();
             attrs.setFormat("mp4");
             attrs.setVideoAttributes(video);
             Encoder encoder = new Encoder();
             encoder.encode(multimediaObject, out, attrs);
             multimediaObject = new MultimediaObject(out);
             return multimediaObject.getInfo().getVideo().getSize();
		 }catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("文件压缩异常");
		}	
	 }
	 
	 
	 public static File getVideoThumbTemp(File source) {
		 try {
			  MultimediaObject multimediaObject  = new MultimediaObject(source);
			  File out = File.createTempFile(UUID.randomUUID().toString(),"png");
			  VideoAttributes video = new VideoAttributes();  
			  video.setCodec("png");//转图片
			  //int width = multimediaObject.getInfo().getVideo().getSize().getWidth();
			  //int height = multimediaObject.getInfo().getVideo().getSize().getHeight();
			  //int width = Integer.min(multimediaObject.getInfo().getVideo().getSize().getWidth(),multimediaObject.getInfo().getVideo().getSize().getHeight());
			  //int height = Integer.max(multimediaObject.getInfo().getVideo().getSize().getWidth(),multimediaObject.getInfo().getVideo().getSize().getHeight());
			  //VideoSize size = new VideoSize(width,height);
		      video.setSize(MP4Util.getVideoSize(source));  
		      EncodingAttributes attrs = new EncodingAttributes();  
		      attrs.setFormat("image2");//转图片  
		      attrs.setOffset(1f);//设置偏移位置，即开始转码位置（3秒）
		      attrs.setDuration(0.01f);//设置转码持续时间（1秒）  
		      attrs.setVideoAttributes(video);
		      Encoder encoder = new Encoder();  
		      encoder.encode(multimediaObject,out, attrs);  
		      return out;
		 }catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("文件压缩异常");
		}	
	 }
}
