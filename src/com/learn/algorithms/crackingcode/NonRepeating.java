/**
 * 
 */
package com.learn.algorithms.crackingcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Soundharya
 *
 */
public class NonRepeating {
	    public static void main(String[] args) {
	        // NOTE: The following input values will be used for testing your solution.
	        System.out.println(nonRepeating("abcab")); // should return 'c'
	        System.out.println(nonRepeating("abab")); // should return null
	        System.out.println(nonRepeating("aabbbc")); // should return 'c'
	        System.out.println(nonRepeating("aabbdbc")); // should return 'd'
	    }

	    // Implement your solution below.
	    public static Character nonRepeating(String s) {
	       LinkedHashMap<Character,Integer> uniqueMap = new LinkedHashMap<>();
	    	for(int i=0;i<s.length();i++){
	    		char item= s.charAt(i);
	    		if(uniqueMap.containsKey(item)){
	    			int count= uniqueMap.get(item);
	    			uniqueMap.put(item, count+1);
	    		}
	    		else{
	    			uniqueMap.put(item, 1);
	    		}
	    	}
	    	
	    	Set<Entry<Character, Integer>> mapValues= uniqueMap.entrySet();
	    	
	    	for(char key: uniqueMap.keySet()){
	    		Integer value= uniqueMap.get(key);
	    		if(value==1){
	    			return key;
	    		}
	    	}
	    	
	    	
	    	
	    	Iterator iterator= mapValues.iterator();
	    	while(iterator.hasNext()){
	    		Map.Entry<Character, Integer> item = (Map.Entry) iterator.next();
	    		if(item.getValue()==1){
	    			return item.getKey();
	    		}
	    	}
	    	return null;
	    }
}
