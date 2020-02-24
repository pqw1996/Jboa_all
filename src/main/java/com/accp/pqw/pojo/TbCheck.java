package com.accp.pqw.pojo;

import java.io.Serializable;

/**
 * tb_check
 * 
 * @author
 */
public class TbCheck implements Serializable {
	/**
	 * 审查记录编号
	 */
	private Integer checkid;

	/**
	 * 业务编号，关联请假表或报销主表
	 */
	private String bizid;

	/**
	 * 1：请假表，2：报销表；关联请假表或报销主表中type_id字段
	 */
	private Integer typeid;

	/**
	 * 审查时间
	 */
	private String checktime;

	/**
	 * 审查人编号
	 */
	private Integer checkman;
	/**
	 * 审查人姓名
	 */
	private String checkmanName;
	/**
	 * 审查结果，外键，关联审查结果表
	 */
	private Integer checkresult;

	/**
	 * 审查意见
	 */
	private String checkcomment;

	private static final long serialVersionUID = 1L;

	public String getCheckmanName() {
		return checkmanName;
	}

	public void setCheckmanName(String checkmanName) {
		this.checkmanName = checkmanName;
	}

	public Integer getCheckid() {
		return checkid;
	}

	public void setCheckid(Integer checkid) {
		this.checkid = checkid;
	}

	public String getBizid() {
		return bizid;
	}

	public void setBizid(String bizid) {
		this.bizid = bizid;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getChecktime() {
		return checktime;
	}

	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}

	public Integer getCheckman() {
		return checkman;
	}

	public void setCheckman(Integer checkman) {
		this.checkman = checkman;
	}

	public Integer getCheckresult() {
		return checkresult;
	}

	public void setCheckresult(Integer checkresult) {
		this.checkresult = checkresult;
	}

	public String getCheckcomment() {
		return checkcomment;
	}

	public void setCheckcomment(String checkcomment) {
		this.checkcomment = checkcomment;
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
		TbCheck other = (TbCheck) that;
		return (this.getCheckid() == null ? other.getCheckid() == null : this.getCheckid().equals(other.getCheckid()))
				&& (this.getBizid() == null ? other.getBizid() == null : this.getBizid().equals(other.getBizid()))
				&& (this.getTypeid() == null ? other.getTypeid() == null : this.getTypeid().equals(other.getTypeid()))
				&& (this.getChecktime() == null ? other.getChecktime() == null
						: this.getChecktime().equals(other.getChecktime()))
				&& (this.getCheckman() == null ? other.getCheckman() == null
						: this.getCheckman().equals(other.getCheckman()))
				&& (this.getCheckresult() == null ? other.getCheckresult() == null
						: this.getCheckresult().equals(other.getCheckresult()))
				&& (this.getCheckcomment() == null ? other.getCheckcomment() == null
						: this.getCheckcomment().equals(other.getCheckcomment()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCheckid() == null) ? 0 : getCheckid().hashCode());
		result = prime * result + ((getBizid() == null) ? 0 : getBizid().hashCode());
		result = prime * result + ((getTypeid() == null) ? 0 : getTypeid().hashCode());
		result = prime * result + ((getChecktime() == null) ? 0 : getChecktime().hashCode());
		result = prime * result + ((getCheckman() == null) ? 0 : getCheckman().hashCode());
		result = prime * result + ((getCheckresult() == null) ? 0 : getCheckresult().hashCode());
		result = prime * result + ((getCheckcomment() == null) ? 0 : getCheckcomment().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", checkid=").append(checkid);
		sb.append(", bizid=").append(bizid);
		sb.append(", typeid=").append(typeid);
		sb.append(", checktime=").append(checktime);
		sb.append(", checkman=").append(checkman);
		sb.append(", checkmanName=").append(checkmanName);
		sb.append(", checkresult=").append(checkresult);
		sb.append(", checkcomment=").append(checkcomment);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}

}