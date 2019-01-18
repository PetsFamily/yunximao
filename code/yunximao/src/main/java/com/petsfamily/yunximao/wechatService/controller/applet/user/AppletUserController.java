package com.petsfamily.yunximao.wechatService.controller.applet.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.common.model.BaseController;
import com.petsfamily.yunximao.common.model.ResponseEntity;

@RestController
@RequestMapping("/applet")
public class AppletUserController extends BaseController{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value = "/createUser", method = {RequestMethod.POST })
	public ResponseEntity createUser(@RequestBody JSONObject dataJson) throws Exception {
		logger.debug(dataJson.toJSONString());
		return ResponseEntity.buildSuccessful();
	}
}
