package com.wrp.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

// 使用beanutils 操纵 Bean的属性（第三方开发包）
public class Demo1 {
	
	@Test
	public void Test1() throws IllegalAccessException, InvocationTargetException{
		Person p = new Person();
		BeanUtils.setProperty(p, "name", "XXXXX");
		
		System.out.println(p.getName());
	}
	
	//下面的Date类型的属性直接使用BeanUtils.setProperty()是有问题的，需要使用转换器处理
	@Test
	public void Test2() throws IllegalAccessException, InvocationTargetException{

		String name = "WangWP";
		String password = "123456";
		String age = "26";
		//String birthday = "1990-07-07"; //不是基本数据类型
		
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);	 // 只支持8种基本数据类型
		//BeanUtils.setProperty(p, "birthday", birthday);	 // 只支持8种基本数据类型,要注册转化器
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		
	}
	
	//非基本类型的处理,自定义转换器
	@Test
	public void Test3() throws IllegalAccessException, InvocationTargetException{
		
		String name = "WangWP";
		String password = "123456";
		String age = "26";
		String birthday = "1990-07-07";
		
		//为了是日期复发哦bean 的 birthday属性上，给beantuils注册一个日期转化器
		ConvertUtils.register(new Converter() {
			@Override
			public Object convert(Class type, Object value) {
				if(value == null){
					return null;
				}
				if(!(value instanceof String)){
					throw new ConversionException("只支持 String 类型的转换！");
				} 
				String str = (String) value;
				if(str.trim().equals("")){
					return null;
				}
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					return new RuntimeException(e); //异常链不能断
				}
			}
		}, Date.class);
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);	 // 只支持8种基本数据类型
		BeanUtils.setProperty(p, "birthday", birthday);	 // 只支持8种基本数据类型,要注册转化器
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		System.out.println(p.getBirthday());
		
		//Date date = p.getBirthday();
		//System.out.println(date.toLocaleString());
		
	}
	
	//非基本类型的处理,调用Apache BeanUtils实现的转换器
	@Test
	public void Test4() throws IllegalAccessException, InvocationTargetException{
		
		String name = "WangWP";
		String password = "123456";
		String age = "26";
		String birthday = "1990-07-07";
		
		//为了是日期复发哦bean 的 birthday属性上，给beantuils注册一个日期转化器，调用已有API
		ConvertUtils.register(new DateLocaleConverter(), Date.class);	//日期为空时会报异常！！
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);	 // 只支持8种基本数据类型
		BeanUtils.setProperty(p, "birthday", birthday);	 // 只支持8种基本数据类型,要注册转化器
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		System.out.println(p.getBirthday());
		
	}
	
	@Test
	public void test5() throws IllegalAccessException, InvocationTargetException{
		
		Map map = new HashMap();
		map.put("name", "LizhiDeng");
		map.put("password", "123");
		map.put("age", "21");
		map.put("birthday", "1996-07-25");
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Person p = new Person();
		BeanUtils.populate(p, map);
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		System.out.println(p.getBirthday());
	}
	
}
