package com.accp.pqw.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.pqw.biz.EmployeeBiz;
import com.accp.pqw.pojo.Employee;

@Controller
@RequestMapping("/c/Employee") // 命名空间
public class EmployeeAction {
	@Autowired
	private EmployeeBiz biz;

	@RequestMapping("login")
	public String login(Integer employeeId, String password, HttpSession session) {
		Employee emp = biz.login(employeeId, password);
		if (emp != null) {
			session.setAttribute("emp", emp);
			return "redirect:/homePage";
		}
		return "redirect:/login";
	}

	@RequestMapping("loginOut")
	public String loginOut(HttpSession session) {
		session.removeAttribute("emp");
		return "redirect:/login";
	}
}
