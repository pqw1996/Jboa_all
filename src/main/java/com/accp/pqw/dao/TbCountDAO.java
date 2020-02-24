package com.accp.pqw.dao;

import com.accp.pqw.pojo.TbCount;

public interface TbCountDAO {
    int deleteByPrimaryKey(Integer countid);

    int insert(TbCount record);

    int insertSelective(TbCount record);

    TbCount selectByPrimaryKey(Integer countid);

    int updateByPrimaryKeySelective(TbCount record);

    int updateByPrimaryKey(TbCount record);
}