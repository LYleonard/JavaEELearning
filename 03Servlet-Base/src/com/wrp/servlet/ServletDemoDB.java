package com.wrp.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//读取资源文件
public class ServletDemoDB extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		test1();
	}


	private void test1() throws IOException {
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties props = new Properties();//Map
		props.load(in);
		
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}
	
	//db.properties在src/com.wrp.servlet包下。
	private void test2() throws IOException {
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/com/wrp/servlet/db.properties");
		Properties props = new Properties();//Map
		props.load(in);
		
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}
	
	//db.properties在WebContent下
	private void test3() throws IOException {
		InputStream in = this.getServletContext().getResourceAsStream("/db.properties");
		Properties props = new Properties();//Map
		props.load(in);
		
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
