package com.wrp.mybatis.mapper;

import java.util.List;

import com.wrp.mybatis.po.Orders;
import com.wrp.mybatis.po.OrdersCustom;
import com.wrp.mybatis.po.User;

/**   
* @Title: OrdersMapperCustom.java 
* @Description: 订单的Mapper
* @author LYleonard
* @date 2016年10月10日 上午9:18:49 
* @version V1.0   
*/
public interface OrdersMapperCustom {
	// 查询订单，关联查询用户信息
	public List<OrdersCustom> findOrdersUser() throws Exception;
	
	// 查询订单，关联查询用户信息，使用resultMap
	public List<Orders> findOrdersUserResultMap() throws Exception;
	
	// 查询订单（关联用户）及订单明细
	public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;
	
	// 查询用户及购买的商品(findUserAndItemsResultMap)
	public List<User> findUserAndItemsResultMap() throws Exception;
	
	// 查询订单关联用户，用户信息需要延迟加载
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
