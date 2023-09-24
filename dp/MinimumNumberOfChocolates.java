package dp;

public class MinimumNumberOfChocolates {
	
	/*
	 * Miss. Noor Rashid is a teacher. She wants to give 
	 * some chocolates to the students in her class. 
	 * All the students sit in a line, and each of them 
	 * has a score according to performance. Noor wants 
	 * to give at least one chocolate to each student. 
	 * She distributes chocolates to them such that If 
	 * two students sit next to each other, then the one 
	 * with the higher score must get more chocolates. 
	 * Miss. Noor wants to save money, so she wants to 
	 * minimize the total number of chocolates.
	 */
	
	// Solving Using Tabulation
	public static int getMin(int arr[], int N){
		/*
		 * Here, the number of chocolates give to a particular
		 * Student is dependent on number of chocolates given to
		 * its neighbors. So, first we give chocolates from moving
		 * from left to right and then re-balance the chocolates from 
		 * moving right to left.
		 */
		if(N == 0) {
			return 0;
		}
        int[] dp = new int[N];
        dp[0] = 1;
        for(int i = 1; i<N; i++){
            if(arr[i] > arr[i-1]){
                dp[i] = 1 + dp[i-1];
            }
            else{
                dp[i] = 1;
            }
        }
        int ans = dp[N-1];
        for(int i = N-2; i>=0; i--){
            if(arr[i] > arr[i+1] && dp[i] <= dp[i+1]){
                dp[i] = 1 + dp[i+1];
            }
            ans += dp[i];
        }
        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
