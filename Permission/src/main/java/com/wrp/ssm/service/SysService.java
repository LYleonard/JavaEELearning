package com.wrp.ssm.service;

import java.util.List;

import com.wrp.ssm.po.ActiveUser;
import com.wrp.ssm.po.SysPermission;
import com.wrp.ssm.po.SysUser;

/**   
* @Title: SysService.java 
* @Description: 用户认证授权服务接口
* @author LYleonard 
*/
public interface SysService {
	// 根据用户身份和密码进行认证，如果认证通过，返回用户身份信息
	public ActiveUser authenticat(String userCode, String password) throws Exception;
	
	// 根账号查询用户信息
	public SysUser findSysUserByUserCode(String userCode)throws Exception;
	
	// 根据id查询用户的权限的菜单
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception;
	
	// 根据id查询用户的权限的url
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception;
}
