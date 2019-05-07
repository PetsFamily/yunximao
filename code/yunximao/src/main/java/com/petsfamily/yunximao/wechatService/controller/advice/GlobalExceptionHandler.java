package com.petsfamily.yunximao.wechatService.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.petsfamily.yunximao.common.model.ResponseEntity;
import com.petsfamily.yunximao.common.util.ExceptionUtil;
@RestControllerAdvice
public class GlobalExceptionHandler {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity jsonErrorHandler(HttpServletRequest request,Exception e) throws Exception{
		logger.error(ExceptionUtil.getStackTrace(e));
		return ResponseEntity.buildFailly("业务异常");
    }
}
