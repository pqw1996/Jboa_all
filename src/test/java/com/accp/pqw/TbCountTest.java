package com.accp.pqw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.pqw.biz.TbCountBiz;
import com.accp.pqw.pojo.TbCount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-ctx.xml" })
public class TbCountTest {
	@Autowired
	private TbCountBiz biz;

	@Test
	public void add() {
		System.err.println(biz.addTbCount(new TbCount(23.5f, 3, 1005)));
	}
}
