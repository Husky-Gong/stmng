package com.sxt.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sxt.pojo.User;
import com.sxt.service.UserService;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1693956602730901819L;

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		System.out.println(user);
		user = UserService.login(user);
		
		if(user == null) {
			try {
				System.out.println("Null");
				resp.sendRedirect("login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				System.out.println("Successfully");
				resp.sendRedirect("http://127.0.0.1:8080/stmng-web/studentList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
