/**
 * 
 */
package com.learn.algorithms.crackingcode;

/**
 * @author Soundharya
 *
 */
public class TwoDArrayRotation {
	public static void main(String[] args) {
		// NOTE: The following input values will be used for testing your
		// solution.
		int a1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		 printField(rotate2(a1, 3));
		// should return:
		// [[7, 4, 1],
		// [8, 5, 2],
		// [9, 6, 3]]

		int a5[][] = { { 1, 2, 3, 4, 5, 6, 7, 8 }, { 9, 10, 11, 12, 13, 14, 15, 16 },
				{ 17, 18, 19, 20, 21, 22, 23, 24 }, { 25, 26, 27, 28, 29, 30, 31, 32 },
				{ 33, 34, 35, 36, 37, 38, 39, 40 }, { 41, 42, 43, 44, 45, 46, 47, 48 },
				{ 49, 50, 51, 52, 53, 54, 55, 56 }, { 57, 58, 59, 60, 61, 62, 63, 64 } };
		printField(rotate2(a5, 8));
		/*
		 * 57 49 41 33 25 17 9 1 
		 * 58 50 42 34 26 18 10 2 
		 * 59 51 43 35 27 19 11 3
		 * 60 52 44 36 28 20 12 4 
		 * 61 53 45 37 29 21 13 5 
		 * 62 54 46 38 30 22 14 6
		 * 63 55 47 39 31 23 15 7 
		 * 64 56 48 40 32 24 16 8
		 */

		int a2[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printField(rotate2(a2, 4));
		// should return:
		// [[13, 9, 5, 1],
		// [14, 10, 6, 2],
		// [15, 11, 7, 3],
		// [16, 12, 8, 4]]
	}

	// Implement your solution below.
	public static int[][] rotate(int[][] a, int n) {
		// NOTE: To solve it in place, write this function so that you
		// won't have to create rotated.
		int[][] rotated = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotated[j][n - 1 - i] = a[i][j];
			}
		}

		return rotated;

	}

	// Implement your solution below.
	public static int[][] rotate2(int[][] a, int n) {

		for (int l = 0; l < n/2 + n%2; l++) {
			for (int m = 0; m < n/2; m++) {
				int currentRow = l;
				int currentColumn = m;
				int[] temp = new int[4];
				for (int i = 0; i < 4; i++) {
					temp[i] = a[currentRow][currentColumn];
					int[] newCoordinates ={currentColumn,n-1-currentRow};
					currentRow = newCoordinates[0]; currentColumn = newCoordinates[1];
				}

				for (int i = 0; i < 4; i++) {
					a[currentRow][currentColumn] = temp[(i + 3) % 4];
					//currentRow = currentColumn;
					//currentColumn = n - 1 - currentRow;
					int[] newCoordinates = {currentColumn,n-1-currentRow};
					currentRow = newCoordinates[0]; currentColumn = newCoordinates[1];
				}

			}

		}

		return a;
	}

	public static int[] rotateSub(int i, int j, int n) {
		int[] newCoordinates = new int[2];
		newCoordinates[0] = j;
		newCoordinates[1] = n - 1 - i;
		return newCoordinates;
	}

	private static void printField(int[][] mineSweeper2) {

		for (int[] item : mineSweeper2) {
			for (int item1 : item) {
				System.out.print(item1 + " ");
			}
			System.out.println();
		}

	}

}
