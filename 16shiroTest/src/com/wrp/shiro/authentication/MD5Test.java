package com.wrp.shiro.authentication;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**   
* @Title: MD5Test.java 
* @Description: 测试MD5加密Hash
* @author LYleonard
* @date 2016年10月21日 下午3:53:45 
* @version V1.0   
*/
public class MD5Test {
	
	public static void main(String[] args) {
		
		String source = "111111";
		String salt = "change";
		int hashIterations = 2;
		// 加密2次后：d60cfac4c0878b4f40764e0ba488dd03
		
		// 构造方法中：
		/*第一个参数：表示明文，原始密码；
		第二个参数：盐，即附加的信息通常使用随机数，起到避免被破解
		第三个参数：散列的次数
		*/
		Md5Hash md5Hash = new Md5Hash(source, salt, hashIterations);
		String password_Md5 = md5Hash.toString();
		System.out.println("password_Md5:" + password_Md5);
		
		// 第一个参数：使用的加密算法的名字
		SimpleHash simpleHash = new SimpleHash("md5", source, salt, hashIterations);
		System.out.println(simpleHash.toString());
		
	}
}
