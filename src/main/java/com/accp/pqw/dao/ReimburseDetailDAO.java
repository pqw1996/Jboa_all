package com.accp.pqw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pqw.pojo.ReimburseDetail;

public interface ReimburseDetailDAO {
	int deleteByPrimaryKey(String id);

	int insert(ReimburseDetail record);

	int insertSelective(ReimburseDetail record);

	ReimburseDetail selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ReimburseDetail record);

	int updateByPrimaryKey(ReimburseDetail record);

	int deleteByMianId(String id);

	List<ReimburseDetail> queryByMianId(String id);

	// 主从修改用的删除方法
	int deleteByUpdate(@Param("mid") String mid, @Param("ids") int[] ids);
}