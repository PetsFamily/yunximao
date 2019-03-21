package com.petsfamily.yunximao.userService.mybatis.dao;

import com.petsfamily.yunximao.userService.mybatis.model.UserFriendInfo;
import com.petsfamily.yunximao.userService.mybatis.model.UserFriendInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFriendInfoMapper {
    /**
     * 根据条件计数
     *
     * @param example
     */
    int countByExample(UserFriendInfoExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(UserFriendInfoExample example);

    /**
     * 根据主键删除数据库的记录
     *
     * @param seqId
     */
    int deleteByPrimaryKey(Integer seqId);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(UserFriendInfo record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(UserFriendInfo record);

    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<UserFriendInfo> selectByExample(UserFriendInfoExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param seqId
     */
    UserFriendInfo selectByPrimaryKey(Integer seqId);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") UserFriendInfo record, @Param("example") UserFriendInfoExample example);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") UserFriendInfo record, @Param("example") UserFriendInfoExample example);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UserFriendInfo record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(UserFriendInfo record);
}