/**
 * 
 */
package com.learn.algorithms.displayrange;

import java.util.Scanner;

/**
 * @author Soundharya
 *
 */
public class DisplayRangeElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int startingRange;
		 int endingRange;
		 Scanner input = new Scanner(System.in);
	      System.out.println("Please Enter a starting range");
	      startingRange=input.nextInt();
	      System.out.println("Please Enter a ending Range");
	      endingRange=input.nextInt();
          //PrintRangeIterative(startingRange,endingRange);
          PrintRangeRecursive(startingRange,endingRange);
	}

	private static void PrintRangeRecursive(int startingRange, int endingRange) {
		if(startingRange>endingRange){
			return;
		}
		System.out.println(startingRange);
		PrintRangeRecursive(++startingRange, endingRange);
		
	}

	private static void PrintRangeIterative(int startingRange, int endingRange) {
		if(startingRange>endingRange){
			System.err.println("SatrtingRange shouldnt be greater than endingRange ");
		}
		for(int i=startingRange;i<=endingRange;i++){
			System.out.println(i);
		}
		
	}

}
