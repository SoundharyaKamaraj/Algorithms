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
	
	//String array containing 13 roman symbols
    
    private static String[] romanSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
     
    //int array containing 13 decimal numbers
     
   private static int[] decimals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	
   private static String[] oldRomanSymbols = {"M", "DCCCC", "D", "CCCC", "C", "LXXXX", "L", "XXXX", "X", "VIIII", "V", "IIII", "I"};
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

	private static String convertToOldApproach(int inputNumber) {
		String roman="";
		
		for(int j=0;j<13;j++){
			while(inputNumber>=decimals[j]){
				inputNumber = inputNumber - decimals[j];
				roman =roman+oldRomanSymbols[j];
			}
		}
		return roman;
	}

	private static String convertToModernSystem(int inputNumber) {
		String roman="";
		 //Copying inputNumber into copyOfInputNumber
        
		if(inputNumber<=0 &&  inputNumber>=3000){
			System.err.println("Please enter an valid number");
		}
		else{
			
			for (int i = 0; i < 13; i++) 
            {
                while(inputNumber >= decimals[i])
                {
                	System.out.println("inputNumber "+inputNumber);
                    inputNumber = inputNumber - decimals[i];
                    roman = roman + romanSymbols[i];
                    System.out.println("Roman Equivalent Of "+inputNumber+" is : "+roman);
                }
            }
             
        }
		
		return roman;
	}
	
	
	

}
