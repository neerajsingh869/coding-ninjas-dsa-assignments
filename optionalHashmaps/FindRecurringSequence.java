package optionalHashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class FindRecurringSequence {
	
	/*
	 * You are given the numerator and denominator of a fraction, you have to find the recurring sequence of digits if exists when this fraction is converted into decimal.
Note: If there is no recurring sequence of digits then return an empty string.
Input Format:
The only line of input line contains numerator and denominator(separated by space).
Output Format:
The only output line contains the recurring sequence of digits.
Sample Input:
1888 3
Sample Output:
3
Explanation:
1888/3 = 629.333333333......
Recurring sequence is 3.
	 */
	
	public static String recurr(int num, int den) {
		// TODO Auto-generated method stub
		return "";
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int den = scn.nextInt();

		System.out.println(recurr(num, den));
	}

}
