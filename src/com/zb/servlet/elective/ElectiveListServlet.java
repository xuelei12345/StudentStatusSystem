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
import java.util.List;

@WebServlet(name = "SelAllElectiveServlet")
public class SelAllElectiveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = Integer.parseInt(req.getParameter("page"));
        ElectiveDao dao = new ElectiveDaoImpl();
        List<Elective> list = dao.getAll(page);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        resp.getWriter().write(json);
    }
}
