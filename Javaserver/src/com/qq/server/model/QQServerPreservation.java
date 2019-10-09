package com.qq.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.qq.common.MessageType;
import com.qq.common.User;
import com.qq.server.db.Operation;

/** 
 * ClassName: QQServerPreservation
 * @Description: 与数据库相关的操作。
 * @author Emma
 */
public class QQServerPreservation {
	 
	public List<String> list = new ArrayList<String>();  //集合
	//String[] qq = new String[2];
    
//    public static void main(String[] args) {
//		// TODO Auto-generated method stub
//    	QQServerPreservation qq = new QQServerPreservation();
//    	qq.IfQQRight();
//	}
	
	//用户检测QQ账户的密码是否正确，正确true
	public boolean IfQQRight(User u){//User u
		boolean flag = false;
		Operation o = new Operation();
		o.Select();
		list = o.getList();;
		
		Iterator<String> it = list.iterator();
		for (String x : list) {
			String qq[] = x.split(" ");
			if(u.getUserId().equals(qq[0]) && u.getPasswd().equals(qq[1])){
				flag = true;
			}
		}
		return flag;
		
	}
	
	//用户检测QQ账户是否已存在，已存在返回false，不存在就将这个数值存入到数据库中。
	public boolean IfQQNumExist(User u){
		boolean flag = true;
		Operation o = new Operation();
		o.Select();
		list = o.getList();;
		
		Iterator<String> it = list.iterator();
		for (String x : list) {
			String qq[] = x.split(" ");
			if(u.getUserId().equals(qq[0])){
				flag = false;//如果QQ号已经存在，返回false
			}
		}
		
		//不存在就将这个数值存入到数据库中。
		if(flag == true){
			o.Insert(u.getUserId(),u.getPasswd());
		}		
		return flag;
		
	}
}
