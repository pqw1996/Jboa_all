package com.accp.pqw.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.pqw.dao.TbCheckDAO;
import com.accp.pqw.pojo.TbCheck;

@Service("TbCheckBiz")
public class TbCheckBiz {
	@Autowired
	private TbCheckDAO dao;

	public TbCheck getOne(Integer id) {
		return dao.selectByPrimaryKey(id);
	}

	public int addCheck(TbCheck c) {
		return dao.insert(c);
	}

	public List<TbCheck> selectByBizId(Integer tid, String bid) {
		return dao.selectByBizId(tid, bid);
	}

	public int removeByBizId(String bizId) {
		return dao.deleteByBizId(bizId);
	}
}
