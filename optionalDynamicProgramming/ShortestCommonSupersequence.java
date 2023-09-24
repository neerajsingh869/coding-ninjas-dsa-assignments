package optionalDynamicProgramming;

import java.util.Scanner;

public class ShortestCommonSupersequence {
	
	/*
	 * You are given two strings string s1 and string s2, you have to find shortest common supersequence of both of the strings. That is, you have to find the smallest string which has both string s1 and string s2 as subsequences.
Input Format:
Line 1 : String S1
Line 2 : String s2
String s1 and String s2 can have both uppercase and lowercase letters and considered as different characters.
Output Format:
The only output line contains length of required string.
Constraints:
1<=Length of string s1, length of string s2<=100
Sample Input:
abcd 
wzcd
Sample Output:
6
	 */
	
	// Solved using Recursion (Time Complexity -> O(2^n), Space Complexity -> O(n*m))
	private static int sCS1(String s1, String s2){
		return sCS1(s1, 0, s2, 0);
	}

	private static int sCS1(String s1, int i1, String s2, int i2){
		int n1 = s1.length();
		int n2 = s2.length();
		if(i1 == n1){
			return n2 - i2;
		}
		if(i2 == n2){
			return n1 - i1;
		}
		if(s1.charAt(i1) == s2.charAt(i2)){
			return 1 + sCS1(s1, i1+1, s2, i2+1);
		}
		else{
			return 1 + Math.min(sCS1(s1, i1+1, s2, i2), sCS1(s1, i1, s2, i2+1));
		}
	}
	
	// Solved using Memoization (Time Complexity -> O(n*m), Space Complexity -> O(n*m))
	private static int sCS2(String s1, String s2){
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] dp = new int[n1][n2];
		for(int i = 0; i<n1; i++){
			for(int j = 0; j<n2; j++){
				dp[i][j] = -1;
			}
		}
		return sCS2(s1, 0, s2, 0, dp);
	}

	private static int sCS2(String s1, int i1, String s2, int i2, int[][] dp){
		int n1 = s1.length();
		int n2 = s2.length();
		if(i1 == n1){
			return n2 - i2;
		}
		if(i2 == n2){
			return n1 - i1;
		}
		if(dp[i1][i2] != -1){
			return dp[i1][i2];
		}
		if(s1.charAt(i1) == s2.charAt(i2)){
			return dp[i1][i2] = 1 + sCS2(s1, i1+1, s2, i2+1, dp);
		}
		else{
			return dp[i1][i2] = 1 + Math.min(sCS2(s1, i1+1, s2, i2, dp), sCS2(s1, i1, s2, i2+1, dp));
		}
	}
	
	// Solved using Tabulation (Time Complexity -> O(n*m), Space Complexity -> O(n*m))
	private static int sCS3(String s1, String s2){
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] dp = new int[n1+1][n2+1];
		for(int i = 0; i<=n1; i++){
			for(int j = 0; j<=n2; j++){
				if(i == 0){
					dp[i][j] = j;
				}
				else if(j == 0){
					dp[i][j] = i;
				}
				else{
					if(s1.charAt(i-1) == s2.charAt(j-1)){
						dp[i][j] = 1 + dp[i-1][j-1];
					}
					else{
						dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
		}
		return dp[n1][n2];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int ans = sCS3(s1, s2);
		System.out.println(ans);
	}

}
