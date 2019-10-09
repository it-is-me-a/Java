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
 * @Description: �����ݿ���صĲ�����
 * @author Emma
 */
public class QQServerPreservation {
	 
	public List<String> list = new ArrayList<String>();  //����
	//String[] qq = new String[2];
    
//    public static void main(String[] args) {
//		// TODO Auto-generated method stub
//    	QQServerPreservation qq = new QQServerPreservation();
//    	qq.IfQQRight();
//	}
	
	//�û����QQ�˻��������Ƿ���ȷ����ȷtrue
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
	
	//�û����QQ�˻��Ƿ��Ѵ��ڣ��Ѵ��ڷ���false�������ھͽ������ֵ���뵽���ݿ��С�
	public boolean IfQQNumExist(User u){
		boolean flag = true;
		Operation o = new Operation();
		o.Select();
		list = o.getList();;
		
		Iterator<String> it = list.iterator();
		for (String x : list) {
			String qq[] = x.split(" ");
			if(u.getUserId().equals(qq[0])){
				flag = false;//���QQ���Ѿ����ڣ�����false
			}
		}
		
		//�����ھͽ������ֵ���뵽���ݿ��С�
		if(flag == true){
			o.Insert(u.getUserId(),u.getPasswd());
		}		
		return flag;
		
	}
}
