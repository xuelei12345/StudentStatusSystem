package com.zb.daoImpl;

import com.zb.dao.ElectiveDao;
import com.zb.pojo.Elective;
import com.zb.pojo.Sc;
import com.zb.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
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
}
