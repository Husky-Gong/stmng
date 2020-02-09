<%@page import="com.sxt.pojo.Student"%>
<%@page import="com.sxt.service.StudentService"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//此jsp 只用于获取查询参数，且将查询的结果数据返回给具体的列表页面  从而进行展示数据
	//1 .获取查询参数
	String name = request.getParameter("name");
	//创建存储查询条件的map容器
	Map<String,Object> param = new HashMap<>();
	if(name != null && name.trim().length() != 0){
		param.put("name",name);
	}
	//根据条件获取查询的结果
	List<Student> sts = StudentService.queryList(param);
	//跳转到具体的学生列表页面  进行数据展示  且要将学生数据传输给学生列表页面
	//所以使用内部转发
	//存数据
	request.setAttribute("sts", sts);
	//页面跳转
	request.getRequestDispatcher("studentList.jsp").forward(request, response);

%>