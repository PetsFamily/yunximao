package com.petsfamily.yunximao.momentsService.mybatis.dao;

import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsInfo;
import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PetMomentsInfoMapper {
    /**
     * 根据条件计数
     *
     * @param example
     */
    int countByExample(PetMomentsInfoExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(PetMomentsInfoExample example);

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
    int insert(PetMomentsInfo record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(PetMomentsInfo record);

    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<PetMomentsInfo> selectByExample(PetMomentsInfoExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param seqId
     */
    PetMomentsInfo selectByPrimaryKey(Integer seqId);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") PetMomentsInfo record, @Param("example") PetMomentsInfoExample example);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") PetMomentsInfo record, @Param("example") PetMomentsInfoExample example);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(PetMomentsInfo record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(PetMomentsInfo record);
}