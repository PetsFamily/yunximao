package com.petsfamily.yunximao.wechatService.controller.applet.music;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.common.model.BaseController;
import com.petsfamily.yunximao.common.model.ResponseEntity;
import com.petsfamily.yunximao.musicService.service.MusicService;

@RestController
@RequestMapping("/applet")
public class AppletMusicController extends BaseController{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private MusicService musicService;
	
	@RequestMapping(value = "/music/queryAllRecommend", method = {RequestMethod.POST })
	public ResponseEntity queryAllRecommend(@RequestBody JSONObject dataJson) throws Exception {
		return musicService.queryAllRecommend(dataJson);
	}
	
	@RequestMapping(value = "/music/queryAllMusicByPage", method = {RequestMethod.POST })
	public ResponseEntity queryMomentByPage(@RequestBody JSONObject dataJson) throws Exception {
		return musicService.queryAllMusicByPage(dataJson);
	}
	
	@RequestMapping(value = "/music/queryMyMusicByPage", method = {RequestMethod.POST })
	public ResponseEntity queryMyMusicByPage(@RequestBody JSONObject dataJson) throws Exception {
		return musicService.queryMyMusicByPage(dataJson);
	}
	
	@RequestMapping(value = "/music/collect", method = {RequestMethod.POST })
	public ResponseEntity collect(@RequestBody JSONObject dataJson) throws Exception {
		return musicService.collect(dataJson);
	}
	
	@RequestMapping(value = "/music/unCollect", method = {RequestMethod.POST })
	public ResponseEntity unCollect(@RequestBody JSONObject dataJson) throws Exception {
		return musicService.unCollect(dataJson);
	}
}
