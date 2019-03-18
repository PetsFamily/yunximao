package com.petsfamily.yunximao.momentsService.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class PetMomentsReadLog implements Serializable {
    /**
     * 主键
     * 表 : pet_moments_read_log
     * 对应字段 : seq_id
     */
    private Integer seqId;

    /**
     * 用户编号
     * 表 : pet_moments_read_log
     * 对应字段 : user_number
     */
    private String userNumber;

    /**
     * 宠物编号
     * 表 : pet_moments_read_log
     * 对应字段 : pet_number
     */
    private String petNumber;

    /**
     * 瞬间编号
     * 表 : pet_moments_read_log
     * 对应字段 : moment_number
     */
    private String momentNumber;

    /**
     * 否:0 是 1
     * 表 : pet_moments_read_log
     * 对应字段 : is_delete
     */
    private Integer isDelete;

    /**
     * 备注
     * 表 : pet_moments_read_log
     * 对应字段 : remark
     */
    private String remark;

    /**
     * 创建人
     * 表 : pet_moments_read_log
     * 对应字段 : create_user
     */
    private String createUser;

    /**
     * 修改人
     * 表 : pet_moments_read_log
     * 对应字段 : update_user
     */
    private String updateUser;

    /**
     * 创建时间
     * 表 : pet_moments_read_log
     * 对应字段 : create_date
     */
    private Date createDate;

    /**
     * 修改时间
     * 表 : pet_moments_read_log
     * 对应字段 : update_date
     */
    private Date updateDate;

    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return pet_moments_read_log.seq_id：主键
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
     * @return pet_moments_read_log.user_number：用户编号
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
     * @return pet_moments_read_log.pet_number：宠物编号
     */
    public String getPetNumber() {
        return petNumber;
    }

    /**
     * set method 
     *
     * @param petNumber  宠物编号
     */
    public void setPetNumber(String petNumber) {
        this.petNumber = petNumber == null ? null : petNumber.trim();
    }

    /**
     * get method 
     *
     * @return pet_moments_read_log.moment_number：瞬间编号
     */
    public String getMomentNumber() {
        return momentNumber;
    }

    /**
     * set method 
     *
     * @param momentNumber  瞬间编号
     */
    public void setMomentNumber(String momentNumber) {
        this.momentNumber = momentNumber == null ? null : momentNumber.trim();
    }

    /**
     * get method 
     *
     * @return pet_moments_read_log.is_delete：否:0 是 1
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
     * @return pet_moments_read_log.remark：备注
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
     * @return pet_moments_read_log.create_user：创建人
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
     * @return pet_moments_read_log.update_user：修改人
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
     * @return pet_moments_read_log.create_date：创建时间
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
     * @return pet_moments_read_log.update_date：修改时间
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
        sb.append(", petNumber=").append(petNumber);
        sb.append(", momentNumber=").append(momentNumber);
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