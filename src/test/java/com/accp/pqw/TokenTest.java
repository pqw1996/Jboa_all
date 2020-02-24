package com.accp.pqw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.pqw.biz.TokenBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-ctx.xml" })
public class TokenTest {
	@Autowired
	private TokenBiz biz;

	@Test
	public void select1() {
		biz.queryTokens1(2018, 5).forEach(i -> {
			System.err.println(i.getId() + "\t" + i.getMoney() + "\t" + i.getName());
		});
	}

	@Test
	public void select2() {
		biz.queryTokens2(2018, 6, 3).forEach(i -> {
			System.err.println(i.getId() + "\t" + i.getMoney() + "\t" + i.getName());
		});
	}

	@Test
	public void select3() {
		biz.queryTokens3(2018).forEach(i -> {
			System.err.println(i.getId() + "\t" + i.getMoney() + "\t" + i.getName());
		});
	}

	@Test
	public void select4() {
		biz.queryTokens4(2018, 3).forEach(i -> {
			System.err.println(i.getId() + "\t" + i.getMoney() + "\t" + i.getName());
		});
	}
}
