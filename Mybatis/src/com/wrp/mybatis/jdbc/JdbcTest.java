package com.wrp.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**   
* @Title: JdbcTest.java 
* @Description: 一般的JDBC程序实现连接数据库
* @author LYleonard
* @date 2016年10月7日 下午5:11:42 
* @version V1.0   
*/
public class JdbcTest {
	
	public static void main(String[] args) {
		
		// 数据库连接
		Connection connection = null;
		// 预编译的statement，使用该预编译语句可以提高数据库的性能
		PreparedStatement preparedStatement = null;
		// 结果集
		ResultSet resultSet = null;
		
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			// 通过驱动管理类获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb?charset=utf-8","root","243015");
			
			// 定义sql语句   ？表示占位符
			String sql = "select * from user where username = ?";
			
			// 获取预处理statement
			preparedStatement = connection.prepareStatement(sql);
			
			// 设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
			preparedStatement.setString(1, "王五");
			// 向数据库发出sql执行查询，查询出结果集
			resultSet = preparedStatement.executeQuery();
			
			// 遍历查询结果集
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id")+" "+ resultSet.getString("username"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			if (resultSet!=null) {
				try {
					resultSet.close();
				} catch ( SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			if (connection!=null) {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
}
