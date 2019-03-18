package com.petsfamily.yunximao.momentsService.mybatis.dao;

import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsCommentsInfo;
import com.petsfamily.yunximao.momentsService.mybatis.model.PetMomentsCommentsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PetMomentsCommentsInfoMapper {
    /**
     * 根据条件计数
     *
     * @param example
     */
    int countByExample(PetMomentsCommentsInfoExample example);

    /**
     *
     * @param example
     */
    int deleteByExample(PetMomentsCommentsInfoExample example);

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
    int insert(PetMomentsCommentsInfo record);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insertSelective(PetMomentsCommentsInfo record);

    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<PetMomentsCommentsInfo> selectByExample(PetMomentsCommentsInfoExample example);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param seqId
     */
    PetMomentsCommentsInfo selectByPrimaryKey(Integer seqId);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") PetMomentsCommentsInfo record, @Param("example") PetMomentsCommentsInfoExample example);

    /**
     * 选择性更新数据库记录
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") PetMomentsCommentsInfo record, @Param("example") PetMomentsCommentsInfoExample example);

    /**
     * 根据主键来更新部分数据库记录
     *
     * @param record
     */
    int updateByPrimaryKeySelective(PetMomentsCommentsInfo record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(PetMomentsCommentsInfo record);
}