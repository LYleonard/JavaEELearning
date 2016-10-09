package com.wrp.mybatis.po;

import java.util.Date;

/**   
* @Title: User.java 
* @Description: 用户po
* @author LYleonard
* @date 2016年10月8日 上午10:18:10 
* @version V1.0   
*/
public class User {
	//属性名和数据库中表的字段对应
	private int id;
	private String username;
	private Date birthday;
	private String sex;
	private String address;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + "]";
	}
	
}
