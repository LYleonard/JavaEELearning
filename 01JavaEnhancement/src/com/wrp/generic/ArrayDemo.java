package com.wrp.generic;

import org.junit.Test;

public class ArrayDemo {
	
	public <T> void swap(T arr[], int pos1, int pos2){
		
		T temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
		
	}
	
	@Test
	public void test(){
		String arr[] = {"aa","bb"};
		reverse(arr);
	}

	// 编写一个泛型方法，接收任意数组，并倒置数组中的所有元素
	public <T> void reverse(T arr[]){
		
		int start = 0;
		int end = arr.length-1;
		
		while(true) {
			if(start>=end){
				break;
			}
			T temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
	}
	
}
