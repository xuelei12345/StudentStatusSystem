package com.zb.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static ComboPooledDataSource dataSource =
            new ComboPooledDataSource("c3p0-config.xml");
    static String driverClass;
    static String url;
    static String username;
    static String password;

    //通过连接池获取链接
    public static Connection getConnectionByDataSource(){
        Connection conn = null;
        try{
            conn= dataSource.getConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 获取数据 连接
    public static Connection getConnection() {
        try {
            Class.forName(driverClass);
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
