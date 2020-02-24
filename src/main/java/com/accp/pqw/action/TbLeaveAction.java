package com.accp.pqw.action;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.pqw.biz.TbCheckBiz;
import com.accp.pqw.biz.TbLeaveBiz;
import com.accp.pqw.pojo.Employee;
import com.accp.pqw.pojo.TbCheck;
import com.accp.pqw.pojo.TbLeave;

@Controller
@RequestMapping("/c/TbLeave") // 命名空间
public class TbLeaveAction {
	@Autowired
	private TbLeaveBiz biz;
	@Autowired
	private TbCheckBiz cbiz;

	@RequestMapping("add")
	public String add(TbLeave tbl, HttpSession session) {
		// 创建职员对象对请假表对象赋值
		Employee emp = (Employee) session.getAttribute("emp");
		tbl.setCreateman(emp.getEmployeeid());
		tbl.setDepartmentid(emp.getDepartmentid());
		tbl.setNextdealman(emp.getPid());
		tbl.setStatusid(2);
		tbl.setLeaveid(UUID.randomUUID().toString().replace("-", ""));
		System.err.println(tbl.getLeaveid());
		if (emp.getPositionid() == 0) {
			// 总经理直接通过审批
			tbl.setStatusid(4);
		}
		biz.addLeave(tbl);
		// 重定向到分页界面
		return "redirect:/c/TbLeave/findPageList?pageNum=1&sTime=&eTime=";
	}

	@RequestMapping("findPageList")
	public String findPageList(HttpSession session, Model model, Integer pageNum, String sTime, String eTime) {
		// 创建职员对象,按职务分页查询
		Employee emp = (Employee) session.getAttribute("emp");
		// 如果时间是空字符串就变为空
		if ("".equals(sTime)) {
			sTime = null;
		}
		if ("".equals(eTime)) {
			eTime = null;
		}
		// 总经理看全部，人事看已审批，部门经理看部门，其他看自己
		if (emp.getPositionid() == 0) {
			model.addAttribute("pageList", biz.selectAll(pageNum, sTime, eTime));
		} else if (emp.getPositionid() == 4) {
			model.addAttribute("pageList", biz.selectGetApproved(pageNum, sTime, eTime));
		} else if (emp.getPositionid() == 1) {
			model.addAttribute("pageList", biz.selectByDepId(emp.getDepartmentid(), pageNum, sTime, eTime));
		} else {
			model.addAttribute("pageList", biz.selectByEmpId(emp.getEmployeeid(), pageNum, sTime, eTime));
		}
		model.addAttribute("sTime", sTime);
		model.addAttribute("eTime", eTime);
		return "leave/findList";
	}

	@RequestMapping("getOne")
	public String getOne(String id, Integer type, Model model) {
		model.addAttribute("l", biz.getOne(id));
		if (type == 1) {
			return "leave/getDetail";
		} else {
			return "leave/toCheckPage";
		}
	}

	@RequestMapping("checkLeave")
	public String checkLeave(HttpSession session, String leaveId, Integer statusId, String checkComment) {
		// 创建职员对象,按职务修改
		Employee emp = (Employee) session.getAttribute("emp");
		// 请假表对象
		TbLeave l = biz.getOne(leaveId);
		// 审查表对象
		TbCheck c = new TbCheck();
		// 部门经理或总经理
		if (emp.getPositionid() == 1 || emp.getPositionid() == 0) {
			// 状态改为已审批
			l.setStatusid(4);
			// 如果部门经理或总经理审批通过，就交由人事存档。否则直接跳过
			if (statusId == 1) {
				l.setNextdealman(1017);
			} else {
				l.setNextdealman(10000);
			}
			// 修改请假表对象
			biz.modifyOne(l);
		} else {
			// 人事存档、修改对象
			l.setStatusid(7);
			l.setNextdealman(10000);
			biz.modifyOne(l);
		}
		// 新增审查记录
		c.setBizid(leaveId);
		c.setTypeid(1);
		c.setCheckman(emp.getEmployeeid());
		c.setCheckresult(statusId);
		c.setCheckcomment(checkComment);
		cbiz.addCheck(c);
		// 重定向到分页界面
		return "redirect:/c/TbLeave/findPageList?pageNum=1&sTime=&eTime=";
	}
}
