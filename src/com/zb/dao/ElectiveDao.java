package com.zb.dao;

import com.zb.pojo.Elective;
import com.zb.pojo.Sc;

import java.util.List;

public interface ElectiveDao {
    public void insertElective(int cno,int sno);
    public Sc searchOne(int cno, int sno);
    public List<Elective> searchCourse(int sno);
    public void deleteElective(int cno,int sno);
}
