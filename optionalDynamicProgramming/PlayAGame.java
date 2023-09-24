package optionalDynamicProgramming;

import java.util.Scanner;

public class PlayAGame {
	
	/*
	 * Anjali has N positive integers and she has to play a game using them. The rules of the games are as follows:
1. If all the numbers are equal, the game ends.
2. If not, then follow these steps:
(i) Select two unequal numbers.
(ii) Subtract the smaller one from the larger one.
(iii) Replace the larger one with the subtraction result obtained above.
She knows that game will always terminate on the same value, no matter how she plays the game. You have to tell if the game terminates on 1.
You have to tell Anjali the number of sub-sequences of the given number sequence, for which, playing the above game on the subsequence will terminate on 1. A sub-sequence can be obtained from the original sequence by deleting 0 or more integers from the original sequence.
Input Format:
The first line of input contains the value of N(the length of the given sequence).
The second line of input contains N positive integers separated by space.
Output Format:
The output contains a single integer denoting the total number of subsequences from the given sequence which results in ending the game with all 1.
Constraints:
1<=N<=60
1<= Value of an integer <=10 4
Sample Input:
4
3 4 8 16
Sample Output:
7
Explanation:
Subsequences are:
{ 3,  4 }
{ 3,  8 }
{ 3, 16 }
{ 3, 4, 8 }
{ 3, 4, 16 }
{ 3, 8, 16 }
{ 3, 4, 8, 16 }
	 */
	// Recursive approach (Time complexity -> exponential)
	public static long numSubSeq1(int n, int[] arr) {
      return numSubSeq1(arr, 0, 0);
    }

    private static long numSubSeq1(int[] arr, int i, int currGCD){
      int n = arr.length;
      if(i == n) return (currGCD == 1) ? 1 : 0;
      if(currGCD == 1) return (long)Math.pow(2, n-i);
      long ansNotPick = numSubSeq1(arr, i+1, currGCD);
      int newGCD = gcd1(arr[i], currGCD);
      long ansPick = numSubSeq1(arr, i+1, newGCD);
      return ansNotPick + ansPick;
    }

    private static int gcd1(int a, int b){
      if(b ==  0) return a;
      if(a == 0) return b;
      int gcd = 1;
      for(int i = Math.min(a, b); i>=1; i--){
        if(b%i == 0 && a%i == 0){
          gcd = i;
          break;
        }
      }
      return gcd;
    }
    
    // Best approach
    static long[][] dp = new long[2][10001];
    
    static int gcd2(int a, int b)
    {
      if (a == 0)
      return b;
      if (b == 0)
      return a;
      if (a == b)
      return a;
      if (a > b)
      return gcd2(a-b, b);
      return gcd2(a, b-a);
    }
    public static long numSubSeq2(int N, int[] arr) {
      int a=0, b=1;
      for(int i=0;i<=10000;i++)
      {
      dp[a][i] = 0;
      }
      dp[a][0] = 1;
      for(int i=0;i<N;i++) {
      for(int j=0;j<=10000;j++)
      {
      dp[b][j] = dp[a][j];
      }
      for(int j=0;j<=10000;j++)
      {
      if(dp[a][j] != 0)
      {
      dp[b][gcd2(arr[i],j)] += dp[a][j];
      }
      }
      int temp=a;
      a=b;
      b=temp;
      }
      return dp[a][1];
    }
    
    public static void main(String[] args) {
 	   Scanner s = new Scanner(System.in);
 	   int n = s.nextInt();
 	   int[] arr = new int[n];
 	   for(int i = 0; i < n; ++i) arr[i] = s.nextInt();
 	   System.out.print(numSubSeq2(n, arr));
 	   s.close();
    }

}
