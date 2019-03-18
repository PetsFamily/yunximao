package com.petsfamily.yunximao.musicService.mybatis.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface MusicMapper {
	public JSONArray selectAllRecommend(JSONObject parameter);
	
	public JSONArray selectAllMusicByPage(JSONObject parameter);
	
	public JSONArray selectMyMusicByPage(JSONObject parameter);
}
