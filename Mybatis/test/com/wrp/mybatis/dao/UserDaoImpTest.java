package com.wrp.mybatis.dao;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wrp.mybatis.po.User;

public class UserDaoImpTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		// 创建UserDao的对象
		UserDao userDao = new UserDaoImp(sqlSessionFactory);

		// 调用UserDao的方法
		User user = userDao.findUserById(27);

		System.out.println(user);
	}
	
	@Test
	public void testFindUserByName() throws Exception {
		// 创建UserDao的对象
		UserDao userDao = new UserDaoImp(sqlSessionFactory);
		
		// 调用UserDao的方法
		List<User> list = userDao.findUserByName("王五");
		
		System.out.println(list);
	}

	@Test
	public void testInsertUser() throws Exception {

		// 插入用户对象
		User user = new User();
		user.setUsername("吴小明");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("贵州贵阳");

		UserDao userDao = new UserDaoImp(sqlSessionFactory);
		userDao.insertUser(user);
	}

	@Test
	public void testDeleteUser() throws Exception {
		UserDao userDao = new UserDaoImp(sqlSessionFactory);
		userDao.deleteUser(30);
	}

}
