package com.zb.daoImpl;

import com.zb.dao.StudentDao;
import com.zb.pojo.Student;
import com.zb.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public int addStudent(Student student) {
        Connection conn = null;
        try {
            conn = DBUtil.getConn();
            /*insert into student(sname, sclass, sno, sage, major) values ('Rwenjie', '17130113', 1713011353, 22, '软件工程');*/
            String sql = "insert into student(sname, sclass, sno, sage, major,spwd) values (?, ?, ?, ?, ?, ?);";
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getSname());
            ps.setString(2, student.getSclass());
            ps.setInt(3, student.getSno());
            ps.setInt(4, student.getSage());
            ps.setString(5, student.getMajor());
            ps.setString(6,student.getSpwd());
            int n = ps.executeUpdate();
            DBUtil.close(conn, ps, null);
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Student> selAllStudent() {
        try {
            Connection conn = DBUtil.getConn();
            String sql = "select * from student";
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Student student =null;
            List<Student> list = new ArrayList<>();
            while (rs.next()){
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setSname(rs.getString("sname"));
                student.setSclass(rs.getString("sclass"));
                student.setSno(rs.getInt("sno"));
                student.setSage(rs.getInt("sage"));
                student.setCreate_time(rs.getString("create_time"));
                student.setDeleted(rs.getInt("deleted"));
                student.setSpwd(rs.getString("spwd"));
                student.setMajor(rs.getString("major"));
                list.add(student);
            }
            DBUtil.close(conn, ps, rs);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //留级功能
    @Override
    public int liuji(int sclass, int id) {
        String sql = "update student set  sclass=? where id=?";
        QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
        try {
            return qr.update(sql,sclass,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
