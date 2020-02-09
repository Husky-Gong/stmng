package com.sxt.pojo;
/**
 * @ClassName: Student 
 * @Description: 学生表实体类
 * @author: Mr.T
 * @date: 2020年2月7日 下午3:00:34
 */
public class Student {
	@Override
	public String toString() {
		return "Student [id=" + id + ", stNo=" + stNo + ", name=" + name + ", sex=" + sex + ", age=" + age + ", score="
				+ score + "]";
	}
	/**
	 * 	学生ID
	 */
	private Integer id;
	/**
	 * 	学号
	 */
	private String stNo;
	/**
	 * 学生姓名
	 */
	private String name;
	/**
	 * 	学生性别
	 */
	private String sex;
	/**
	 * 	学生年龄
	 */
	private Integer age;
	/**
	 * 	学生分数
	 */
	private String score;
	
	public Student() {}
	
	
	
	
	public Student(String stNo, String name, String sex, Integer age, String score) {
		this.stNo = stNo;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.score = score;
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStNo() {
		return stNo;
	}
	public void setStNo(String stNo) {
		this.stNo = stNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	
	

}
