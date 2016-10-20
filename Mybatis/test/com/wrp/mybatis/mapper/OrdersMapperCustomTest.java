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
	
	// 测试一级缓存
	@Test
	public void testCache1Level() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		// 下次查询使用一个SqlSession
		// 第一次发出请求，查询id为1的用户
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);
		
		// 如果sqlSession去执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新的信息，避免脏读。
		// 更新user1的信息
		user1.setUsername("测试用户1");
		userMapper.updateUser(user1);
		
		// 第二次发出请求，查询id为1的用户
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);
	}
	
	// 测试二级缓存
	@Test
	public void testCache2Level() throws Exception{
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		// 第一次发出请求，查询id为1的用户
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);
		// 这里执行关闭操作，将sqlsession中的数据写到二级缓存
		sqlSession1.close();
		
		// 使用sqlSession3执行commit()操作
		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		User user = userMapper3.findUserById(1);
		user.setUsername("李颖");
		userMapper3.updateUser(user);
		// 执行提交，清空UserMapper下的二级缓存
		sqlSession3.commit();
		sqlSession3.close();
		
		
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		// 第二次发出请求，查询id为1的用户
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);
		sqlSession2.close();
	}
	
}
