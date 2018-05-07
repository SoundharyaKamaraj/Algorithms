/**
 * 
 */
package com.learn.algorithms.romannumerals;

import java.util.Scanner;

/**
 * @author Soundharya
 *
 */
public class RomanToDigitalConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter the value");
		String userInput = input.nextLine();
		covertToDigitalNumeral(userInput);
	}

	private static void covertToDigitalNumeral(String userInput) {
		userInput =userInput.toUpperCase();
		int arabic = 0; 
		for(int i=0;i<userInput.length();i++){
			 char letter = userInput.charAt(i);        // Letter at current position in string.
             int number = letterToNumber(letter);
             if(i+1!=userInput.length()){
             int nextNumber = letterToNumber(userInput.charAt(i+1));
             System.err.println("Number is"+number);
             System.err.println("Next Number is"+nextNumber);
             if (nextNumber > number) {
                 // Combine the two letters to get one value, and move on to next position in string.
              arabic += (nextNumber - number);
              System.err.println(arabic);
             i=i+1;
           }
           else {
                 // Don't combine the letters.  Just add the value of the one letter onto the number.
              arabic += number;
           }
             }
             else{
            	 arabic += number; 
             }
		}
		System.err.println(arabic);
	}

	private static int letterToNumber(char letter) {
		switch (letter) {
        case 'I':  return 1;
        case 'V':  return 5;
        case 'X':  return 10;
        case 'L':  return 50;
        case 'C':  return 100;
        case 'D':  return 500;
        case 'M':  return 1000;
        default:   return -1;
		}
	}

}
