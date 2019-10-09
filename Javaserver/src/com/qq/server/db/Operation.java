package com.qq.server.db;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import com.qq.common.User;
import com.qq.server.db.*;

/** 
 * ClassName: Operation
 * @Description: 对数据库进行相关操作
 * @author Emma
 */
public class Operation{

	//测试代码
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Operation o = new Operation();
//		o.Select();
//		o.Insert("6","123456");
	}
	
	// 连接对象
    private Connection conn;
    // 传递sql语句
    private Statement stt;
    // 结果集,暂时存放数据库查询操作获取到的数据集
    private ResultSet set;
    
    public List<String> list = new ArrayList<String>();  //集合
    
    public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	// 查询操作
    public void Select() {
        try {
            // 获取连接
            conn = SqlHelper.getConnection();
            if (conn == null)
                return;
            // 定义sql语句
            String Sql = "select * from qqlogin";  //获取表login的数据
            // 创建语句
            stt = conn.createStatement();
            // 返回结果集
            set = stt.executeQuery(Sql);//执行给定的sql语句
            // 显示获取到的数据
            
            while (set.next()) {
               // System.out.println("QQ号:" + set.getString(1) + "\t密码:" + set.getString(2));
               list.add(set.getString(1) + " " + set.getString(2));
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
                set.close();
                conn.close();
            } catch (Exception e2) {
                // TODO: handle exception
            	e2.printStackTrace();
            }

       }
    }
    
    //向数据库添加数据
    public void Insert(String qqnumber, String qqkeynumber){        
        try {
            //获取连接
        	conn = SqlHelper.getConnection();
            if(conn==null)
            	return;
            
            //获取用户输入的账号和密码
//            Scanner input = new Scanner(System.in);
//            System.out.print("请输入用户名:");
//            int user = input.nextInt();
//            System.out.print("请输入密码:");
//            String pwd = input.next();
            
            String user = qqnumber;
            String pwd = qqkeynumber;
            
            //定义sql语句
            String sql = "insert into qqlogin values("+user+" , '"+pwd+"');";
            //获取Statement对象
            stt = conn.createStatement();
            //执行sql语句
            stt.executeUpdate(sql);
 System.out.println("数据插入成功！");           
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            try {                
                conn.close();                
            } catch (Exception e2) {
            	e2.printStackTrace();
            }
        }
     
    }
    
    
    public void realse(){
    	try {
            set.close();
            conn.close();
        } catch (Exception e2) {
            // TODO: handle exception
        	e2.printStackTrace();
        }
    }
   
    
    
}

