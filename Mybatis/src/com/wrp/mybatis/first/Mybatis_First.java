package com.wrp.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wrp.mybatis.po.User;

/**
 * @Title: Mybatis_First.java
 * @Description: 入门程序
 * @author LYleonard
 * @date 2016年10月8日 上午10:41:06
 * @version V1.0
 */
public class Mybatis_First {
	// 根据id查询用户信息，一条记录
	@Test
	public void findUserByIdTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过sqlSession操作数据库
		// 第一个参数：映射文件中statement的id，设置为namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType的类型参数
		// sqlSession.selectOne结果是与映射文件中所匹配的resultType类的对象
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user);

		// 释放资源
		sqlSession.close();
	}

	// 根据用户名称模糊查询用户信息
	@Test
	public void findUserByNameTest() throws IOException {

		String resource = "SqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<User> list = sqlSession.selectList("test.findUserByName", "王五");

		System.out.println(list);

		sqlSession.close();
	}

	// 添加用户信息
	@Test
	public void insertUserTest() throws IOException {

		String resource = "SqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 插入用户对象
		User user = new User();
		user.setUsername("松江");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("河南郑州");

		sqlSession.insert("test.insertUser", user);
		// 事务提交
		sqlSession.commit();
		// 获取用户信息的主键
		System.out.println(user.getId());
		// 关闭会话
		sqlSession.close();
	}

	// 根据id删除用户
	@Test
	public void deleteUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过sqlSession操作数据库
		sqlSession.delete("test.deleteUser", 28);
		// 事务提交
		sqlSession.commit();
		// 释放资源
		sqlSession.close();
	}

	// 根据id更新用户
	@Test
	public void updateUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 更新用户信息
		User user = new User();
		user.setId(26);
		user.setUsername("王旭");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("河南安阳");
		// 通过sqlSession操作数据库
		sqlSession.update("test.updateUser", user);
		// 事务提交
		sqlSession.commit();
		// 释放资源
		sqlSession.close();
	}

}
