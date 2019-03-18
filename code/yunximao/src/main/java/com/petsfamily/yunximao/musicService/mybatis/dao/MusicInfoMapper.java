package com.petsfamily.yunximao.musicService.mybatis.dao;

import com.petsfamily.yunximao.musicService.mybatis.model.MusicInfo;
import com.petsfamily.yunximao.musicService.mybatis.model.MusicInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MusicInfoMapper {
    /**
     * 根据条件计数
     *
     * @param example
     */
    int countByExample(MusicInfoExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(MusicInfoExample example);

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
    int insert(MusicInfo record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(MusicInfo record);

    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<MusicInfo> selectByExample(MusicInfoExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param seqId
     */
    MusicInfo selectByPrimaryKey(Integer seqId);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") MusicInfo record, @Param("example") MusicInfoExample example);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") MusicInfo record, @Param("example") MusicInfoExample example);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(MusicInfo record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(MusicInfo record);
}