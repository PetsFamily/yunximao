package com.petsfamily.yunximao.musicService.mybatis.dao;

import com.petsfamily.yunximao.musicService.mybatis.model.MusicCollectInfo;
import com.petsfamily.yunximao.musicService.mybatis.model.MusicCollectInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MusicCollectInfoMapper {
    /**
     * 根据条件计数
     *
     * @param example
     */
    int countByExample(MusicCollectInfoExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(MusicCollectInfoExample example);

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
    int insert(MusicCollectInfo record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(MusicCollectInfo record);

    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<MusicCollectInfo> selectByExample(MusicCollectInfoExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param seqId
     */
    MusicCollectInfo selectByPrimaryKey(Integer seqId);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") MusicCollectInfo record, @Param("example") MusicCollectInfoExample example);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") MusicCollectInfo record, @Param("example") MusicCollectInfoExample example);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MusicCollectInfo record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(MusicCollectInfo record);
}