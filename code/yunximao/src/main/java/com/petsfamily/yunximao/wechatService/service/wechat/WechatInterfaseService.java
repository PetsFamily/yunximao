package com.petsfamily.yunximao.wechatService.service.wechat;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSONObject;

public interface WechatInterfaseService {
	public JSONObject getAccessToken() throws ClientProtocolException, IOException;
/**	{
	  "country": "中国",
	  "unionid": "ok6Kd5uBtnl96Xc7ZFhdMxDVKWVw",
	  "qr_scene": 0,
	  "subscribe": 1,
	  "city": "朝阳",
	  "openid": "oXnTp5hgBe7GOl3F4vdcXHJtSDzQ",
	  "tagid_list": [
	    
	  ],
	  "sex": 1,
	  "groupid": 0,
	  "language": "zh_CN",
	  "remark": "",
	  "subscribe_time": 1550036929,
	  "province": "北京",
	  "subscribe_scene": "ADD_SCENE_PROFILE_CARD",
	  "nickname": "鑫霖",
	  "headimgurl": "http://thirdwx.qlogo.cn/mmopen/OxUBpiaYgpHhngnwiaR1ibrs9u9Wk4jhH4z8roLGra8kLGg4Z3Bk7LicOSroMGib6UujkBwhGuHic46OPlcTBfyIU9zg/132",
	  "qr_scene_str": ""
	}*/
	public JSONObject getUserInfo(String openid) throws ClientProtocolException, IOException;
}
