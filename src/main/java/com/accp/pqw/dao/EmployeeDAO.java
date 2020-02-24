package com.accp.pqw.dao;

import org.apache.ibatis.annotations.Param;

import com.accp.pqw.pojo.Employee;

public interface EmployeeDAO {
	int deleteByPrimaryKey(Integer employeeid);

	int insert(Employee record);

	int insertSelective(Employee record);

	Employee selectByPrimaryKey(Integer employeeid);

	Employee login(@Param("id") Integer employeeid, @Param("pwd") String password);

	int updateByPrimaryKeySelective(Employee record);

	int updateByPrimaryKey(Employee record);
}