/**
 * 
 */
package com.learn.algorithms.crackingcode;

/**
 * @author Soundharya
 *
 */
public class RotationArray {
	public static void main(String[] args) {
		// NOTE: The following input values will be used for testing your
		// solution.
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7 };
		int[] array2a = { 4, 5, 6, 7, 8, 1, 2, 3 };
		System.out.println(isRotation(array1, array2a));
		int[] array2b = { 4, 5, 6, 7, 1, 2, 3 };
		System.out.println(isRotation(array1, array2b));
		// should return true.
		int[] array2c = { 4, 5, 6, 9, 1, 2, 3 };
		System.out.println(isRotation(array1, array2c));
		// should return false.
		int[] array2d = { 4, 6, 5, 7, 1, 2, 3 };
		System.out.println(isRotation(array1, array2d));
		// should return false.
		int[] array2e = { 4, 5, 6, 7, 0, 2, 3 };
		System.out.println(isRotation(array1, array2e));
		// should return false.
		int[] array2f = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(isRotation(array1, array2f));
		// should return true.
	}

	// Implement your solution below.
	public static Boolean isRotation(int[] array1, int[] array2) {
		boolean isRotation = false;
		if (array1.length == array2.length) {
			int pointerOne = 0;
			int pointerTwo = 0;
			while (pointerOne < array1.length) {
				if (pointerTwo >= array2.length) {
					if (isRotation) {
						pointerTwo = 0;
					} else {
						return isRotation;
					}
				}
				if (array1[pointerOne] == array2[pointerTwo]) {
					pointerOne++;
					pointerTwo++;
					isRotation = true;
				}

				else {
					if (isRotation) {
						return false;
					} else {
						pointerTwo++;
					}
				}

			}
		}
		return isRotation;
	}
}
