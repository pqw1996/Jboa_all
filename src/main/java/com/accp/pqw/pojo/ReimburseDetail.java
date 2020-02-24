package com.accp.pqw.pojo;

import java.io.Serializable;

/**
 * reimburse_detail
 * 
 * @author
 */
public class ReimburseDetail implements Serializable {
	/**
	 * 详情编号
	 */
	private Integer id;

	/**
	 * 报销主表编号
	 */
	private String mainid;

	/**
	 * 事项金额
	 */
	private Float subtotal;

	/**
	 * 事项描述
	 */
	private String desc;

	/**
	 * 报销单图片名
	 */
	private String imgs;

	private static final long serialVersionUID = 1L;

	public String getImgs() {
		return imgs;
	}

	public void setImgs(String imgs) {
		this.imgs = imgs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMainid() {
		return mainid;
	}

	public void setMainid(String mainid) {
		this.mainid = mainid;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
		ReimburseDetail other = (ReimburseDetail) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
				&& (this.getMainid() == null ? other.getMainid() == null : this.getMainid().equals(other.getMainid()))
				&& (this.getSubtotal() == null ? other.getSubtotal() == null
						: this.getSubtotal().equals(other.getSubtotal()))
				&& (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()))
				&& (this.getImgs() == null ? other.getImgs() == null : this.getImgs().equals(other.getImgs()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getMainid() == null) ? 0 : getMainid().hashCode());
		result = prime * result + ((getSubtotal() == null) ? 0 : getSubtotal().hashCode());
		result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
		result = prime * result + ((getImgs() == null) ? 0 : getImgs().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", mainid=").append(mainid);
		sb.append(", subtotal=").append(subtotal);
		sb.append(", desc=").append(desc);
		sb.append(", imgs=").append(imgs);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}

	/**
	 * 新增用
	 * 
	 * @param mainid
	 * @param subtotal
	 * @param desc
	 * @param imgs
	 */
	public ReimburseDetail(String mainid, float subtotal, String desc, String imgs) {
		this.setMainid(mainid);
		this.setDesc(desc);
		this.setSubtotal(subtotal);
		this.setImgs(imgs);
	}

	/**
	 * 不改图片用
	 * 
	 * @param id
	 * @param subtotal
	 * @param desc
	 */
	public ReimburseDetail(Integer id, float subtotal, String desc) {
		this.setId(id);
		this.setSubtotal(subtotal);
		this.setDesc(desc);
	}

	/**
	 * 改图片用
	 * 
	 * @param id
	 * @param subtotal
	 * @param desc
	 * @param imgs
	 */
	public ReimburseDetail(Integer id, float subtotal, String desc, String imgs) {
		this.setId(id);
		this.setSubtotal(subtotal);
		this.setDesc(desc);
		this.setImgs(imgs);
	}

	public ReimburseDetail() {
	}

}