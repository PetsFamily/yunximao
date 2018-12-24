package com.petsfamily.yunximao.wechatService.common.model;

/**
 * 返回参数对象
 * @author zhangxun
 *
 */
public class ResponseEntity {
	private ResponseEntity() {
		
	}
	public static String SUCCESS_CODE = "0000";
	public static String FAIL_CODE = "9999";
	
	public static String SUCCESS_MSG = "业务成功";
	public static String FAIL_MSG = "业务失败";
	
	private String code;
	private String msg;
	private Object data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public static ResponseEntity buildSuccessful() {
		ResponseEntity response = new ResponseEntity();
		response.setCode(SUCCESS_CODE);
		response.setMsg(SUCCESS_MSG);
		return response;
	}
	public static ResponseEntity buildSuccessful(Object data) {
		ResponseEntity response = new ResponseEntity();
		response.setCode(SUCCESS_CODE);
		response.setMsg(SUCCESS_MSG);
		response.setData(data);
		return response;
	}
	public static ResponseEntity buildFailly() {
		ResponseEntity response = new ResponseEntity();
		response.setCode(FAIL_CODE);
		response.setMsg(FAIL_MSG);
		return response;
	}
	
	
	
}
