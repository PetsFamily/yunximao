package com.petsfamily.yunximao.userService.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.client.UserTokenHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.common.model.ResponseEntity;
import com.petsfamily.yunximao.common.util.DateTimeUtil;
import com.petsfamily.yunximao.userService.mybatis.dao.UserFriendInfoMapper;
import com.petsfamily.yunximao.userService.mybatis.dao.UserInfoMapper;
import com.petsfamily.yunximao.userService.mybatis.dao.UserTokenInfoMapper;
import com.petsfamily.yunximao.userService.mybatis.dao.WechatInfoMapper;
import com.petsfamily.yunximao.userService.mybatis.model.UserFriendInfo;
import com.petsfamily.yunximao.userService.mybatis.model.UserFriendInfoExample;
import com.petsfamily.yunximao.userService.mybatis.model.UserInfo;
import com.petsfamily.yunximao.userService.mybatis.model.UserInfoExample;
import com.petsfamily.yunximao.userService.mybatis.model.UserTokenInfo;
import com.petsfamily.yunximao.userService.mybatis.model.UserTokenInfoExample;
import com.petsfamily.yunximao.userService.mybatis.model.WechatInfo;
import com.petsfamily.yunximao.userService.mybatis.model.WechatInfoExample;
import com.petsfamily.yunximao.userService.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserInfoMapper userMapper;
	@Resource
	private UserFriendInfoMapper friendInfoMapper;
	@Resource
	private WechatInfoMapper wechatMapper;
	@Resource
	private UserTokenInfoMapper tokenMapper;
		
	@Override
	@Transactional(rollbackFor={Throwable.class,RuntimeException.class} ,propagation=Propagation.REQUIRED)
	public ResponseEntity createUserByWeChat(JSONObject dataJson) {
			String unionId = dataJson.getString("unionId");
			String openId = dataJson.getString("openId");
			String nickName = dataJson.getString("nickName");
			String avatarUrl = dataJson.getString("avatarUrl");
			String gender = dataJson.getString("gender");
			String country = dataJson.getString("country");
			String province = dataJson.getString("province");
			String city = dataJson.getString("city");
			String language = dataJson.getString("language");
			String sessionKey = dataJson.getString("sessionKey");
			
			if(StringUtils.isBlank("unionId")&&StringUtils.isBlank("openId")) {
				return ResponseEntity.buildFailly("unionId 和 openId 获取异常");
			}
			UserInfo user = queryUserByUnionId(unionId);
			if(user==null) {
				user = new UserInfo();
				user.setIsDelete(0);
				user.setCreateUser("weChat");
				user.setCreateDate(new Date());
				user.setUserName(nickName);
				user.setAvatarUrl(avatarUrl);
				if("1".equals(gender)) {
					user.setGender("男");
				}else if("2".equals(gender)) {
					user.setGender("女");
				}
				user.setUserType(1);
				user.setStatus(1);
				user.setRegistrationTime(new Date());
				userMapper.insert(user);
				user.setUserNumber(getUserNumber(user.getSeqId()));
				userMapper.updateByPrimaryKeySelective(user);
				
				WechatInfo wechat = new WechatInfo();
				wechat.setIsDelete(0);
				wechat.setCreateUser(user.getUserNumber());
				wechat.setCreateDate(new Date());
				wechat.setUserNumber(user.getUserNumber());
				wechat.setUnionId(unionId);
				wechat.setOpenId(openId);
				wechat.setNickName(nickName);
				wechat.setAvatarUrl(avatarUrl);
				wechat.setGender(gender);
				wechat.setCountry(country);
				wechat.setProvince(province);
				wechat.setCity(city);
				wechat.setLanguage(language);
				wechatMapper.insert(wechat);
			}
			
			String newToken = UUID.randomUUID().toString().replaceAll("-","");
			UserTokenInfoExample example = new UserTokenInfoExample();
			example.createCriteria().andUnionIdEqualTo(unionId);
			List<UserTokenInfo> tokens = tokenMapper.selectByExample(example);
			if(tokens.isEmpty()) {
				UserTokenInfo token = new UserTokenInfo();
				token.setCreateDate(new Date());
				token.setUnionId(unionId);
				token.setSessionKey(sessionKey);
				token.setUserToken(newToken);
				tokenMapper.insert(token);
			}else if(tokens.size()==1) {
				UserTokenInfo token = tokens.get(0);
				
				UserTokenInfoExample update = new UserTokenInfoExample();
				update.createCriteria().andUserTokenEqualTo(token.getUserToken());
				
				token.setUnionId(unionId);
				token.setUserToken(newToken);
				token.setSessionKey(sessionKey);
				token.setUpdateDate(new Date());
				
				tokenMapper.updateByExample(token, example);
			}else {
				tokenMapper.deleteByExample(example);
				UserTokenInfo token = new UserTokenInfo();
				token.setCreateDate(new Date());
				token.setUnionId(unionId);
				token.setSessionKey(sessionKey);
				token.setUserToken(newToken);
				tokenMapper.insert(token);
			}
			JSONObject userData = (JSONObject) JSON.toJSON(user);
			userData.put("token",newToken);
			return ResponseEntity.buildSuccessful(JSON.toJSON(userData));
	}
	
	/**
	 * 根据unionId判断用户是否存在
	 * @param unionId
	 * @return
	 */
	@Transactional(readOnly=true)
	private UserInfo queryUserByUnionId(String unionId) {
		if(StringUtils.isBlank(unionId)) {
			return null;
		}else {
			WechatInfoExample example = new WechatInfoExample();
			example.createCriteria().andIsDeleteEqualTo(0).andUnionIdEqualTo(unionId);
			List<WechatInfo> wechats = wechatMapper.selectByExample(example);
			if(!wechats.isEmpty()) {
				UserInfoExample userInfoExample = new UserInfoExample();
				userInfoExample.createCriteria()
								.andIsDeleteEqualTo(0)
								.andUserNumberEqualTo(wechats.get(0).getUserNumber());
				List<UserInfo> userInfos = userMapper.selectByExample(userInfoExample);
				if(userInfos.isEmpty()) {
					throw new RuntimeException("用户数据异常");
				}else {
					if(StringUtils.isBlank(userInfos.get(0).getAvatarUrl())) {
						userInfos.get(0).setAvatarUrl(wechats.get(0).getAvatarUrl());
					}
					return userInfos.get(0);
				}
			}else {
				return null;
			}
		}
	}
	
	@Override
	@Transactional(readOnly=true)
	public UserInfo getUserInfoByToken(String token) {
		if(StringUtils.isBlank(token)) {
			return null;
		}else {
			UserTokenInfo tokenInfo = tokenMapper.selectByPrimaryKey(token);
			if(tokenInfo==null) {
				return null;
			}else {
				return queryUserByUnionId(tokenInfo.getUnionId());
			}
		}
	}
	@Override
	@Transactional(readOnly=true)
	public UserInfo getUserInfoByCode(String code) {
		if(StringUtils.isBlank(code)) {
			return null;
		}else {
			UserInfoExample example = new UserInfoExample();
			example.createCriteria().andIsDeleteEqualTo(0).andUserNumberEqualTo(code);
			List<UserInfo> userInfos = userMapper.selectByExample(example);
			if(userInfos.isEmpty()) {
				return null;
			}else {
				return userInfos.get(0);
			}
		}
	}
	
	private String getUserNumber(Integer Id) {
		String IdStr = Id.toString();
		DateFormat dFormat = new SimpleDateFormat("yyyyMM");
		if(IdStr.length()<6){
			return "QQ"+dFormat.format(new Date())+String.format("%06d",Id);
		}else if(IdStr.length()==6){
			return "QQ"+dFormat.format(new Date())+IdStr;
		}else{
			return "QQ"+dFormat.format(new Date())+IdStr.substring(IdStr.length()-6);
		}
	}

	@Override
	public ResponseEntity modifyUserInfo(JSONObject dataJson) {
		String token = dataJson.getString("token");//预留埋点
		String type = dataJson.getString("type");
		String value = dataJson.getString("value");
		if(StringUtils.isBlank(token)||StringUtils.isBlank(type)||StringUtils.isBlank(value)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		UserInfo user = this.getUserInfoByToken(token);
		if(user==null) {
			return ResponseEntity.buildFailly("数据错误");
		}
		if(type.equals("userName")) {
			user.setUserName(value);
		}else if(type.equals("gender")) {
			user.setGender(value);
		}else if(type.equals("birthday")) {
			user.setBirthday(DateTimeUtil.parseDate(value));
		}else if(type.equals("mobile")) {
			user.setMobile(value);
		}else if(type.equals("email")) {
			user.setEmail(value);
		}else if(type.equals("remark")) {
			user.setRemark(value);
		}
		user.setUpdateDate(new Date());
		user.setUpdateUser(user.getUserNumber());
		userMapper.updateByPrimaryKeySelective(user);
		return ResponseEntity.buildSuccessful(user);
	}

	@Override
	public ResponseEntity modifyUserHeadImg(JSONObject dataJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity addFriend(JSONObject dataJson) {
		String token = dataJson.getString("token");//预留埋点
		String friendNumber = dataJson.getString("friendNumber");
		if(StringUtils.isBlank(token)||StringUtils.isBlank(friendNumber)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		UserInfo user = this.getUserInfoByToken(token);
		if(user==null) {
			return ResponseEntity.buildFailly("用户信息非法");
		}
		UserFriendInfoExample example = new UserFriendInfoExample();
		example.createCriteria()
				.andIsDeleteEqualTo(0)
				.andUserNumberEqualTo(user.getUserNumber())
				.andFriendNumberEqualTo(friendNumber);
		if(friendInfoMapper.countByExample(example)>0) {
			return ResponseEntity.buildSuccessful();
		}else {
			UserFriendInfo friend = new UserFriendInfo();
			friend.setIsDelete(0);
			friend.setCreateUser(user.getUserNumber());
			friend.setCreateDate(new Date());
			friend.setUserNumber(user.getUserNumber());
			friend.setFriendNumber(friendNumber);
			friendInfoMapper.insert(friend);
			return ResponseEntity.buildSuccessful();
		}
	}

	@Override
	public ResponseEntity deleFriend(JSONObject dataJson) {
		String token = dataJson.getString("token");//预留埋点
		String friendNumber = dataJson.getString("friendNumber");
		if(StringUtils.isBlank(token)||StringUtils.isBlank(friendNumber)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		UserInfo user = this.getUserInfoByToken(token);
		if(user==null) {
			return ResponseEntity.buildFailly("用户信息非法");
		}
		UserFriendInfoExample example = new UserFriendInfoExample();
		example.createCriteria()
				.andIsDeleteEqualTo(0)
				.andUserNumberEqualTo(user.getUserNumber())
				.andFriendNumberEqualTo(friendNumber);
		UserFriendInfo record = new UserFriendInfo();
		record.setIsDelete(1);
		record.setUpdateDate(new Date());
		record.setUpdateUser(user.getUserNumber());
		friendInfoMapper.updateByExampleSelective(record, example);
		return ResponseEntity.buildSuccessful();
	}
	
	@Override
	public boolean isFriend(String userNumber, String friendNumber) {
		if(StringUtils.isBlank(userNumber)||StringUtils.isBlank(friendNumber)) {
			throw new RuntimeException("参数错误");
		}
		if(userNumber.equals(friendNumber)) {
			return true;
		}
		UserFriendInfoExample example = new UserFriendInfoExample();
		example.createCriteria().andIsDeleteEqualTo(0).andUserNumberEqualTo(userNumber).andFriendNumberEqualTo(friendNumber);
		if(friendInfoMapper.countByExample(example)>0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public ResponseEntity queryFriendNum(JSONObject dataJson) {
		String token = dataJson.getString("token");//预留埋点
		if(StringUtils.isBlank(token)) {
			return ResponseEntity.buildFailly("参数错误");
		}
		UserInfo user = this.getUserInfoByToken(token);
		if(user==null) {
			return ResponseEntity.buildFailly("数据错误");
		}
		UserFriendInfoExample example = new UserFriendInfoExample();
		example.createCriteria().andIsDeleteEqualTo(0).andUserNumberEqualTo(user.getUserNumber());
		return ResponseEntity.buildSuccessful(friendInfoMapper.countByExample(example));
		
	}
}
