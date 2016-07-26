package com.wrp.reflect;

import java.awt.List;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.acl.Permission;
import java.util.ArrayList;

import org.junit.Test;

// 反射类的构造函数，创建类的对象
public class Demo2 {
	
	// 反射构造函数：public Person()
	@Test
	public void test1() throws Exception{
		// 加载类
		Class class1 = Class.forName("com.wrp.reflect.Person");
		
		// 反射类的构造函数，并创建类的对象
		Constructor c = class1.getConstructor(null);
		Person p = (Person) c.newInstance(null);
		
		System.out.println(p.name);
	}
	
	// public Person(String name)
	@Test
	public void test2() throws Exception{
		// 加载类
		Class class1 = Class.forName("com.wrp.reflect.Person");
		
		// 反射类的构造函数，并创建类的对象
		Constructor c = class1.getConstructor(String.class);
		Person p = (Person) c.newInstance("xxxxxxx");
		
		System.out.println(p.name);
	}
	
	// public Person(String name,int password)
	@Test
	public void test3() throws Exception{
		//加载类
		Class class1 = Class.forName("com.wrp.reflect.Person");
		
		//反射类的构造函数，并创建类的对象
		Constructor c = class1.getConstructor(String.class,int.class);
		Person p = (Person) c.newInstance("xxxxx",421563);
		
		System.out.println(p.name);
	}
	
	//private Person(List list)
	@Test
	public void test4() throws Exception {
		Class class1 = Class.forName("com.wrp.reflect.Person");
		Constructor c = class1.getDeclaredConstructor(List.class);//只能访问public类型的方法
		c.setAccessible(true);//暴力反射
		Person p =(Person) c.newInstance(new List());
		System.out.println(p.name);
	}
	
	// 创建对象的第二种方法
	@Test
	public void test5() throws Exception {
		Class class1 = Class.forName("com.wrp.reflect.Person");
		Person p =(Person) class1.newInstance();
		System.out.println(p);
	}
	
}
