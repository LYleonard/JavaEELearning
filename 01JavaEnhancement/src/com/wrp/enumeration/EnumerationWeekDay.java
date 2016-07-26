package com.wrp.enumeration;

public class EnumerationWeekDay {

	public static void main(String[] args) {
		
		WeekDay weekDay= WeekDay.Sat;
		String value = weekDay.localValue();
		
		System.out.println(value);
	}
}

enum WeekDay {
	Mon("Monday"){
		public String localValue(){
			return "星期一";
		}
	},
	Tue("Tuesday"){
		public String localValue(){
			return "星期二";
		}
	},
	Wed("Wednesday"){
		public String localValue(){
			return "星期三";
		}
	},
	Thu("Thursday"){
		public String localValue(){
			return "星期四";
		}
	},
	Fri("Friday"){
		public String localValue(){
			return "星期五";
		}
	},
	Sat("Saturday"){
		public String localValue(){
			return "星期六";
		}
	},
	Sun("Sunday"){
		public String localValue(){
			return "星期日";
		}
	};
	
	private String value;
	
	private WeekDay(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
	public abstract String localValue();
}