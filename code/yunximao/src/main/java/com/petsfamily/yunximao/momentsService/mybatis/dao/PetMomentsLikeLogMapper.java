package com.petsfamily.yunximao.momentsService.mybatis.dao;

import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsLikeLog;
import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsLikeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PetMomentsLikeLogMapper {
    /**
     * 根据条件计数
     *
     * @param example
     */
    int countByExample(PetMomentsLikeLogExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(PetMomentsLikeLogExample example);

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
    int insert(PetMomentsLikeLog record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(PetMomentsLikeLog record);

    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<PetMomentsLikeLog> selectByExample(PetMomentsLikeLogExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param seqId
     */
    PetMomentsLikeLog selectByPrimaryKey(Integer seqId);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") PetMomentsLikeLog record, @Param("example") PetMomentsLikeLogExample example);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") PetMomentsLikeLog record, @Param("example") PetMomentsLikeLogExample example);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(PetMomentsLikeLog record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(PetMomentsLikeLog record);
}