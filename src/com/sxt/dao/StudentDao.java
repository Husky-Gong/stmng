package com.sxt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sxt.pojo.Student;

/**
 * @ClassName: StudentDao 
 * @Description: 学生数据操作类
 * @author: Mr.T
 * @date: 2020年2月7日 下午4:15:00
 */
public class StudentDao extends BaseDao {
	
	/**
	 * @Title: selectStudent
	 * @author: Mr.T   
	 * @date: 2020年2月7日 下午4:15:32 
	 * @Description: 根据学号查询学生
	 * @param stNo
	 * @return
	 * @return: Student
	 */
	public Student selectStudent(String stNo) {
		String sql = "select id from student where st_no = ?";
		return super.selectOne(sql, Student.class, stNo);
	}
	/**
	 * @Title: insert
	 * @author: Mr.T   
	 * @date: 2020年2月7日 下午4:18:21 
	 * @Description: 添加学生信息
	 * @param st
	 * @return
	 * @return: Student
	 */
	public Student insert(Student st) {
		String sql = "insert into student value(0,?,?,?,?,?)";
		System.out.println(st);
		int id = super.insert(sql, st.getStNo(),st.getName(),st.getSex(),st.getAge(),st.getScore());
		if(id == 0) {
			System.out.println("学生添加失败:系统错误");
			return null;
		}
		st.setId(id);
		return st;
	}
	/**
	 * @Title: selectList
	 * @author: Mr.T   
	 * @date: 2020年2月7日 下午4:32:17 
	 * @Description: 根据条件查询学生信息 : 目前只有学生名称
	 * 使用map接收 查询条件  便于扩展 ,例如：根据分数范围查询    根据性别查询  根据年龄范围查询
	 * 根据不同的条件  产生不同的sql语句 
	 * 动态sql
	 * @param param    存储的搜索条件   根据搜索条件产生不同的sql条件
	 * @return
	 * @return: List<Student>
	 */
	public List<Student> selectList(Map<String, Object> param) {
		// sql语句中 where 后面就是拼接条件
		String sql = "select id,st_no as stNo,name,sex,age,score from student where 1=1";
		// 此时 1=1 就是第一个条件   所有 if 成立都不再是第一个条件  所以 前面都要拼接and
		//说明 有 个根据名字查询的条件
		//如果名字存在 从map中  获取名字的值  根据这个值模糊搜索  
		if(param.containsKey("name")) {
			sql = sql + "  and name like '%"+param.get("name")+"%'";
		}
		//根据性别查询
		//如果 sex这个key存在，那么从map中,获取sex的值  进行精确搜索
		if(param.containsKey("sex")) {
			sql = sql + " and  sex ='"+param.get("sex")+"'";
		}
		System.out.println("将要执行的sql:"+sql );
		sql = sql +"  order by score desc";
		//代码按照以上写法 : 会出现: 如果没有条件 sql 语句最后是where  sql 错误
		// 如果是 2个条件  : name  和 sex 都有  , 缺少 and
		// 如果只有一个条件   只有 sex : 则sql 多了and 
		//所以 可以在基本的sql语句后面  拼接 一个无效条件  1=1 这样 所有的条件分支 都有可以在其前面 添加 一个  and  做兼容
		return super.selectList(sql, Student.class);
		
	}
	
	public Student insertStu(Student stu) {
		String sql = "insert into student value(0,?,?,?,?,?)";
		int stuId = super.insert(sql, stu.getStNo(),stu.getName(),stu.getSex(),stu.getAge(),stu.getScore());
		if(stuId == 0) {
			return null;
		}
		stu.setId(stuId);
		return stu;
	}
	
	public static void main(String[] args) {
		//map  什么条件都没有
		Map<String,Object> param = new HashMap<String, Object>();
		//param.put("name", "韩");
		//param.put("sex", "女");
		
		
		new StudentDao().selectList(param);
	}

}
