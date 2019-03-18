package com.petsfamily.yunximao.userService.mybatis.dao;

import com.petsfamily.yunximao.userService.mybatis.model.WechatInfo;
import com.petsfamily.yunximao.userService.mybatis.model.WechatInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatInfoMapper {
    /**
     * 根据条件计数
     *
     * @param example
     */
    int countByExample(WechatInfoExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(WechatInfoExample example);

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
    int insert(WechatInfo record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(WechatInfo record);

    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<WechatInfo> selectByExample(WechatInfoExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param seqId
     */
    WechatInfo selectByPrimaryKey(Integer seqId);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") WechatInfo record, @Param("example") WechatInfoExample example);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") WechatInfo record, @Param("example") WechatInfoExample example);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(WechatInfo record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(WechatInfo record);
}