package com.zb.servlet.student;

import com.google.gson.Gson;
import com.zb.dao.StudentDao;
import com.zb.daoImpl.StudentDaoImpl;
import com.zb.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Rwenjie
 * @ProjectName: StudentStatusSystem
 * @Description:
 * @Date: 2020/7/15   9:37
 * url:localhost:8080//studentListServlet
 * return
 **/
@WebServlet("/studentListServlet")
public class StudentListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("查询所有学生的信息");
        StudentDao studao = new StudentDaoImpl();
        List<Student> list = studao.selAllStudent();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        response.getWriter().write(json);
    }
}
