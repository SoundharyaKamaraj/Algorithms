/**
 * 
 */
package com.learn.algorithms.fibonacci;

import java.util.Scanner;

/**
 * @author Soundharya
 *
 */
public class FibonacciNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter the count for fibonnaci series ");
		int count = input.nextInt();
		printFibonacci(count);
		printEvenFibonacci(count);

	}

	private static void printFibonacci(int count) {
    int firstNumber =0;
    int secondNumber=1;
    int thirdNumber;
    int EvenNoTotal=0;
    System.out.println(firstNumber+" "+secondNumber);
    for(int i=2;i<=count;i++){
    	thirdNumber=firstNumber+secondNumber;
    	firstNumber=secondNumber;
    	secondNumber=thirdNumber;
    	System.out.println(" "+thirdNumber+" ");
    	if(thirdNumber%2==0){
    		EvenNoTotal += thirdNumber;	
    	}
    }
    System.out.println("Even Number total is "+EvenNoTotal);
	}
	
	// AND (&) operator returns a one in each bit position for which the
	// corresponding bits of both operands are ones; otherwise returns zero. The
	// idea to find odd or even using the last digit of a number will also work
	// for the numbers in binary format. The binary number is odd if its last
	// digit is 1 and even if its last digit is 0.

	// To get the last digit of the binary number, do AND (&) operation of the
	// number with 1.

	// number & 1 will give you the last digit of the binary number.
	
	private static void printEvenFibonacci(int count) {
	    int firstNumber =0;
	    int secondNumber=2;
	    int thirdNumber;
	    System.out.println(firstNumber+" "+secondNumber);
	    for(int i=2;i<=count;i++){
	    	thirdNumber=firstNumber+secondNumber;
	    	firstNumber=secondNumber;
	    	secondNumber=thirdNumber;
	    	if((thirdNumber&1)==0){
	    		System.out.println(" "+thirdNumber+" ");
	    	}
	    }
		}

}
