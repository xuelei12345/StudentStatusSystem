package com.zb.servlet.student;

import com.alibaba.fastjson.JSON;
import com.zb.dao.StudentDao;
import com.zb.daoImpl.StudentDaoImpl;
import com.zb.pojo.ResultObj;
import com.zb.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Rwenjie
 */
@WebServlet("/addStudentServlet")
public class AddStudentServlet extends HttpServlet {
    /**
     * @author: Rwenjie
     * @description: //TODO 任文杰测试上传
     * url:localhost:8080//addStudentServlet?son=12345678&sage=25&sname=Rwenjie&sclass=171300113&spwd=123456&major=软件工程
     * return {"code":200,"msg":"添加成功"}
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("添加学生信息");
        System.out.println(req.toString());
        int sno =Integer.parseInt(req.getParameter("sno"));
        int sage =Integer.parseInt(req.getParameter("sage"));
        String sname =req.getParameter("sname");
        String sclass = req.getParameter("sclass");
        String spwd =req.getParameter("spwd");
        String major =req.getParameter("major");
        StudentDao dao = new StudentDaoImpl();
        Student student  = new Student();
        student.setMajor(major);
        student.setSclass(sclass);
        student.setSname(sname);
        student.setSage(sage);
        student.setSno(sno);
        student.setSpwd(spwd);
        int n = dao.addStudent(student);
        if(n>0) {
            PrintWriter out = resp.getWriter();
            out.println(JSON.toJSONString(ResultObj.ADD_SUCCESS));
        }
    }
}
