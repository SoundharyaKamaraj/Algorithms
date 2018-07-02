/**
 * 
 */
package com.learn.algorithms.crackingcode;

/**
 * @author Soundharya
 *
 */
public class OneAwayString {
	public static void main(String[] args) {
		// NOTE: The following input values will be used for testing your
		// solution.
		System.out.println(isOneAway("abcde", "abcd")); // should return true
		System.out.println(isOneAway("abde", "abcde")); // should return true
		System.out.println(isOneAway("a", "a")); // should return true
		System.out.println(isOneAway("abcdef", "abqdef")); // should return true
		System.out.println(isOneAway("abcdef", "abccef")); // should return true
		System.out.println(isOneAway("abcdef", "abcde")); // should return true
		System.out.println(isOneAway("aaa", "abc")); // should return false
		System.out.println(isOneAway("abcde", "abc")); // should return false
		System.out.println(isOneAway("abc", "abcde")); // should return false
		System.out.println(isOneAway("abc", "bcc")); // should return false
	}

	// Implement your solution below.
	public static Boolean isOneAway(String s1, String s2) {
		if (s1.equals(s2)) {
			return true;
		} else if (s1.length() == s2.length() || s1.length() - 1 == s2.length() || s1.length() == s2.length() - 1) {

			if (s1.length() == s2.length()) {
				return isOneAwaySameLength(s1, s2);

			} else if (s1.length() > s2.length()) {
				return isOneAwayDifferentLength(s1, s2);
			} else if (s2.length() > s1.length()) {
				return isOneAwayDifferentLength(s2, s1);
			}
		}
		return false;
	}

	private static Boolean isOneAwayDifferentLength(String s1, String s2) {
		int pointerOne = 0;
		int pointerTwo = 0;
		int uniqueCount = 0;
		while (s2.length() < pointerTwo) {
			if (s1.charAt(pointerOne) == s2.charAt(pointerTwo)) {
				pointerOne++;
				pointerTwo++;
			} else {
				pointerOne++;
				uniqueCount++;
			}
			if (uniqueCount > 1) {
				return false;
			}
		}

		return true;
	}

	private static Boolean isOneAwaySameLength(String s1, String s2) {

		int uniqueCount = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				uniqueCount++;
			}
			if (uniqueCount > 1) {
				return false;
			}
		}

		return true;
	}
}