package com.accp.pqw.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.pqw.dao.ReimburseDetailDAO;
import com.accp.pqw.pojo.ReimburseDetail;

@Service("ReimburseDetailBiz")
public class ReimburseDetailBiz {
	@Autowired
	private ReimburseDetailDAO dao;

	public boolean addRds(List<ReimburseDetail> rds) {
		int count = 0;
		for (ReimburseDetail reimburseDetail : rds) {
			if (dao.insert(reimburseDetail) > 0) {
				count++;
			}
		}
		return count == rds.size();
	}

	public int removeByMianId(String id) {
		return dao.deleteByMianId(id);
	}

	public List<ReimburseDetail> queryByMianId(String id) {
		return dao.queryByMianId(id);
	}

	public int removeByUpdate(String mid, int[] ids) {
		return dao.deleteByUpdate(mid, ids);
	}

	public int modifyByObj(ReimburseDetail rd) {
		return dao.updateByPrimaryKeySelective(rd);
	}
}
