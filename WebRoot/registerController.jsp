<%@page import="com.sxt.service.UserService"%>
<%@page import="com.sxt.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//此jsp 用于处理注册的数据
	//获取注册数据
	String username = request.getParameter("username"); 
	String password = request.getParameter("password"); 
	String realName = request.getParameter("realName"); 
	User user = new User();
	user.setUsername(username);
	user.setPassword(password);
	user.setRealName(realName);
	//进行用户注册
	boolean flag = UserService.register(user);
	if(flag){
		//注册成功  去登录页面
		response.sendRedirect("login.jsp");
	}else{
		//注册失败  就返回注册页面
		response.sendRedirect("register.jsp");
	}





%>