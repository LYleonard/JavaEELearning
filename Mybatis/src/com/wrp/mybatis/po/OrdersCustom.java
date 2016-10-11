package com.wrp.mybatis.po;

/**   
* @Title: OrdersCustom.java 
* @Description: 订单的扩展类，通过此类可以映射订单和用户查询的结果，让此类继承字段较多的pojo类
* @author LYleonard
* @date 2016年10月10日 上午8:59:54 
* @version V1.0   
*/
public class OrdersCustom extends Orders{
	
	// 添加用户属性：username、sex、address
	private String username;
	private String sex;
	private String address;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
}
