package nuc.ss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import nuc.ss.dao.StudentDao;
import nuc.ss.daoImpl.StudentDaoImpl;
import nuc.ss.entity.ResultObj;

/**
 * Servlet implementation class StudentDelete
 */
@WebServlet("/StudentDelete")
public class StudentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int id =Integer.parseInt(req.getParameter("id"));
		StudentDao dao = new StudentDaoImpl();
		int n = dao.delete(id);
	    if(n>0) {
	    	PrintWriter out = resp.getWriter();
	    	out.println(JSON.toJSONString(ResultObj.DELETE_SUCCESS));
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
