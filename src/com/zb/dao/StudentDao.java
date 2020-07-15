package com.zb.dao;

import com.zb.pojo.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 添加学生信息
     * @Param [student]
     * @return: void
     */
    int addStudent(Student student);

    /**
     * 查找所有学生的信息
     * @Param []
     * @return: java.util.List<com.zb.pojo.Student>
     */

    List<Student> selAllStudent();

}
