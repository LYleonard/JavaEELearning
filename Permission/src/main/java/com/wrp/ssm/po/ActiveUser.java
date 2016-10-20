package com.wrp.ssm.po;

import java.util.List;

public class ActiveUser implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private String userid; //用户id（主键）
	private String usercode; //用户账号
	private String username; //用户名
	
	private List<SysPermission> menus;
	private List<SysPermission> permission;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<SysPermission> getMenus() {
		return menus;
	}

	public void setMenus(List<SysPermission> menus) {
		this.menus = menus;
	}

	public List<SysPermission> getPermission() {
		return permission;
	}

	public void setPermission(List<SysPermission> permission) {
		this.permission = permission;
	}
	
}
