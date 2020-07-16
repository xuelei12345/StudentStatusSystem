package com.zb.servlet;

import com.google.gson.Gson;
import com.zb.dao.ElectiveDao;
import com.zb.daoImpl.ElectiveDaoImpl;
import com.zb.pojo.Elective;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/searchCourse")
public class SearchCourseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sno =Integer.parseInt(request.getParameter("sno"));
        System.out.println(sno);
        ElectiveDao electiveDao = new ElectiveDaoImpl();
        List<Elective> list = electiveDao.searchCourse(sno);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        PrintWriter pw = response.getWriter();
        pw.write(json);
    }
}
