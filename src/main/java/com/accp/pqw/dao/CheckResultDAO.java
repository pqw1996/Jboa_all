package com.accp.pqw.dao;

import com.accp.pqw.pojo.CheckResult;

public interface CheckResultDAO {
    int deleteByPrimaryKey(Integer resultid);

    int insert(CheckResult record);

    int insertSelective(CheckResult record);

    CheckResult selectByPrimaryKey(Integer resultid);

    int updateByPrimaryKeySelective(CheckResult record);

    int updateByPrimaryKey(CheckResult record);
}