package com.wrp.enumeration;

import org.junit.Test;

public class EnumerationGrade {

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
*/
	@Test
	public void test(){
		print(Grade.B);
	}
	
	public void print(Grade g){
		String value = g.localeValue();
		System.out.println(value);
	}
	
}

//带抽象犯法的枚举类型
enum Grade{//class		A 100-90 优	 B 89-80 良   	C 79-70 中 	D 69-60 及格  	E 59-0 不及格
	
	A("100-90"){
		public String localeValue(){
			return "优";
		}
	}
	,B("89-80"){
		public String localeValue(){
			return "良";
		}
	}
	,C("79-70"){
		public String localeValue(){
			return "中";
		}
	}
	,D("69-60"){
		public String localeValue(){
			return "及格";
		}
	}
	,E("59-0"){
		public String localeValue(){
			return "不及格";
		}
	};
	
	private String value;
	private Grade(String value) {
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public abstract String localeValue();
}