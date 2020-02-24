package com.accp.pqw.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.pqw.dao.TbLeaveDAO;
import com.accp.pqw.pojo.TbLeave;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("TbLeaveBiz")
public class TbLeaveBiz {
	@Autowired
	private TbLeaveDAO dao;

	// 新增请假表
	public int addLeave(TbLeave l) {
		return dao.insert(l);
	}

	// 职员id查询
	public PageInfo<TbLeave> selectByEmpId(Integer id, Integer pageNum, String sTime, String eTime) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<TbLeave>(dao.selectByEmpId(id, sTime, eTime));
	}

	// 部门id查询
	public PageInfo<TbLeave> selectByDepId(Integer id, Integer pageNum, String sTime, String eTime) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<TbLeave>(dao.selectByDepId(id, sTime, eTime));
	}

	// 查询全部
	public PageInfo<TbLeave> selectAll(Integer pageNum, String sTime, String eTime) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<TbLeave>(dao.selectAll(sTime, eTime));
	}

	// id查询
	public TbLeave getOne(String id) {
		return dao.selectByPrimaryKey(id);
	}

	// 修改
	public int modifyOne(TbLeave l) {
		return dao.updateByPrimaryKeySelective(l);
	}

	// 审核通过查询
	public PageInfo<TbLeave> selectGetApproved(Integer pageNum, String sTime, String eTime) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<TbLeave>(dao.selectGetApproved(sTime, eTime));
	}

	public PageInfo<TbLeave> selectTip(Integer pageNum, int id) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<TbLeave>(dao.selectTip(id));
	}

}
