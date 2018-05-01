/**
 * 
 */
package com.learn.algorithms.romannumerals;

import java.util.Scanner;

/**
 * @author Soundharya
 *
 */
public class RomanNumerals {

	public static final String ROMAN_ONE = "I";
	public static final String ROMAN_FIVE = "V";
	public static final String ROMAN_TEN = "X";
	public static final String ROMAN_FIFTY = "L";
	public static final String ROMAN_HUNDRED = "C";
	public static final String ROMAN_FIVEHUNDRED = "L";
	public static final String ROMAN_THOUSAND = "M";
	public static final String EMPTY_STRING = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int userOne;
		String modernValue = "";
		boolean modernSystem = false;

		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter the value");
		userOne = input.nextInt();
		System.out.println("Do you want Modern Numeral system");
		modernSystem = input.nextBoolean();

		System.out.println(convertToRomanNumeral(userOne, modernSystem));

		// System.out.println("Exiting the program");

	}

	private static String convertToRomanNumeral(int userOne, boolean modernSystem) {
		if (modernSystem) {
			return convertToModernSystem(userOne);
		}
		return convertToOldApproach(userOne);
	}

	private static String convertToOldApproach(int userOne) {

		int modulusValue = fetchModulusValue(userOne, 10);
		return fetchRomanNumeralRecursively(userOne, modulusValue);
	}

	private static String fetchRomanNumeralRecursively(int userOne, int modulusValue) {
		String firstRomanValue = EMPTY_STRING;
		String secondRomanValue = EMPTY_STRING;
		int remainingTotal = userOne - modulusValue;
		if(remainingTotal !=0){
			firstRomanValue=fetchFirstNumeralValue(remainingTotal,firstRomanValue);
		}
		secondRomanValue = fectSecondRomanValue(modulusValue);
		System.err.println(firstRomanValue+"-->firstRomanValue");
		System.err.println(secondRomanValue+"-->secondRomanValue");
		return firstRomanValue.concat(secondRomanValue);
	}

	private static String fectSecondRomanValue(int modulusValue) {
		String secondRomanValue = EMPTY_STRING;
		if (modulusValue == 5){
			secondRomanValue = secondRomanValue + ROMAN_FIVE;
		}
		else if (modulusValue < 5) {
			for (int i = 0; i < modulusValue; i++) {
				secondRomanValue = secondRomanValue + ROMAN_ONE;
			}
		}
		else {
				secondRomanValue=ROMAN_FIVE;
				int modVal =fetchModulusValue(modulusValue,5);
				for (int i = 0; i < modVal; i++) {
					secondRomanValue = secondRomanValue + ROMAN_ONE;
				}
			}
		return secondRomanValue;
	}

	private static int fetchModulusValue(int actualValue, int modulusValue) {
		return actualValue % modulusValue;
	}

	private static String fetchFirstNumeralValue(int remainingTotal,String firstRomanValue) {
		if (remainingTotal >= 1 && remainingTotal < 5) {
			for (int i = 0; i < remainingTotal; i++) {
				firstRomanValue = firstRomanValue + ROMAN_ONE;
			}
		} else if (remainingTotal >= 5 && remainingTotal < 10) {
			firstRomanValue = firstRomanValue + ROMAN_FIVE;
		}

		else if (remainingTotal >= 10 && remainingTotal < 50) {
			int firstDigit = firstDigit(remainingTotal);
			for (int i = 0; i < firstDigit; i++) {
				firstRomanValue = firstRomanValue + ROMAN_TEN;
			}
			

		} else if (remainingTotal >= 50 && remainingTotal < 100) {
			firstRomanValue=firstRomanValue + ROMAN_FIFTY;
			String romanDigitValue=EMPTY_STRING;
			 int actualValue= remainingTotal-50;
			 int firstDigit = firstDigit(actualValue);
			 for(int i=0;i<firstDigit;i++){
				 romanDigitValue=romanDigitValue+fetchRomanDigit(actualValue);
			 }
			 firstRomanValue =firstRomanValue.concat(romanDigitValue);
			 
		} else if (remainingTotal >= 100 && remainingTotal < 500) {
			firstRomanValue=firstRomanValue + ROMAN_HUNDRED;
			String romanDigitValue=EMPTY_STRING;
			 int actualValue= remainingTotal-100;
			 int firstDigit = firstDigit(actualValue);
			 for(int i=0;i<firstDigit;i++){
				 romanDigitValue=romanDigitValue+fetchRomanDigit(actualValue);
			 }
			 firstRomanValue =firstRomanValue.concat(romanDigitValue);
		}
		else if (remainingTotal >= 500 && remainingTotal < 1000) {
			firstRomanValue=firstRomanValue + ROMAN_FIVEHUNDRED;
			String romanDigitValue=EMPTY_STRING;
			 int actualValue= remainingTotal-500;
			 int firstDigit = firstDigit(actualValue);
			 for(int i=0;i<firstDigit;i++){
				 romanDigitValue=romanDigitValue+fetchRomanDigit(actualValue);
			 }
			 firstRomanValue =firstRomanValue.concat(romanDigitValue);
		} else {
			firstRomanValue=firstRomanValue + ROMAN_THOUSAND;
			String romanDigitValue=EMPTY_STRING;
			 int actualValue= remainingTotal-1000;
			 int modulusValue= fetchModulusValue(remainingTotal,1000);
			 int firstDigit = firstDigit(actualValue);
			 for(int i=0;i<firstDigit;i++){
				 romanDigitValue=romanDigitValue+fetchRomanDigit(actualValue);
			 }
			 firstRomanValue =firstRomanValue.concat(romanDigitValue);
		}

		return firstRomanValue;

	}

	private static String fetchRomanDigit(int value) {

		if (value >= 1 && value < 5) {
			return ROMAN_ONE;
		} else if (value >= 5 && value < 10) {
			return ROMAN_FIVE;
		} else if (value >= 10 && value < 50) {
			return ROMAN_TEN;
		} else if (value >= 50 && value < 100) {
			return ROMAN_FIFTY;
		} else if (value >= 100 && value < 500) {
			return ROMAN_HUNDRED;
		} else if (value >= 500 && value < 1000) {
			return ROMAN_FIVEHUNDRED;
		} else if (value >= 1000) {
			return ROMAN_THOUSAND;
		}
		return EMPTY_STRING;
	}

	private static String convertToModernSystem(int userOne) {
		return null;
	}

	private static int firstDigit(int remainingTotal) {
		if (remainingTotal / 10 == 0)
			return remainingTotal;
		return firstDigit(remainingTotal / 10);

	}

}
