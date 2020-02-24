package com.accp.pqw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pqw.pojo.Dates;

public interface DatesDAO {
	/**
	 * 总经理月度
	 * 
	 * @param year
	 * @param beginMonth
	 * @param endMonth
	 * @return
	 */
	List<Dates> selectDates1(@Param("year") int year, @Param("beginMonth") int beginMonth,
			@Param("endMonth") int endMonth);

	Dates selectOne1(int index);

	/**
	 * 部门经理月度
	 * 
	 * @param year
	 * @param beginMonth
	 * @param endMonth
	 * @param did
	 * @return
	 */
	List<Dates> selectDates2(@Param("year") int year, @Param("beginMonth") int beginMonth,
			@Param("endMonth") int endMonth, @Param("did") int did);

	/**
	 * 总经理年度
	 * 
	 * @param beginYear
	 * @param endYear
	 * @return
	 */
	List<Dates> selectDates3(@Param("beginYear") int beginYear, @Param("endYear") int endYear);

	/**
	 * 部门经理年度
	 * 
	 * @param beginYear
	 * @param endYear
	 * @param did
	 * @return
	 */
	List<Dates> selectDates4(@Param("beginYear") int beginYear, @Param("endYear") int endYear, @Param("did") int did);
}
