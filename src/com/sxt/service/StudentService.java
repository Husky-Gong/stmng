package com.sxt.service;

import java.util.List;
import java.util.Map;

import com.sxt.dao.StudentDao;
import com.sxt.pojo.Student;

/**
s * @ClassName: StudentService 
 * @Description: 学生业务类
 * @author: Mr.T
 * @date: 2020年2月7日 下午4:13:36
 */
public class StudentService {
	static StudentDao studentDao = new StudentDao();
	
	/**
	 * @Title: addStudent
	 * @author: Mr.T   
	 * @date: 2020年2月7日 下午4:14:08 
	 * @Description: 新增学生  如果添加成功 返回 true  失败 false
	 * @param st
	 * @return: boolean  
	 */
	public static boolean addStudent(Student st) {
		//校验学号是否重复
		Student student = studentDao.selectStudent(st.getStNo());
		if(student != null) {
			System.out.println("添加学生失败: 学号已被使用");
			return false;
		}
		st = studentDao.insert(st);
		return st == null?false:true;
	}
	/**
	 * @Title: queryList
	 * @author: Mr.T   
	 * @date: 2020年2月7日 下午4:29:45 
	 * @Description: 根据查询参数 查询学生列表数据
	 * @param param  查询的参数
	 * @return
	 * @return: List<Student>
	 */
	public static List<Student> queryList(Map<String, Object> param) {
		// 根据条件查询学生信息
		List<Student> sts = studentDao.selectList(param);

		return sts;
	}

}
