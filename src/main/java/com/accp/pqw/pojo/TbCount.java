package com.accp.pqw.pojo;

import java.io.Serializable;

/**
 * tb_count
 * 
 * @author
 */
public class TbCount implements Serializable {
	/**
	 * 统计编号
	 */
	private Integer countid;

	/**
	 * 金额
	 */
	private Float money;

	/**
	 * 年份
	 */
	private Integer year;

	/**
	 * 月份
	 */
	private Integer month;

	/**
	 * 部门编号
	 */
	private Integer departmentid;

	/**
	 * 员工编号
	 */
	private Integer employeeid;

	/**
	 * 部门名称
	 */
	private String departmentname;

	/**
	 * 员工名称
	 */
	private String employeename;

	private static final long serialVersionUID = 1L;

	public Integer getCountid() {
		return countid;
	}

	public void setCountid(Integer countid) {
		this.countid = countid;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

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

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		TbCount other = (TbCount) that;
		return (this.getCountid() == null ? other.getCountid() == null : this.getCountid().equals(other.getCountid()))
				&& (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
				&& (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
				&& (this.getMonth() == null ? other.getMonth() == null : this.getMonth().equals(other.getMonth()))
				&& (this.getDepartmentid() == null ? other.getDepartmentid() == null
						: this.getDepartmentid().equals(other.getDepartmentid()))
				&& (this.getEmployeeid() == null ? other.getEmployeeid() == null
						: this.getEmployeeid().equals(other.getEmployeeid()))
				&& (this.getDepartmentname() == null ? other.getDepartmentname() == null
						: this.getDepartmentname().equals(other.getDepartmentname()))
				&& (this.getEmployeename() == null ? other.getEmployeename() == null
						: this.getEmployeename().equals(other.getEmployeename()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCountid() == null) ? 0 : getCountid().hashCode());
		result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
		result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
		result = prime * result + ((getMonth() == null) ? 0 : getMonth().hashCode());
		result = prime * result + ((getDepartmentid() == null) ? 0 : getDepartmentid().hashCode());
		result = prime * result + ((getEmployeeid() == null) ? 0 : getEmployeeid().hashCode());
		result = prime * result + ((getDepartmentname() == null) ? 0 : getDepartmentname().hashCode());
		result = prime * result + ((getEmployeename() == null) ? 0 : getEmployeename().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", countid=").append(countid);
		sb.append(", money=").append(money);
		sb.append(", year=").append(year);
		sb.append(", month=").append(month);
		sb.append(", departmentid=").append(departmentid);
		sb.append(", employeeid=").append(employeeid);
		sb.append(", departmentname=").append(departmentname);
		sb.append(", employeename=").append(employeename);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}

	public TbCount() {
	}

	public TbCount(float money, int departmentid, int employeeid) {
		this.setMoney(money);
		this.setDepartmentid(departmentid);
		this.setEmployeeid(employeeid);
	}
}