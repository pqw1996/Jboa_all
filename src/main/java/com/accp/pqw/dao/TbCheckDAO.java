package com.accp.pqw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pqw.pojo.TbCheck;

public interface TbCheckDAO {
	int deleteByPrimaryKey(Integer checkid);

	int insert(TbCheck record);

	int insertSelective(TbCheck record);

	TbCheck selectByPrimaryKey(Integer checkid);

	int updateByPrimaryKeySelective(TbCheck record);

	int updateByPrimaryKey(TbCheck record);

	int deleteByBizId(String bizId);

	List<TbCheck> selectByBizId(@Param("tid") Integer typeId, @Param("bid") String bizId);
}