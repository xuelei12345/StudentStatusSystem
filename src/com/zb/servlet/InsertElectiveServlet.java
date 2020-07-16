package com.zb.servlet;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.zb.dao.ElectiveDao;
import com.zb.daoImpl.ElectiveDaoImpl;
import com.zb.pojo.ResultObj;
import com.zb.pojo.Sc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/insertElective")
public class InsertElectiveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer cno = Integer.parseInt(request.getParameter("cno"));
        System.out.println(cno);
        Integer sno = Integer.parseInt(request.getParameter("sno"));
        System.out.println(sno);
        ElectiveDao electiveDao = new ElectiveDaoImpl();
        Sc sc=electiveDao.searchOne(cno,sno);
        System.out.println(sc);
        if(sc!=null){
            Gson gson = new Gson();
            String json = gson.toJson(sc);

            PrintWriter pw = response.getWriter();
            pw.write(json);
            pw.println(JSON.toJSONString(ResultObj.SELECT_COURSE));
        }else{
            electiveDao.insertElective(cno,sno);
            PrintWriter pw = response.getWriter();
            pw.println(JSON.toJSONString(ResultObj.ADD_HOT));
        }
    }
}
