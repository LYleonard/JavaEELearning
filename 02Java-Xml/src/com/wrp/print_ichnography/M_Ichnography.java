package com.wrp.print_ichnography;

import org.junit.Test;

/*	打印如下的数字图像
 * 	
 *    3   7
 *   2 4 6 8
 *  1   5   9
 *  
 *  这是一个平面图像题（二维数组）
 */
public class M_Ichnography {

	public static void main(String[] args) {

		int num = 9;
		int arr[][] = new int[3][9];
		int x = 2;
		int y = 0;
		
		boolean order = false;
		for(int i=1; i<=9; i++){
			arr[x][y] = i;
			y++;
			
			if(!order){
				x--;
			}
			if(order){
				x++;
			}
			
			if(x<0){
				order = true;
				x = x+2;
			}
			if(x>2){
				order = false;
				x = x-2;
			}
		}
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(arr[i][j]==0){
					System.out.print(" ");
				}else {
					System.out.print(arr[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	@Test
	public void test1(){
		int num = 13;
		int hight = num/4 + 1;
		int wigth = num;
		
		int arr[][] = new int[hight][wigth];
		int x = hight-1;
		int y = 0;
		
		boolean order = false;
		for(int i=1; i<=num; i++){
			arr[x][y] = i;
			y++;
			
			if(!order){
				x--;
			}
			if(order){
				x++;
			}
			
			if(x<0){
				order = true;
				x = x+2;
			}
			if(x>hight-1){
				order = false;
				x = x-2;
			}
		}
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				if(arr[i][j]==0){
					System.out.print(" ");
				}else {
					System.out.print(arr[i][j]);
				}
			}
			System.out.println();
		}
	}

}
