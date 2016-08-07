package com.wrp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//获取web应用的初始化参数以及转发
public class ServletDemo8 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String value = this.getServletContext().getInitParameter("data0");
		//System.out.println(value);
		response.getOutputStream().write(value.getBytes());
		
		//数据转发(不能通过Context域，要通过request域)
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
