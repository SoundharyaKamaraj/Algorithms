/**
 * 
 */
package com.learn.algorithms.uniquecharacters;

/**
 * @author Soundharya
 *
 */
public class UniqueCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isUniqueChars2("fortune");
		isUniqueChars2("cookies");
	}

	private static boolean isUniqueChars2(String input) {

		boolean[] asciiValues = new boolean[256];
		for (int i = 0; i < input.length(); i++) {
			int asciiKey = input.charAt(i);
			if (asciiValues[asciiKey]) {
				return false;
			}
			asciiValues[asciiKey] = true;

		}

		return true;
	}

}
