package com.wrp.reflect;

import java.awt.List;
import java.io.InputStream;

public class Person {
	public String name = "aaaaa";
	private int password = 22445;
	private static int age = 20;

	public Person() {
		System.out.println("Person");
	}
	
	public Person(String name){
		System.out.println("Person name"); 
		System.out.println(name); 
	}
	
	public Person(String name,int password){
		System.out.println(name + ":" + password);
	}
	
	@SuppressWarnings("unused")
	private Person(List list){
		System.out.println("List");
	}
	
	public void aa1(){
		System.out.println("aa1");
	}
	
	public void aa1(String name,int password){
		System.out.println(name + ":" + password);
	}
	
	public Class[] aa1(String name, int[] password){
		return new Class[]{String.class};
	}
	
	private void aa1(InputStream in){
		System.out.println(in);
	}
	
	public static void aa1(int num){
		System.out.println(num);
	}
	
	public static void main(String[] args){
		System.out.println("Main!!");
	}
}
