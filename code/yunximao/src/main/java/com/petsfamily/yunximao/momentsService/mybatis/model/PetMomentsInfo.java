package com.petsfamily.yunximao.momentsService.mybatis.model;

import java.io.Serializable;
import java.util.Date;

public class PetMomentsInfo implements Serializable {
    /**
     * 主键
     * 表 : pet_moments_info
     * 对应字段 : seq_id
     */
    private Integer seqId;

    /**
     * 用户编号
     * 表 : pet_moments_info
     * 对应字段 : user_number
     */
    private String userNumber;

    /**
     * 宠物编号
     * 表 : pet_moments_info
     * 对应字段 : pet_number
     */
    private String petNumber;

    /**
     * 瞬间编号
     * 表 : pet_moments_info
     * 对应字段 : moment_number
     */
    private String momentNumber;

    /**
     * 瞬间类型 1:文字 2:图片 3:小视频
     * 表 : pet_moments_info
     * 对应字段 : moment_type
     */
    private Integer momentType;

    /**
     * 瞬间标题
     * 表 : pet_moments_info
     * 对应字段 : moment_title
     */
    private String momentTitle;

    /**
     * 瞬间内容
     * 表 : pet_moments_info
     * 对应字段 : moment_content
     */
    private String momentContent;

    /**
     * 收藏数量
     * 表 : pet_moments_info
     * 对应字段 : favorites_count
     */
    private Integer favoritesCount;

    /**
     * 阅读数量
     * 表 : pet_moments_info
     * 对应字段 : read_count
     */
    private Integer readCount;

    /**
     * 点赞数量
     * 表 : pet_moments_info
     * 对应字段 : like_count
     */
    private Integer likeCount;

    /**
     * 否:0 是 1
     * 表 : pet_moments_info
     * 对应字段 : is_delete
     */
    private Integer isDelete;

    /**
     * 备注
     * 表 : pet_moments_info
     * 对应字段 : remark
     */
    private String remark;

    /**
     * 创建人
     * 表 : pet_moments_info
     * 对应字段 : create_user
     */
    private String createUser;

    /**
     * 修改人
     * 表 : pet_moments_info
     * 对应字段 : update_user
     */
    private String updateUser;

    /**
     * 创建时间
     * 表 : pet_moments_info
     * 对应字段 : create_date
     */
    private Date createDate;

    /**
     * 修改时间
     * 表 : pet_moments_info
     * 对应字段 : update_date
     */
    private Date updateDate;

    /**
     * 关键字
     * 表 : pet_moments_info
     * 对应字段 : key_word
     */
    private String keyWord;

    /**
     * 评论数量
     * 表 : pet_moments_info
     * 对应字段 : comments_count
     */
    private Integer commentsCount;

    /**
     * 
     * 表 : pet_moments_info
     * 对应字段 : moment_video
     */
    private String momentVideo;

    /**
     * 
     * 表 : pet_moments_info
     * 对应字段 : is_pass
     */
    private Integer isPass;

    /**
     * 
     * 表 : pet_moments_info
     * 对应字段 : task_id
     */
    private String taskId;

    private static final long serialVersionUID = 1L;

    /**
     * get method 
     *
     * @return pet_moments_info.seq_id：主键
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
     * @return pet_moments_info.user_number：用户编号
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
     * @return pet_moments_info.pet_number：宠物编号
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
     * @return pet_moments_info.moment_number：瞬间编号
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
     * @return pet_moments_info.moment_type：瞬间类型 1:文字 2:图片 3:小视频
     */
    public Integer getMomentType() {
        return momentType;
    }

    /**
     * set method 
     *
     * @param momentType  瞬间类型 1:文字 2:图片 3:小视频
     */
    public void setMomentType(Integer momentType) {
        this.momentType = momentType;
    }

    /**
     * get method 
     *
     * @return pet_moments_info.moment_title：瞬间标题
     */
    public String getMomentTitle() {
        return momentTitle;
    }

    /**
     * set method 
     *
     * @param momentTitle  瞬间标题
     */
    public void setMomentTitle(String momentTitle) {
        this.momentTitle = momentTitle == null ? null : momentTitle.trim();
    }

    /**
     * get method 
     *
     * @return pet_moments_info.moment_content：瞬间内容
     */
    public String getMomentContent() {
        return momentContent;
    }

    /**
     * set method 
     *
     * @param momentContent  瞬间内容
     */
    public void setMomentContent(String momentContent) {
        this.momentContent = momentContent == null ? null : momentContent.trim();
    }

    /**
     * get method 
     *
     * @return pet_moments_info.favorites_count：收藏数量
     */
    public Integer getFavoritesCount() {
        return favoritesCount;
    }

    /**
     * set method 
     *
     * @param favoritesCount  收藏数量
     */
    public void setFavoritesCount(Integer favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    /**
     * get method 
     *
     * @return pet_moments_info.read_count：阅读数量
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     * set method 
     *
     * @param readCount  阅读数量
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    /**
     * get method 
     *
     * @return pet_moments_info.like_count：点赞数量
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * set method 
     *
     * @param likeCount  点赞数量
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * get method 
     *
     * @return pet_moments_info.is_delete：否:0 是 1
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
     * @return pet_moments_info.remark：备注
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
     * @return pet_moments_info.create_user：创建人
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
     * @return pet_moments_info.update_user：修改人
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
     * @return pet_moments_info.create_date：创建时间
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
     * @return pet_moments_info.update_date：修改时间
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
     * get method 
     *
     * @return pet_moments_info.key_word：关键字
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * set method 
     *
     * @param keyWord  关键字
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    /**
     * get method 
     *
     * @return pet_moments_info.comments_count：评论数量
     */
    public Integer getCommentsCount() {
        return commentsCount;
    }

    /**
     * set method 
     *
     * @param commentsCount  评论数量
     */
    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    /**
     * get method 
     *
     * @return pet_moments_info.moment_video：
     */
    public String getMomentVideo() {
        return momentVideo;
    }

    /**
     * set method 
     *
     * @param momentVideo  
     */
    public void setMomentVideo(String momentVideo) {
        this.momentVideo = momentVideo == null ? null : momentVideo.trim();
    }

    /**
     * get method 
     *
     * @return pet_moments_info.is_pass：
     */
    public Integer getIsPass() {
        return isPass;
    }

    /**
     * set method 
     *
     * @param isPass  
     */
    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    /**
     * get method 
     *
     * @return pet_moments_info.task_id：
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * set method 
     *
     * @param taskId  
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
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
        sb.append(", momentType=").append(momentType);
        sb.append(", momentTitle=").append(momentTitle);
        sb.append(", momentContent=").append(momentContent);
        sb.append(", favoritesCount=").append(favoritesCount);
        sb.append(", readCount=").append(readCount);
        sb.append(", likeCount=").append(likeCount);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", remark=").append(remark);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", keyWord=").append(keyWord);
        sb.append(", commentsCount=").append(commentsCount);
        sb.append(", momentVideo=").append(momentVideo);
        sb.append(", isPass=").append(isPass);
        sb.append(", taskId=").append(taskId);
        sb.append("]");
        return sb.toString();
    }
}