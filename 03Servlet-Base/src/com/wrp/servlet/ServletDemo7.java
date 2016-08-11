package com.wrp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContext域
 * 1. 这是一个容器
 * 2. servletContext域说明了这个容器是我作用范围
 * 
 * 3. 通过servletContext实现ServletDemo6和ServletDemo7的数据共享
 */
public class ServletDemo7 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String value = (String) this.getServletContext().getAttribute("data");
		System.out.println(value);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
