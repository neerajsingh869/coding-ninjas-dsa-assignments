package optionalRecursionAndBacktracking;

import java.util.Scanner;

public class ReverseNumber {
	
	/*
	 * You are given an integer N, you have to find the reverse of this integer N.
		Input Format:
		The only input line contains the integer N
		Output Format:
		The only output line contains the reverse of this integer N.
		Constraints:
		Value of N should lie in the range [-100000000, 100000000]
		Sample Input:
		-4683
		Sample Output:
		-3864
	 */
	
	// Time Complexity -> O(no. of digits) = O(log(n))
	public static int reverseInteger1(int num) {
		int ans = 0;
		while(num != 0){
			ans = ans*10 + num%10;
			num /= 10;
		}
		return ans;
	}
	
	// Time Complexity -> O(no. of digits) = O(log(n))
	public static int reverseInteger2(int num) {
		int digits = countDigits(num);
		return reverseInteger2(num, digits);
	}

	private static int countDigits(int num){
		int count = 0;
		while(num != 0){
			count ++;
			num /= 10;
		}
		return count;
	}

	private static int reverseInteger2(int num, int digits){
		if(num == 0){
			return num;
		}
		return (num%10)* (int)Math.pow(10, digits-1) + reverseInteger2(num/10, digits-1);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int num = s.nextInt();

		System.out.println(reverseInteger2(num));
	}

}
