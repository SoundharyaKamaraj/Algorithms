package com.learn.algorithms.rockpaperscissor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HardMode {
	
	private static enum Option {
		ROCK,
		SPOCK,
		SCISSORS,
		PAPER,
		LIZARD;
	}
	
	public static void main(String[] args) {
		
		
		Map<Option, Option[]> graph = new HashMap<>();
		graph.put(Option.ROCK, new Option[] {Option.SCISSORS, Option.LIZARD});
		graph.put(Option.SPOCK, new Option[] {Option.SCISSORS, Option.ROCK});
		graph.put(Option.SCISSORS, new Option[] {Option.PAPER, Option.LIZARD});
		graph.put(Option.PAPER, new Option[] {Option.SPOCK,Option.ROCK});
		graph.put(Option.LIZARD, new Option[] {Option.PAPER, Option.SPOCK});
		String userOne="";
		while (!userOne.equalsIgnoreCase("Exit")) {
			Scanner input = new Scanner(System.in);
			System.out.println("Please Enter the value");
			userOne = input.nextLine();
			System.out.println(printTheWinner(userOne,graph));
		}
	}

	private static Option printTheWinner(String inputString, Map<Option, Option[]> graph) {
		Option userOne;
		Option userTwo;
		if (null != inputString && inputString.contains(" ")) {
			String[] input = inputString.split(" ");
			userOne = Option.valueOf(input[0]);
			userTwo = Option.valueOf(input[1]);
			if (userOne == userTwo) {
				return userOne;
			}
			
			// trying to fetch possible vertices for userone and 
			//trying to compare if the user two is any one of the value
			//If so return the winner else fetch the possible outcomes for usertwo and check  if user one is of
			//any value.If so return that value as winner.
			else {
				Option[] possibleOutcomeone= graph.get(userOne) ;
				for (Option outcome : possibleOutcomeone) {
					if(outcome == userTwo) {
						return userOne;
					}
				}
				return userTwo;
			}
		}
		return null;
	}
	

	

}
