package com.zb.servlet.student;

import com.google.gson.Gson;
import com.zb.dao.StudentDao;
import com.zb.daoImpl.StudentDaoImpl;
import com.zb.pojo.ResultObj;
import com.zb.pojo.StopStudy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: StudentStatusSystem
 * @description:
 * @author: Mr.Gml
 * @create: 2020-07-16 10:41
 **/
@WebServlet("/StudentXiuxueServlet")
public class StudentXiuxueServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

//        int id =Integer.parseInt(req.getParameter("id"));
        int sno =Integer.parseInt(req.getParameter("sno"));
        int sage =Integer.parseInt(req.getParameter("sage"));
        String sname =req.getParameter("sname");
        int sclass =Integer.parseInt(req.getParameter("sclass"));
        String spwd =req.getParameter("spwd");
        String major =req.getParameter("major");

        StudentDao dao = new StudentDaoImpl();
//
 //       dao.delete(id);
        StopStudy stop  = new StopStudy();
        stop.setMajor(major);
        stop.setSclass(sclass);
        stop.setSname(sname);
        stop.setSage(sage);
        stop.setSno(sno);
        stop.setSpwd(spwd);
        int n = dao.xiuxue(stop);
        if(n>0) {
            PrintWriter out = resp.getWriter();
            out.println(new Gson().toJson(ResultObj.ADD_SUCCESS));
        }
    }
}
