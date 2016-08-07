package com.wrp.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ServletConfig对象：用于封装servlet的配置信息
// 在实际开发中，有些不适合在Servlet中写死，这里数据可以通过初始化参数配置传给Servlet
public class ServletDemo4 extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到指定的参数
		String value = this.getServletConfig().getInitParameter("data");
		System.out.println(value);
		
		//得到所有的参数
		Enumeration e = this.getServletConfig().getInitParameterNames();
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			String value1 =this.getServletConfig().getInitParameter(name);
			System.out.println(name + "=" +value1);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
}
