package com.accp.pqw.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.pqw.biz.DatesBiz;
import com.accp.pqw.biz.DepartmentBiz;
import com.accp.pqw.biz.TokenBiz;
import com.accp.pqw.pojo.Dates;
import com.accp.pqw.pojo.Employee;
import com.accp.pqw.tools.ReturnStr;

@Controller
@RequestMapping("/c/TbCount") // 命名空间
public class TbCountAction {
	@Autowired
	private DatesBiz biz;
	@Autowired
	private TokenBiz tbiz;
	@Autowired
	private DepartmentBiz dbiz;

	@RequestMapping("findMonthList")
	public String findMonthList(Model m, int pageNum, int year, int beginMonth, int endMonth, HttpSession s) {
		Employee emp = (Employee) s.getAttribute("emp");
		// 区分总经理和部门经理
		if (emp.getPositionid() == 0) {
			m.addAttribute("pageList", biz.queryDates1(pageNum, year, beginMonth, endMonth));
		} else {
			m.addAttribute("pageList", biz.queryDates2(pageNum, year, beginMonth, endMonth, emp.getDepartmentid()));
		}
		m.addAttribute("year", year).addAttribute("beginMonth", beginMonth).addAttribute("endMonth", endMonth);
		return "statistics/monthList";
	}

	@RequestMapping("findYearList")
	public String findYearList(int beginYear, int endYear, int pageNum, HttpSession s, Model m) {
		Employee emp = (Employee) s.getAttribute("emp");
		// 区分总经理和部门经理
		if (emp.getPositionid() == 0) {
			m.addAttribute("pageList", biz.queryDates3(pageNum, beginYear, endYear));
		} else {
			m.addAttribute("pageList", biz.queryDates4(pageNum, beginYear, endYear, emp.getDepartmentid()));
		}
		m.addAttribute("beginYear", beginYear).addAttribute("endYear", endYear);
		return "statistics/yearList";
	}

	@RequestMapping("monthDetails")
	public String monthDetails(int year, int month, float money, Model m, HttpSession s) {
		Dates date = new Dates(year, month, money);
		Employee emp = (Employee) s.getAttribute("emp");
		// 区分总经理和部门经理
		if (emp.getPositionid() == 0) {
			date.setList(tbiz.queryTokens1(year, month));
		} else {
			date.setList(tbiz.queryTokens2(year, month, emp.getDepartmentid()));
		}
		m.addAttribute("date", date).addAttribute("eChartsDate", ReturnStr.eCharts(date.getList()))
				.addAttribute("dName", dbiz.queryOne(emp.getDepartmentid()).getDepartmentname());
		return "statistics/monthDetails";
	}

	@RequestMapping("yearDetails")
	public String yearDetails(int year, float money, Model m, HttpSession s) {
		Dates date = new Dates(year, 0, money);
		System.err.println(date.getYear() + "\t" + date.getMoney());
		Employee emp = (Employee) s.getAttribute("emp");
		// 区分总经理和部门经理
		if (emp.getPositionid() == 0) {
			date.setList(tbiz.queryTokens3(year));
		} else {
			date.setList(tbiz.queryTokens4(year, emp.getDepartmentid()));
		}
		m.addAttribute("date", date).addAttribute("eChartsDate", ReturnStr.eCharts(date.getList()))
				.addAttribute("dName", dbiz.queryOne(emp.getDepartmentid()).getDepartmentname());
		return "statistics/yearDetails";
	}
}
