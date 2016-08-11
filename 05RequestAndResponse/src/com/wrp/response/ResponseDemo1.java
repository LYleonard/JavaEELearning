package com.wrp.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		test(response);

	}

	private void test2(HttpServletResponse response) throws IOException, UnsupportedEncodingException {
		//若果写成以下形式，则浏览器会下载该文件
		response.setHeader("Content-Type", "text/html,charset=UTF-8");//注意"text/html,charset=UTF-8"中的逗号
		String data = "中国";
		OutputStream out = response.getOutputStream();
		out.write(data.getBytes("UTF-8"));
	}

	private void test1(HttpServletResponse response) throws IOException, UnsupportedEncodingException {

		String data = "中国";
		OutputStream out = response.getOutputStream();

		out.write("<meta http-equiv='Content-Type' content='text/html;charset=UTF-8'>".getBytes());
		out.write(data.getBytes("UTF-8"));
	}

	private void test(HttpServletResponse response) throws IOException, UnsupportedEncodingException {

		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		String data = "中国";
		OutputStream out = response.getOutputStream();
		out.write(data.getBytes("UTF-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
