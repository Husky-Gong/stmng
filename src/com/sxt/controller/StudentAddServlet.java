package com.sxt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxt.pojo.Student;
import com.sxt.service.StudentService;

public class StudentAddServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4489781155663402662L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String st_no = req.getParameter("st_no");
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		int age = Integer.parseInt(req.getParameter("age"));
		String score = req.getParameter("score");
		
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
			resp.sendRedirect("http://127.0.0.1:8080/stmng-web/studentList.do");
		}
		else{
			//Register failed
			resp.sendRedirect("studentAdd.jsp");
		}
	}
	
}
