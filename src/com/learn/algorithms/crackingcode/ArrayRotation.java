/**
 * 
 */
package com.learn.algorithms.crackingcode;

import java.util.Scanner;

/**
 * @author Soundharya
 *
 */
public class ArrayRotation {

	private static final Scanner scanner = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String nd[] = scanner.nextLine().split(" ");

		int n= Integer.parseInt(nd[0]);
		int d= Integer.parseInt(nd[1]);
		
		int a[] = new int[n];
		
		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		
		for (int i=0;i<n;i++){
			int item =Integer.parseInt(aItems[i]);
			a[i] = item;
		}
		
		
		int[] result =leftRotation(a,d);
		
		for(int i=0;i<result.length-1;i++){
			System.out.print(result[i]);
		}
		
	}
	
	
	private static int[] leftRotation(int[] a, int d) {
		
		int[] result = new int[a.length];
		for(int i=d;i<a.length-1;i++){
			result[i] =a[i];
		}
		for(int i=0;i<d-1;i++){
			result[i] =a[i];
		}
		return null;
	}

}
