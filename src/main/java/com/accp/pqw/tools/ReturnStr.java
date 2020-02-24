package com.accp.pqw.tools;

import java.util.List;

import com.accp.pqw.pojo.Token;

public class ReturnStr {
	public static String eCharts(List<Token> list) {
		// 生成eCharts表数据[{money:1212,name:雷军},{money:3555,name:丁磊}]
		String str = "[";
		for (int i = 0; i < list.size(); i++) {
			str += String.format("{'money':%s,'name':'%s'},", list.get(i).getMoney(), list.get(i).getName());
		}
		str = str.substring(0, str.length() - 1) + "]";
		return str;
	}
}
