package com.wrp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 线程安全问题
public class ServletDemo3 extends HttpServlet implements SingleThreadModel {
	
	int i = 0;
	//子类在覆盖父类的方法时，不能抛出比父类更多的异常
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//synchronized (this) {
			i++;
			try {
				Thread.sleep(1000*4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			response.getOutputStream().write((i+" ").getBytes());
		//}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
