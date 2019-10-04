/*
 * 这是客户端连接服务器的后台
 */
package com.qq.client.model;
import java.net.*;
import java.io.*;
import java.net.*;

import com.qq.client.tools.ClientConnectServerThread;
import com.qq.client.tools.ManageClientConServerThread;
import com.qq.common.*;

public class MyQQClient implements java.io.Serializable{

	//public static Socket s;//写成静态的会有并发问题，比如说同时和两个聊天，就会挣这个socket
	
	public Socket s;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//发送第一次请求
	public boolean sendLoginInfoToServer(Object o){
		boolean b = false;
		try {
			s = new Socket("127.0.0.1",8080);
			
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			Message ms = (Message)ois.readObject();
			
			if(ms.getMesType().equals("1")){
				//验证成功
				
				//创建该id和服务器的保持通讯连接的thread，保存到hashmap中，并启动
				ClientConnectServerThread ccst = new ClientConnectServerThread(s);		
				ccst.start();
				ManageClientConServerThread.addManageClientThread(((User)o).getUserId(), ccst);
				b = true;
			
			}else{
				s.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO Auto-generated catch block
			
		}
		return b;
	}
	
	//后面的发送，都是数据的发送
	public void SendInfoToServer(Object o){
		
	}

}
