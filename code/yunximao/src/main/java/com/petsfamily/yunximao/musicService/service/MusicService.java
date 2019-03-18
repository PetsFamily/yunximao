package com.petsfamily.yunximao.musicService.service;

import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.common.model.ResponseEntity;
import com.petsfamily.yunximao.musicService.mybatis.model.MusicInfo;

public interface MusicService {
	/**
	 * 查询所有推荐歌曲 推荐值排序
	 * @param dataJson
	 * @return
	 */
	public ResponseEntity queryAllRecommend(JSONObject dataJson);
	
	/**
	 * 查询歌曲列表（不包含推荐）
	 * @param 
	 * dataSize 已经返回的数据条数 第一页传0
	 * seach 查询条件
	 * @return
	 */
	public ResponseEntity queryAllMusicByPage(JSONObject dataJson);
	
	/**
	 * 查询关注歌曲列表（不包含推荐）
	 * @param 
	 * dataSize 已经返回的数据条数 第一页传0
	 * seach 查询条件
	 * @return
	 */
	public ResponseEntity queryMyMusicByPage(JSONObject dataJson);
	/**
	 * 取消收藏
	 * @param dataJson
	 * @return
	 */
	public ResponseEntity unCollect(JSONObject dataJson);
	/**
	 * 收藏音乐
	 * @param dataJson
	 * @return
	 */
	public ResponseEntity collect(JSONObject dataJson);
	
	public MusicInfo getMusicByCode(String code);
}
