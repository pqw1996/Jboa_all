package com.accp.pqw.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.pqw.dao.EmployeeDAO;
import com.accp.pqw.pojo.Employee;

@Service("EmployeeBiz")
public class EmployeeBiz {
	@Autowired
	private EmployeeDAO dao;

	public Employee login(Integer id, String pwd) {
		return dao.login(id, pwd);
	}

	public Employee getOne(int id) {
		return dao.selectByPrimaryKey(id);
	}
}
