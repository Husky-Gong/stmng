<%@page import="com.sxt.pojo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生列表</title>
</head>
<body>
<form action="studentListController.jsp">
	<p>学生名称:<input type="text" name="name" /><input type="submit"  value="查询" />&nbsp;&nbsp;&nbsp;&nbsp;<a href="studentAdd.jsp">添加学生</a></p>
</form>
<hr>

<table>
  <tr>
  	<th>ID</th>
  	<th>学号</th>
  	<th>名称</th>
  	<th>性别</th>
  	<th>年龄</th>
  	<th>总分</th>
  </tr>
 <%
 	@SuppressWarnings("unchecked")
 	List<Student> sts = (List<Student>)request.getAttribute("sts");
 	for(int i=0;i<sts.size();i++){
		//单个学生对象  学生数据是展示在一个table中  而具体循环的其实是table中  tr  
		// 每一条数据  就是一个tr
		Student st = sts.get(i);
	
 %>
<tr>
	<td><%=st.getId() %></td>
	<td><%=st.getStNo() %></td>
	<td><%=st.getName() %></td>
	<td><%=st.getSex() %></td>
	<td><%=st.getAge() %></td>
	<td><%=st.getScore() %></td>
</tr>
<%} %>
 </table>

</body>
</html>