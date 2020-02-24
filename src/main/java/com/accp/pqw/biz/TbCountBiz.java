package com.accp.pqw.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.pqw.dao.TbCountDAO;
import com.accp.pqw.pojo.TbCount;

@Service("TbCountBiz")
public class TbCountBiz {
	@Autowired
	private TbCountDAO dao;

	public int addTbCount(TbCount tc) {
		return dao.insert(tc);
	}
}
