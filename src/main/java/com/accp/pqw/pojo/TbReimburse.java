package com.accp.pqw.pojo;

import java.io.Serializable;

/**
 * tb_reimburse
 * 
 * @author
 */
public class TbReimburse implements Serializable {
	/**
	 * 报销编号
	 */
	private String reimburseid;

	/**
	 * 2代表报销表
	 */
	private Integer typeid;

	/**
	 * 报销人
	 */
	private Integer createman;

	/**
	 * 创建时间
	 */
	private String createtime;

	/**
	 * 部门编号
	 */
	private Integer departmentid;

	/**
	 * 下个处理人
	 */
	private Integer nextdealman;

	/**
	 * 报销事由
	 */
	private String event;

	/**
	 * 报销总金额
	 */
	private Float totalcount;

	/**
	 * 状态，外键，关联状态表
	 */
	private Integer statusid;

	/**
	 * 创建人
	 */
	private String createmanName;

	/**
	 * 下个处理人
	 */
	private String nextdealmanName;

	/**
	 * check结果
	 */
	private int check;

	private static final long serialVersionUID = 1L;

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public String getCreatemanName() {
		return createmanName;
	}

	public void setCreatemanName(String createmanName) {
		this.createmanName = createmanName;
	}

	public String getNextdealmanName() {
		return nextdealmanName;
	}

	public void setNextdealmanName(String nextdealmanName) {
		this.nextdealmanName = nextdealmanName;
	}

	public String getReimburseid() {
		return reimburseid;
	}

	public void setReimburseid(String reimburseid) {
		this.reimburseid = reimburseid;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public Integer getCreateman() {
		return createman;
	}

	public void setCreateman(Integer createman) {
		this.createman = createman;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public Integer getNextdealman() {
		return nextdealman;
	}

	public void setNextdealman(Integer nextdealman) {
		this.nextdealman = nextdealman;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Float getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(Float totalcount) {
		this.totalcount = totalcount;
	}

	public Integer getStatusid() {
		return statusid;
	}

	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
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
		TbReimburse other = (TbReimburse) that;
		return (this.getReimburseid() == null ? other.getReimburseid() == null
				: this.getReimburseid().equals(other.getReimburseid()))
				&& (this.getTypeid() == null ? other.getTypeid() == null : this.getTypeid().equals(other.getTypeid()))
				&& (this.getCreateman() == null ? other.getCreateman() == null
						: this.getCreateman().equals(other.getCreateman()))
				&& (this.getCreatetime() == null ? other.getCreatetime() == null
						: this.getCreatetime().equals(other.getCreatetime()))
				&& (this.getDepartmentid() == null ? other.getDepartmentid() == null
						: this.getDepartmentid().equals(other.getDepartmentid()))
				&& (this.getNextdealman() == null ? other.getNextdealman() == null
						: this.getNextdealman().equals(other.getNextdealman()))
				&& (this.getEvent() == null ? other.getEvent() == null : this.getEvent().equals(other.getEvent()))
				&& (this.getTotalcount() == null ? other.getTotalcount() == null
						: this.getTotalcount().equals(other.getTotalcount()))
				&& (this.getStatusid() == null ? other.getStatusid() == null
						: this.getStatusid().equals(other.getStatusid()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getReimburseid() == null) ? 0 : getReimburseid().hashCode());
		result = prime * result + ((getTypeid() == null) ? 0 : getTypeid().hashCode());
		result = prime * result + ((getCreateman() == null) ? 0 : getCreateman().hashCode());
		result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
		result = prime * result + ((getDepartmentid() == null) ? 0 : getDepartmentid().hashCode());
		result = prime * result + ((getNextdealman() == null) ? 0 : getNextdealman().hashCode());
		result = prime * result + ((getEvent() == null) ? 0 : getEvent().hashCode());
		result = prime * result + ((getTotalcount() == null) ? 0 : getTotalcount().hashCode());
		result = prime * result + ((getStatusid() == null) ? 0 : getStatusid().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", reimburseid=").append(reimburseid);
		sb.append(", typeid=").append(typeid);
		sb.append(", createman=").append(createman);
		sb.append(", createtime=").append(createtime);
		sb.append(", departmentid=").append(departmentid);
		sb.append(", nextdealman=").append(nextdealman);
		sb.append(", event=").append(event);
		sb.append(", totalcount=").append(totalcount);
		sb.append(", statusid=").append(statusid);
		sb.append(", createmanName=").append(createmanName);
		sb.append(", nextdealmanName=").append(nextdealmanName);
		sb.append(", check=").append(check);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}

	public TbReimburse() {
	}

	public TbReimburse(String id, int statusid) {
		this.setReimburseid(id);
		this.setStatusid(statusid);
	}
}