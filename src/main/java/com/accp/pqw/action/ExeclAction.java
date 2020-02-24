package com.accp.pqw.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.pqw.biz.DepartmentBiz;
import com.accp.pqw.biz.TokenBiz;
import com.accp.pqw.pojo.Dates;
import com.accp.pqw.pojo.Employee;
import com.accp.pqw.tools.CreateExecl;

@Controller
@RequestMapping("/c/Execl") // 命名空间
public class ExeclAction {
	@Autowired
	private TokenBiz tbiz;
	@Autowired
	private DepartmentBiz dbiz;

	@RequestMapping("month")
	public String Month(int[] years, int[] months, float[] moneys, HttpSession s) {
		List<Dates> list = new ArrayList<Dates>();
		Employee emp = (Employee) s.getAttribute("emp");
		for (int i = 0; i < years.length; i++) {
			Dates d = new Dates(years[i], months[i], moneys[i]);
			// 区分总经理和部门经理
			if (emp.getPositionid() == 0) {
				d.setList(tbiz.queryTokens1(years[i], months[i]));
			} else {
				d.setList(tbiz.queryTokens2(years[i], months[i], emp.getDepartmentid()));
			}
			list.add(d);
		}
		CreateExecl.createExecl(list, dbiz.queryOne(emp.getDepartmentid()).getDepartmentname());
		return "redirect:/c/TbCount/findMonthList?pageNum=1&year=0&beginMonth=0&endMonth=0";
	}

	@RequestMapping("year")
	public String Year(int[] years, float[] moneys, HttpSession s) {
		List<Dates> list = new ArrayList<Dates>();
		Employee emp = (Employee) s.getAttribute("emp");
		for (int i = 0; i < years.length; i++) {
			Dates d = new Dates(years[i], moneys[i]);
			// 区分总经理和部门经理
			if (emp.getPositionid() == 0) {
				d.setList(tbiz.queryTokens3(years[i]));
			} else {
				d.setList(tbiz.queryTokens4(years[i], emp.getDepartmentid()));
			}
			list.add(d);
		}
		CreateExecl.createExecl(list, dbiz.queryOne(emp.getDepartmentid()).getDepartmentname());
		return "redirect:/c/TbCount/findYearList?pageNum=1&beginYear=0&endYear=0";
	}
}
