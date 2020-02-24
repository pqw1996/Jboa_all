package com.accp.pqw.dao;

import com.accp.pqw.pojo.Position;

public interface PositionDAO {
    int deleteByPrimaryKey(Integer positionid);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer positionid);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}