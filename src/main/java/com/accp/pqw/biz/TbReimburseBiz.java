package com.accp.pqw.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.pqw.dao.TbReimburseDAO;
import com.accp.pqw.pojo.TbReimburse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("TbReimburseBiz")
public class TbReimburseBiz {
	@Autowired
	private TbReimburseDAO dao;

	public int add(TbReimburse t) {
		return dao.insert(t);
	}

	public PageInfo<TbReimburse> queryByCreateMan(Integer pageNum, Integer empId, Integer statusId, String sTime,
			String eTime) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<TbReimburse>(dao.queryByCreateMan(empId, statusId, sTime, eTime));
	}

	public PageInfo<TbReimburse> queryByDepartment(Integer empId, Integer pageNum, Integer depId, Integer statusId,
			String sTime, String eTime) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<TbReimburse>(dao.queryByDepartment(empId, depId, statusId, sTime, eTime));
	}

	public PageInfo<TbReimburse> queryAll(Integer empId, Integer pageNum, Integer statusId, String sTime,
			String eTime) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<TbReimburse>(dao.queryAll(empId, statusId, sTime, eTime));
	}

	public PageInfo<TbReimburse> queryByCashier(Integer empId, Integer pageNum, String sTime, String eTime) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<TbReimburse>(dao.queryByCashier(empId, sTime, eTime));
	}

	public int modifyStatusid(TbReimburse t) {
		return dao.updateByPrimaryKeySelective(t);
	}

	public int removeById(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	public TbReimburse getOne(String id) {
		return dao.selectByPrimaryKey(id);
	}

	public int modifyByObj(TbReimburse t) {
		return dao.updateByPrimaryKeySelective(t);
	}

	public PageInfo<TbReimburse> selectTip(int pageNum, int id) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<TbReimburse>(dao.selectTip(id));
	}
}
