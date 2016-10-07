package com.wrp.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.wrp.ssm.po.Items;

/**   
* @Title: ItemsController.java 
* @Description: 实现Controller接口的处理器
* @author LYleonard
* @date 2016年9月5日 下午4:59:42 
* @version V1.0   
*/
public class ItemsController implements Controller{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//调用servlet查找数据库，查询商品，这里先用静态数据模拟
		List<Items> itemsList = new ArrayList<Items>();
		
		//向list中填充静态数据
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
		
		//创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();
		
		//填充数据
		modelAndView.addObject("itemsList", itemsList);
		
		//视图
		modelAndView.setViewName("/WEB-INF/views/items/itemsList.jsp");
		
		return modelAndView;
	}

	
	
}
