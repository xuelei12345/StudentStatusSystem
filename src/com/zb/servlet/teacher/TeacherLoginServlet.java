package com.zb.servlet.teacher;

import com.zb.dao.TeacherDao;
import com.zb.daoImpl.TeacherDaoImpl;
import com.zb.pojo.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String admin = request.getParameter("admin");
        String pwd   = request.getParameter("pwd");
        Teacher teacher = new Teacher();
        teacher.setAdmin(admin);
        teacher.setPwd(pwd);
        TeacherDao teacherDao = new TeacherDaoImpl();
        boolean login = teacherDao.teacherLogin(teacher);
        if(login == true){
            response.sendRedirect("success");
        }else {
            response.sendRedirect("error");
        }
    }
}
