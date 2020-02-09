package com.sxt.pojo;
/**
 * @ClassName: User 
 * @Description: 用户表实体类
 * @author: Mr.T
 * @date: 2020年2月7日 下午2:57:57
 */
public class User {
	/**
	 * 	用户ID
	 */
	private Integer id;
	/**
	 * 	用户名
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 	真实姓名
	 */
	private String realName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	
	
}
