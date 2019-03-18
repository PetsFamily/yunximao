package com.petsfamily.yunximao.userService.mybatis.dao;

import com.petsfamily.yunximao.userService.mybatis.model.UserInfo;
import com.petsfamily.yunximao.userService.mybatis.model.UserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {
    /**
     * 根据条件计数
     *
     * @param example
     */
    int countByExample(UserInfoExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(UserInfoExample example);

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
    int insert(UserInfo record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(UserInfo record);

    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<UserInfo> selectByExample(UserInfoExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param seqId
     */
    UserInfo selectByPrimaryKey(Integer seqId);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(UserInfo record);
}