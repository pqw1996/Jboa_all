package com.accp.pqw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.pqw.biz.TbLeaveBiz;
import com.accp.pqw.pojo.TbLeave;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-ctx.xml" })
public class TbLeaveTest {
	@Autowired
	private TbLeaveBiz biz;

	@Test
	public void add() {
		TbLeave l = new TbLeave();
		l.setCreateman(1);
		l.setDepartmentid(1);
		l.setEvent("1234");
		l.setNextdealman(2);
		l.setStatusid(2);
		l.setTotalcount(100);
		System.err.println(biz.addLeave(l));
	}

	@Test
	public void selectByEmpId() {
		biz.selectByEmpId(1007, 1, null, null).getList().forEach(row -> {
			System.err.println(row.getDepartmentName());
		});
	}

	@Test
	public void selectByDepId() {
		biz.selectByDepId(3, 1, "2020-01-01", "2020-12-05").getList().forEach(row -> {
			System.err.println(row.toString());
		});
	}

	@Test
	public void selectAll() {
		biz.selectAll(1, null, null).getList().forEach(row -> {
			row.getCheckList().forEach(i -> {
				System.err.println(i.toString());
			});
		});
	}

	@Test
	public void getOne() {
		// System.err.println(biz.getOne(8).getCreatemanName());
		System.err.println(biz.getOne("22").getNextdealmanName());
	}

	@Test
	public void selectGetApproved() {
		biz.selectGetApproved(2, "2000-01-01", "2020-01-03").getList().forEach(i -> {
			System.err.println(i.toString());
		});
	}

	@Test
	public void selectTip() {
		biz.selectTip(1, 1004).getList().forEach(i -> {
			System.err.println(i.toString());
		});
	}
}
