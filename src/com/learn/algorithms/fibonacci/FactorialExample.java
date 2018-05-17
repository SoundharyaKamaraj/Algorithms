/**
 * 
 */
package com.learn.algorithms.fibonacci;

/**
 * @author Soundharya
 *
 */
public class FactorialExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findFactorailUsingIteration(5);
		System.out.println(findFactorailUsingRecusrsive(6));
	}

	private static int findFactorailUsingRecusrsive(int number) {
		if (number == 0) {
			return 1;
		}
		return number * findFactorailUsingRecusrsive(number - 1);
	}

	private static void findFactorailUsingIteration(int number) {
		int total = 1;
		for (int i = number; i > 0; i--) {
			total = total * i;
		}
		System.out.println(total);

	}

}
