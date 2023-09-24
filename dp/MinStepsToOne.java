package dp;

public class MinStepsToOne {
	
	/*
	 * Given a positive integer 'n', find and return the 
	 * minimum number of steps that 'n' has to take to get 
	 * reduced to 1. You can perform any one of the following 3 steps:
			1.) Subtract 1 from it. (n = n - ­1) ,
			2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
			3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
	 */
	// Solving Using Recursion
	public static int countMinStepsToOne(int n) {
        if(n == 1){
            return 0;
        }
        int subtract1 = countMinStepsToOne(n-1);
        int divide2 = Integer.MAX_VALUE;
        if(n%2 == 0){
            divide2 = countMinStepsToOne(n/2);
        }
        int divide3 = Integer.MAX_VALUE;
        if(n%3 == 0){
            divide3 = countMinStepsToOne(n/3);
        }
        return 1 + Math.min(subtract1, Math.min(divide2, divide3));
	}
	
	// Solving Using Memoization
	public static int countMinStepsToOneMemoi(int n) {
        int dp[] = new int[n+1];
        for(int i = 0; i<n+1; i++){
            dp[i] = -1;
        }
        return countMinStepsToOneMemoi_helper(n, dp);
	}
    
    public static int countMinStepsToOneMemoi_helper(int n, int dp[]){
        if(n == 1){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int subtract1 = countMinStepsToOneMemoi_helper(n-1, dp);
        int divide2 = Integer.MAX_VALUE;
        if(n%2 == 0){
            divide2 = countMinStepsToOneMemoi_helper(n/2, dp);
        }
        int divide3 = Integer.MAX_VALUE;
        if(n%3 == 0){
            divide3 = countMinStepsToOneMemoi_helper(n/3, dp);
        }
        return dp[n] = 1 + Math.min(subtract1, Math.min(divide2, divide3));
    }
	
	// Solving Using Tabulation
    public static int countMinStepsToOneTabu(int n) {
        if(n == 0){
            return Integer.MAX_VALUE;
        }
        int dp[] = new int[n+1];
        dp[0] = Integer.MAX_VALUE;
        dp[1] = 0;
        for(int i = 2; i<n+1; i++){
            int subtract1 = dp[i-1];
            int divide2 = Integer.MAX_VALUE;
        	int divide3 = Integer.MAX_VALUE;
            if(i%2 == 0){
                divide2 = dp[i/2];
            }
            if(i%3 == 0){
            	divide3 = dp[i/3];
        	}
            dp[i] = 1 + Math.min(subtract1, Math.min(divide2, divide3));
        }
        return dp[n];
	}

	public static void main(String[] args) {
		
	}

}
