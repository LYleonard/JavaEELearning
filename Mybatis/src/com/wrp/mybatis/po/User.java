package com.wrp.mybatis.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.core.config.Order;

/**   
* @Title: User.java 
* @Description: 用户po
* @author LYleonard
* @date 2016年10月8日 上午10:18:10 
* @version V1.0   
*/
public class User implements Serializable{
	/**
	 * 调用pojo类user实现序列化接口
	 */
	private static final long serialVersionUID = 1L;
	//属性名和数据库中表的字段对应
	private int id;
	private String username;
	private Date birthday;
	private String sex;
	private String address;
	
	// 用户创建的订单列表
	private List<Order> ordersList;
	
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
	
	public List<Order> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Order> ordersList) {
		this.ordersList = ordersList;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + "]";
	}
	
}
