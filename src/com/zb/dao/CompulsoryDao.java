package com.zb.dao;

import com.zb.pojo.Sc;

import java.util.List;

public interface CompulsoryDao {
    //查询大一的必修成绩
    public List<Sc> searchOneSc(int sno);
    //查询大二必修成绩
    public List<Sc> searchSecondSc(int sno);
    //查询大三必修成绩
    public List<Sc> searchThirdSc(int sno);
    //查询大四必修成绩
    public List<Sc> searchFourthSc(int sno);
}
