package com.accp.pqw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.pqw.biz.TbReimburseBiz;
import com.accp.pqw.pojo.TbReimburse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-ctx.xml" })
public class TbReimburseTest {
	@Autowired
	private TbReimburseBiz biz;

	@Test
	public void add() {
		TbReimburse t = new TbReimburse();
		t.setCreateman(1004);
		t.setDepartmentid(2);
		t.setEvent("哦豁！");
		t.setNextdealman(1000);
		t.setReimburseid("1234567890");
		t.setStatusid(1);
		t.setTotalcount(25.5f);
		System.err.println(biz.add(t));
	}

	@Test
	public void queryByCreateMan() {
		biz.queryByCreateMan(1, 1008, 5, null, "2018-07-31").getList().forEach(i -> {
			System.err.println(i.toString());
		});
	}

	@Test
	public void queryByDepartment() {
		biz.queryByDepartment(1004, 1, 3, 0, null, null).getList().forEach(i -> {
			System.err.println(i.getCreatemanName());
		});
	}

	@Test
	public void modifyStatusid() {
		TbReimburse t = new TbReimburse("2d8109c69c0c45d590532c2ac6516eb2", 1);
		t.setTotalcount(5001f);
		t.setEvent("OJBK!");
		System.err.println(biz.modifyStatusid(t));
	}

	@Test
	public void removeById() {
		System.err.println(biz.removeById("1"));
	}

	@Test
	public void getOne() {
		System.err.println(biz.getOne("2"));
	}

	@Test
	public void queryAll() {
		biz.queryAll(1000, 1, 2, null, null).getList().forEach(i -> {
			System.err.println(i.toString());
		});
	}

	@Test
	public void selectTip() {
		biz.selectTip(1, 10000).getList().forEach(i -> {
			System.err.println(i.toString());
		});
	}
}
