package com.accp.pqw.pojo;

import java.io.Serializable;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * tb_leave
 * 
 * @author
 */
public class TbLeave implements Serializable {
	/**
	 * 请假编号
	 */
	private String leaveid;

	/**
	 * 1表示为请假表
	 */
	private Integer typeid;

	/**
	 * 请假人编号
	 */
	private Integer createman;
	/**
	 * 请假人姓名
	 */
	private String createmanName;
	/**
	 * 请假人部门编号
	 */
	private Integer departmentid;
	/**
	 * 请假人部门名称
	 */
	private String departmentName;
	/**
	 * 创建时间
	 */
	private String createtime;

	/**
	 * 请假开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String starttime;

	/**
	 * 请假结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String endtime;

	/**
	 * 下个处理人，外键
	 */
	private Integer nextdealman;
	/**
	 * 下个处理人姓名
	 */
	private String nextdealmanName;
	/**
	 * 请假事由
	 */
	private String event;

	/**
	 * 请假总天数
	 */
	private Integer totalcount;

	/**
	 * 状态
	 */
	private Integer statusid;
	/**
	 * 审查记录集合
	 */
	private List<TbCheck> checkList;

	private static final long serialVersionUID = 1L;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	public List<TbCheck> getCheckList() {
		return checkList;
	}

	public void setCheckList(List<TbCheck> checkList) {
		this.checkList = checkList;
	}

	public String getLeaveid() {
		return leaveid;
	}

	public void setLeaveid(String leaveid) {
		this.leaveid = leaveid;
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

	public Integer getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
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

	public Integer getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(Integer totalcount) {
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
		TbLeave other = (TbLeave) that;
		return (this.getLeaveid() == null ? other.getLeaveid() == null : this.getLeaveid().equals(other.getLeaveid()))
				&& (this.getTypeid() == null ? other.getTypeid() == null : this.getTypeid().equals(other.getTypeid()))
				&& (this.getCreateman() == null ? other.getCreateman() == null
						: this.getCreateman().equals(other.getCreateman()))
				&& (this.getDepartmentid() == null ? other.getDepartmentid() == null
						: this.getDepartmentid().equals(other.getDepartmentid()))
				&& (this.getCreatetime() == null ? other.getCreatetime() == null
						: this.getCreatetime().equals(other.getCreatetime()))
				&& (this.getStarttime() == null ? other.getStarttime() == null
						: this.getStarttime().equals(other.getStarttime()))
				&& (this.getEndtime() == null ? other.getEndtime() == null
						: this.getEndtime().equals(other.getEndtime()))
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
		result = prime * result + ((getLeaveid() == null) ? 0 : getLeaveid().hashCode());
		result = prime * result + ((getTypeid() == null) ? 0 : getTypeid().hashCode());
		result = prime * result + ((getCreateman() == null) ? 0 : getCreateman().hashCode());
		result = prime * result + ((getDepartmentid() == null) ? 0 : getDepartmentid().hashCode());
		result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
		result = prime * result + ((getStarttime() == null) ? 0 : getStarttime().hashCode());
		result = prime * result + ((getEndtime() == null) ? 0 : getEndtime().hashCode());
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
		sb.append(", leaveid=").append(leaveid);
		sb.append(", typeid=").append(typeid);
		sb.append(", createman=").append(createman);
		sb.append(", departmentid=").append(departmentid);
		sb.append(", createtime=").append(createtime);
		sb.append(", starttime=").append(starttime);
		sb.append(", endtime=").append(endtime);
		sb.append(", nextdealman=").append(nextdealman);
		sb.append(", event=").append(event);
		sb.append(", totalcount=").append(totalcount);
		sb.append(", statusid=").append(statusid);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}