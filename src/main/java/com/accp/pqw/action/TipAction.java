package com.accp.pqw.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.pqw.biz.TbLeaveBiz;
import com.accp.pqw.biz.TbReimburseBiz;
import com.accp.pqw.pojo.Employee;

@Controller
@RequestMapping("/c/Tip") // 命名空间
public class TipAction {
	@Autowired
	private TbLeaveBiz biz;
	@Autowired
	private TbReimburseBiz tBiz;

	@RequestMapping("findList")
	public String findList(HttpSession session, Model model) {
		// 创建职员对象,按职务分页查询
		Employee emp = (Employee) session.getAttribute("emp");
		// 总经理看全部，人事看已审批，部门经理看部门，其他看自己
		model.addAttribute("pageList1", biz.selectTip(1, emp.getEmployeeid()));
		model.addAttribute("pageList2", tBiz.selectTip(1, emp.getEmployeeid()));
		return "NewFile1";
	}
}
