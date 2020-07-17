package com.zb.daoImpl;

import com.zb.dao.TeacherDao;
import com.zb.pojo.Sc;
import com.zb.pojo.Teacher;
import com.zb.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherDaoImpl implements TeacherDao {


    //老师登录
    @Override
    public boolean teacherLogin(Teacher teacher) {
        try{
            Connection conn = DBUtil.getConn();
            String sql = "select * from teacher where admin=? and pwd = ?";
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,teacher.getAdmin());
            ps.setString(2,teacher.getPwd());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
            DBUtil.close(conn,ps,rs);
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }



    //成绩删除
    @Override
    public int deletedById(int id){
        try{
            Connection conn = DBUtil.getConn();
            String sql = "delete from sc where id = ?";
            QueryRunner qr = new QueryRunner();
            return qr.update(sql,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    //查询学生信息
    @Override
    public Sc findSc_grade(Sc sc){
        try{
            Connection conn = DBUtil.getConn();
            String sql = "select * from sc  where id=?";
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,sc.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sc.setGrade(rs.getInt("grade"));
            }
            DBUtil.close(conn,ps,rs);
            return  sc;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    //修改成绩
    @Override
    public int updateGrade(Sc sc){
        try{
            Connection conn = DBUtil.getConn();
            String sql = "update sc set grade = ? where id = ?";
            QueryRunner qr = new QueryRunner();
            return qr.update(sql, sc.getGrade(), sc.getId());
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
