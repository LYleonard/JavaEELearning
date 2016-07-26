package com.wrp.generic;

import org.junit.Test;

//自定义带泛型的方法
public class DefinedGeneric { //public class DefinedGeneric<T> 类上的定义的泛型 ，对静态方法无效
	
	@Test
	public void test1(){
		A_method("混蛋啊");
	}
	
	public <T> Object A_method(T t){
		T A;
		return A = t;
	}
	public <T, E, K> void B_method(T t, E e, K k){
		
	}
	
	public static <T> void C_method(T t){
		
	}
}
