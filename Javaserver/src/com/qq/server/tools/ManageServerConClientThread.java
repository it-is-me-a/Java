/*
 * 管理客户端的Socket
 */
package com.qq.server.tools;

import java.util.*;

public class ManageServerConClientThread {
	
	public static HashMap hm = new HashMap<String, ServerConnectClientThread>();//做成静态的
	
	public static void addClientThread(ServerConnectClientThread sct, String uid){
		hm.put(uid, sct);
	}
	
	public static ServerConnectClientThread getClientThread(String uid){
		return (ServerConnectClientThread)hm.get(uid);
	}
	
	//返回在线好友的情况
	public static String GetOnlineUserId(){
		String res = "";
		//使用迭代器
		Iterator it = hm.keySet().iterator();
		while(it.hasNext()){
			res +=it.next().toString()+" ";
		}
		return res;
		
	}
}
