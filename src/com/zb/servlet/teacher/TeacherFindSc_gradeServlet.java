package com.zb.servlet.teacher;

import com.zb.dao.TeacherDao;
import com.zb.daoImpl.TeacherDaoImpl;
import com.zb.pojo.Sc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TeacherFindSc_gradeServlet")
public class TeacherFindSc_gradeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Sc sc = new Sc();
        sc.setId(id);
        TeacherDao teacherDao = new TeacherDaoImpl();
        sc = teacherDao.findSc_grade(sc);
        request.setAttribute("sc",sc);
        request.getRequestDispatcher("UpdateGradeServlet").forward(request,response);
    }
}
