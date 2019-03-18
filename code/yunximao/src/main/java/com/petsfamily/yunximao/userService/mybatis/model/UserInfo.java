package com.petsfamily.yunximao.userService.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    /**
     * 主键
     * 表 : user_info
     * 对应字段 : seq_id
     */
    private Integer seqId;

    /**
     * 用户编号
     * 表 : user_info
     * 对应字段 : user_number
     */
    private String userNumber;

    /**
     * 用户名称
     * 表 : user_info
     * 对应字段 : user_name
     */
    private String userName;

    /**
     * 头像
     * 表 : user_info
     * 对应字段 : avatar_url
     */
    private String avatarUrl;

    /**
     * 性别
     * 表 : user_info
     * 对应字段 : gender
     */
    private String gender;

    /**
     * 出生日期
     * 表 : user_info
     * 对应字段 : birthday
     */
    private Date birthday;

    /**
     * 手机号码
     * 表 : user_info
     * 对应字段 : mobile
     */
    private String mobile;

    /**
     * 电子邮箱
     * 表 : user_info
     * 对应字段 : email
     */
    private String email;

    /**
     * 真实姓名
     * 表 : user_info
     * 对应字段 : real_name
     */
    private String realName;

    /**
     * 身份证号
     * 表 : user_info
     * 对应字段 : id_number
     */
    private String idNumber;

    /**
     * 1:观众，2:宠主
     * 表 : user_info
     * 对应字段 : user_type
     */
    private Integer userType;

    /**
     * 用户状态（1:正常，2:禁用）
     * 表 : user_info
     * 对应字段 : status
     */
    private Integer status;

    /**
     * 注册时间
     * 表 : user_info
     * 对应字段 : registration_time
     */
    private Date registrationTime;

    /**
     * 否:0 是 1
     * 表 : user_info
     * 对应字段 : is_delete
     */
    private Integer isDelete;

    /**
     * 备注
     * 表 : user_info
     * 对应字段 : remark
     */
    private String remark;

    /**
     * 创建人
     * 表 : user_info
     * 对应字段 : create_user
     */
    private String createUser;

    /**
     * 修改人
     * 表 : user_info
     * 对应字段 : update_user
     */
    private String updateUser;

    /**
     * 创建时间
     * 表 : user_info
     * 对应字段 : create_date
     */
    private Date createDate;

    /**
     * 修改时间
     * 表 : user_info
     * 对应字段 : update_date
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return user_info.seq_id：主键
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
     * @return user_info.user_number：用户编号
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
     * @return user_info.user_name：用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * set method 
     *
     * @param userName  用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * get method 
     *
     * @return user_info.avatar_url：头像
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * set method 
     *
     * @param avatarUrl  头像
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * get method 
     *
     * @return user_info.gender：性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * set method 
     *
     * @param gender  性别
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * get method 
     *
     * @return user_info.birthday：出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * set method 
     *
     * @param birthday  出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * get method 
     *
     * @return user_info.mobile：手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * set method 
     *
     * @param mobile  手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * get method 
     *
     * @return user_info.email：电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * set method 
     *
     * @param email  电子邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * get method 
     *
     * @return user_info.real_name：真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * set method 
     *
     * @param realName  真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * get method 
     *
     * @return user_info.id_number：身份证号
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * set method 
     *
     * @param idNumber  身份证号
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    /**
     * get method 
     *
     * @return user_info.user_type：1:观众，2:宠主
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * set method 
     *
     * @param userType  1:观众，2:宠主
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * get method 
     *
     * @return user_info.status：用户状态（1:正常，2:禁用）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * set method 
     *
     * @param status  用户状态（1:正常，2:禁用）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * get method 
     *
     * @return user_info.registration_time：注册时间
     */
    public Date getRegistrationTime() {
        return registrationTime;
    }

    /**
     * set method 
     *
     * @param registrationTime  注册时间
     */
    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    /**
     * get method 
     *
     * @return user_info.is_delete：否:0 是 1
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
     * @return user_info.remark：备注
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
     * @return user_info.create_user：创建人
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
     * @return user_info.update_user：修改人
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
     * @return user_info.create_date：创建时间
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
     * @return user_info.update_date：修改时间
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
        sb.append(", userName=").append(userName);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", realName=").append(realName);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", userType=").append(userType);
        sb.append(", status=").append(status);
        sb.append(", registrationTime=").append(registrationTime);
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