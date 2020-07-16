package com.zb.servlet;

import com.alibaba.fastjson.JSON;
import com.zb.dao.ElectiveDao;
import com.zb.daoImpl.ElectiveDaoImpl;
import com.zb.pojo.ResultObj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteElective")
public class DeleteElectiveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cno = Integer.parseInt(request.getParameter("cno"));
        System.out.println(cno);
        int sno = Integer.parseInt(request.getParameter("sno"));
        System.out.println(sno);
        ElectiveDao electiveDao = new ElectiveDaoImpl();
        electiveDao.deleteElective(cno,sno);
        PrintWriter pw = response.getWriter();
        pw.println(JSON.toJSONString(ResultObj.DELETE_SUCCESS));
    }
}
