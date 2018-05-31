/**
 * 
 */
package com.learn.algorithms.hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Soundharya
 *
 */
public class WatsonLoveArrays {

	static long howManyGoodSubarrays(int[] A, int m, int k) {
		long totalGoodArray = 0;
      int currentNum =1;
      int maxNum=1;
      for (int i = 0; i < A.length; i++) {
    	  maxNum=maxNum*A[i];
    	  if (maxNum % m == k) {
				totalGoodArray++;
			}
      }
      
		/*for (int i = 0; i < A.length; i++) {
			int temp = 0;
			for (int j = i; j < A.length; j++) {
				if (i == j) {
					temp = A[i];
				} else {
					temp = A[j] * temp;
				}
				if (temp % m == k) {
					totalGoodArray++;
				}
			}
		}*/

		return totalGoodArray;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			String[] nmk = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nmk[0]);

			int m = Integer.parseInt(nmk[1]);

			int k = Integer.parseInt(nmk[2]);

			int[] A = new int[n];

			String[] AItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int AItem = Integer.parseInt(AItems[i]);
				A[i] = AItem;
			}

			long result = howManyGoodSubarrays(A, m, k);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
	
	static long howManyLatestGoodSubarrays(int[] A, int m, int k) {
	     long totalGoodArray = 0;
			for (int i = 0; i < A.length; i++) {
				int temp = 0;
				for (int j = i; j < A.length; j++) {
					if (i == j) {
						temp = A[i];
					} else {
						temp = A[j] * temp;
					}
					if (temp % m == k) {
						totalGoodArray++;
					}
				}
			}

			return totalGoodArray;


	    }

}
