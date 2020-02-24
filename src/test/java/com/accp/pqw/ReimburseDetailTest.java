package com.accp.pqw;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.pqw.biz.ReimburseDetailBiz;
import com.accp.pqw.pojo.ReimburseDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-ctx.xml" })
public class ReimburseDetailTest {
	@Autowired
	private ReimburseDetailBiz biz;

	@Test
	public void add() {
		ReimburseDetail r1 = new ReimburseDetail();
		r1.setDesc("ssdfsd");
		r1.setImgs("sfdffsd");
		r1.setMainid("1234");
		r1.setSubtotal(23.5f);
		ReimburseDetail r2 = new ReimburseDetail();
		r2.setDesc("fgfglhk");
		r2.setImgs("sdsaadayut");
		r2.setMainid("1234");
		r2.setSubtotal(53f);
		List<ReimburseDetail> rds = new ArrayList<ReimburseDetail>();
		rds.add(r1);
		rds.add(r2);
		System.err.println(biz.addRds(rds));
	}

	@Test
	public void queryByMianId() {
		biz.queryByMianId("16").forEach(i -> {
			System.err.println(i.toString());
		});
	}

	@Test
	public void removeByUpdate() {
		System.err.println(biz.removeByUpdate("2d8109c69c0c45d590532c2ac6516eb2", null));
	}
}
