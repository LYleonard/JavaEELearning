package com.wrp.randomImagieVerification;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 控制浏览器定时刷新
public class ServletPeriodicRefreshing extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		test3(request, response);
		
	}

	//开发中使用的跳转
	private void test3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//假设这是一个用于登录的Servlet
		
		//假设程序运行到此，用户登录成功,提示登录成功
		
		String message = "<meta http-equiv='refresh' content='3;url=/05RequestAndResponse/index.jsp'>恭喜你，登陆成功！浏览器将在3秒内跳转到首页，若未跳转，请点击<a href=''>这里</a>进行跳转！";
		this.getServletContext().setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
	}


	private void test2(HttpServletResponse response) throws IOException {
		//假设这是一个用于登录的Servlet
		
		//假设程序运行到此，用户登录成功,提示登录成功
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("refresh", "3;url='/05RequestAndResponse/index.jsp'");
		response.getWriter().write("恭喜你，登陆成功！浏览器将在3秒内跳转到首页，若未跳转，请点击<a href='/05RequestAndResponse/index.jsp'>这里</a>进行跳转！");
	}


	private void test1(HttpServletResponse response) throws IOException {
		response.setHeader("refresh", "3");
		
		String data = new Random().nextInt(100000) + "";
		response.getWriter().write(data);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
