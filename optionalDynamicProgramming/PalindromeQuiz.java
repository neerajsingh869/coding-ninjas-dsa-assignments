package optionalDynamicProgramming;

import java.util.Scanner;

public class PalindromeQuiz {
	
	/*
	 * A teacher is playing a Quiz with her students. The Quiz is based on palindrome numbers. In this quiz, the students are given a string S, and they are asked to insert the minimum number of characters in that string to make it a palindrome. You have to help them in finding the correct answer.
Note: Characters can be inserted anywhere in the string.
Input Format:
The only input line contains the string given to students in the Quiz.
Output Format:
The only output line contains an integer denoting the minimum number characters that needs to be inserted into the string to make it palindrome.
Constraints:
1<=Length of String<=60
Sample Input:
abedba
Sample Output:
1
Explanation:
Only one character needs to be inserted: abdedba
	 */
	// Recursive approach (Time complexity -> O(2^n), Space
	// complexity -> O(n))
	public static int minChar1(String str) {
		  int n = str.length();
		  return minChar1(str, 0, n-1);
	}

	private static int minChar1(String str, int i, int j){
		if(i > j){
			return 0;
		}
		if(str.charAt(i) == str.charAt(j)){
			return minChar1(str, i+1, j-1);
		}
		else{
			return 1 + Math.min(minChar1(str, i+1, j), minChar1(str, i, j-1));
		}
	}
	
	// Memorization approach (Time complexity -> O(n*n), 
	// Space complexity -> O(n*n))
	public static int minChar2(String str) {
		int n = str.length();
	    int[][] dp = new int[n][n];
	    for(int i = 0; i<n; i++){
	      for(int j = 0; j<n; j++){
	        dp[i][j] = -1;
	      }
	    }
	    return minChar2(str, 0, n-1, dp);
	}

	private static int minChar2(String str, int i, int j, int[][] dp){
	    if(i > j){
	      return 0;
	    }
	    if(dp[i][j] != -1){
	      return dp[i][j];
	    }
	    if(str.charAt(i) == str.charAt(j)){
	      return dp[i][j] = minChar2(str, i+1, j-1, dp);
	    }
	    else{
	      return dp[i][j] = 1 + Math.min(minChar2(str, i+1, j ,dp), minChar2(str, i, j-1, dp));
	    }
  	}
	
	// Tabulation approach (Time complexity -> O(n*n), 
	// Space complexity -> O(n*n))
  	public static int minChar3(String str) {
	  int n = str.length();
	  int[][] dp = new int[n][n];
	  for(int i = n-1; i>=0; i--){
	    for(int j = 0; j<n; j++){
	      if(i >= j){
	        dp[i][j] = 0;
	      }
	      else{
	        if(str.charAt(i) == str.charAt(j)){
	          dp[i][j] = dp[i+1][j-1];
	        }
	        else{
	          dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
	        }
	      }
	    }
	  }
	  return dp[0][n-1];
	}
  	
  	public static void main(String[] args) {
 	   Scanner s = new Scanner(System.in);
 	   String str = s.next();
 	   System.out.print(minChar3(str));
 	   s.close();
    }

}
