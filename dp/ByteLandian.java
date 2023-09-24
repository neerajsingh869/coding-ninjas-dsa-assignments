package dp;

import java.util.HashMap;

public class ByteLandian {
	
	/*
	 * Byteland has a very strange monetary system.
	 * 
	 * Each Bytelandian gold coin has an integer number 
	 * written on it. A coin n can be exchanged in a bank into 
	 * three coins: n/2, n/3 and n/4. But these numbers are all 
	 * rounded down (the banks have to make a profit).
	 * 
	 * You can also sell Bytelandian coins for American dollars. 
	 * The exchange rate is 1:1. But you can not buy Bytelandian coins.
	 * 
	 * You have one gold coin. What is the maximum amount of American 
	 * dollars you can get for it?
	 */
	public static long bytelandian(long n, HashMap<Long, Long> memo) {
        if(n == 0){
            return 0;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        long ans = n;
        long divide2 = bytelandian(n/2, memo);
        long divide3 = bytelandian(n/3, memo);
        long divide4 = bytelandian(n/4, memo);
        ans = Math.max(ans, divide2 + divide3 + divide4);
        memo.put(n, ans);
        return memo.get(n);
	}

	public static void main(String[] args) {

	}

}
