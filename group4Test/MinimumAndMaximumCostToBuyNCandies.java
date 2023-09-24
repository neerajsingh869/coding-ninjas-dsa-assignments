package group4Test;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumAndMaximumCostToBuyNCandies {
	
	/*
	 * Ram went to a specialty candy store in Ninjaland which has 'N' candies with different costs.
The Candy shop gives a special offer to its customers. A customer can buy a single candy from the store and get at most 'K' different candies for free. Now, Ram is interested in knowing the maximum and the minimum amount he needs to spend for buying all the candies available in the store.
Note: In both cases, Ram must utilize the offer i.e. if 'K' or more candies are available, he must take 'K' candies for every candy purchase. If less than K candies are available, he must take all candies for a candy purchase.
For Example :
For 'N' =  5 and 'K' = 2

Let the cost of different candies in the store be: [9 8 2 6 4]

For the minimum amount: 
Ram can buy a candy with cost 2 and take candies with costs 9 and 8 for free. 
Then, he can buy a candy with cost 4 and take candy with cost 7 for free. 
Thus, the minimum cost will be 6 i.e. 2 + 4. 

For the maximum amount: 
Ram can buy a candy with cost 9 and take candies with costs 2 and 6 for free. 
Then, he can buy candy at cost 8 and take candy at cost 4 for free. 
Thus, the minimum cost will be 17 i.e. 9 + 8.

Thus, Minimum = 6 and Maximum = 17.
Input format :
The first line contains an integer 'T' which denotes the number of test cases or queries to be run. Then, the 'T' test cases follow.

The first line of each test case or query contains two space-separated integers 'N' and ‘K’ representing the number of candies available and the number of candies you get free for a single purchase respectively.

The second line of each test case contains 'N' single space-separated integers, representing the costs of the candies.
Output format:
For each test case, print two space-separated integers 'A' and 'B' where 'A' is the minimum amount and 'B' is the maximum amount in which Ram can buy all the candies.
Note:
You do not need to print anything, it has already been taken care of. Just implement the given function.
Constraints:
1 <= 'T' <= 5
1 <= 'N' <= 10^5
0 <= 'K' < N
1 <= 'COST' <= (10^9) 

Where 'T' is the number of test cases, 'N' is the number of candies, 'K' is a type of candies and 'COST' is the cost of candies.

Time limit: 1 sec
Sample Input 1:
1
4 2
3 2 1 4
Sample Output 1 :
3 7
Explanation :
For the minimum amount: 
Ram can buy candy with cost 1 and take candies with costs 3 and 4 for free. 
Then, he can buy candy with cost 2.
Thus, the minimum cost will be 3 i.e. 1 + 2. 

For the maximum amount: 
Ram can buy candy with cost 4 and take candies with costs 1 and 2 for free. 
Then, he can buy candy with cost 3. 
Thus, the minimum cost will be 7 i.e. 4 + 3.
Sample Input 2:
2
5 2
9 8 2 6 4
3 0
1 5 4
Sample Output 2 :
6 17
10 10
	 */
	
	public static long minimumCost(int[] cost, int n, int k) 
	{
        Arrays.sort(cost);
    
        long minCost = 0;

    	for(int i = 0; i < n; i++)
        {
        	minCost += cost[i];

        	// Dropping the right k elements as we get them for free.
        	n = n - k;
    	}
    	return minCost;
    }
    
    public static long maximumCost(int[] cost, int n, int k) 
	{
        Arrays.sort(cost);
    
        long maxCost = 0;
        int total = 0;
        
        // Iterating cost array from last index.
        int i = n-1;
        
        while(total < n)
        {
            maxCost += cost[i];
            i--;
            
            // Taking the left k elements for free.
            total += (k + 1);
        }
    	return maxCost;
    }
	
	public static void main(String[] args) {
    	
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        StringBuffer sb = new StringBuffer();
        
        while(t-- > 0) {
        
            int n = s.nextInt();
            int k = s.nextInt();
            
            int cost[] = new int[n];

            for(int i = 0; i < n; i++) {
                cost[i] = s.nextInt();
            }

            long a = minimumCost(cost, n, k);
            long b = maximumCost(cost, n, k);

            System.out.print(a + " " + b + "\n");

        }
    }

}
