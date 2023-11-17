package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinTower {
	
	/*
	 * Whis and Beerus are playing a new game today. 
	 * They form a tower of N coins and make a move in 
	 * alternate turns. Beerus plays first. In one step, 
	 * the player can remove either 1, X, or Y coins from 
	 * the tower. The person to make the last move wins 
	 * the game. Can you find out who wins the game?
	 */
	 // Time complexity -> O(3 ^ n)
	public static String findWinner(int n, int x, int y) {
		return findWinner(n, x, y, "Beerus");
	}

	private static String findWinner(int n, int x, int y, String playerName) {
		if (n <= 0) {
			if (playerName == "Beerus") {
				return "Whis";
			} else {
				return "Beerus";
			}
		}

		String nextPlayerName = "Whis";
		if (playerName == "Whis") {
			nextPlayerName = "Beerus";
		}
		
		String winner1 = findWinner(n - 1, x, y, nextPlayerName);
		String winner2 = findWinner(n - x, x, y, nextPlayerName);
		String winner3 = findWinner(n - y, x, y, nextPlayerName);

		if (winner1 == playerName || winner2 == playerName || winner3 == playerName) {
			return playerName;
		} else {
			return nextPlayerName;
		}

	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String findWinnerMemoi(int n, int x, int y) {
		String[][] dp = new String[n + 1][2];
		return findWinnerMemoi(n, x, y, "Beerus", dp);
	}

	private static String findWinnerMemoi(int n, int x, int y, String playerName, String dp[][]) {
		if (n <= 0) {
			if (playerName == "Beerus") {
				return "Whis";
			} else {
				return "Beerus";
			}
		}

		String nextPlayerName = "Whis";
		int currPlayerIdx = 0;
		if (playerName == "Whis") {
			nextPlayerName = "Beerus";
			currPlayerIdx = 1;
		}

		if (dp[n][currPlayerIdx] != null) {
			return dp[n][currPlayerIdx];
		}
		
		String winner1 = findWinnerMemoi(n - 1, x, y, nextPlayerName, dp);
		String winner2 = findWinnerMemoi(n - x, x, y, nextPlayerName, dp);
		String winner3 = findWinnerMemoi(n - y, x, y, nextPlayerName, dp);

		if (winner1 == playerName || winner2 == playerName || winner3 == playerName) {
			return dp[n][currPlayerIdx] = playerName;
		} else {
			return dp[n][currPlayerIdx] = nextPlayerName;
		}

	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String findWinnerTabu1(int n, int x, int y) {
		int[][] dp = new int[n + 1][2];
		dp[0][0] = 1;
		dp[0][1] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= 1; j++) {
				int winner1 = dp[i - 1][(j == 0) ? 1 : 0];
				int winner2 = (i - x >= 0) ? dp[i - x][(j == 0) ? 1 : 0] : (j == 0) ? 1 : 0;
				int winner3 = (i - y >= 0) ? dp[i - y][(j == 0) ? 1 : 0] : (j == 0) ? 1 : 0;

				if (winner1 == j || winner2 == j || winner3 == j) {
					dp[i][j] = j;
				} else {
					dp[i][j] = (j == 1) ? 0 : 1;
				}
			}
		}

		return (dp[n][0] == 0) ? "Beerus" : "Whis";
	}
    
	// Time complexity -> O(n), Space complexity -> O(n)
    public static String findWinnerTabu2(int n, int x, int y) {
		if(x > y){
			int temp = x;
			x = y;
			y = temp;
		}
		
		boolean dp[] = new boolean[n + 1];
		
		for (int i = 1; i <= n; i++) {
			if(i == 1 || i == x || i == y){
				dp[i] = true;
			}
			else if(i < x){
				dp[i] = !dp[i-1];
			}
			else if(i < y){
				dp[i] = !(dp[i-1] && dp[i-x]);
			}
			else{
				dp[i] = !(dp[i-1] && dp[i-x] && dp[i-y]);
			}
		}
		
		boolean result = dp[n];
		if(result){
			return "Beerus";
		}
		else{
			return "Whis";
		}
	}
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            String[] strNums = br.readLine().trim().split("\\s");
            int n = Integer.parseInt(strNums[0]);
            int x = Integer.parseInt(strNums[1]);
            int y = Integer.parseInt(strNums[2]);

            System.out.println(findWinner(n, x, y));
    }

}
