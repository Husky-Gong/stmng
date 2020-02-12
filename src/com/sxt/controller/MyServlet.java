package com.sxt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8953505235304132263L;

	
	/*
	 * override parent's service method
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Service");
		res.getWriter().print("Hello HttpServlet");
	}
}
