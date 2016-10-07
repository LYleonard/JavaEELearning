package com.wrp.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wrp.ssm.po.Items;

/**
 * @Title: ItemsController.java
 * @Description: 注解的Handleer
 * @author LYleonard
 * @date 2016年9月5日 下午4:59:42
 * @version V1.0
 */
// RenderMapping实现了对方法queryItems的注解
//使用注解Controller来标记它是一个控制器
@Controller
public class ItemsController3 {

	//商品产查询列表
	@RequestMapping("/queryItems")
	public ModelAndView	queryItems() {
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
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("itemsList",itemsList);
		
		// 下边的路径，如果在视图解析器中配置jsp路径路径的后缀
		//modelAndView.setViewName("/WEB-INF/views/items/itemsList.jsp");
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	//商品的添加
	//商品的修改
	
}
