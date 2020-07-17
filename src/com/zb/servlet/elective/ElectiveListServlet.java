package com.zb.servlet.elective;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/electivelist")
public class ElectiveListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = Integer.parseInt(req.getParameter("page"));
        int curr = (page-1)*5;
        ElectiveDao dao = new ElectiveDaoImpl();
        List<Elective> list = dao.getAll(curr);
        int count = dao.getElectiveCount();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count",count);
        result.put("data", list);
        Gson gson = new Gson();
        String json = gson.toJson(result);
        System.out.println(json);
        resp.getWriter().write(json);
    }
}
