package com.petsfamily.yunximao.userService.mybatis.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface UserMapper {
	public JSONArray selectFriendsByPage(JSONObject parameter);
}
