package com.wrp.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//通过response的write流输出数据的编码问题
public class ResponseDemo2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//test1(response);
		String data = "中国";
		//设置Response使用的编码表，以控制Response以什么码表向浏览器写出数据
		response.setCharacterEncoding("UTF-8");
		//指定浏览器以什么编码表打开服务器发送的数据
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		/*//以上两句的简写
		response.setContentType("text/html;charset=UTF-8");*/
		
		PrintWriter out = response.getWriter();
		out.write(data);
	}


	private void test1(HttpServletResponse response) throws IOException {
		String data = "中国";
		//设置Response使用的编码表，以控制Response以什么码表向浏览器写出数据
		response.setCharacterEncoding("UTF-8");
		//指定浏览器以什么编码表打开服务器发送的数据
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();//PrintWrite流只能写字符串
		out.write(data);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
