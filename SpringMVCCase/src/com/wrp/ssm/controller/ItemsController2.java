package com.wrp.ssm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.wrp.ssm.po.Items;

/**
 * @Title: ItemsController.java
 * @Description: 实现HttpRequestHandler接口的处理器
 * @author LYleonard
 * @date 2016年9月5日 下午4:59:42
 * @version V1.0
 */
public class ItemsController2 implements HttpRequestHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.HttpRequestHandler#handleRequest(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 调用servlet查找数据库，查询商品，这里先用静态数据模拟
		List<Items> itemsList = new ArrayList<Items>();

		// 向list中填充静态数据
		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");

		itemsList.add(items_1);
		itemsList.add(items_2);
		
		request.setAttribute("itemsList", itemsList);
		
		request.getRequestDispatcher("/WEB-INF/views/items/itemsList.jsp").forward(request, response);
		
		// 使用该方法可以通过修改response，设置相应的数据格式，比如下，响应json数据
		/*response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;chartset=utf-8");
		response.getWriter().write("json串");*/
	}
}
