package dp;

public class CoinTower {
	
	/*
	 * Whis and Beerus are playing a new game today. 
	 * They form a tower of N coins and make a move in 
	 * alternate turns. Beerus plays first. In one step, 
	 * the player can remove either 1, X, or Y coins from 
	 * the tower. The person to make the last move wins 
	 * the game. Can you find out who wins the game?
	 */
	 
	public static String findWinner(int n, int x, int y) {
        return findWinner_helper(n, x, y, "Beerus");
	}
    
    public static String findWinner_helper(int n, int x, int y, String firstPlayer){
        if(n <= 0){
            if(firstPlayer == "Beerus"){
                return "Whis";
            }
            else{
                return "Beerus";
            }
        }
        String winner1, winner2, winner3;
        String newFirstPlayer = "Whis";
        if(firstPlayer == "Whis"){
            newFirstPlayer = "Beerus";
        }
        winner1 = findWinner_helper(n-1, x, y, newFirstPlayer);
		winner2 = findWinner_helper(n-x, x, y, newFirstPlayer);
		winner3 = findWinner_helper(n-y, x, y, newFirstPlayer);
        if(winner1 == firstPlayer || winner2 == firstPlayer || winner3 == firstPlayer){
			return firstPlayer;
		}
        else{
            return newFirstPlayer;
        }  
    }
    
    public static String findWinnerTabu(int n, int x, int y) {
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
	
	public static void main(String[] args) {
		
	}

}
