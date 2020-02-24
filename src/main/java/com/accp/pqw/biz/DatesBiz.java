package com.accp.pqw.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.pqw.dao.DatesDAO;
import com.accp.pqw.pojo.Dates;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("DateBiz")
public class DatesBiz {
	@Autowired
	private DatesDAO dao;

	public PageInfo<Dates> queryDates1(int pageNum, int year, int beginMonth, int endMonth) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<Dates>(dao.selectDates1(year, beginMonth, endMonth));
	}

	public PageInfo<Dates> queryDates2(int pageNum, int year, int beginMonth, int endMonth, int did) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<Dates>(dao.selectDates2(year, beginMonth, endMonth, did));
	}

	public PageInfo<Dates> queryDates3(int pageNum, int beginYear, int endYear) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<Dates>(dao.selectDates3(beginYear, endYear));
	}

	public PageInfo<Dates> queryDates4(int pageNum, int beginYear, int endYear, int did) {
		PageHelper.startPage(pageNum, 10);
		return new PageInfo<Dates>(dao.selectDates4(beginYear, endYear, did));
	}
}
