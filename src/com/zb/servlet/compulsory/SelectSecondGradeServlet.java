package com.zb.servlet.compulsory;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.zb.dao.CompulsoryDao;
import com.zb.daoImpl.CompulsoryDaoImpl;
import com.zb.pojo.Sc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet( "selectSecondGrade")
public class SelectSecondGradeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("查询大二成绩");
        int sno = Integer.parseInt(req.getParameter("sno"));
        System.out.println(sno);

        CompulsoryDao dao =new CompulsoryDaoImpl();
        List<Sc> list = dao.searchSecondSc(sno);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",10);
        result.put("data", list);
        JSONObject json = new JSONObject(result);
        System.out.println(json);
        PrintWriter out = resp.getWriter();
        out.println(json.toJSONString());
    }
}
