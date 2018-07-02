/**
 * 
 */
package com.learn.algorithms.anagram;

import java.util.Arrays;

/**
 * @author Soundharya
 *
 */
public class AnagramExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isAnagramWord("army","mary"));
		System.out.println(checkAnagram("stop","tops"));
		//System.out.println(checkAnagram("stoep","tops"));

	}

	public static boolean checkAnagram(String first, String second){
        char[] characters = first.toCharArray();
        StringBuilder sbSecond = new StringBuilder(second);
       System.out.println(characters);
        for(char ch : characters){
        	System.out.println(ch);
            int index = sbSecond.indexOf(""+ch);
            System.out.println(index);
            if(index != -1){
                sbSecond.deleteCharAt(index);
            }else{
                return false;
            }
        }
       
        return sbSecond.length()==0 ? true : false;
    }

	private static boolean isAnagramWord(String word, String anagramWord) {
		char[] word1 = word.replaceAll("[\\s]", "").toCharArray();
		char[] word2 = anagramWord.replaceAll("[\\s]", "").toCharArray();
		Arrays.sort(word1);
		Arrays.sort(word2);
		System.out.println(word1);
		System.out.println(word2);
		return Arrays.equals(word1, word2);
	}

}
