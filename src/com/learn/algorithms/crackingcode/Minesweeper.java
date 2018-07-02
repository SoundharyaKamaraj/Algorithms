/**
 * 
 */
package com.learn.algorithms.crackingcode;

/**
 * @author Soundharya
 *
 */
public class Minesweeper {

    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] bombs1 = {{0, 2}, {2, 0}};
        printField(mineSweeper2(bombs1, 3, 3));
        //should return:
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        printField(mineSweeper2(bombs2, 3, 4));
         //should return:
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]
        
        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        printField(mineSweeper2(bombs3, 5, 5));
         //should return:
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]
    }

    private static void printField(int[][] mineSweeper2) {
		
    	for(int[] item:mineSweeper2){
    		for(int item1:item){
    			System.out.print(item1+" ");
    		}
    		System.out.println();
    	}
		
	}

	// Implement your solution below.
    public static int[][] mineSweeper2(int[][] bombs, int numRows, int numCols) {
    	int[][] field = new int[numRows][numCols];
    	
    	for (int[] bomb : bombs) {
    		int x = bomb[0];
    		int y = bomb[1];
    		field[x][y] = -1;
    		for (int i=-1; i<=1; i++) {
    			int x1 = x+i;
    			for (int j=-1; j<=1; j++) {
    				// update the cell if within field
    				int y1 = y+j;
    				if (x1<0 || y1<0 || x1>=numRows || y1>=numCols || field[x1][y1] == -1) {
    					continue;
    				}
    				field[x1][y1] += 1;
    			}
    		}
    	}
    	
    	return field;
    }

    // Implement your solution below.
    public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];	
		for (int i = 0; i < bombs.length; i++) {
			int[] arrayElem = bombs[i];
			field[arrayElem[0]][arrayElem[1]] = -1;
		}
     for(int i=0;i<field.length;i++){/*
			for (int j = 0; j < field[i].length; j++) {
				System.out.print(field[i][j]);
				if (field[i][j] == -1) {
					field[i-1][j]+=1;
					field[i-1]

				} 
			}
        	//System.out.println("");
        	*/}
        
        return field;
    }
 }

