package com.zb.dao;

import com.zb.pojo.Sc;
import com.zb.pojo.Teacher;

public interface TeacherDao {
    //老师登录验证
    public boolean teacherLogin(Teacher teacher);
    //老师删除成绩
    public int deletedById(int id);
    //查询单个学生成绩信息
    public Sc findSc_grade(Sc sc);
    //修改成绩
    public int updateGrade(Sc sc);
}
