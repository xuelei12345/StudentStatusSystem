package com.zb.servlet.student;


import com.google.gson.Gson;
import com.zb.dao.StudentDao;
import com.zb.daoImpl.StudentDaoImpl;
import com.zb.pojo.ResultObj;


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
 * @create: 2020-07-15 12:46
 **/
@WebServlet("/StudentLiujiServlet")
public class StudentLiujiServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int sclass =Integer.parseInt(req.getParameter("sclass"));
        int id =Integer.parseInt(req.getParameter("id"));

        StudentDao dao = new StudentDaoImpl();
        int n = dao.liuji(sclass, id);


        if(n>0) {
            PrintWriter out = resp.getWriter();
            out.println(new Gson().toJson(ResultObj.ADD_SUCCESS));
        }

    }
}
