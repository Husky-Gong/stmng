package com.sxt.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.pojo.Student;
import com.sxt.service.StudentService;

public class StudentListServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3722978837216828071L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		
		Map<String,Object> param = new HashMap<>();
		
		if(name != null && name.trim().length() != 0) {
			param.put("name", name);
		}
		
		List<Student> sts = StudentService.queryList(param);
		
		req.setAttribute("sts", sts);
		req.getRequestDispatcher("studentList.jsp").forward(req, resp);
	}
}
