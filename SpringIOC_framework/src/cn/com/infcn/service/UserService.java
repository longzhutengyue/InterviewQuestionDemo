package cn.com.infcn.service;

import cn.com.infcn.annotation.Component;
import cn.com.infcn.bean.User;

/**
 * * �û�Serviceʵ��
 * @author USER
 *
 */
@Component
public class UserService {

	public User getUser() {
		User user=new User("����", 18);
		return user;
	}
}
