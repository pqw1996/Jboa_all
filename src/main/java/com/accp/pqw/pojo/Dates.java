package com.accp.pqw.pojo;

import java.util.List;

public class Dates {
	private Integer year;
	private Integer month;
	private Float money;
	private List<Token> list;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public List<Token> getList() {
		return list;
	}

	public void setList(List<Token> list) {
		this.list = list;
	}

	public Dates() {

	}

	public Dates(int year, int month, float money) {
		this.setMoney(money);
		this.setMonth(month);
		this.setYear(year);
	}

	public Dates(int year, float money) {
		this.setMoney(money);
		this.setYear(year);
	}
}
