package com.zb.servlet.teacher;

import com.zb.dao.TeacherDao;
import com.zb.daoImpl.TeacherDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TeacherDeleteSCServlet")
public class TeacherDeleteSCServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TeacherDao teacherDao = new TeacherDaoImpl();
        int i = teacherDao.deletedById(id);
        if(i==1) {
            request.getRequestDispatcher("").forward(request, response);
        }else {
            System.out.println("失败");
        }
    }
}
