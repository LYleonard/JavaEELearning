package com.wrp.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wrp.mybatis.po.Orders;
import com.wrp.mybatis.po.OrdersCustom;
import com.wrp.mybatis.po.User;

public class OrdersMapperCustomTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		// Mybatis配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrdersUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建代理对象
		OrdersMapperCustom orderMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		// 调用mapper的方法
		List<OrdersCustom> list = orderMapperCustom.findOrdersUser();
		System.out.println(list);
		sqlSession.close();
	}
	
	// 测试：查询订单，关联查询用户信息，使用resultMap
	@Test
	public void testFindOrdersUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
		
		System.out.println(list);
		sqlSession.close();
	}
	
	//测试：查询订单，关联查询用户信息及订单明细 
	@Test
	public void testFindOrdersAndOrderDetailResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap();
		
		System.out.println(list);
		sqlSession.close();
	}
	
	// 测试：查询用户及购买的商品(findUserAndItemsResultMap)
	@Test
	public void testFindUserAndItemsResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<User> list = ordersMapperCustom.findUserAndItemsResultMap();
		
		System.out.println(list);
		sqlSession.close();
	}
	
	// 查询订单关联用户，用户信息需要延迟加载
	@Test
	public void testFindOrdersUserLazyLoading()throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		// 查询订单信息（单表）
		List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();
		
		// 遍历订单列表
		for(Orders orders:list){
			// 执行getUser（）去查询用户信息，按需进行延迟加载
			User user = orders.getUser();
			System.out.println(user);
		}
	}
}
