package com.wrp.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * request的常用方法
 */
public class ServletRequest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 得到请求者的URI和URL
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		
		// http://localhost:8080/05RequestAndResponse/ServletRequest?name=aaa
		System.out.println(request.getQueryString());
		
		// 得到来访者IP地址
		System.out.println(request.getRemoteAddr());
		
		// 返回发出请求的客户机的完整主机名
		System.out.println(request.getRemoteHost());
		
		// 返回发出请求的客户机所使用它的网络端口号
		System.out.println(request.getRemotePort());
		
		// 返回WEB服务器的IP地址
		System.out.println(request.getLocalAddr());
		
		// 返回WEB服务器的主机名
		System.out.println(request.getLocalName());
		
		// 得到客户机的请求方式
		System.out.println(request.getMethod());
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
