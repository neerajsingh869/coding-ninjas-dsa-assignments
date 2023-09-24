package optionalStackNQueues;

import java.util.Scanner;

public class CountNumbers {
	
	/*
	 * You are given an integer n, you have to count all those natural numbers from 1 to n whose all permutations is greater than or equal to that number n.
Input Format:
The only input line contains the value of integer n.
Output Format:
The only output line contains the count of all those natural numbers from 1 to n whose all permutations is greater than or equal to that number n.
Constraints:
Value of n lies between [1,100000]
Sample Input:
17
Sample Output:
16
Explanation:
1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16 and 17 are the numbers whose all permutation is greater than the number itself. So, output 16.
	 */
	
	public static int permutations(int n) {
        //Write your code here
		return 0;
    }
	
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.print(permutations(n));
    }

}
