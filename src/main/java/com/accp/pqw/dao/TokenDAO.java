package com.accp.pqw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pqw.pojo.Token;

public interface TokenDAO {
	/**
	 * 总经理月度
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	List<Token> selectTokens1(@Param("year") int year, @Param("month") int month);

	/**
	 * 部门经理月度
	 * 
	 * @param year
	 * @param month
	 * @param did
	 * @return
	 */
	List<Token> selectTokens2(@Param("year") int year, @Param("month") int month, @Param("did") int did);

	/**
	 * 总经理年度
	 * 
	 * @param year
	 * @return
	 */
	List<Token> selectTokens3(@Param("year") int year);

	/**
	 * 部门经理年度
	 * 
	 * @param year
	 * @param did
	 * @return
	 */
	List<Token> selectTokens4(@Param("year") int year, @Param("did") int did);
}
