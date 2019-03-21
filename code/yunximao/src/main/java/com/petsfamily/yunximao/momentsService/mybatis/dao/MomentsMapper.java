package com.petsfamily.yunximao.momentsService.mybatis.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsLikeLog;

public interface MomentsMapper {
	public JSONArray selectMomentListByPage(JSONObject parameter);
	
	public JSONArray selectCommentsListByPage(JSONObject parameter);
	
	public int addReadNum(String momentNumber);
	
	public int totalReadNum(String userNumber);
	
	public int addLikeNum(String momentNumber);
	
	public int addCommentsCount(String momentNumber);
	
	public int saveLikeLog(PetMomentsLikeLog likeLog);
	
	
}
