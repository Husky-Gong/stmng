<%@page import="com.sxt.pojo.User"%>
<%@page import="com.sxt.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 此jsp 用于接收登录提交的数据。
	//使用request对象 获取提交的数据
	//获取到了用户名和密码
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	//调用方法，根据用户名和密码从数据库中查询是否存在这个用户
	User user = new User();
	user.setUsername(username);
	user.setPassword(password);
	user = UserService.login(user);
	//如果  user为null 则说明账号密码不正确，返回登录页面
	if(user == null){
		//使用重定向进行页面跳转
		response.sendRedirect("login.jsp");
	}else{
		//登录成功  去 学生信息列表
		//学生信息列表需要展示数据，在去具体的学生信息列表之前，要查询学生信息，这样学生信息列表页面才
		//有学生数据进行展示
		response.sendRedirect("studentListController.jsp");
	}
	




%>