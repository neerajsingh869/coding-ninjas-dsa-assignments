package optionalRecursionAndBacktracking;

import java.util.Scanner;

public class FindBinaryNumber {
	
	/*
	 * You are given an integral value n, you have to find all n-digit binary numbers such that the binary number must have more 1's than 0's for any prefix of the number.
		Input Format:
		The only input line contains the value of n.
		Output Format:
		The output contains binary numbers in different lines.
		Constraints:
		Value of n lies between [1,15]
		Sample Input:
		5
		Sample Output:
		11111
		11110
		11101
		11100
		11011
		11010
		11001
		10111
		10110
		10101
	 */

	// Time Complexity -> O(2^n)
	public static void printBinary(int n) {
		printBinary(n, "", 0, 0);
	}

	private static void printBinary(int n, String ansTillNow, int count1, int count0){
		if(count1 < count0){
			return;
		}
		if(n == 0){
			if(ansTillNow.charAt(0) == '1'){
				System.out.println(ansTillNow);
			}
			return;
		}
		printBinary(n-1, ansTillNow + "1", count1+1, count0);
		printBinary(n-1, ansTillNow + "0" , count1, count0+1);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		printBinary(s.nextInt());
	}
}
