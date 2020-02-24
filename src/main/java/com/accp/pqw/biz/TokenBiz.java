package com.accp.pqw.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.pqw.dao.TokenDAO;
import com.accp.pqw.pojo.Token;

@Service("TokenBiz")
public class TokenBiz {
	@Autowired
	private TokenDAO dao;

	public List<Token> queryTokens1(int year, int month) {
		return dao.selectTokens1(year, month);
	}

	public List<Token> queryTokens2(int year, int month, int did) {
		return dao.selectTokens2(year, month, did);
	}

	public List<Token> queryTokens3(int year) {
		return dao.selectTokens3(year);
	}

	public List<Token> queryTokens4(int year, int did) {
		return dao.selectTokens4(year, did);
	}

}
