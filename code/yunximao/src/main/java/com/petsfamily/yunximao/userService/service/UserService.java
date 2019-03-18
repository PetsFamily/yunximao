package com.petsfamily.yunximao.userService.service;
/**
 * 用户业务接口
 * 2019-02-19
 * @author zhangxun
 *
 */
import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.common.model.ResponseEntity;
import com.petsfamily.yunximao.userService.mybatis.model.UserInfo;

public interface UserService {
	/**
	 * 保存用户（新增或者更新）
	 * @param
	 * unionId
	 * openId
	 * nickName 微信昵称
	 * avatarUrl 微信头像
	 * gender 性别(男:1 女:2 未知:0)
	 * country 国家
	 * province 省/市
	 * city 区/县
	 * language 语言
	 * @return 用户信息
	 */
	public ResponseEntity createUserByWeChat(JSONObject dataJson);
	
	/**
	 * 修改用户信息
	 * type: userName gender birthday mobile email
	 * value
	 * token
	 * @return
	 */
	public ResponseEntity modifyUserInfo(JSONObject dataJson);
	
	/**
	 * 修改用户头像
	 * headImg
	 * @return
	 */
	public ResponseEntity modifyUserHeadImg(JSONObject dataJson);
	
	/**
	 * token
	 * @return
	 */
	public UserInfo getUserInfoByToken(String token);
	/**
	 * token
	 * @return
	 */
	public UserInfo getUserInfoByCode(String Code);
}
