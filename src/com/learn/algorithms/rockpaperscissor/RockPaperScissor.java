/**
 * 
 */
package com.learn.algorithms.rockpaperscissor;

import java.util.Scanner;

/**
 * @author Soundharya
 *
 */
public class RockPaperScissor {

	public static final String ROCK = "Rock";
	public static final String PAPER = "Paper";
	public static final String SCISSORS = "Scissors";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String userOne = "";
		while (!userOne.equalsIgnoreCase("Exit")) {
			Scanner input = new Scanner(System.in);
			System.out.println("Please Enter the value");
			userOne = input.nextLine();
			System.out.println(printTheWinner(userOne));
		}
		System.out.println("Exiting the program");
	}

	private static String printTheWinner(String inputString) {
		String output = "";
		String userOne;
		String userTwo;
		if (null != inputString && inputString.contains(" ")) {
			String[] input = inputString.split(" ");
			userOne = input[0];
			userTwo = input[1];
			if (userOne.equalsIgnoreCase(userTwo)) {
				output = userOne;
				return output;
			} else if ((userOne.equalsIgnoreCase(ROCK) && userTwo.equalsIgnoreCase(PAPER))
					|| (userTwo.equalsIgnoreCase(ROCK) && userOne.equalsIgnoreCase(PAPER))) {
				output = PAPER;
				return output;
			} else if ((userOne.equalsIgnoreCase(ROCK) && userTwo.equalsIgnoreCase(SCISSORS))
					|| (userTwo.equalsIgnoreCase(ROCK) && userOne.equalsIgnoreCase(SCISSORS))) {
				output = ROCK;
				return output;
			} else if ((userOne.equalsIgnoreCase(PAPER) && userTwo.equalsIgnoreCase(SCISSORS))
					|| userTwo.equalsIgnoreCase(PAPER) && userOne.equalsIgnoreCase(SCISSORS)) {
				output = SCISSORS;
				return output;
			}
		} else {
			return ("Enter a valid input");
		}
		return output;

	}

}
