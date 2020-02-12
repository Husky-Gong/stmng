package com.sxt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.pojo.User;
import com.sxt.service.UserService;

public class RegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3801073559327076976L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String realName = req.getParameter("realName");
		
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setRealName(realName);
		
		boolean flag = UserService.register(user);
		
		if(flag) {
			resp.sendRedirect("login.jsp");
		}
		else {
			resp.sendRedirect("register.jsp");
		}
	}
}
