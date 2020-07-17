package com.zb.dao;

import com.zb.pojo.Elective;
import com.zb.pojo.Sc;

import java.util.List;

public interface ElectiveDao {
    public void insertElective(int cno,int sno);
    public Sc searchOne(int cno, int sno);
    public List<Elective> searchCourse(int sno);
    public void deleteElective(int sno,int cno);
    //查询所有选修课
    public List<Elective> getAll(int page);
    //选修课数量
    public Integer getElectiveCount();

}
