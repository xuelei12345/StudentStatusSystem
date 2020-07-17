package com.zb.servlet.student;

import com.zb.dao.StudentDao;
import com.zb.dao.TeacherDao;
import com.zb.daoImpl.StudentDaoImpl;
import com.zb.daoImpl.TeacherDaoImpl;
import com.zb.pojo.Student;
import com.zb.pojo.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int    admin = Integer.parseInt(request.getParameter("sno"));
        String pwd   = request.getParameter("spwd");
        Student student = new Student();
        student.setSno(admin);
        student.setSpwd(pwd);
        StudentDao studentDao = new StudentDaoImpl();
        boolean login = studentDao.studentLogin(student);
        if(login == true){
            response.sendRedirect("success");
        }else {
            response.sendRedirect("error");
        }
    }
}
