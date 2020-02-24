package com.accp.pqw.pojo;

import java.io.Serializable;

/**
 * check_result
 * @author 
 */
public class CheckResult implements Serializable {
    /**
     * 结果编号
     */
    private Integer resultid;

    /**
     * 结果名称
     */
    private String resultname;

    private static final long serialVersionUID = 1L;

    public Integer getResultid() {
        return resultid;
    }

    public void setResultid(Integer resultid) {
        this.resultid = resultid;
    }

    public String getResultname() {
        return resultname;
    }

    public void setResultname(String resultname) {
        this.resultname = resultname;
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
        CheckResult other = (CheckResult) that;
        return (this.getResultid() == null ? other.getResultid() == null : this.getResultid().equals(other.getResultid()))
            && (this.getResultname() == null ? other.getResultname() == null : this.getResultname().equals(other.getResultname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getResultid() == null) ? 0 : getResultid().hashCode());
        result = prime * result + ((getResultname() == null) ? 0 : getResultname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resultid=").append(resultid);
        sb.append(", resultname=").append(resultname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}