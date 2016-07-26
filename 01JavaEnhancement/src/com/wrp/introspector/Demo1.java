package com.wrp.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

//使用内省 API 操作 bean 的属性
public class Demo1 {
	//得到Bean的所有属性
	@Test
	public void test1() throws IntrospectionException{
		
		BeanInfo info = Introspector.getBeanInfo(Person.class,Object.class); //得到 Bean 自己的属性，二不得到从父类 Object 继承的属性
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds){
			System.out.println(pd.getName());
		}
	}
	
	//操作Bean的指定属性:age
	@Test
	public void test2() throws Exception {
		
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age",Person.class);
		
		// 获取属性的写方法，为属性赋值
		Method method = pd.getWriteMethod(); // public void setAge(int age)
		method.invoke(p, 23);
		
		//获取属性的值
		method = pd.getReadMethod();
		System.out.println(method.invoke(p, null));  // public void setAge()
	}
	
	//获取当前操作的属性的类型
	@Test
	public void test3() throws Exception {
		
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age",Person.class);
		
		System.out.println(pd.getPropertyType());
	}
	
}
