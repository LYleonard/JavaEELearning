package com.wrp.mybatis.po;

import java.util.Date;

/**   
* @Title: Items.java 
* @Description: TODO
* @author LYleonard
* @date 2016年10月10日 上午9:10:09 
* @version V1.0   
*/
public class Items {
	
	private Integer id;
	
	private String name;
	
	private Float price;
	
	private String pic;
	
	private Date createtime;
	
	private String detail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", price=" + price + ", pic=" + pic + ", createtime=" + createtime
				+ ", detail=" + detail + "]";
	}
	
}