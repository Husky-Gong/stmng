<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
</head>
<body>
	<!-- 
		要将 form表单的数据进行提交 需要地址接收数据
		When submit, 
	 	it will jump to the "login controller" 
	 	which is the destination of "myServlet03.do"
	 -->
	 
	<form action="login.do" method="post">
		<p>用户名:<input type="text" name="username" /></p>
		<p>密码:<input type="text" name="password" /></p>
		<p>
			<input type="submit"   value="登录" /> &nbsp;&nbsp;&nbsp;&nbsp;
			<a href="register.jsp">注册</a>
		</p>
	</form>
</body>
</html>