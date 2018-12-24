package com.petsfamily.yunximao.wechatService.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.wechatService.common.model.ResponseEntity;


@RestController
@RequestMapping("/")
public class IndexController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/sayHi")
    public ResponseEntity sayHi() {
		return ResponseEntity.buildSuccessful();
    }
}
