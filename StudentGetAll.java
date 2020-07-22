package nuc.ss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import nuc.ss.dao.StudentDao;
import nuc.ss.daoImpl.StudentDaoImpl;
import nuc.ss.entity.Student;

/**
 * Servlet implementation class StudentGetAll
 */
@WebServlet("/StudentGetAll")
public class StudentGetAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int page =Integer.parseInt(req.getParameter("page")); 
		int curr=(page-1)*5;
		StudentDao dao = new StudentDaoImpl();
		List<Student> student = dao.getAll(curr);
		Map<String, Object> result = new HashMap<String, Object>();
    	result.put("code", 0);
    	result.put("msg", "");
    	result.put("count",10);
    	result.put("data", student);
    	JSONObject json = new JSONObject(result);
    	PrintWriter out = resp.getWriter();
        out.println(json.toJSONString());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
