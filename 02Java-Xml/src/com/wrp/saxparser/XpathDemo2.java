package com.wrp.saxparser;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

// 查找user.xml文件中是否存在相匹配的用户名和密码
public class XpathDemo2 {
	
	public static void main(String[] args) throws DocumentException {
		
		String username = "Zhang";
		String password = "123456";
		
		//检测xml文旦中是否存在匹配的用户和密码
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/user.xml"));
		
		Node node = document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");//注意：Xpath书写
		
		if (node==null) {
			System.out.println("用户名或密码错误！！");
		}else {
			//
			System.out.println("登陆成功");
		}
	}
	
}
