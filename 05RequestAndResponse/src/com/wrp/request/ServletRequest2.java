package com.wrp.request;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.omg.PortableInterceptor.INACTIVE;

/** 
 *  request的常用方法--获取请求头和请求数据
 *  获取请求数据（获取请求数据时一般要先检查在使用）
 */
public class ServletRequest2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("---------------获取数据方式1------------");
		String value = request.getParameter("username");
		if (value!=null && !value.trim().equals("")) {
			System.out.println(value);
		}
		
		
		System.out.println("--------------获取数据方式2------------");
		
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()){
			String name = (String) e.nextElement();
			value = request.getParameter(name);
			System.out.println(name + "=" + value);
		}
		
		System.out.println("--------------获取数据方式3-------------");
		
		String[] values = request.getParameterValues("username");
		for (int i=0; value!=null && i<values.length; i++) {
			System.out.println(values);
		}
		
		System.out.println("--------------获取数据方式4(常用)-------------");
		Map  map = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);//username String[] 用map集合数据填充bean
			//BeanUtils.copyProperties(user, formbean);bean的拷贝
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		System.out.println(user);
		
	}


	private void test1(HttpServletRequest request) {
		String headValue = request.getHeader("Accept-Encoding");
		System.out.println(headValue);
		
		System.out.println("------------------------------------");
		Enumeration e = request.getHeaders("Accept-Encoding");
		while (e.hasMoreElements()) {
			String value = (String) e.nextElement();
			System.out.println(value);
		}
		
		System.out.println("------------------------------------");
		
		e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value = request.getHeader(name);
			System.out.println(name + "=" + value);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
