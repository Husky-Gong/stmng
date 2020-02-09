package com.sxt.dao;

import com.sxt.pojo.User;

/**
 * @ClassName: UserDao 
 * @Description: 用户数据操作类
 * @author: Mr.T
 * @date: 2020年2月7日 下午3:25:11
 */
public class UserDao extends BaseDao {
	
	/**
	 * @Title: selectUser
	 * @author: Mr.T   
	 * @date: 2020年2月7日 下午3:25:43 
	 * @Description: 根据用户名查询用户
	 * @param username
	 * @return
	 * @return: User
	 */
	public User selectUser(String username) {
		String sql = "select id from user where username = ?";
		return super.selectOne(sql, User.class, username);
	}
	
	
	
	public User  insert(User user) {
		String sql = "insert into user value(0,?,?,?)";
		int id = super.insert(sql, user.getUsername(),user.getPassword(),user.getRealName());
		//如何ID 为0  说明：s
		if(id == 0) {
			return null;
		}
		user.setId(id);
		return user;
	}


	/**
	 * @Title: selectUser
	 * @author: Mr.T   
	 * @date: 2020年2月7日 下午4:04:01 
	 * @Description: 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return
	 * @return: User
	 */
	public User selectUser(String username, String password) {
		String sql = "select id,real_name as realName from user where username = ? and password = ?";
		return super.selectOne(sql, User.class, username,password);
	}

}
