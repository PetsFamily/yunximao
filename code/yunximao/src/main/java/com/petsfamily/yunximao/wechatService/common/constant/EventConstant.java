package com.petsfamily.yunximao.wechatService.common.constant;

public class EventConstant {
	/**订阅*/
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
	/**取消订阅*/
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	/**扫描二维码*/
	public static final String EVENT_TYPE_SCAN = "SCAN";
	/**上传位置*/
	public static final String EVENT_TYPE_LOCATION = "LOCATION";
	/**点击菜单拉取消息时的事件*/
	public static final String EVENT_TYPE_CLICK = "CLICK";
	/**点击菜单跳转链接时的事件*/
	public static final String EVENT_TYPE_VIEW = "VIEW";
	/**小程序-网页版客服工具进入会话事件*/
	public static final String KF_CREATE_SESSION = "kf_create_session";
	/**小程序-网页版客服工具退出会话事件*/
	public static final String KF_CLOSE_SESSION = "kf_close_session";
	/**小程序-网页版客服工具切换会话事件*/
	public static final String KF_SWITCH_SESSION = "kf_switch_session";
}
