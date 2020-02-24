package com.accp.pqw.pojo;

import java.io.Serializable;

/**
 * employee
 * 
 * @author
 */
public class Employee implements Serializable {
	/**
	 * 用户编号
	 */
	private Integer employeeid;

	/**
	 * 用户姓名
	 */
	private String employeename;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 所属部门编号，外键
	 */
	private Integer departmentid;

	/**
	 * 职位编号，外键
	 */
	private Integer positionid;

	/**
	 * 上级id
	 */
	private Integer pid;

	private static final long serialVersionUID = 1L;

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public Integer getPositionid() {
		return positionid;
	}

	public void setPositionid(Integer positionid) {
		this.positionid = positionid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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
		Employee other = (Employee) that;
		return (this.getEmployeeid() == null ? other.getEmployeeid() == null
				: this.getEmployeeid().equals(other.getEmployeeid()))
				&& (this.getEmployeename() == null ? other.getEmployeename() == null
						: this.getEmployeename().equals(other.getEmployeename()))
				&& (this.getPassword() == null ? other.getPassword() == null
						: this.getPassword().equals(other.getPassword()))
				&& (this.getDepartmentid() == null ? other.getDepartmentid() == null
						: this.getDepartmentid().equals(other.getDepartmentid()))
				&& (this.getPositionid() == null ? other.getPositionid() == null
						: this.getPositionid().equals(other.getPositionid()))
				&& (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getEmployeeid() == null) ? 0 : getEmployeeid().hashCode());
		result = prime * result + ((getEmployeename() == null) ? 0 : getEmployeename().hashCode());
		result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
		result = prime * result + ((getDepartmentid() == null) ? 0 : getDepartmentid().hashCode());
		result = prime * result + ((getPositionid() == null) ? 0 : getPositionid().hashCode());
		result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", employeeid=").append(employeeid);
		sb.append(", employeename=").append(employeename);
		sb.append(", password=").append(password);
		sb.append(", departmentid=").append(departmentid);
		sb.append(", positionid=").append(positionid);
		sb.append(", pid=").append(pid);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}