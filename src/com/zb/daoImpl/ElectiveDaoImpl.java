package com.zb.daoImpl;

import com.zb.dao.ElectiveDao;
import com.zb.pojo.Elective;
import com.zb.pojo.Sc;
import com.zb.utils.DBUtil;
import com.zb.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ElectiveDaoImpl implements ElectiveDao {

    @Override
    public void insertElective(int cno, int sno) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        String sql ="insert into sc(sno,cno) values(?,?)";
        try {
            qr.update(sql,sno,cno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sc searchOne(int cno, int sno) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

        String sql="select * from sc where sno = ? and cno = ?";
        try {
            return qr.query(sql,new BeanHandler<Sc>(Sc.class),sno,cno);

        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public List<Elective> searchCourse(int sno) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "select *  from  elective where cno in (select cno  from sc where cno like '11%' and sno = ?)";
        try {
            return qr.query(sql,new BeanListHandler<Elective>(Elective.class),sno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteElective(int sno, int cno) {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
        String sql = "delete from sc where cno=? and sno=?";
        try {
            qr.update(sql,sno,cno);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Elective> getAll(int page) {
        try {
            Connection conn = DBUtil.getConn();
            String sql = "select * from elective limit ?,5";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,page);
            ResultSet rs = ps.executeQuery();
            Elective elective =null;
            List<Elective> list = new ArrayList<>();
            while (rs.next()){
                elective = new Elective();
                elective.setId(rs.getInt("id"));
                elective.setCno(rs.getInt("cno"));
                elective.setCname(rs.getString("cname"));
                elective.setCnumber(rs.getInt("cnumber"));
                elective.setTeacher(rs.getString("teacher"));
                elective.setCreate_time(rs.getString("created_time"));
                elective.setMajor(rs.getString("major"));
                list.add(elective);
            }
            DBUtil.close(conn, ps, rs);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getElectiveCount() {
        try {
            Connection conn = DBUtil.getConn();
            String sql = "select count(*) as count from elective";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()){
                count = rs.getInt("count");
            }
            DBUtil.close(conn, ps, rs);
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
