package com.qq.server.db;

import java.sql.*;

/** 
 * ClassName: SqlHelper
 * @Description: �������ݿ�
 * @author Emma
 */
public class SqlHelper {

    private static Connection Conn; // ���ݿ����Ӷ���

    // ���ӵ����ݿ��ַ
    private static String URL = "jdbc:mysql://localhost:3306/myschool";
    // ���ݿ���û���
    private static String UserName = "root";
    // ���ݿ������
    private static String Password = "18309293959";

    
    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver"); // ��������
System.out.println("���������ɹ�!!!");
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        try {

            //ͨ��DriverManager���getConenction����ָ����������,�������ݿ�
            Conn = DriverManager.getConnection(URL, UserName, Password);
System.out.println("�������ݿ�ɹ�!!!");

            //�������Ӷ���
            return Conn;

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }

}

