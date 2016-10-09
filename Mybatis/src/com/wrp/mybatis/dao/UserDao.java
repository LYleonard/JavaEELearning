package com.wrp.mybatis.dao;

import java.util.List;

import com.wrp.mybatis.po.User;

/**
 * @Title: UserDao.java
 * @Description: UserDao的定义
 * @author LYleonard
 * @date 2016年10月8日 下午9:30:44
 * @version V1.0
 */
public interface UserDao {
	// 根据id查询用户信息
	public User findUserById(int id) throws Exception;

	// 根据用户名查询用户信息列表
	public List<User> findUserByName(String name) throws Exception;

	// 添加用户信息
	public void insertUser(User user) throws Exception;

	// 删除用户信息
	public void deleteUser(int id) throws Exception;

}
