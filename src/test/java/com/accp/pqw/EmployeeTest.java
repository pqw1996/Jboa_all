package com.accp.pqw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.pqw.biz.EmployeeBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-ctx.xml" })
public class EmployeeTest {
	@Autowired
	private EmployeeBiz biz;

	@Test
	public void login() {
		System.err.println(biz.login(1004, "aaa12345").toString());
	}
}
