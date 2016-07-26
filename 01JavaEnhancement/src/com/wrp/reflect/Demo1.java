package com.wrp.reflect;

/**
 * 反射：加载类,获得累的字节码
 *
 */
public class Demo1 {

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) throws ClassNotFoundException {
		//方法1
		Class cl = Class.forName("com.wrp.reflect.Person");
		
		//方法2
		Class cl2 = new Person().getClass();
		
		//方法3
		Class cl3 = Person.class;
	}

}
