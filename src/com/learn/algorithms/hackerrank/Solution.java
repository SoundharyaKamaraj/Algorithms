package com.learn.algorithms.hackerrank;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the findTheAbsentStudents function below.
    static int[] findTheAbsentStudents(int n, int[] a) {
        boolean[] presentArray = new boolean[n];
        int[] absentArray = new int[n];
        for(int i=0;i<a.length;i++){
            presentArray[a[i]-1] = true;
        }
        int counter=0;
        for(int i=0;i<n;i++){
            if(!presentArray[i]){
                absentArray[counter++] =i+1;
            }
        }
        return Arrays.copyOf(absentArray,counter);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = findTheAbsentStudents(n, a);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}