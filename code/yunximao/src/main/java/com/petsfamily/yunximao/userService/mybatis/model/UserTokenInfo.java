package com.petsfamily.yunximao.userService.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class UserTokenInfo implements Serializable {
    /**
     * 用户token
     * 表 : user_token_info
     * 对应字段 : user_token
     */
    private String userToken;

    /**
     * unionId
     * 表 : user_token_info
     * 对应字段 : union_id
     */
    private String unionId;

    /**
     * sessionKey
     * 表 : user_token_info
     * 对应字段 : session_key
     */
    private String sessionKey;

    /**
     * 创建时间
     * 表 : user_token_info
     * 对应字段 : create_date
     */
    private Date createDate;

    /**
     * 修改时间
     * 表 : user_token_info
     * 对应字段 : update_date
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return user_token_info.user_token：用户token
     */
    public String getUserToken() {
        return userToken;
    }

    /**
     * set method 
     *
     * @param userToken  用户token
     */
    public void setUserToken(String userToken) {
        this.userToken = userToken == null ? null : userToken.trim();
    }

    /**
     * get method 
     *
     * @return user_token_info.union_id：unionId
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
     * @return user_token_info.session_key：sessionKey
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * set method 
     *
     * @param sessionKey  sessionKey
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey == null ? null : sessionKey.trim();
    }

    /**
     * get method 
     *
     * @return user_token_info.create_date：创建时间
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
     * @return user_token_info.update_date：修改时间
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
        sb.append(", userToken=").append(userToken);
        sb.append(", unionId=").append(unionId);
        sb.append(", sessionKey=").append(sessionKey);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append("]");
        return sb.toString();
    }
}