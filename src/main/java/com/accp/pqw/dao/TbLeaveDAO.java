package com.accp.pqw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pqw.pojo.TbLeave;

public interface TbLeaveDAO {
	int deleteByPrimaryKey(String leaveid);

	int insert(TbLeave record);

	int insertSelective(TbLeave record);

	TbLeave selectByPrimaryKey(String leaveid);

	int updateByPrimaryKeySelective(TbLeave record);

	int updateByPrimaryKey(TbLeave record);

	// 根据职员id查询
	List<TbLeave> selectByEmpId(@Param("id") Integer id, @Param("start") String sTime, @Param("end") String eTime);

	// 根据部门id查询
	List<TbLeave> selectByDepId(@Param("id") Integer id, @Param("start") String sTime, @Param("end") String eTime);

	// 查询全部
	List<TbLeave> selectAll(@Param("start") String sTime, @Param("end") String eTime);

	// 查询审批通过的
	List<TbLeave> selectGetApproved(@Param("start") String sTime, @Param("end") String eTime);

	// tip查询
	List<TbLeave> selectTip(@Param("id") int id);

}