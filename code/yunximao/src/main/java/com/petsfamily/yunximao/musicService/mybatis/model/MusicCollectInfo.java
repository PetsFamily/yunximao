package com.petsfamily.yunximao.musicService.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class MusicCollectInfo implements Serializable {
    /**
     * 主键
     * 表 : music_collect_info
     * 对应字段 : seq_id
     */
    private Integer seqId;

    /**
     * 音乐编号
     * 表 : music_collect_info
     * 对应字段 : music_number
     */
    private String musicNumber;

    /**
     * 用户编号
     * 表 : music_collect_info
     * 对应字段 : user_number
     */
    private String userNumber;

    /**
     * 否:0 是 1
     * 表 : music_collect_info
     * 对应字段 : is_delete
     */
    private Integer isDelete;

    /**
     * 备注
     * 表 : music_collect_info
     * 对应字段 : remark
     */
    private String remark;

    /**
     * 创建人
     * 表 : music_collect_info
     * 对应字段 : create_user
     */
    private String createUser;

    /**
     * 修改人
     * 表 : music_collect_info
     * 对应字段 : update_user
     */
    private String updateUser;

    /**
     * 创建时间
     * 表 : music_collect_info
     * 对应字段 : create_date
     */
    private Date createDate;

    /**
     * 修改时间
     * 表 : music_collect_info
     * 对应字段 : update_date
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return music_collect_info.seq_id：主键
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
     * @return music_collect_info.music_number：音乐编号
     */
    public String getMusicNumber() {
        return musicNumber;
    }

    /**
     * set method 
     *
     * @param musicNumber  音乐编号
     */
    public void setMusicNumber(String musicNumber) {
        this.musicNumber = musicNumber == null ? null : musicNumber.trim();
    }

    /**
     * get method 
     *
     * @return music_collect_info.user_number：用户编号
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
     * @return music_collect_info.is_delete：否:0 是 1
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
     * @return music_collect_info.remark：备注
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
     * @return music_collect_info.create_user：创建人
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
     * @return music_collect_info.update_user：修改人
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
     * @return music_collect_info.create_date：创建时间
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
     * @return music_collect_info.update_date：修改时间
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
        sb.append(", musicNumber=").append(musicNumber);
        sb.append(", userNumber=").append(userNumber);
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