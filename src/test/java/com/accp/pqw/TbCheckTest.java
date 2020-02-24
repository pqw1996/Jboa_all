package com.accp.pqw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.pqw.biz.TbCheckBiz;
import com.accp.pqw.pojo.TbCheck;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-ctx.xml" })
public class TbCheckTest {
	@Autowired
	private TbCheckBiz biz;

	@Test
	public void getOne() {
		System.err.println(biz.getOne(35));
	}

	@Test
	public void addOne() {
		TbCheck c = new TbCheck();
		c.setBizid("1");
		c.setTypeid(1);
		c.setCheckman(1);
		c.setCheckresult(1);
		c.setCheckcomment("1234");
		System.err.println(biz.addCheck(c));
	}

	@Test
	public void selectByBizId() {
		biz.selectByBizId(2, "18").forEach(i -> {
			System.err.println(i.toString());
		});
	}

	@Test
	public void deleteByBizId() {
		System.err.println(biz.removeByBizId("78"));
	}
}
