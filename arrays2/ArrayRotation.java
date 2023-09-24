package arrays2;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArrayRotation {
	
	/*
	 * There is an array ‘A’ of size ‘N’.
		You are also given an integer ‘X’ and direction ‘DIR’. You must rotate the array in the direction of ‘DIR’ by ‘X’ positions.
		You must return the rotated array.
		For example:
		Input :
		A = [6, 2, 6, 1], X = 1, DIR = ‘LEFT’
		
		Output :
		2 6 1 6
		
		Explanation: Rotate array ‘A’ to the left one time.
		[6, 2, 6, 1] => [2, 6, 1, 6]
		Input Format:
		First-line contains 'T,' denoting the number of Test cases.
		For each Test case:
		The first line contains two integers, ‘N', ‘X’, and the string ‘DIR’.
		The second line has ‘N’ integers denoting the array ‘A’.
		Output Format:-
		You must return the rotated array.
		Note:-
		You don’t need to print anything. Just implement the given function.
		Constraints :
		1 <= T <= 10
		1 <= N <= 10^5 
		1 <= X <= 10^9
		‘DIR’ is an element of {‘LEFT’, ‘RIGHT’}
		Time Limit: 1 sec
		Sample Input 1 :
		2
		4 1 LEFT
		1 2 3 4
		6 2 RIGHT
		1 2 4 3 5 6 
		Sample Output 1 :
		2 3 4 1
		5 6 1 2 4 3
		Explanation Of Sample Input 1 :
		For test case one:
		
		Input :
		A = [1, 2, 3, 4], X = 1, DIR = ‘LEFT’
		
		Output :
		2 3 4 1
		
		Explanation: Rotate array ‘A’ to the left one time.
		[1, 2, 3, 4] => [2, 3, 4, 1]
		
		For test case two:
		
		Input :
		A = [1, 2, 4, 3, 5, 6], X = 2, DIR = ‘RIGHT’
		
		Output :
		5 6 1 2 4 3
		
		Explanation: Rotate array ‘A’ to the right one time.
		[1, 2, 4, 3, 5, 6] => [6, 1, 2, 4, 3, 5]
		Sample Input 2 :
		2
		6 3 LEFT
		22 8 4 7 5 10
		6 2 RIGHT
		9 3 1 6 3 9
		Sample Output 2 :
		7 5 10 22 8 4 
		3 9 9 3 1 6 
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(x)
	public static int[] rotateArray1(int []a, int x, String dir) {
        int n = a.length;
        x = x%n;
        int[] rotatedPart = new int[x];
        if(dir.equals("LEFT")){
            for(int i = 0; i<x; i++){
                rotatedPart[i] = a[i];
            }
            for(int i = 0; i<n; i++){
                if(i < n-x){
                    a[i] = a[i+x];
                }
                else{
                    a[i] = rotatedPart[i-(n-x)];
                }
            }
        }
        else{
            for(int i = 0; i<x; i++){
                rotatedPart[i] = a[n-x+i];
            }
            for(int i = n-1; i>=0; i--){
                if(i >= x){
                    a[i] = a[i-x];
                }
                else{
                    a[i] = rotatedPart[i];
                }
            }
        }
        return a;
    }
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static int[] rotateArray2(int []a, int x, String dir) {
        int n = a.length;
        x = x%n;
        reverseArray(a, 0, n-1);
        if(dir.equals("LEFT")){
            reverseArray(a, 0, n-x-1);
            reverseArray(a, n-x, n-1);
        }
        else{
            reverseArray(a, 0, x-1);
            reverseArray(a, x, n-1);
        }
        return a;
    }

    private static void reverseArray(int[] a, int i, int j){
        while(i < j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
    
    public static class FastReader {

        BufferedReader br;
        StringTokenizer root;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (root == null || !root.hasMoreTokens()) {
                try {
                    root = new StringTokenizer(br.readLine());
                } catch (Exception r) {
                    r.printStackTrace();
                }
            }
            return root.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static FastReader sc = new FastReader();

    private static int t;
    private static int []n;
    private static int []x;
    private static String []dir;
    private static int [][]a;

    private static void takeInput() {
        t = sc.nextInt();
        n = new int[t];
        x = new int[t];
        dir = new String[t];
        a = new int[t][];
        for (int i = 0; i < t; ++i) {
            n[i] = sc.nextInt();
            x[i] = sc.nextInt();
            dir[i] = sc.next();
            a[i] = new int[n[i]];
            for(int j = 0; j < n[i]; j++) {
                a[i][j] = sc.nextInt();
            }
        }
    }

    private static void execute() {
        int [][]aCpy = a.clone();
        for (int i = 0; i < t; ++i) {
            int []ans = rotateArray2(aCpy[i], x[i], dir[i]);
        }
    }

    private static void executeAndPrintOutput() {
        for (int i = 0; i < t; ++i) {
            int []ans = rotateArray2(a[i], x[i], dir[i]);
            for(int j : ans)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        takeInput();
        executeAndPrintOutput();
        out.close();
    }

}
