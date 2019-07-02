package cn.com.infcn.service;

import cn.com.infcn.annotation.Component;
import cn.com.infcn.bean.User;

/**
 * * 用户Service实现
 * @author USER
 *
 */
@Component
public class UserService {

	public User getUser() {
		User user=new User("张三", 18);
		return user;
	}
}
