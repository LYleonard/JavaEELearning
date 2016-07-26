package com.wrp.beanutils;

import java.util.Date;

// 用于 beanutils 测试的类
public class Person {
	
	private String name; // 字段
	private String password; // 字段
	private int age; // 字段
	private Date birthday;
	
	public String getAB(){
		return null;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
