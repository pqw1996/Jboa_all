package com.accp.pqw.action;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.accp.pqw.biz.EmployeeBiz;
import com.accp.pqw.biz.ReimburseDetailBiz;
import com.accp.pqw.biz.TbCheckBiz;
import com.accp.pqw.biz.TbCountBiz;
import com.accp.pqw.biz.TbReimburseBiz;
import com.accp.pqw.pojo.Employee;
import com.accp.pqw.pojo.ReimburseDetail;
import com.accp.pqw.pojo.TbCheck;
import com.accp.pqw.pojo.TbCount;
import com.accp.pqw.pojo.TbReimburse;

@Controller
@RequestMapping("/c/TbReimburse") // 命名空间
public class TbReimburseAction {
	@Autowired
	private TbReimburseBiz tBiz;
	@Autowired
	private ReimburseDetailBiz rdBiz;
	@Autowired
	private EmployeeBiz eBiz;
	@Autowired
	private TbCheckBiz tcBiz;
	@Autowired
	private TbCountBiz tctBiz;

	@RequestMapping("add")
	public String addTbReimburses(String[] desc, Float[] subtotal, MultipartFile[] imgFile, HttpSession session,
			String event, Float totalcount, Integer statusId) {
		// 报销表
		Employee emp = (Employee) session.getAttribute("emp");
		TbReimburse tb = new TbReimburse();
		tb.setCreateman(emp.getEmployeeid());
		tb.setDepartmentid(emp.getDepartmentid());
		// 总经理报销，直接交由财务审批。
		if (emp.getPositionid() == 0) {
			tb.setNextdealman(1001);
		} else {
			// 其他交上级
			tb.setNextdealman(emp.getPid());
		}
		// 事由、总金额、状态
		tb.setEvent(event);
		tb.setTotalcount(totalcount);
		tb.setStatusid(statusId);
		// 主键uuid
		String uuid = UUID.randomUUID().toString().replace("-", "");
		tb.setReimburseid(uuid);
		// 把图片文件数组转成Base64字符串数组
		String[] imgStrs = new String[desc.length];
		for (int i = 0; i < desc.length; i++) {
			Base64.Encoder base64Encoder = Base64.getEncoder();
			try {
				imgStrs[i] = "DATA:image/png;base64," + base64Encoder.encodeToString(imgFile[i].getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 报销表明细
		List<ReimburseDetail> rds = new ArrayList<ReimburseDetail>();
		for (int i = 0; i < desc.length; i++) {
			ReimburseDetail r = new ReimburseDetail();
			r.setDesc(desc[i]);
			r.setSubtotal(subtotal[i]);
			r.setImgs(imgStrs[i]);
			r.setMainid(uuid);
			rds.add(r);
		}
		if (tBiz.add(tb) > 0 && rdBiz.addRds(rds)) {
			System.out.println("完成！");
		}
		return "redirect:/c/TbReimburse/findPageList?pageNum=1&type=0";
	}

	@RequestMapping("findPageList")
	public String findPageList(Integer pageNum, Integer[] type, String sTime, String eTime, HttpSession session,
			Model m) {
		if ("".equals(sTime)) {
			sTime = null;
		}
		if ("".equals(eTime)) {
			eTime = null;
		}
		Employee emp = (Employee) session.getAttribute("emp");
		if (emp.getPositionid() == 2 || emp.getPositionid() == 4) {
			// 普通员工和人事看自己的
			m.addAttribute("pageList", tBiz.queryByCreateMan(pageNum, emp.getEmployeeid(), type[0], sTime, eTime));
		} else if (emp.getPositionid() == 1) {
			// 部门经理看自己部门的
			m.addAttribute("pageList",
					tBiz.queryByDepartment(emp.getEmployeeid(), pageNum, emp.getDepartmentid(), type[0], sTime, eTime));
		} else if (emp.getPositionid() == 0 || emp.getPositionid() == 3) {
			// 总经理和财务看全部
			m.addAttribute("pageList", tBiz.queryAll(emp.getEmployeeid(), pageNum, type[0], sTime, eTime));
		} else {
			// 出纳看已审批的
			m.addAttribute("pageList", tBiz.queryByCashier(emp.getEmployeeid(), pageNum, sTime, eTime));
		}
		m.addAttribute("type", type[0]);
		m.addAttribute("sTime", sTime);
		m.addAttribute("eTime", eTime);
		return "page/findList";
	}

	@RequestMapping("submit")
	public String submit(String id, int statusid, int pageNum, int type, String sTime, String eTime) {
		tBiz.modifyStatusid(new TbReimburse(id, statusid));
		return "redirect:/c/TbReimburse/findPageList?pageNum=" + pageNum + "&type=" + type + "&sTime=" + sTime
				+ "&eTime=" + eTime;
	}

	@RequestMapping("delete")
	public String delete(String id, int pageNum, int size, String sTime, String eTime, int type) {
		// 删除三张表内容
		tBiz.removeById(id);
		rdBiz.removeByMianId(id);
		tcBiz.removeByBizId(id);
		// 如果是最后一页的最后一个就回到上一页
		if (pageNum > 1 && size - 1 == 0) {
			pageNum--;
		}
		return "redirect:/c/TbReimburse/findPageList?pageNum=" + pageNum + "&type=" + type + "&sTime=" + sTime
				+ "&eTime=" + eTime;
	}

	@RequestMapping("getDetails")
	public String getDetails(String id, Model m, int choice) {
		TbReimburse t = tBiz.getOne(id);
		m.addAttribute("trb", t);
		// 职员信息
		m.addAttribute("emp", eBiz.getOne(t.getCreateman()));
		// 项目信息
		m.addAttribute("rds", rdBiz.queryByMianId(id));
		// 审核信息
		m.addAttribute("tcs", tcBiz.selectByBizId(2, id));
		if (choice == 1) {
			return "page/getDetails";
		} else {
			return "page/toUpdatePage";
		}
	}

	@RequestMapping("toCheck")
	public String toCheck(String id, Model m) {
		TbReimburse t = tBiz.getOne(id);
		m.addAttribute("trb", t);
		// 职员信息
		m.addAttribute("emp", eBiz.getOne(t.getCreateman()));
		// 项目信息
		m.addAttribute("rds", rdBiz.queryByMianId(id));
		return "page/toCheckPage";
	}

	@RequestMapping("updateStatus")
	public String updateStatus(TbCheck tc, HttpSession s) {
		tc.setTypeid(2);
		tc.setCheckman(((Employee) s.getAttribute("emp")).getEmployeeid());
		if (tcBiz.addCheck(tc) > 0) {
			System.out.println("完成");
		}
		TbReimburse tr = tBiz.getOne(tc.getBizid());
		switch (tc.getCheckresult()) {
		case 1:// 通过
			tr.setStatusid(3);// 改为审批中
			switch (((Employee) s.getAttribute("emp")).getPositionid()) {
			case 0:// 总经理
				tr.setNextdealman(1001);
				break;
			case 1:// 部门经理
				if (tr.getTotalcount() >= 5000) {
					tr.setNextdealman(1000);
				} else {
					tr.setNextdealman(1001);
				}
				break;
			case 3:// 财务
				tr.setNextdealman(1002);
				tr.setStatusid(4);// 改为已审批
				break;
			case 5:// 出纳
				tr.setNextdealman(10000);
				tr.setStatusid(5);// 改为已付款
				// 统计报表
				tctBiz.addTbCount(new TbCount(tr.getTotalcount(), tr.getDepartmentid(), tr.getCreateman()));
				break;
			}
			tBiz.modifyByObj(tr);// 修改
			break;
		case 2:// 拒绝
			tr.setStatusid(4);
			tBiz.modifyStatusid(tr);
			break;
		case 3:// 打回
			tr.setStatusid(6);
			// 重新设置处理人
			tr.setNextdealman(eBiz.getOne(tr.getCreateman()).getPid());
			tBiz.modifyStatusid(tr);
			break;
		}
		return "redirect:/c/TbReimburse/findPageList?pageNum=1&type=0";
	}

	@RequestMapping("toUpdatePage")
	public String toUpdatePage(TbReimburse tb, String[] desc, float[] subtotal, MultipartFile[] imgs, int[] ids,
			String[] opr) {
		// 修改主表对象
		tBiz.modifyByObj(tb);
		// 删除从表数据(delete from a where mid='aaa' and id not in(1,3,4....))
		rdBiz.removeByUpdate(tb.getReimburseid(), ids);
		// 如果没有改图片是no，新增是add，改了是yes。 no除图片、id外全改，add新增，yes除id外全改
		int count = 0;
		List<ReimburseDetail> rds = new ArrayList<ReimburseDetail>();
		Base64.Encoder base64Str = Base64.getEncoder();
		for (int i = 0; i < opr.length; i++) {
			switch (opr[i]) {
			case "no":
				// 图片不修改
				rdBiz.modifyByObj(new ReimburseDetail(ids[count++], subtotal[i], desc[i]));
				break;
			case "yes":
				// 图片修改
				try {
					rdBiz.modifyByObj(new ReimburseDetail(ids[count++], subtotal[i], desc[i],
							"DATA:image/png;base64," + base64Str.encodeToString(imgs[i].getBytes())));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break;
			default:
				try {
					rds.add(new ReimburseDetail(tb.getReimburseid(), subtotal[i], desc[i],
							"DATA:image/png;base64," + base64Str.encodeToString(imgs[i].getBytes())));
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
		// 新增
		rdBiz.addRds(rds);
		return "redirect:/c/TbReimburse/findPageList?pageNum=1&type=0";
	}
}
