/*
 * qq�������������ȴ��ͻ��˵�����
 */
package com.qq.server.model;

import java.net.*;
import java.io.*;
import java.util.*;

import com.qq.common.*;
import com.qq.server.tools.ManageServerConClientThread;
import com.qq.server.tools.ServerConnectClientThread;

public class MyQQServer implements java.io.Serializable{

	public MyQQServer(){
		try {
			System.out.println("���Ƿ�����,����8080����");
			ServerSocket sc = new ServerSocket(8080);
			while(true){
				//�����ȴ�����
				Socket s = sc.accept();
				
				//��������
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				User u = (User)ois.readObject();

				//�õ�U�����֤,Ӧ���ǵ����ݿ�ȥ�����ݣ���������ȼ����� �򵥵Ĺ����ǣ����������123456����Ϊ�ɹ�
				Message ms = new Message();
				
				//����֤������Ϣ����
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				if(u.getPasswd().equals("123456")){
					ms.setMesType("1");
					oos.writeObject(ms);
					
					//�ɹ���¼�󣬷�����Ϊ�ͻ��˵���һ���߳�������ÿͻ��˵�ͨѶ
					ServerConnectClientThread scct = new ServerConnectClientThread(s);
					
					//���¿����̼߳��뵽 hashmap 
					ManageServerConClientThread.addClientThread(scct, u.getUserId());
					
					//����ͨѶ�߳�
					scct.start();
					
					//��֪ͨ���������û�˵��������
					scct.NoticeOther(u.getUserId());
					
				}else{
					ms.setMesType("2");
					oos.writeObject(ms);
					//������󣬹ر�����
					s.close();
				}
			}
	
			
			
		} catch (Exception e) {
			e.printStackTrace();//��ӡ���쳣
		}
	}
	
	
}
