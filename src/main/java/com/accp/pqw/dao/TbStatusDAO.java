package com.accp.pqw.dao;

import com.accp.pqw.pojo.TbStatus;

public interface TbStatusDAO {
    int deleteByPrimaryKey(Integer statusid);

    int insert(TbStatus record);

    int insertSelective(TbStatus record);

    TbStatus selectByPrimaryKey(Integer statusid);

    int updateByPrimaryKeySelective(TbStatus record);

    int updateByPrimaryKey(TbStatus record);
}