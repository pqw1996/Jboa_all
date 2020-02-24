package com.accp.pqw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pqw.pojo.TbReimburse;

public interface TbReimburseDAO {
	int deleteByPrimaryKey(String reimburseid);

	int insert(TbReimburse record);

	int insertSelective(TbReimburse record);

	TbReimburse selectByPrimaryKey(String reimburseid);

	int updateByPrimaryKeySelective(TbReimburse record);

	int updateByPrimaryKey(TbReimburse record);

	// 人事和普通员工查询
	List<TbReimburse> queryByCreateMan(@Param("eid") Integer empId, @Param("sid") Integer statusId,
			@Param("s") String sTime, @Param("e") String eTime);

	// 部门经理查询
	List<TbReimburse> queryByDepartment(@Param("eid") Integer empId, @Param("did") Integer depId,
			@Param("sid") Integer statusId, @Param("s") String sTime, @Param("e") String eTime);

	// 总经理和财务查询
	List<TbReimburse> queryAll(@Param("eid") Integer empId, @Param("sid") Integer statusId, @Param("s") String sTime,
			@Param("e") String eTime);

	// 出纳查询
	List<TbReimburse> queryByCashier(@Param("eid") Integer empId, @Param("s") String sTime, @Param("e") String eTime);

	List<TbReimburse> selectTip(@Param("id") int id);

}