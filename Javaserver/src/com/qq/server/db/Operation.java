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
 * @Description: �����ݿ������ز���
 * @author Emma
 */
public class Operation{

	//���Դ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Operation o = new Operation();
//		o.Select();
//		o.Insert("6","123456");
	}
	
	// ���Ӷ���
    private Connection conn;
    // ����sql���
    private Statement stt;
    // �����,��ʱ������ݿ��ѯ������ȡ�������ݼ�
    private ResultSet set;
    
    public List<String> list = new ArrayList<String>();  //����
    
    public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	// ��ѯ����
    public void Select() {
        try {
            // ��ȡ����
            conn = SqlHelper.getConnection();
            if (conn == null)
                return;
            // ����sql���
            String Sql = "select * from qqlogin";  //��ȡ��login������
            // �������
            stt = conn.createStatement();
            // ���ؽ����
            set = stt.executeQuery(Sql);//ִ�и�����sql���
            // ��ʾ��ȡ��������
            
            while (set.next()) {
               // System.out.println("QQ��:" + set.getString(1) + "\t����:" + set.getString(2));
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
    
    //�����ݿ��������
    public void Insert(String qqnumber, String qqkeynumber){        
        try {
            //��ȡ����
        	conn = SqlHelper.getConnection();
            if(conn==null)
            	return;
            
            //��ȡ�û�������˺ź�����
//            Scanner input = new Scanner(System.in);
//            System.out.print("�������û���:");
//            int user = input.nextInt();
//            System.out.print("����������:");
//            String pwd = input.next();
            
            String user = qqnumber;
            String pwd = qqkeynumber;
            
            //����sql���
            String sql = "insert into qqlogin values("+user+" , '"+pwd+"');";
            //��ȡStatement����
            stt = conn.createStatement();
            //ִ��sql���
            stt.executeUpdate(sql);
 System.out.println("���ݲ���ɹ���");           
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //�ͷ���Դ
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

