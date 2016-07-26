package com.wrp.reflect;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Set;

import org.junit.Test;

//反射类的方法
public class Dome3 {
	//反射类的方法：public void aa1()
	@Test
	public void test1() throws Exception{
		
		Person p = new Person();
		Class class1 = Class.forName("com.wrp.reflect.Person");
		Method method = class1.getMethod("aa1", null);
		method.invoke(p, null);
	}
	
	//反射类的方法：public void aa1(String name,int password)
	@Test
	public void test2() throws Exception{
		
		Person p = new Person();
		Class class1 = Class.forName("com.wrp.reflect.Person");
		Method method = class1.getMethod("aa1", String.class,int.class);
		method.invoke(p, "Jone",21);
	}
	
	//反射类的方法：public Class[] aa1(String name, int[] password)
	@Test
	public void test3() throws Exception{
		
		Person p = new Person();
		Class class1 = Class.forName("com.wrp.reflect.Person");
		Method method = class1.getMethod("aa1", String.class,int[].class);
		Class cs[] = (Class[]) method.invoke(p, "Test Test  啊！",new int[]{1,2,3});
		System.out.println(cs[0]);
	}
	
	//反射类的方法：private void aa1(InputStream in)
	@Test
	public void test4() throws Exception{
		
		Person p = new Person();
		Class class1 = Class.forName("com.wrp.reflect.Person");
		Method method = class1.getDeclaredMethod("aa1", InputStream.class);
		method.setAccessible(true);
		method.invoke(p, new FileInputStream("C:\\Users\\aygxy\\Desktop\\1.txt"));
	}
	
	//反射类的方法：public static void aa1(int num)
	@Test
	public void test5() throws Exception{
		
		Class class1 = Class.forName("com.wrp.reflect.Person");
		Method method = class1.getMethod("aa1", int.class);
		method.invoke(null,20);
	}
	
	//反射类的方法：public static void main(String[] args)
	@Test
	public void test6() throws Exception{
		
		Class class1 = Class.forName("com.wrp.reflect.Person");
		Method method = class1.getMethod("main", String[].class);
		method.invoke(null,new Object[]{new String[]{"aa","bb"}});
		//method.invoke(null,(Object)new String[]{"aa","bb"});
	}
	
}
