package com.accp.pqw.pojo;

public class Token {
	private Integer id;
	private String name;
	private Float money;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public Token() {

	}

	public Token(int id, String name, float money) {
		this.setId(id);
		this.setName(name);
		this.setMoney(money);
	}
}
