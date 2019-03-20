package com.petsfamily.yunximao.momentsService.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.common.model.ResponseEntity;
import com.petsfamily.yunximao.common.util.ContentAuditUtil;
import com.petsfamily.yunximao.common.util.FileUtil;
import com.petsfamily.yunximao.common.util.PageUtil;
import com.petsfamily.yunximao.common.util.mp4.MP4Util;
import com.petsfamily.yunximao.momentsService.mybatis.dao.MomentsMapper;
import com.petsfamily.yunximao.momentsService.mybatis.dao.PetMomentsCommentsInfoMapper;
import com.petsfamily.yunximao.momentsService.mybatis.dao.PetMomentsInfoMapper;
import com.petsfamily.yunximao.momentsService.mybatis.dao.PetMomentsLikeLogMapper;
import com.petsfamily.yunximao.momentsService.mybatis.dao.PetMomentsReadLogMapper;
import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsCommentsInfo;
import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsInfo;
import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsInfoExample;
import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsLikeLog;
import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsLikeLogExample;
import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsReadLog;
import com.petsfamily.yunximao.momentsService.service.MomentsService;
import com.petsfamily.yunximao.musicService.service.MusicService;
import com.petsfamily.yunximao.userService.mybatis.model.UserInfo;
import com.petsfamily.yunximao.userService.service.UserService;
@Service
public class MomentsServiceImpl implements MomentsService {
	@Resource
	private MomentsMapper momentsMapper;
	@Resource
	private PetMomentsInfoMapper momentsInfoMapper;
	@Resource
	private PetMomentsReadLogMapper readLogMapper;
	@Resource
	private PetMomentsLikeLogMapper likeLogMapper;
	@Resource
	private PetMomentsCommentsInfoMapper commentsInfoMapper;
	@Resource
	private UserService userService;
	@Resource
	private MusicService musicService;
	@Resource
	private FileUtil fileUtil;
	@Resource
	private ContentAuditUtil audit;
	
	@Override
	@Transactional(readOnly=true)
	public ResponseEntity queryMomentList(JSONObject dataJson) {
		String dataSize = dataJson.getString("dataSize");
		String seach = dataJson.getString("seach");
		String tag = dataJson.getString("tag");//预留字段
		String token = dataJson.getString("token");//预留埋点
		if(StringUtils.isBlank(dataSize)||!StringUtils.isNumeric(dataSize)) {
			dataSize = "0";
		}
		JSONObject parameter = new JSONObject();
		if(StringUtils.isNotBlank(token)) {
			UserInfo user = userService.getUserInfoByToken(token);
			if(user!=null) {
				parameter.put("userNumber",user.getUserNumber());
			}else {
				parameter.put("userNumber","none");
			}
		}else {
			parameter.put("userNumber","none");
		}
		parameter.put("seach",seach);
		parameter.put("offset", PageUtil.getOffset(Integer.valueOf(dataSize)));
		parameter.put("limit", PageUtil.getLimit(Integer.valueOf(dataSize)));
		return ResponseEntity.buildSuccessful(momentsMapper.selectMomentListByPage(parameter));
	}
	
	@Override
	@Transactional(readOnly=true)
	public ResponseEntity queryCommentsList(JSONObject dataJson) {
		String dataSize = dataJson.getString("dataSize");
		String momentNumber = dataJson.getString("momentNumber");
		if(StringUtils.isBlank(dataSize)||!StringUtils.isNumeric(dataSize)) {
			dataSize = "0";
		}
		JSONObject parameter = new JSONObject();
		parameter.put("momentNumber",momentNumber);
		parameter.put("offset", PageUtil.getOffset(Integer.valueOf(dataSize)));
		parameter.put("limit", PageUtil.getLimit(Integer.valueOf(dataSize)));
		return ResponseEntity.buildSuccessful(momentsMapper.selectCommentsListByPage(parameter));
	}
	
