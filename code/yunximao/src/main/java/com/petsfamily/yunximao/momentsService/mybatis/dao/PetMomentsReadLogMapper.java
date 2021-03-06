package com.petsfamily.yunximao.momentsService.mybatis.dao;

import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsReadLog;
import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsReadLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PetMomentsReadLogMapper {
    /**
     * 根据条件计数
     *
     * @param example
     */
    int countByExample(PetMomentsReadLogExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(PetMomentsReadLogExample example);

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
    int insert(PetMomentsReadLog record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(PetMomentsReadLog record);

    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<PetMomentsReadLog> selectByExample(PetMomentsReadLogExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param seqId
     */
    PetMomentsReadLog selectByPrimaryKey(Integer seqId);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") PetMomentsReadLog record, @Param("example") PetMomentsReadLogExample example);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") PetMomentsReadLog record, @Param("example") PetMomentsReadLogExample example);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(PetMomentsReadLog record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(PetMomentsReadLog record);
}