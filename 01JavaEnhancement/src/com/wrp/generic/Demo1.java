package com.wrp.generic;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

	public static <E> void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("WRP");
		
		String i = list.get(0);
		
		System.out.println(i);
	}

}
