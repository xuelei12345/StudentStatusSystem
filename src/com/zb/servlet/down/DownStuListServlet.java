package com.zb.servlet.down;

import com.zb.utils.down.ExcelPOI;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Rwenjie
 * @ProjectName: StudentStatusSystem
 * @Description:
 * @Date: 2020/7/20   8:20
 **/
@WebServlet("/downStuListServlet")
public class DownStuListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("开始下载学生list");
        //1.创建一个流，将我们生成的excel对象返回给浏览器
        ServletOutputStream out = response.getOutputStream();
        //2.设置头文件，让浏览器去下载
        response.setHeader("Content-Disposition","attachment;fileName=studentList.xls");
        //3.预先设置表头
        String [] titles = {"编号","姓名","班级","学号","年龄", "创建时间", "密码", "专业"};
        //调用ExcelPOI（我们自己创建的类）里面的方法，帮助我们生成excel
        ExcelPOI excelPOI = new ExcelPOI();
        excelPOI.export(titles,out);
        System.out.println("下载完成");
    }
}
