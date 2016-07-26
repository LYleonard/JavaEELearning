package com.wrp.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class GenericDemo2 {
	
	@Test
	public void test1(){
		
		List<String> list = new ArrayList<String>(); //使用泛型是两边类型要一致
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String value = it.next();
			System.out.println(value);
		}
		
		//增强for循环
		for(String s : list){
			System.out.println(s);
		}
		
		Map<Integer, String> map = new HashMap<Integer, String>(); //Map<K,V>中，K、V 必须是引用数据类型，不能是基本类型
		map.put(1, "AA");
		map.put(2, "BB");
		map.put(3, "CC");
		
		//传统 keyset entryset
		Set<Map.Entry<Integer, String>> set= map.entrySet();
		Iterator<Map.Entry<Integer, String>> it1 = set.iterator();
		
	}
	
	@Test
	public void test2(){
		
		//Map<Integer, String> map = new HashMap<Integer, String>(); //Map<K,V>中，K、V 必须是对象类型, 顺序会有变化
		Map<Integer, String> map = new LinkedHashMap<Integer, String>(); // 顺序为输入时的顺序,购物车可以用此实现
		map.put(1, "AA");
		map.put(2, "BB");
		map.put(3, "CC");
		
		//传统 keyset entryset
		Set<Map.Entry<Integer, String>> set= map.entrySet();
		Iterator<Map.Entry<Integer, String>> it1 = set.iterator();
		while(it1.hasNext()){
			Map.Entry<Integer, String> entry = it1.next();
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key + " = " + value);
		}
		
		//增强 for循环(重点)
		for(Map.Entry<Integer, String> entry :map.entrySet()){
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key + " = " + value);
		}
	}
	
	@Test
	public void test3(){
		
		ArrayList<String> list = new ArrayList();//这种也可以运行，主要是为了低级程序与高级程序兼容问题
		ArrayList list1 = new ArrayList<String>();//这种也可以运行，主要是为了版本兼容问题
		
	}
	
}
