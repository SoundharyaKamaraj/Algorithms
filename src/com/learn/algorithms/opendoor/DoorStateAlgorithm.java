/**
 * 
 */
package com.learn.algorithms.opendoor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Soundharya
 *
 */
public class DoorStateAlgorithm {
	
	private static boolean[] doorStatuses = new boolean[100];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 100;
		for (int i=0; i < doorStatuses.length; i++) {
			List<Integer> factors = getFactors(i+1);
			/*int count = 0;
			for (int factor : factors) {
				if (factor <= n) {
					count++;
				}
			}*/
			if (factors.size()%2 == 1) {
				doorStatuses[i] = true;
			}
			System.out.println(String.format("door[%s] is %s", i+1, doorStatuses[i] ? "open" : "closed"));
		}
		
	}
	
	private static List<Integer> getFactors(int x) {
		List<Integer> list = new LinkedList<>();
		for (int i=1; i<=x; i++) {
			if (x%i == 0) {
				list.add(i);
			}
		}
		return list;
	}

}
