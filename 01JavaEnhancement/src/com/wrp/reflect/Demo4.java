package com.wrp.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

//反射字段
public class Demo4 {
	//反射字段：public String name = "aaaaa"
	@Test
	public void test() throws Exception{
		
		Person p = new Person();
		
		Class class1 = Class.forName("com.wrp.reflect.Person");
		Field f = class1.getField("name");
		String name = (String) f.get(p);
		
		//获取字段的值
		Object value = f.get(p);
		//获取字段的值
		Class type = f.getType();
		
		if(type.equals(String.class)){
			String val = (String) value;
			System.out.println(val);
		}
		
		//设置字段的值
		f.set(p, "MiSSSS");
		System.out.println(p.name);
	}
	
	// 反射字段：private int passwod
	@Test
	public void test2() throws Exception{
		
		Person p = new Person();
		Class class1 = Class.forName("com.wrp.reflect.Person");
		Field f = class1.getDeclaredField("password");
		f.setAccessible(true);
		
		System.out.println(f.get(p));
	}
	
	// 反射字段：private static int age
	@Test
	public void test3() throws Exception{
		
		Person p = new Person();
		Class class1 = Class.forName("com.wrp.reflect.Person");
		Field f = class1.getDeclaredField("age");
		f.setAccessible(true);
		
		System.out.println(f.get(p));
	}
	
}
