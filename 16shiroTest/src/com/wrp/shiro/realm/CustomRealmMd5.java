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
import org.apache.shiro.util.ByteSource;

public class CustomRealmMd5 extends AuthorizingRealm{
	
	@Override
	public void setName(String name) {
		super.setName("CustomRealm");
	}
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		// token使用户输入的认证信息，第一步先取出token中的身份信息
		String userCode = (String) token.getPrincipal();
		// 根据用户输入的userCode从数据库中查询是否存在
		// .....
		// 模拟从数据库中取得的密码,MD5加密后的密文要存储到数据库中
		String password = "d60cfac4c0878b4f40764e0ba488dd03";
		// 模拟从数据库中获取到了salt
		String salt = "change";
		// 若查询不到返回null
		// 如果查询到了，则返回认证信息AuthenticationInfo
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				userCode, password, ByteSource.Util.bytes(salt), this.getName());
		
		return simpleAuthenticationInfo;
	}
	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}
	
}
