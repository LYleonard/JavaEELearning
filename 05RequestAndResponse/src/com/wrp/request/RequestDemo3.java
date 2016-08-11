package com.wrp.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo3
 */
public class RequestDemo3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("gender"));
		System.out.println(request.getParameter("city"));
		String likes[] = request.getParameterValues("likes");
		for (int i=0;likes!=null && i<likes.length; i++) {
			System.out.println(likes[i]);
		}
		System.out.println(request.getParameter("description"));
		System.out.println(request.getParameter("id"));
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
