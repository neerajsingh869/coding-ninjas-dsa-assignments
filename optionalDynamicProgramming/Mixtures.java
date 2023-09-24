package optionalDynamicProgramming;

import java.util.Scanner;

class PairM {
    int minSmoke;
    int finalColor;
    PairM(int minSmoke, int finalColor){
        this.minSmoke = minSmoke;
        this.finalColor = finalColor;
    }
}

public class Mixtures {
	
	/*
	 * Hermione is attending the Magic Potion's Class in Hogwarts . She has N potions in front of her lying in a row . Her task is to combine these potions into 1 . In order to do so she can pick any two adjacent potions of color A,B and mix them to form another potion of color C=(A+B)%100 which will then replace A and B in the row (Two potions combine to form one potion) . But when a new potion is formed it produces smoke of value A*B . Hermione needs your help to minimise the smoke produced in the above task .
Input Format :
Line 1 : Integer N 
Line 2 : A list of N integers, representing colors of each potion
Output Format :
Minimum Smoke that can be produced
Constraints :
1<= N <=100
0 <= color of a potion <= 99
Sample Input :
3
1 2 4
Sample Output :
14
	 */
	// Recursive approach using Pair (Time complexity -> Exponential)
	public static int solve1(int n,int colors[]){
        return solve1(colors, 0, n-1).minSmoke;
    }

    private static PairM solve1(int[] colors, int i, int j){
        int n = colors.length;
        if(i == j){
            return new PairM(0, colors[i]);
        }
        int currMinSmoke = Integer.MAX_VALUE;
        int currFinalColor = 0;
        for(int k = i + 1; k<=j; k++){
            PairM ans1 = solve1(colors, k, j);
            PairM ans2 = solve1(colors, i, k-1);
            int tempFinalColor = (ans1.finalColor + ans2.finalColor)%100;
            int tempMinSmoke = ans1.minSmoke + ans2.minSmoke + (ans1.finalColor*ans2.finalColor);
            if(tempMinSmoke < currMinSmoke){
                currFinalColor = tempFinalColor;
                currMinSmoke = tempMinSmoke;
            }
        }
        return new PairM(currMinSmoke, currFinalColor);
    }
    
    // Simpler Recursive approach (Time complexity -> Exponential)
    public static int solve2(int n,int colors[]){
        return solve2(colors, 0, n-1);
    }

    private static int solve2(int[] colors, int i, int j){
        int n = colors.length;
        if(i == j){
            return 0;
        }
        int minSmoke = Integer.MAX_VALUE;
        for(int k = i + 1; k<=j; k++){
            minSmoke = Math.min(minSmoke, solve2(colors, i, k-1) + solve2(colors, k, j) + 
            		sum(colors, i, k-1)*sum(colors, k, j));
        }
        return minSmoke;
    }
    
    // Memorization approach (Time complexity -> O(n*n))
    public static int solve3(int n,int colors[]) {
    	PairM[][] dp = new PairM[n][n];
        return solve3(colors, 0, n-1, dp).minSmoke;
    }

    private static PairM solve3(int[] colors, int i, int j, PairM[][] dp){
        int n = colors.length;
        if(i == j){
            return new PairM(0, colors[i]);
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int currMinSmoke = Integer.MAX_VALUE;
        int currFinalColor = 0;
        for(int k = i + 1; k<=j; k++){
        	PairM ans1 = solve3(colors, k, j, dp);
        	PairM ans2 = solve3(colors, i, k-1, dp);
            int tempFinalColor = (ans1.finalColor + ans2.finalColor)%100;
            int tempMinSmoke = ans1.minSmoke + ans2.minSmoke + (ans1.finalColor*ans2.finalColor);
            if(tempMinSmoke < currMinSmoke){
                currFinalColor = tempFinalColor;
                currMinSmoke = tempMinSmoke;
            }
        }
        return dp[i][j] = new PairM(currMinSmoke, currFinalColor);
    }
    
    // Simpler Memorization approach (Time complexity -> O(n*n))
    public static int solve4(int n,int colors[]) {
    	int[][] dp = new int[n][n];
        return solve4(colors, 0, n-1, dp);
    }

    private static int solve4(int[] colors, int i, int j, int[][] dp){
        int n = colors.length;
        if(i == j){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int minSmoke = Integer.MAX_VALUE;
        for(int k = i + 1; k<=j; k++){
        	minSmoke = Math.min(minSmoke, solve4(colors, i, k-1, dp) + solve4(colors, k, j, dp) + 
            		sum(colors, i, k-1)*sum(colors, k, j));
        }
        return dp[i][j] = minSmoke;
    }
    
    // Calculating final portion color (Need not to use pair for that)
    private static int sum(int[] colors, int i, int j){
        int sum = 0;
        for(int k = i; k<=j; k++){
            sum += colors[k];
            sum %= 100;
        }
        return sum;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int[] color = new int[n];
		for(int i=0;i<n;i++)
		{
			color[i]=scan.nextInt();
		}
		System.out.println(solve4(n,color));
	}

}
