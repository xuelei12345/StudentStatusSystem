package com.zb.servlet.student;


import com.google.gson.Gson;
import com.zb.dao.StudentDao;
import com.zb.daoImpl.StudentDaoImpl;
import com.zb.pojo.StopStudy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @program: StudentStatusSystem
 * @description:
 * @author: Mr.Gml
 * @create: 2020-07-16 8:44
 **/
@WebServlet("/SelectXiuxueServlet")
public class SelectXiuxueServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        StudentDao dao = new StudentDaoImpl();
        List<StopStudy> stopStudyList = dao.selectAllStopStudent();

        System.out.println(stopStudyList);

        Gson gson = new Gson();
        PrintWriter out = resp.getWriter();

        out.println(gson.toJson(stopStudyList));
    }

}