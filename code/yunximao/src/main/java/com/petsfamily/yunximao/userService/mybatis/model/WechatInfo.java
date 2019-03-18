package com.petsfamily.yunximao.userService.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class WechatInfo implements Serializable {
    /**
     * 主键
     * 表 : wechat_info
     * 对应字段 : seq_id
     */
    private Integer seqId;

    /**
     * 用户编号
     * 表 : wechat_info
     * 对应字段 : user_number
     */
    private String userNumber;

    /**
     * unionId
     * 表 : wechat_info
     * 对应字段 : union_id
     */
    private String unionId;

    /**
     * openId
     * 表 : wechat_info
     * 对应字段 : open_id
     */
    private String openId;

    /**
     * 微信昵称
     * 表 : wechat_info
     * 对应字段 : nick_name
     */
    private String nickName;

    /**
     * 微信头像
     * 表 : wechat_info
     * 对应字段 : avatar_url
     */
    private String avatarUrl;

    /**
     * 性别 男:1 女:2 未知:0
     * 表 : wechat_info
     * 对应字段 : gender
     */
    private String gender;

    /**
     * 国家
     * 表 : wechat_info
     * 对应字段 : country
     */
    private String country;

    /**
     * 省/市
     * 表 : wechat_info
     * 对应字段 : province
     */
    private String province;

    /**
     * 区/县
     * 表 : wechat_info
     * 对应字段 : city
     */
    private String city;

    /**
     * 语言
     * 表 : wechat_info
     * 对应字段 : language
     */
    private String language;

    /**
     * 否:0 是 1
     * 表 : wechat_info
     * 对应字段 : is_delete
     */
    private Integer isDelete;

    /**
     * 备注
     * 表 : wechat_info
     * 对应字段 : remark
     */
    private String remark;

    /**
     * 创建人
     * 表 : wechat_info
     * 对应字段 : create_user
     */
    private String createUser;

    /**
     * 修改人
     * 表 : wechat_info
     * 对应字段 : update_user
     */
    private String updateUser;

    /**
     * 创建时间
     * 表 : wechat_info
     * 对应字段 : create_date
     */
    private Date createDate;

    /**
     * 修改时间
     * 表 : wechat_info
     * 对应字段 : update_date
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return wechat_info.seq_id：主键
     */
    public Integer getSeqId() {
        return seqId;
    }

    /**
     * set method 
     *
     * @param seqId  主键
     */
    public void setSeqId(Integer seqId) {
        this.seqId = seqId;
    }

    /**
     * get method 
     *
     * @return wechat_info.user_number：用户编号
     */
    public String getUserNumber() {
        return userNumber;
    }

    /**
     * set method 
     *
     * @param userNumber  用户编号
     */
    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.union_id：unionId
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * set method 
     *
     * @param unionId  unionId
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.open_id：openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * set method 
     *
     * @param openId  openId
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.nick_name：微信昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * set method 
     *
     * @param nickName  微信昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.avatar_url：微信头像
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * set method 
     *
     * @param avatarUrl  微信头像
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.gender：性别 男:1 女:2 未知:0
     */
    public String getGender() {
        return gender;
    }

    /**
     * set method 
     *
     * @param gender  性别 男:1 女:2 未知:0
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.country：国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * set method 
     *
     * @param country  国家
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.province：省/市
     */
    public String getProvince() {
        return province;
    }

    /**
     * set method 
     *
     * @param province  省/市
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.city：区/县
     */
    public String getCity() {
        return city;
    }

    /**
     * set method 
     *
     * @param city  区/县
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.language：语言
     */
    public String getLanguage() {
        return language;
    }

    /**
     * set method 
     *
     * @param language  语言
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.is_delete：否:0 是 1
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * set method 
     *
     * @param isDelete  否:0 是 1
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * get method 
     *
     * @return wechat_info.remark：备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * set method 
     *
     * @param remark  备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.create_user：创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * set method 
     *
     * @param createUser  创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.update_user：修改人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * set method 
     *
     * @param updateUser  修改人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * get method 
     *
     * @return wechat_info.create_date：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * set method 
     *
     * @param createDate  创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * get method 
     *
     * @return wechat_info.update_date：修改时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * set method 
     *
     * @param updateDate  修改时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", seqId=").append(seqId);
        sb.append(", userNumber=").append(userNumber);
        sb.append(", unionId=").append(unionId);
        sb.append(", openId=").append(openId);
        sb.append(", nickName=").append(nickName);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", gender=").append(gender);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", language=").append(language);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", remark=").append(remark);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append("]");
        return sb.toString();
    }
}