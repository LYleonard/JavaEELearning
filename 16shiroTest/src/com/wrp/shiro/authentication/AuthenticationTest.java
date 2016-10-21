package com.wrp.shiro.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**   
* @Title: AuthenticationTest.java 
* @Description: 认证测试：通过登录和退出
* @author LYleonard
* @date 2016年10月21日 上午9:46:19 
* @version V1.0   
*/
public class AuthenticationTest {
	//用户登录和退出
	@Test
	public void testLoginAndLogout(){
		// 构造SecurityManager环境
		// 创建SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		// 创建SecurityManager
		SecurityManager securityManager = factory.getInstance();
		
		// 将SecurityManager配置到当前的运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		
		// 从SecurityUtils中创建一个subject
		Subject subject = SecurityUtils.getSubject();
		
		// 认证前准备token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "111111");
		
		// 执行认证提交
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		boolean isAuthenticated = subject.isAuthenticated();
		System.out.println("是否通过认证：" + isAuthenticated);
		
		// 退出操作
		subject.logout();
		
		// 是否认证通过
		isAuthenticated = subject.isAuthenticated();
		
		System.out.println("是否通过认证：" + isAuthenticated);
	}
	
	//测试自定义realm
	@Test
	public void testCustomRealm(){
		// 构造SecurityManager环境
		// 创建SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shirorealm.ini");
		// 创建SecurityManager
		SecurityManager securityManager = factory.getInstance();
		
		// 将SecurityManager配置到当前的运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		
		// 从SecurityUtils中创建一个subject
		Subject subject = SecurityUtils.getSubject();
		
		// 认证前准备token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "111111");
		
		// 执行认证提交
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		boolean isAuthenticated = subject.isAuthenticated();
		System.out.println("是否通过认证：" + isAuthenticated);
		
	}
	
	//测试自定义realm实现散列值匹配
	@Test
	public void testCustomRealmMd5(){
		// 构造SecurityManager环境
		// 创建SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm-md5.ini");
		// 创建SecurityManager
		SecurityManager securityManager = factory.getInstance();
		
		// 将SecurityManager配置到当前的运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		
		// 从SecurityUtils中创建一个subject
		Subject subject = SecurityUtils.getSubject();
		
		// 认证前准备token（令牌）
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "111111");
		
		// 执行认证提交
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		
		boolean isAuthenticated = subject.isAuthenticated();
		System.out.println("是否通过认证：" + isAuthenticated);
		
	}
}
