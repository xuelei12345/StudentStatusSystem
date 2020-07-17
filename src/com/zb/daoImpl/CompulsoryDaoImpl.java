package com.zb.daoImpl;

import com.zb.dao.CompulsoryDao;
import com.zb.pojo.Sc;
import com.zb.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CompulsoryDaoImpl implements CompulsoryDao {
    @Override
    public List<Sc> searchOneSc(int sno) {
        String sql = "select s1.id , s1.grade ,c2.cno ,c2.cname ,c2.teacher	from sc s1 , compulsory c2 where s1.cno = c2.cno and s1.sno = ?  and s1.cno like '10%'";
        QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
        try {
            return  qr.query(sql,new BeanListHandler<Sc>(Sc.class),sno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Sc> searchSecondSc(int sno) {
        String sql = "select s1.id , s1.grade ,c2.cno ,c2.cname ,c2.teacher	from sc s1 , compulsory c2 where s1.cno = c2.cno and s1.sno = ?  and s1.cno like '20%'";
        QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
        try {
            return  qr.query(sql,new BeanListHandler<Sc>(Sc.class),sno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Sc> searchThirdSc(int sno) {
        String sql = "select s1.id , s1.grade ,c2.cno ,c2.cname ,c2.teacher	from sc s1 , compulsory c2 where s1.cno = c2.cno and s1.sno = ?  and s1.cno like '30%'";
        QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
        try {
            return  qr.query(sql,new BeanListHandler<Sc>(Sc.class),sno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Sc> searchFourthSc(int sno) {
        String sql = "select s1.id , s1.grade ,c2.cno ,c2.cname ,c2.teacher	from sc s1 , compulsory c2 where s1.cno = c2.cno and s1.sno = ?  and s1.cno like '40%'";
        QueryRunner qr = new QueryRunner(DBUtil.getDataSource());
        try {
            return  qr.query(sql,new BeanListHandler<Sc>(Sc.class),sno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
