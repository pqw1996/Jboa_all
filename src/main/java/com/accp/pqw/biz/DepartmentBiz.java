package com.accp.pqw.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.pqw.dao.DepartmentDAO;
import com.accp.pqw.pojo.Department;

@Service("DepartmentBiz")
public class DepartmentBiz {
	@Autowired
	private DepartmentDAO dao;

	public Department queryOne(int departmentid) {
		return dao.selectByPrimaryKey(departmentid);
	}
}
