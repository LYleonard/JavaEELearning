package com.wrp.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wrp.mybatis.po.User;

/**
 * @Title: UserDaoImp.java
 * @Description: UserDao的实现类
 * @author LYleonard
 * @date 2016年10月8日 下午9:36:56
 * @version V1.0
 */
public class UserDaoImp implements UserDao {

	// 需要想dao实现类中注入SqlSessionFactory，这里通过构造函数注入
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImp(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = sqlSession.selectOne("test.findUserById", id);
		// 释放资源
		sqlSession.close();

		return user;
	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<User> list = sqlSession.selectList("test.findUserByName", name);
		// 释放资源
		sqlSession.close();

		return list;
	}

	@Override
	public void insertUser(User user) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行插入的操作
		sqlSession.insert("test.insertUser", user);
		// 事务提交
		sqlSession.commit();
		// 释放资源
		sqlSession.close();
		
	}

	@Override
	public void deleteUser(int id) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 执行插入的操作
		sqlSession.delete("test.deleteUser", id);
		// 事务提交
		sqlSession.commit();
		// 释放资源
		sqlSession.close();
		
	}

}
