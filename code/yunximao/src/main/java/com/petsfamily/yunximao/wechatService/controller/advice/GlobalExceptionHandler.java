package com.petsfamily.yunximao.wechatService.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.petsfamily.yunximao.common.model.ResponseEntity;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity jsonErrorHandler(HttpServletRequest request,Exception e) throws Exception{
        e.printStackTrace();
		return ResponseEntity.buildFailly("业务异常");
    }
}
