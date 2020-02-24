package com.accp.pqw.pojo;

import java.io.Serializable;

/**
 * tb_status
 * @author 
 */
public class TbStatus implements Serializable {
    /**
     * 状态编号
     */
    private Integer statusid;

    /**
     * 状态名称
     */
    private String statusname;

    private static final long serialVersionUID = 1L;

    public Integer getStatusid() {
        return statusid;
    }

    public void setStatusid(Integer statusid) {
        this.statusid = statusid;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
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
        TbStatus other = (TbStatus) that;
        return (this.getStatusid() == null ? other.getStatusid() == null : this.getStatusid().equals(other.getStatusid()))
            && (this.getStatusname() == null ? other.getStatusname() == null : this.getStatusname().equals(other.getStatusname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStatusid() == null) ? 0 : getStatusid().hashCode());
        result = prime * result + ((getStatusname() == null) ? 0 : getStatusname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", statusid=").append(statusid);
        sb.append(", statusname=").append(statusname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}