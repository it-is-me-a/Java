package com.qq.server.db;

import java.sql.*;

/** 
 * ClassName: SqlHelper
 * @Description: 连接数据库
 * @author Emma
 */
public class SqlHelper {

    private static Connection Conn; // 数据库连接对象

    // 连接的数据库地址
    private static String URL = "jdbc:mysql://localhost:3306/myschool";
    // 数据库的用户名
    private static String UserName = "root";
    // 数据库的密码
    private static String Password = "18309293959";

    
    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver"); // 加载驱动
System.out.println("加载驱动成功!!!");
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        try {

            //通过DriverManager类的getConenction方法指定三个参数,连接数据库
            Conn = DriverManager.getConnection(URL, UserName, Password);
System.out.println("连接数据库成功!!!");

            //返回连接对象
            return Conn;

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

}

