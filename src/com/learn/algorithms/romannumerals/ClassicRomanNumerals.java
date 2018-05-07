/**
 * 
 */
package com.learn.algorithms.romannumerals;

import java.util.Scanner;

/**
 * @author Soundharya
 *
 */
public class ClassicRomanNumerals {
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
	}

	private static String convertToRomanNumeral(int userOne, boolean modernSystem) {
		if (modernSystem) {
			return convertToModernSystem(userOne);
		}
		return convertToOldApproach(userOne);
	}

	private static String convertToOldApproach(int userOne) {
		int lengthOfDigit = (int) Math.log10(userOne) + 1;
		System.err.println(lengthOfDigit);
		String firstRomanValue = EMPTY_STRING;
		String remainngRomanValue = EMPTY_STRING;
		
		if (lengthOfDigit == 1) {
			if (userOne >= 1 && userOne < 5) {
				for (int i = 0; i < userOne; i++) {
					firstRomanValue = firstRomanValue + ROMAN_ONE;
				}
				return firstRomanValue;
			} 
			else{
				firstRomanValue = firstRomanValue + ROMAN_FIVE;
				remainngRomanValue=fetchRemainRomanValue(userOne-5,firstRomanValue);
				return firstRomanValue+remainngRomanValue;
			}

		} 
		else if (lengthOfDigit == 2) {
			if (userOne >= 10 && userOne < 50) {
				firstRomanValue = firstRomanValue + ROMAN_TEN;
				remainngRomanValue=fetchRemainRomanValue(userOne-10,firstRomanValue);
				return firstRomanValue+remainngRomanValue;
				}
				else if (userOne >= 50 && userOne < 100) {
					firstRomanValue=firstRomanValue + ROMAN_FIFTY;
					remainngRomanValue=fetchRemainRomanValue(userOne-50,firstRomanValue);
					return firstRomanValue+remainngRomanValue;
				}		
		} else if (lengthOfDigit == 3) {

		} else if (lengthOfDigit == 4) {

		} else if (lengthOfDigit == 5) {

		}

		return null;
	}

	private static String fetchRemainRomanValue(int remainingTotal, String firstRomanValue) {
		int modulusValue = fetchModulusValue(remainingTotal, 10);
		String remainNumerals=EMPTY_STRING;
		if(modulusValue==0){
			for(double i=0;i<=Math.log(remainingTotal);i++){
				remainNumerals = remainNumerals + firstRomanValue;
			}
		}
		
		else{
			int pendingNumerals=remainingTotal-modulusValue;
			
			remainNumerals= CalculateModulusNumerals(modulusValue);
		}
		return remainNumerals;
		
	}

	private static String CalculateModulusNumerals(int modulusValue) {
		String secondRomanValue = EMPTY_STRING;
		if (modulusValue == 5){
			secondRomanValue = secondRomanValue + ROMAN_FIVE;
		}
		else if (modulusValue < 5) {
			for (int i = 0; i < modulusValue; i++) {
				secondRomanValue = secondRomanValue + ROMAN_ONE;
			}
		}
		else{
			secondRomanValue = secondRomanValue + ROMAN_FIVE;
			for (int i = 0; i < modulusValue-5; i++) {
				secondRomanValue = secondRomanValue + ROMAN_ONE;
			}
		}
		return secondRomanValue;
	}

	private static String convertToModernSystem(int userOne) {

		return null;
	}
	
	private static int fetchModulusValue(int actualValue, int modulusValue) {
		return actualValue % modulusValue;
	}

}
