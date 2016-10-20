package com.wrp.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wrp.mybatis.po.User;
import com.wrp.mybatis.po.UserCustom;
import com.wrp.mybatis.po.UserQueryVo;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//用户信息的综合查询
	@Test
	public void testfindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		// 创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("张三");
		userQueryVo.setUserCustom(userCustom);
		
		// 调用UserMapper 的方法
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		sqlSession.close();
		System.out.println(list);
	}
	
	//用户信息的综合查询
	@Test
	public void testfindUserList2() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		// 创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		
		// 传入多个id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(16);
		ids.add(22);
		ids.add(25);
		userQueryVo.setIds(ids);
		
		userCustom.setUsername("小明");
		userQueryVo.setUserCustom(userCustom);
		
		// 调用UserMapper 的方法
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		sqlSession.close();
		System.out.println(list);
	}

	//用户信息的综合查询总数
	@Test
	public void testFindUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		// 创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("张三");
		userQueryVo.setUserCustom(userCustom);
		
		// 调用UserMapper 的方法
		int count = userMapper.findUserCount(userQueryVo);
		sqlSession.close();
		System.out.println(count);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		// 调用UserMapper 的方法
		User user = userMapper.findUserById(27);
		sqlSession.close();
		System.out.println(user);
	}
	
	// 根据id查询用户信息，使用resultMap输出
	@Test
	public void testFindUserByIdResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象，Mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		// 调用UserMapper 的方法
		User user = userMapper.findUserByIdResultMap(27);
		sqlSession.close();
		System.out.println(user);
	}

	@Test
	public void testFindUserByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

}