	@Override
	@Transactional(readOnly=true)
	public ResponseEntity queryMomentInfo(JSONObject dataJson) {
		String token = dataJson.getString("token");//预留埋点
		String momentNumber = dataJson.getString("momentNumber");
		if(StringUtils.isBlank(momentNumber)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		PetMomentsInfoExample momentsInfoExample = new PetMomentsInfoExample();
		momentsInfoExample.createCriteria().andIsDeleteEqualTo(0).andMomentNumberEqualTo(momentNumber);
		List<PetMomentsInfo> momentsInfos = momentsInfoMapper.selectByExample(momentsInfoExample);	
		if(momentsInfos.isEmpty()) {
			return ResponseEntity.buildFailly("数据错误");
		}else {
			PetMomentsInfo momentsInfo = momentsInfos.get(0);
			UserInfo userInfo = userService.getUserInfoByCode(momentsInfo.getUserNumber());
			JSONObject data = new JSONObject();
			data.put("moments",JSON.toJSON(momentsInfo));
			data.put("publisher",JSON.toJSON(userInfo));
			if(StringUtils.isNotBlank(token)) {
				UserInfo reader = userService.getUserInfoByToken(token);
				if(reader!=null) {
					data.put("isLike",this.isLike(momentNumber,reader.getUserNumber()));
				}else {
					data.put("isLike",false);
				}
			}else {
				data.put("isLike",false);
			}
			return ResponseEntity.buildSuccessful(data);
		}
	}
	
	@Override
	@Transactional(rollbackFor={Throwable.class,RuntimeException.class} ,propagation=Propagation.REQUIRED)
	public ResponseEntity readMoment(JSONObject dataJson) {
		String token = dataJson.getString("token");//预留埋点
		String momentNumber = dataJson.getString("momentNumber");
		if(StringUtils.isBlank(momentNumber)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		UserInfo user = null;
		if(StringUtils.isNotBlank(token)) {
			user  = userService.getUserInfoByToken(token);
			if(user==null) {
				return ResponseEntity.buildFailly("数据错误");
			}
		}
		PetMomentsReadLog log = new PetMomentsReadLog();
		log.setIsDelete(0);
		if(user!=null) {
			log.setCreateUser(user.getUserNumber());
			log.setUserNumber(user.getUserNumber());
		}else {
			log.setCreateUser("");
			log.setUserNumber(null);
		}
		log.setCreateDate(new Date());
		log.setMomentNumber(momentNumber);
		readLogMapper.insert(log);
		momentsMapper.addReadNum(momentNumber);
		return ResponseEntity.buildSuccessful();
	}
	
	@Override
	@Transactional(rollbackFor={Throwable.class,RuntimeException.class} ,propagation=Propagation.REQUIRED)
	public ResponseEntity likeMoment(JSONObject dataJson) {
		String token = dataJson.getString("token");//预留埋点
		String momentNumber = dataJson.getString("momentNumber");
		if(StringUtils.isBlank(momentNumber)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		if(StringUtils.isBlank(token)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		UserInfo user = userService.getUserInfoByToken(token);
		if(user==null) {
			return ResponseEntity.buildFailly("数据错误");
		}else {
			PetMomentsLikeLog log = new PetMomentsLikeLog();
			log.setIsDelete(0);
			log.setCreateUser(user.getUserNumber());
			log.setCreateDate(new Date());
			log.setUserNumber(user.getUserNumber());
			log.setMomentNumber(momentNumber);
			int count = momentsMapper.saveLikeLog(log);
			if(count==1) {
				momentsMapper.addLikeNum(momentNumber);
			}
			return ResponseEntity.buildSuccessful();
		}
	}
	
	@Override
	@Transactional(rollbackFor={Throwable.class,RuntimeException.class} ,propagation=Propagation.REQUIRED)
	public ResponseEntity submitComments(JSONObject dataJson) {
		String token = dataJson.getString("token");//预留埋点
		String momentNumber = dataJson.getString("momentNumber");
		String comments = dataJson.getString("comments");
		if(StringUtils.isBlank(momentNumber)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		if(StringUtils.isBlank(token)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		if(StringUtils.isBlank(comments)) {
			return ResponseEntity.buildFailly("参数错误");
		}else {
			if(comments.length()>280) {//前端140  后端放宽些  考虑到表情
				return ResponseEntity.buildFailly("评论超长");
			}
		}
		UserInfo user = userService.getUserInfoByToken(token);
		if(user==null) {
			return ResponseEntity.buildFailly("数据错误");
		}else {
			if(audit.auditText(comments)) {
				PetMomentsCommentsInfo commentsInfo = new PetMomentsCommentsInfo();
				commentsInfo.setIsDelete(0);
				commentsInfo.setCreateUser(user.getUserNumber());
				commentsInfo.setCreateDate(new Date());
				commentsInfo.setUserNumber(user.getUserNumber());
				commentsInfo.setMomentNumber(momentNumber);
				commentsInfo.setCommentNumber(null);
				commentsInfo.setCommentContent(comments);
				commentsInfoMapper.insert(commentsInfo);
				commentsInfo.setCommentNumber(getCommentNumber(commentsInfo.getSeqId()));
				commentsInfoMapper.updateByPrimaryKeySelective(commentsInfo);
				momentsMapper.addCommentsCount(momentNumber);
				return ResponseEntity.buildSuccessful();
			}else {
				return ResponseEntity.buildFailly("输入内容有违规情况");
			}
		}
	}

	
	@Override
	public ResponseEntity queryHotKeyWord(JSONObject dataJson) {
		JSONArray datas = new JSONArray();
		JSONObject 大橘为重 = new JSONObject();
		大橘为重.put("text","大橘为重");
		JSONObject 瓜子蛇精脸 = new JSONObject();
		瓜子蛇精脸.put("text","瓜子蛇精脸");
		JSONObject 包子脸 = new JSONObject();
		包子脸.put("text","包子脸");
		JSONObject 蓝精灵 = new JSONObject();
		蓝精灵.put("text","蓝精灵");
		JSONObject 黑煤球 = new JSONObject();
		黑煤球.put("text","黑煤球");
		JSONObject 纯血贵族 = new JSONObject();
		纯血贵族.put("text","纯血贵族");
		JSONObject 白雪公主 = new JSONObject();
		白雪公主.put("text","白雪公主");
		JSONObject 小肥脸 = new JSONObject();
		小肥脸.put("text","小肥脸");
		JSONObject 飘逸长发 = new JSONObject();
		飘逸长发.put("text","飘逸长发");
		JSONObject 呆萌小宝贝 = new JSONObject();
		呆萌小宝贝.put("text","呆萌小宝贝");
		JSONObject 小主子 = new JSONObject();
		小主子.put("text","小主子");
		
		
		datas.add(大橘为重);
		datas.add(瓜子蛇精脸);
		datas.add(包子脸);
		datas.add(蓝精灵);
		datas.add(黑煤球);
		datas.add(纯血贵族);
		datas.add(白雪公主);
		datas.add(小肥脸);
		datas.add(飘逸长发);
		datas.add(呆萌小宝贝);
		datas.add(小主子);
		return ResponseEntity.buildSuccessful(datas);
	}

	@Override
	@Transactional(rollbackFor={Throwable.class,RuntimeException.class} ,propagation=Propagation.REQUIRED)
	public ResponseEntity submitPic(JSONObject dataJson) {
		String token = dataJson.getString("token");
		MultipartFile file = dataJson.getObject("file",MultipartFile.class);
		String title = dataJson.getString("title");
		String keyWord = dataJson.getString("keyWord");
		if(StringUtils.isBlank(token)) {
			return ResponseEntity.buildFailly("token不能为空");
		}
		if(file==null) {
			return ResponseEntity.buildFailly("请求数据不完整");
		}
		if(StringUtils.isNotBlank(keyWord)&&keyWord.indexOf("#")<0) {
			return ResponseEntity.buildFailly("请求数据格式错误");
		}
		UserInfo user = userService.getUserInfoByToken(token);
		if(user==null) {
			return ResponseEntity.buildFailly("用户信息非法");
		}
		if(user.getStatus()!=1) {
			return ResponseEntity.buildFailly("用户状态异常");
		}
		
		if(!audit.auditText(title)) {
			return ResponseEntity.buildFailly("输入内容有违规情况");
		}
		
		PetMomentsInfo moments = new PetMomentsInfo();
		moments.setIsPass(-1);//初始化 未知
		moments.setIsDelete(0);
		moments.setCreateUser(user.getUserNumber());
		moments.setCreateDate(new Date());
		moments.setUserNumber(user.getUserNumber());
		moments.setPetNumber(null);//预留
		moments.setMomentNumber(null);//瞬间编号
		moments.setMomentType(2);//图片
		moments.setMomentTitle(title);
		moments.setMomentContent(null);
		moments.setKeyWord(keyWord);//关键字
		moments.setFavoritesCount(0);
		moments.setReadCount(0);
		moments.setLikeCount(0);
		moments.setCommentsCount(0);
		momentsInfoMapper.insert(moments);
		moments.setMomentNumber(getMomentNumber(moments.getSeqId()));
		
		String module = "moments/pic";
		String name = moments.getMomentNumber() +"."+ file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-1];
		String url = "";
		try {
			url = fileUtil.saveByAliOSS(module+"/"+name,file.getInputStream());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("文件上传失败");
		}

		JSONObject auditRtn = audit.auditImage(moments.getMomentNumber(), url);
		
		if(auditRtn!=null) {
			if("pass".equals(auditRtn.getString("suggestion"))) {
				moments.setIsPass(1);
				moments.setTaskId(auditRtn.getString("taskId"));
				moments.setMomentContent(url);
				momentsInfoMapper.updateByPrimaryKeySelective(moments);
			}else {
				moments.setIsPass(0);
				moments.setTaskId(auditRtn.getString("taskId"));
				moments.setMomentContent(url);
				momentsInfoMapper.updateByPrimaryKeySelective(moments);
			}
		}else {
			throw new RuntimeException("文件校验异常");
		}
		return ResponseEntity.buildSuccessful(null);
	}

	@Override
	@Transactional(rollbackFor={Throwable.class,RuntimeException.class} ,propagation=Propagation.REQUIRED)
	public ResponseEntity submitVideoPic(JSONObject dataJson) {
		
		String token = dataJson.getString("token");
		MultipartFile file = dataJson.getObject("file",MultipartFile.class);
		String title = dataJson.getString("title");
		String keyWord = dataJson.getString("keyWord");
		if(StringUtils.isBlank(token)) {
			return ResponseEntity.buildFailly("token不能为空");
		}
		if(file==null) {
			return ResponseEntity.buildFailly("请求数据不完整");
		}
		if(StringUtils.isNotBlank(keyWord)&&keyWord.indexOf("#")<0) {
			return ResponseEntity.buildFailly("请求数据格式错误");
		}
		UserInfo user = userService.getUserInfoByToken(token);
		if(user==null) {
			return ResponseEntity.buildFailly("用户信息非法");
		}
		if(user.getStatus()!=1) {
			return ResponseEntity.buildFailly("用户状态异常");
		}
		
		if(!audit.auditText(title)) {
			return ResponseEntity.buildFailly("输入内容有违规情况");
		}
	
		PetMomentsInfo moments = new PetMomentsInfo();
		moments.setIsDelete(0);
		moments.setIsPass(-1);//初始化 未知
		moments.setCreateUser(user.getUserNumber());
		moments.setCreateDate(new Date());
		moments.setUserNumber(user.getUserNumber());
		moments.setPetNumber(null);//预留
		moments.setMomentNumber(null);//瞬间编号
		moments.setMomentType(3);//视频
		moments.setMomentTitle(title);
		moments.setMomentContent(null);
		moments.setKeyWord(keyWord);//关键字
		moments.setFavoritesCount(0);
		moments.setReadCount(0);
		moments.setLikeCount(0);
		moments.setCommentsCount(0);
		momentsInfoMapper.insert(moments);
		moments.setMomentNumber(getMomentNumber(moments.getSeqId()));
		
		String module = "moments/video";
		String name = moments.getMomentNumber() +"_pic."+ file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-1];
	
		String url = "";
		try {
			url = fileUtil.saveByAliOSS(module+"/"+name,file.getInputStream());
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("文件上传失败");
		}
		moments.setMomentContent(url);
		momentsInfoMapper.updateByPrimaryKeySelective(moments);
		return ResponseEntity.buildSuccessful(moments.getMomentNumber());
	}

	@Override
	@Transactional(rollbackFor={Throwable.class,RuntimeException.class} ,propagation=Propagation.REQUIRED)
	public ResponseEntity submitVideo(JSONObject dataJson) {
		try {
			String token = dataJson.getString("token");
			MultipartFile file = dataJson.getObject("file",MultipartFile.class);
			String music = dataJson.getString("music");
			String title = dataJson.getString("title");
			String keyWord = dataJson.getString("keyWord");
			if(StringUtils.isBlank(token)) {
				return ResponseEntity.buildFailly("token不能为空");
			}
			if(file==null) {
				return ResponseEntity.buildFailly("请求数据不完整");
			}
			UserInfo user = userService.getUserInfoByToken(token);
			if(user==null) {
				return ResponseEntity.buildFailly("用户信息非法");
			}
			if(user.getStatus()!=1) {
				return ResponseEntity.buildFailly("用户状态异常");
			}
			
			if(!audit.auditText(title)) {
				return ResponseEntity.buildFailly("输入内容有违规情况");
			}
			
			PetMomentsInfo moment = new PetMomentsInfo();
			moment.setIsDelete(0);
			moment.setIsPass(-1);//初始化 未知
			moment.setCreateUser(user.getUserNumber());
			moment.setCreateDate(new Date());
			moment.setUserNumber(user.getUserNumber());
			moment.setPetNumber(null);//预留
			moment.setMomentNumber(null);//瞬间编号
			moment.setMomentType(3);//视频
			moment.setMomentTitle(title);
			moment.setMomentContent(null);
			moment.setKeyWord(keyWord);//关键字
			moment.setFavoritesCount(0);
			moment.setReadCount(0);
			moment.setLikeCount(0);
			moment.setCommentsCount(0);
			momentsInfoMapper.insert(moment);
			moment.setMomentNumber(getMomentNumber(moment.getSeqId()));
			
			File source = File.createTempFile(UUID.randomUUID().toString(),file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-1]);
			file.transferTo(source);
			
			
			String module = "moments/video";
			String name = moment.getMomentNumber() +"."+ file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-1];
			
			if(StringUtils.isNotBlank(music)&&"mp4".equals(name.split("\\.")[1].toLowerCase())) {//有背景音乐 且 视频格式为MP4 则合成 
				//合成视频
				File mp3 = fileUtil.getByAliOSS("music/"+music+".aac");
			    File mp4 = MP4Util.getCompressVideo(source);
			    File outMap4 = File.createTempFile(moment.getMomentNumber(),"mp4");
			    MP4Util.joinVideo(mp4, mp3, outMap4);
			    String  outUrl = "";
			    outUrl = fileUtil.saveByAliOSS(module+"/"+name, new FileInputStream(outMap4));
			    if(StringUtils.isBlank(outUrl)) {
					throw new RuntimeException("文件上传失败");
				}
			    moment.setMomentVideo(outUrl);
			    JSONObject auditRtn = audit.auditVideo(moment.getMomentNumber(), outUrl);
			    if(auditRtn!=null) {
			    	String ImgName = moment.getMomentNumber() +"_pic.png";
			    	String ImgUrl = "";
					try {
						ImgUrl = fileUtil.saveByAliOSS(module+"/"+ImgName,new FileInputStream(MP4Util.getVideoThumbTemp(outMap4)));
					}catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException("文件上传失败");
					}
					moment.setMomentContent(ImgUrl);
					moment.setTaskId(auditRtn.getString("taskId"));
					if(200 != auditRtn.getInteger("code")) {//同步失败 直接 认定 不通过
						moment.setIsPass(0);
					}
					momentsInfoMapper.updateByPrimaryKeySelective(moment);
				}else {
					throw new RuntimeException("文件校验异常");
				}
				return ResponseEntity.buildSuccessful(null);
			    
			}else {
				String url = "";
				File out = source;
				if("mp4".equals(name.split("\\.")[1].toLowerCase())) {
					out = MP4Util.getCompressVideo(source);
					try {
						url = fileUtil.saveByAliOSS(module+"/"+name,new FileInputStream(out));
					}catch (Exception e) {
						throw new RuntimeException("文件上传失败");
					}
				}else {
					try {
						url = fileUtil.saveByAliOSS(module+"/"+name,new FileInputStream(source));
					}catch (Exception e) {
						throw new RuntimeException("文件上传失败");
					}
				}				
				JSONObject auditRtn = audit.auditVideo(moment.getMomentNumber(), url);
				if(auditRtn!=null) {
					String ImgName = moment.getMomentNumber() +"_pic.png";
			    	String ImgUrl = "";
					try {
						ImgUrl = fileUtil.saveByAliOSS(module+"/"+ImgName,new FileInputStream(MP4Util.getVideoThumbTemp(out)));
					}catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException("文件上传失败");
					}
					moment.setMomentContent(ImgUrl);
					moment.setMomentVideo(url);
					moment.setTaskId(auditRtn.getString("taskId"));
					if(200 != auditRtn.getInteger("code")) {//同步失败 直接 认定 不通过
						moment.setIsPass(0);
					}
					momentsInfoMapper.updateByPrimaryKeySelective(moment);
				}else {
					throw new RuntimeException("文件校验异常");
				}
				return ResponseEntity.buildSuccessful(null);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private PetMomentsInfo getMomentsInfoByCode(String momentCode) {
		if(StringUtils.isBlank(momentCode)) {
			return null;
		}else {
			PetMomentsInfoExample example = new PetMomentsInfoExample();
			example.createCriteria().andIsDeleteEqualTo(0).andMomentNumberEqualTo(momentCode);
			List<PetMomentsInfo> momentsInfos =  momentsInfoMapper.selectByExample(example);
			if(momentsInfos.isEmpty()) {
				return null;
			}else {
				return momentsInfos.get(0);
			}
		}
	}
	
	private boolean isLike(String momentCode,String userCode) {
		if(StringUtils.isBlank(momentCode)) {
			return false;
		}
		if(StringUtils.isBlank(userCode)) {
			return false;
		}
		PetMomentsLikeLogExample example = new PetMomentsLikeLogExample();
		example.createCriteria().andIsDeleteEqualTo(0).andMomentNumberEqualTo(momentCode).andUserNumberEqualTo(userCode);
		if(likeLogMapper.countByExample(example)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	private String getMomentNumber(Integer Id) {
		String IdStr = Id.toString();
		DateFormat dFormat = new SimpleDateFormat("yyyyMMdd");
		if(IdStr.length()<6){
			return "MN"+dFormat.format(new Date())+String.format("%010d",Id);
		}else if(IdStr.length()==6){
			return "MN"+dFormat.format(new Date())+IdStr;
		}else{
			return "MN"+dFormat.format(new Date())+IdStr.substring(IdStr.length()-6);
		}
	}
	
	private String getCommentNumber(Integer Id) {
		String IdStr = Id.toString();
		DateFormat dFormat = new SimpleDateFormat("yyyyMMdd");
		if(IdStr.length()<6){
			return "MCN"+dFormat.format(new Date())+String.format("%010d",Id);
		}else if(IdStr.length()==6){
			return "MCN"+dFormat.format(new Date())+IdStr;
		}else{
			return "MCN"+dFormat.format(new Date())+IdStr.substring(IdStr.length()-6);
		}
	}

	@Override
	public ResponseEntity reAuditVideo(JSONObject dataJson) {
		PetMomentsInfoExample example = new PetMomentsInfoExample();
		example.createCriteria().andIsDeleteEqualTo(0).andIsPassEqualTo(-1).andTaskIdIsNotNull();
		List<PetMomentsInfo> momentsInfos = momentsInfoMapper.selectByExample(example);
		for (PetMomentsInfo petMomentsInfo : momentsInfos) {
			 JSONObject rtn = audit.getVideoAuditRtn(petMomentsInfo.getTaskId());
			 if(rtn.getInteger("code")==200) {
				 JSONArray datas = rtn.getJSONArray("data");
				 for (Object data : datas) {
					 JSONArray audioScanResults = ((JSONObject)data).getJSONArray("audioScanResults");
					 JSONArray results = ((JSONObject)data).getJSONArray("results");
					 if(audioScanResults==null&&results==null) {
						 return ResponseEntity.buildFailly("处理中");
					 }
					 boolean audioPass = false;
					 boolean pass = false;
					 if(audioScanResults==null) {
						 audioPass = true;
					 }else {
						 for (Object audioScanResult : audioScanResults) {
							 if("pass".equals(((JSONObject)audioScanResult).getString("suggestion"))){
								 audioPass = true;
							 }
						 }
					 }
					 for (Object result : results) {
						 if("pass".equals(((JSONObject)result).getString("suggestion"))){
							 pass = true;
						 }
					 }
					 if(audioPass&&pass) {
						 petMomentsInfo.setIsPass(1);
						 petMomentsInfo.setUpdateDate(new Date());
						 momentsInfoMapper.updateByPrimaryKeySelective(petMomentsInfo);
					 }else {
						 petMomentsInfo.setIsPass(0);
						 petMomentsInfo.setUpdateDate(new Date());
						 momentsInfoMapper.updateByPrimaryKeySelective(petMomentsInfo);
					 }
				}
			 }
		}
		return ResponseEntity.buildSuccessful();
	}

	@Override
	@Transactional(rollbackFor={Throwable.class,RuntimeException.class} ,propagation=Propagation.REQUIRED)
	public void callbackAuditVideo(JSONObject dataJson) {
		String content = dataJson.getString("content");
		if(StringUtils.isBlank(content)) {
			throw new RuntimeException("请求数据错误");
		}
		JSONObject contentJson = JSON.parseObject(content);
		if(contentJson.getInteger("code")==200) {
			String dataId = contentJson.getString("dataId");
			String taskId = contentJson.getString("taskId");
			PetMomentsInfoExample example = new PetMomentsInfoExample();
			example.createCriteria().andIsDeleteEqualTo(0).andTaskIdEqualTo(taskId).andMomentNumberEqualTo(dataId);
			List<PetMomentsInfo> list = momentsInfoMapper.selectByExample(example);
			if(list.isEmpty()) {
				throw new RuntimeException("数据异常");
			}else{
				PetMomentsInfo	info = list.get(0);
				
				JSONArray audioScanResults = contentJson.getJSONArray("audioScanResults");
				 JSONArray results = contentJson.getJSONArray("results");
				 if(audioScanResults==null&&results==null) {
					 throw new RuntimeException("处理中");
				 }
				 boolean audioPass = false;
				 boolean pass = false;
				 if(audioScanResults==null) {
					 audioPass = true;
				 }else {
					 for (Object audioScanResult : audioScanResults) {
						 if("pass".equals(((JSONObject)audioScanResult).getString("suggestion"))){
							 audioPass = true;
						 }
					 }
				 }
				 for (Object result : results) {
					 if("pass".equals(((JSONObject)result).getString("suggestion"))){
						 pass = true;
					 }
				 }
				 if(audioPass&&pass) {
					 info.setIsPass(1);
					 info.setUpdateDate(new Date());
					 momentsInfoMapper.updateByPrimaryKeySelective(info);
				 }else {
					 info.setIsPass(0);
					 info.setUpdateDate(new Date());
					 momentsInfoMapper.updateByPrimaryKeySelective(info);
				 }
			}
		}else {
			throw new RuntimeException("审核结果异常");
		}
	}
}
