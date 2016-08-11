package com.wrp.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//如果读取资源文件的程序不是Servlet的话，要通过类装载器去读取
public class UserDao {
	
	//以下静态代码块虽然可以读取资源文件的数据，但是无法获取更新后的数据。
	private static Properties dbconfig = new Properties();
	static {
		try {
			InputStream in = UserDao.class.getClassLoader().getResourceAsStream("db.properties");
			dbconfig.load(in);
		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	
	public void update() throws IOException {
		
		System.out.println(dbconfig.getProperty("url"));
		
		//第二种方法：通过类装载的方式得到资源文件的位置，再通过传统方式读取资源文件的数据，这样可以读取到更新后的数据
		String path = UserDao.class.getResource("db.properties").getPath();
		FileInputStream in = new FileInputStream(path);
		Properties properties = new Properties();
		properties.load(in);
		
		System.out.println(properties.getProperty("url"));
	}
	
	public void find(){
		
	}
	
	public void delete(){
		
	}
	
}
