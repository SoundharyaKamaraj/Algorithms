/**
 * 
 */
package com.learn.algorithms.crackingcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Soundharya
 *
 */
public class MostFrequest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 // NOTE: The following input values are used for testing your solution.

        // mostFrequent(array1) should return 1.
        int[] array1 = {1, 3, 1, 3, 2, 1};
        // mostFrequent(array2) should return 3.
        int[] array2 = {3, 3, 1, 3, 2, 1};
        // mostFrequent(array3) should return null.
        int[] array3 = {};
        // mostFrequent(array4) should return 0.
        int[] array4 = {0};
        // mostFrequent(array5) should return -1.
        int[] array5 = {0, -1, 10, 10, -1, 10, -1, -1, -1, 1};

        
        int[] array1A = {1, 3, 4, 6, 7, 9};
        int[] array2A = {1, 2, 4, 5, 9, 10};
        // commonElements(array1A, array2A) should return [1, 4, 9] (an array).

        int[] array1B = {1, 2, 9, 10, 11, 12};
        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
        // commonElements(array1B, array2B) should return [1, 2, 9, 10, 12] (an array).

        int[] array1C = {0, 1, 2, 3, 4, 5};
        int[] array2C = {6, 7, 8, 9, 10, 11};
      //  mostFrequent(array1C,array2C);
	}
	
	// Implement your solution below.
    public static Integer mostFreqent(int[] givenArray) {
        Integer maxItem = null;
        HashMap<Integer,Integer> mpfHashMap= new HashMap<>();
        int maxCount=-1;
        
        for(int i:givenArray){
        	if(mpfHashMap.containsKey(i)){
        		Integer newVal= mpfHashMap.get(i);
        		mpfHashMap.put(i, newVal);
        	}
        	else{
        		mpfHashMap.put(i, 1);
        	}
        	
        	if(mpfHashMap.get(i)>maxCount){
        		maxCount= mpfHashMap.get(i);
        		maxItem=i;
        	}
        }
        return maxItem;
    }
    
    
    


}
