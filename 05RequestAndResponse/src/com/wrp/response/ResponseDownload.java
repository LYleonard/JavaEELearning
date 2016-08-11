package com.wrp.response;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 文件下载
public class ResponseDownload extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String path = this.getServletContext().getRealPath("/download/1.jpg");
		String path = this.getServletContext().getRealPath("/download/柳岩.jpg");
		String filename = path.substring(path.lastIndexOf("\\")+1);
		//如果下载文件名是中文，则文件名需要经过URL编码
		//response.setHeader("content-disposition", "attachment;filename=" + filename);
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
		
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			
			in = new FileInputStream(path);
			int len = 0;
			byte buffer[] = new byte[1024];
			out = response.getOutputStream();
			while ((len = in.read(buffer))>0) {
				out.write(buffer, 0, len);
			}
			
		} finally {
			
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
