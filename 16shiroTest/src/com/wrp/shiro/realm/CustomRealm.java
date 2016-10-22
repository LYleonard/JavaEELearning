package com.wrp.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealm extends AuthorizingRealm {

	@Override
	public void setName(String name) {
		super.setName("CustomRealm");
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// token使用户输入的认证信息，第一步先取出token中的身份信息
		String userCode = (String) token.getPrincipal();
		// 根据用户输入的userCode从数据库中查询是否存在
		// .....
		// 模拟从数据库中取得的密码
		String password = "111111";

		// 若查询不到返回null
		// 如果查询到了，则返回认证信息AuthenticationInfo
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userCode, password,
				this.getName());

		return simpleAuthenticationInfo;
	}
	
	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 从principals获取主身份信息
		// 将getPrimaryPrincipal方法返回值强转为真实的身份类型（在上边的doGetAuthenticationInfo方法中认证通过后填充的SimpleAuthenticationInfo信息的类型）
		String userCode = (String) principals.getPrimaryPrincipal();

		// 根据身份信息获取权限信息
		// 连接数据库查询
		// ....
		// 模拟从数据库中取出了权限信息
		List<String> permissions = new ArrayList<String>();
		permissions.add("user:create");
		permissions.add("item:add");
		permissions.add("user:delete");

		// 查询到权限数据，返回
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}
	
}
