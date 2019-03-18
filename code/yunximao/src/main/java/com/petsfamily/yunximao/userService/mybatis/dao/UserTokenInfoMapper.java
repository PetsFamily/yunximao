package com.petsfamily.yunximao.userService.mybatis.dao;

import com.petsfamily.yunximao.userService.mybatis.model.UserTokenInfo;
import com.petsfamily.yunximao.userService.mybatis.model.UserTokenInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTokenInfoMapper {
    /**
     * 根据条件计数
     *
     * @param example
     */
    int countByExample(UserTokenInfoExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(UserTokenInfoExample example);

    /**
     * 根据主键删除数据库的记录
     *
     * @param userToken
     */
    int deleteByPrimaryKey(String userToken);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(UserTokenInfo record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(UserTokenInfo record);

    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<UserTokenInfo> selectByExample(UserTokenInfoExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param userToken
     */
    UserTokenInfo selectByPrimaryKey(String userToken);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") UserTokenInfo record, @Param("example") UserTokenInfoExample example);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") UserTokenInfo record, @Param("example") UserTokenInfoExample example);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UserTokenInfo record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(UserTokenInfo record);
}