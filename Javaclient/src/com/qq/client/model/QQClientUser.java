/*
 * 只要是涉及用户的，都要用这个类
 */
package com.qq.client.model;

import com.qq.common.*;

public class QQClientUser {

	/*
	 * 检查用户是否合法
	 */
	public boolean checkUser(User u){
		return new MyQQClient().sendLoginInfoToServer(u);
	}
}
