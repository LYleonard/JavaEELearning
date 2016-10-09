package com.wrp.mybatis.mapper;

import java.util.List;

import com.wrp.mybatis.po.User;
import com.wrp.mybatis.po.UserCustom;
import com.wrp.mybatis.po.UserQueryVo;
/**   
* @Title: UserMapper.java 
* @Description: UserMapper的接口
* @author LYleonard
* @date 2016年10月8日 下午10:43:03 
* @version V1.0   
*/
public interface UserMapper {
	// 用户信息的综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	// 用户信息的综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	// 根据id查询用户信息
	public User findUserById(int id) throws Exception;

	// 根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int id) throws Exception;
	
	// 根据用户名查询用户信息列表
	public List<User> findUserByName(String name) throws Exception;
	
	// 添加用户信息
	public void insertUser(User user) throws Exception;
	// 删除用户信息
	public void deleteUser(int id) throws Exception;
	
}
