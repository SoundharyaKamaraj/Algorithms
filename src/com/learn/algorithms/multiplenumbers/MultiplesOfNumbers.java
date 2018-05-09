/**
 * 
 */
package com.learn.algorithms.multiplenumbers;

import java.util.Scanner;

/**
 * @author Soundharya
 *
 */
public class MultiplesOfNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter the count for fibonnaci series ");
		int count = input.nextInt();
		printMultiplesOfNumber(count);
	}

	private static void printMultiplesOfNumber(int count) {
		int total=0;
		for(int i=0;i<count;i++){
			if(i%3==0 || i%5==0){
				System.out.println(i);
				total+=i;
			}
		}
		System.out.println("Total of the series is "+total);
		
	}

}
