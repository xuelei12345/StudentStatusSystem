package com.zb.dao;

import com.zb.pojo.Elective;

import java.util.List;

public interface ElectiveDao {
    //查询所有选修课
    public List<Elective> getAll(int page);
    //选修课数量
    public Integer getElectiveCount();
}
