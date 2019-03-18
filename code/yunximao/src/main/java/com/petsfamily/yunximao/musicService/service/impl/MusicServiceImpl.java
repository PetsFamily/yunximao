package com.petsfamily.yunximao.musicService.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.common.model.ResponseEntity;
import com.petsfamily.yunximao.common.util.PageUtil;
import com.petsfamily.yunximao.musicService.mybatis.dao.MusicCollectInfoMapper;
import com.petsfamily.yunximao.musicService.mybatis.dao.MusicInfoMapper;
import com.petsfamily.yunximao.musicService.mybatis.dao.MusicMapper;
import com.petsfamily.yunximao.musicService.mybatis.model.MusicCollectInfo;
import com.petsfamily.yunximao.musicService.mybatis.model.MusicCollectInfoExample;
import com.petsfamily.yunximao.musicService.mybatis.model.MusicInfo;
import com.petsfamily.yunximao.musicService.mybatis.model.MusicInfoExample;
import com.petsfamily.yunximao.musicService.service.MusicService;
import com.petsfamily.yunximao.userService.mybatis.model.UserInfo;
import com.petsfamily.yunximao.userService.service.UserService;
@Service
public class MusicServiceImpl implements MusicService {
	@Resource
	private MusicMapper musicMapper;
	@Resource
	private MusicInfoMapper musicInfoMapper;
	@Resource
	private MusicCollectInfoMapper collectInfoMapper;
	@Resource
	private UserService userService;
	
	@Override
	public ResponseEntity queryAllRecommend(JSONObject dataJson) {
		return ResponseEntity.buildSuccessful(musicMapper.selectAllRecommend(null));
	}

	@Override
	public ResponseEntity queryAllMusicByPage(JSONObject dataJson) {
		String dataSize = dataJson.getString("dataSize");
		String seach = dataJson.getString("seach");
		if(StringUtils.isBlank(dataSize)||!StringUtils.isNumeric(dataSize)) {
			dataSize = "0";
		}
		JSONObject parameter = new JSONObject();
		parameter.put("seach",seach);
		parameter.put("offset", PageUtil.getOffset(Integer.valueOf(dataSize)));
		parameter.put("limit", PageUtil.getLimit(Integer.valueOf(dataSize)));
		return ResponseEntity.buildSuccessful(musicMapper.selectAllMusicByPage(parameter));
	}

	@Override
	public ResponseEntity queryMyMusicByPage(JSONObject dataJson) {
		String dataSize = dataJson.getString("dataSize");
		String seach = dataJson.getString("seach");
		if(StringUtils.isBlank(dataSize)||!StringUtils.isNumeric(dataSize)) {
			dataSize = "0";
		}
		JSONObject parameter = new JSONObject();
		parameter.put("seach",seach);
		parameter.put("offset", PageUtil.getOffset(Integer.valueOf(dataSize)));
		parameter.put("limit", PageUtil.getLimit(Integer.valueOf(dataSize)));
		return ResponseEntity.buildSuccessful(musicMapper.selectMyMusicByPage(parameter));
	}

	@Override
	@Transactional(rollbackFor={Throwable.class,RuntimeException.class} ,propagation=Propagation.REQUIRED)
	public ResponseEntity unCollect(JSONObject dataJson) {
		String music = dataJson.getString("music");
		String token = dataJson.getString("token");//预留埋点
		if(StringUtils.isBlank(music)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		if(StringUtils.isBlank(token)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		UserInfo user = userService.getUserInfoByToken(token);
		if(user==null) {
			return ResponseEntity.buildFailly("数据错误");
		}else {
			MusicCollectInfoExample example = new MusicCollectInfoExample();
			example.createCriteria()
					.andIsDeleteEqualTo(0)
					.andUserNumberEqualTo(user.getUserNumber())
					.andMusicNumberEqualTo(music);
			MusicCollectInfo record = new MusicCollectInfo();
			record.setIsDelete(1);
			record.setUpdateUser(user.getUserNumber());
			record.setUpdateDate(new Date());
			collectInfoMapper.updateByExampleSelective(record, example);
			return ResponseEntity.buildSuccessful(music);
		}
	}

	@Override
	@Transactional(rollbackFor={Throwable.class,RuntimeException.class} ,propagation=Propagation.REQUIRED)
	public ResponseEntity collect(JSONObject dataJson) {
		String music = dataJson.getString("music");
		String token = dataJson.getString("token");//预留埋点
		if(StringUtils.isBlank(music)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		if(StringUtils.isBlank(token)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		UserInfo user = userService.getUserInfoByToken(token);
		if(user==null) {
			return ResponseEntity.buildFailly("数据错误");
		}else {
			MusicCollectInfoExample example = new MusicCollectInfoExample();
			example.createCriteria()
					.andIsDeleteEqualTo(0)
					.andUserNumberEqualTo(user.getUserNumber())
					.andMusicNumberEqualTo(music);
			if(collectInfoMapper.countByExample(example)>0) {//没有收藏过
				return ResponseEntity.buildSuccessful(music);
			}else {
				MusicCollectInfo record = new MusicCollectInfo();
				record.setMusicNumber(music);
				record.setUserNumber(user.getUserNumber());
				record.setIsDelete(0);
				record.setCreateUser(user.getUserNumber());
				record.setCreateDate(new Date());
				collectInfoMapper.insert(record);
				return ResponseEntity.buildSuccessful(music);
			}
		}
	}

	@Override
	public MusicInfo getMusicByCode(String code) {
		if(StringUtils.isBlank(code)) {
			return null;
		}
		MusicInfoExample example = new MusicInfoExample();
		example.createCriteria().andIsDeleteEqualTo(0).andMusicNumberEqualTo(code);
		List<MusicInfo> musicInfos = musicInfoMapper.selectByExample(example);
		if(musicInfos.isEmpty()) {
			return null;
		}else {
			return musicInfos.get(0);
		}
	}

}
