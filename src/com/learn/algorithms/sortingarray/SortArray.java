/**
 * 
 */
package com.learn.algorithms.sortingarray;

import java.util.Scanner;

/**
 * @author Soundharya
 *
 */
public class SortArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter the count for fibonnaci series ");
		int[] count = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		sortArray(count);

	}

	private static void sortArray(int[] count) {
		int j=count.length-1;
		for(int i=0;i<count.length;i++){
			if(count[i]==1 &&  count[j]==0){
			int temp=count[i];
				count[i]=count[j];
				count[j]=temp;
				j--;
			}
		}
		for(int k=0;k<count.length;k++){
			System.out.println(count[k]);
			}
	}

}
