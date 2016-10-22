package com.wrp.shiro.authorization;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**   
* @Title: AuthorizationTest.java 
* @Description: 授权测试
* @author LYleonard
* @date 2016年10月22日 下午2:03:10 
* @version V1.0   
*/
public class AuthorizationTest {
	// 角色授权、资源授权测试
	@Test
	public void testAuthorization(){
		// 创建SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
		
		// 创建SecurityManager
		SecurityManager securityManager = factory.getInstance();
		
		// 将SecurityManager配置到当前的运行环境中,和 spring整合后将SecurityManager配置到spring容器中，一般采用单例管理
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","111111");
		
		// 执行认证
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		System.out.println("认证的状态：" + subject.isAuthenticated());
		
		// 认证通过执行授权
		// 基于角色的授权,其中hasRole() 中传入的是角色标识
		boolean hasRole1 = subject.hasRole("role1");
		System.out.println("单个角色role1的授权是否通过："+ hasRole1);
		boolean hasAllRoles1 = subject.hasAllRoles(Arrays.asList("role1", "role2"));
		System.out.println("多个个角色的授权是否通过：" + hasAllRoles1);
		// 使用check方法进行授权，如果授权不通过则抛出异常
		subject.checkRole("role3");
		
		// 基于资源的授权
		// isPermitted中传入的权限的标识符
		boolean isPermitted1 = subject.isPermitted("user:create");
		System.out.println("单个权限的授权是否通过："+isPermitted1);
		
		boolean isPermittedAll1 = subject.isPermittedAll("user:create","user:delete");
		System.out.println("多个权限的授权是否通过："+isPermittedAll1);
		
		// 使用check方法进行授权，如果授权不通过则抛出异常
		subject.checkPermission("item:create");
	}
	
	// 角色授权、资源授权测试
	@Test
	public void testAuthorizationCustomRealm(){
		// 创建SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shirorealm.ini");
		
		// 创建SecurityManager
		SecurityManager securityManager = factory.getInstance();
		
		// 将SecurityManager配置到当前的运行环境中,和 spring整合后将SecurityManager配置到spring容器中，一般采用单例管理
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","111111");
		
		// 执行认证
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		System.out.println("认证的状态：" + subject.isAuthenticated());
		
		// 认证通过执行授权
		// 基于资源的授权,调用isPermitted方法会调用CustomRealm从数据库查询正确权限数据
		// isPermitted中传入的权限的标识符，判断user:create是否在CustomRealm查询到权限数据之内
		boolean isPermitted1 = subject.isPermitted("user:create");
		System.out.println("单个权限的授权是否通过："+isPermitted1);
		
		boolean isPermittedAll1 = subject.isPermittedAll("user:create","user:update");
		System.out.println("多个权限的授权是否通过："+isPermittedAll1);
		
		// 使用check方法进行授权，如果授权不通过则抛出异常
		subject.checkPermission("item:add");
	}
	
}
