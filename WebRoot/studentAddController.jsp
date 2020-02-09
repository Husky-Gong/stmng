<%@page import="com.sxt.dao.*" %>
<%@page import="com.sxt.pojo.*" %>
<%@page import="com.sxt.service.*" %>
<%@page import="com.sxt.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	/*
	 * This jsp file is used to assist adding new students
	 * Get new student information first
	 */
	String st_no = request.getParameter("st_no");
	String name = request.getParameter("name");
	String sex = request.getParameter("sex");
	int age = Integer.parseInt(request.getParameter("age"));
	String score = request.getParameter("score");
	
	Student stu = new Student();
	stu.setStNo(st_no);
	stu.setName(name);
	stu.setSex(sex);
	stu.setAge(age);
	stu.setScore(score);
	System.out.println(stu);
	boolean flag = StudentService.addStudent(stu);
	System.out.println(flag);
	if(flag){
		// Register successfully
		response.sendRedirect("studentListController.jsp");
	}
	else{
		//Register failed
		response.sendRedirect("studentAdd.jsp");
	}
%>