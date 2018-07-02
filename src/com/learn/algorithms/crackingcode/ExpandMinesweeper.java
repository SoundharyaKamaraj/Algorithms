/**
 * 
 */
package com.learn.algorithms.crackingcode;

import java.util.ArrayDeque;

/**
 * @author Soundharya
 *
 */
public class ExpandMinesweeper {

	    public static void main(String[] args) {
	        // NOTE: The following input values will be used for testing your solution.
	        int[][] field1 = {{0, 0, 0, 0, 0},
	                          {0, 1, 1, 1, 0},
	                          {0, 1, -1, 1, 0}};

	       //click(field1, 3, 5, 2, 2);
	       printFiled(click(field1, 3, 5, 2, 2));
	       //should return:
	        // [[0, 0, 0, 0, 0],
	        //  [0, 1, 1, 1, 0],
	        //  [0, 1, -1, 1, 0]]
          
	       printFiled(click(field1, 3, 5, 1, 4));
	        
	        //should return:
	        // [[-2, -2, -2, -2, -2],
	        //  [-2, 1, 1, 1, -2],
	        //  [-2, 1, -1, 1, -2]]


	        int[][] field2 = {{-1, 1, 0, 0},
	                          {1, 1, 0, 0},
	                          {0, 0, 1, 1},
	                          {0, 0, 1, -1}};

	        printFiled(click(field2, 4, 4, 0, 1));
	        //should return:
	        // [[-1, 1, 0, 0],
	        //  [1, 1, 0, 0],
	        //  [0, 0, 1, 1],
	        //  [0, 0, 1, -1]]

	        printFiled(click(field2, 4, 4, 1, 3));
	        //should return:
	        // [[-1, 1, -2, -2],
	        //  [1, 1, -2, -2],
	        //  [-2, -2, 1, 1],
	        //  [-2, -2, 1, -1]]
	    }

	    private static void printFiled(int[][] click) {
			for(int i=0;i<click.length;i++){
				for(int j=0;j<click[i].length;j++){
					System.out.print(click[i][j]+" ");
				}
				System.out.println();
			}
		}

		// Implement your solution below.
	    public static int[][] click(int[][] field, int numRows, int numCols, int givenI, int givenJ) {
	    ArrayDeque<int[]> checkElements = new ArrayDeque<>();
	    	if(field[givenI][givenJ]==-1 || field[givenI][givenJ]==1){
	    		return field;
	    	}
	    	else{
	    		int[] coordinates= {givenI,givenJ};
	    		checkElements.add(coordinates);
	    	}

		while (!checkElements.isEmpty()) {
			int[] currentCoordinates= checkElements.remove();
				int x = currentCoordinates[0];
				int y = currentCoordinates[1];
				for (int i = x-1; i <= x+1; i++) {
					for (int j = y-1; j <= y+1; j++) {
						if (i >=0 &&  i<numRows
								&& j>=0 && j<numCols
								&& field[i][j] == 0) {
							field[i][j] = -2;
							int[] addCoordinates={i,j};
							checkElements.add(addCoordinates);
						}

				}
			}
		}
    	return field;	
    	
	    }

}
