package com.sxt.service;

import com.sxt.dao.UserDao;
import com.sxt.pojo.User;

/**
 * @ClassName: UserService 
 * @Description: 用户业务处理类
 * @author: Mr.T
 * @date: 2020年2月7日 下午3:23:18
 */
public class UserService {
	
	
	/**
	 * @Title: register
	 * @author: Mr.T   
	 * @date: 2020年2月7日 下午3:24:03 
	 * @Description: 用户注册方法
	 * @param user
	 * @return: boolean
	 */
	public static boolean register(User user) {
		//校验用户的账号是否已经存在
		//根据用户账号查询用户信息 --- 从数据库查询用户信息
		UserDao userDao = new UserDao();
		User u = userDao.selectUser(user.getUsername());
		//如果u 不为null 
		if(u != null) {
			System.out.println("注册失败:用户名已经被占用");
			return false;
		}
		//接收注册的结果
		user = userDao.insert(user);
		if(user == null) {
			System.out.println("注册失败:系统错误");
			return false;
		}
		System.out.println("注册成功");
		return true;
	}
	/**
	 * @Title: login
	 * @author: Mr.T   
	 * @date: 2020年2月7日 下午4:01:56 
	 * @Description: 处理用户登录的方法
	 * @param loginData
	 * @return: User
	 */
	public static User login(User loginData) {
		//根据用户名和密码查询用户信息
		UserDao userDao = new UserDao();
		User user = userDao.selectUser(loginData.getUsername(),loginData.getPassword());
		//如果根据用户名和密码查询用户数据为null 说明 用户名密码不正确
		if(user == null) {
			System.out.println("登录失败:用户名和密码不正确");
			return null;
		}
		System.out.println("欢迎:   "+user.getRealName());
		return user;
	}

}
