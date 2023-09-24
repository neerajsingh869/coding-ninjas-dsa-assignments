package arrays2;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExtraCandies {
	
	/*
	 * There are ‘N’ houses. Two persons ‘P1’ and ‘P2’ distribute some candies to all these houses.
		You are given an integer, ‘X’. If the total number of candies received by any house is more than ‘X’, it will pass the rest of the candies to the next house to the right. The rightmost house will just throw the extra candies.
		You must return an array of ‘N’ integers denoting the final number of candies for all the houses.
		For example:
		Input :
		‘N’ = 3, ‘P1’ = [2, 6, 1], ‘P2’ = [1, 2, 1], ‘X’ = 6
		
		Output :
		3 6 4
		
		Explanation: Total candies at first house 2 + 1 = 3.
		Total candies at the second house 6 + 2 = 8, extra = 8 - 6 = 2.
		Total candies at the third house 1 + 1 + 2 ( extra from house 2) = 4.
		Input Format:
		First-line contains 'T', denoting the number of Test cases.
		For each Test case:
		The first line contains two integers, ‘N' and ‘X’.
		The second line contains ‘N’ integers denoting the array ‘P1’.
		The third line contains ‘N’ integers denoting the array ‘P2’.
		Output Format:-
		You must return the final number of candies for all the houses.
		Note:-
		You don’t need to print anything. Just implement the given function.
		Since the limit of the total of array will exceed the scope of the 'int'. Instead of taking 'int' , try to take the ''carry'' and ''total'' in 'long'.  
		Constraints :
		1<= T <=10
		1<= N <=10^5
		1<= P1[i], P2[i], X <=10^8
		The Sum of 'N' over all test cases doesn't exceed 10 ^ 5.
		Time Limit: 1 sec
		Sample Input 1 :
		2
		4 7
		2 3 4 7
		6 2 6 1
		2 4
		1 1
		1 1
		Sample Output 1 :
		7 6 7 7
		2 2
		Explanation Of Sample Input 1 :
		For test case one:
		
		Input :
		‘N’ = 4, ‘P1’ = [2, 3, 4, 7], ‘P2’ = [6, 2, 6, 1], ‘X’ = 7
		
		Output :
		7 6 7 7
		
		Explanation: Total candies at first house 2 + 6 = 8, extra = 8 - 7 =  1.
		Total candies at the second house 3 + 2 + 1 ( from the first house ) = 6.
		Total candies at the third house 4 + 6 = 10, extra = 10 - 7 = 3.
		Total candies at the fourth house 7 + 1 + 3 ( from the second house ) = 11, Extra = 11 - 7= 4.
		
		For test case two:
		
		Input :
		‘N’ = 2, ‘P1’ = [1, 1], ‘P2’ = [1, 1], ‘X’ = 4
		
		Output :
		2 2
		
		Explanation: Total candies at first house 1+1 =  2.
		Total candies at the second house 1+1 = 2.
		Sample Input 2 :
		2
		6 17
		22 8 4 7 5 10
		9 3 1 6 0 9
		1 1
		1
		1
		Sample Output 2 :
		17 17 13 13 5 17 
		1 
	 */
	
	// Time Complexity -> O(n), Auxiliary Space Complexity -> O(1)
	public static int[] extraCandies1(int n, int x, int []p1, int []p2) {
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            ans[i] = p1[i] + p2[i];
        }
        for(int i = 0; i<n; i++){
            if(i != n-1){
                if(ans[i] > x){
                    int extraCandies = ans[i] - x;
                    ans[i] = x;
                    ans[i+1] += extraCandies;
                }
            }
            else{
                ans[i] = (ans[i] > x) ? x : ans[i];
            }
        }
        return ans;
    }
	
	// Time Complexity -> O(n), Auxiliary Space Complexity -> O(1)
	public static int[] extraCandies2(int n, int x, int []p1, int []p2) {
		int[] ans = new int[n];
        int extra = 0;
        for(int i = 0; i<n; i++){
            int totalCandiesForHome = p1[i] + p2[i] + extra;
            extra = 0;
            if(totalCandiesForHome > x){
                if(i != n-1){
                    extra = totalCandiesForHome - x;
                }
                totalCandiesForHome = x;
            }
            ans[i] = totalCandiesForHome;
        }
        return ans;
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
    private static int [][]p1;
    private static int [][]p2;

    private static void takeInput() {
        t = sc.nextInt();
        n = new int[t];
        x = new int[t];
        p1 = new int[t][];
        p2 = new int[t][];
        for (int i = 0; i < t; ++i) {
            n[i] = sc.nextInt();
            x[i] = sc.nextInt();
            p1[i] = new int[n[i]];
            p2[i] = new int[n[i]];
            for(int j = 0; j < n[i]; j++) {
                p1[i][j] = sc.nextInt();
            }
            for(int j = 0; j < n[i]; j++) {
                p2[i][j] = sc.nextInt();
            }
        }
    }

    private static void execute() {
        int [][]p1Cpy = p1.clone();
        int [][]p2Cpy = p2.clone();
        for (int i = 0; i < t; ++i) {
            int []ans = extraCandies2(n[i], x[i], p1Cpy[i], p2Cpy[i]);
        }
    }

    private static void executeAndPrintOutput() {
        for (int i = 0; i < t; ++i) {
            int []ans = extraCandies2(n[i], x[i], p1[i], p2[i]);
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
