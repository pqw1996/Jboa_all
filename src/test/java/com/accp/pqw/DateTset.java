package com.accp.pqw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.pqw.biz.DatesBiz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-ctx.xml" })
public class DateTset {
	@Autowired
	private DatesBiz biz;

	@Test
	public void queryDates1() {
		biz.queryDates1(1, 2018, 0, 0).getList().forEach(i -> {
			System.err.println(i.getYear() + "\t" + i.getMonth() + "\t" + i.getMoney());
		});
	}

	@Test
	public void queryDates2() {
		biz.queryDates2(1, 2018, 0, 0, 3).getList().forEach(i -> {
			System.err.println(i.getYear() + "\t" + i.getMonth() + "\t" + i.getMoney());
		});
	}

	@Test
	public void queryDates3() {
		biz.queryDates3(1, 2018, 2020).getList().forEach(i -> {
			System.err.println(i.getYear() + "\t" + i.getMonth() + "\t" + i.getMoney());
		});
	}
}
