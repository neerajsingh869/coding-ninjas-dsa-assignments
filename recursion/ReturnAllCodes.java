package recursion;

import java.util.Scanner;

public class ReturnAllCodes {
	
	/*
	 * Assume that the value of a = 1, b = 2, ... z = 26. You
	 * are given a numeric String S. Write a program to return the 
	 * list of all possible codes that can be generated from the
	 * given string.
	 */
	
	public static  String[] getCode(String input){
		int n = input.length();
		if (n == 0) {
			String[] ans = {""};
			return ans;
		}
		
		String[] tempAns1 = getCode(input.substring(1));
		String[] tempAns2 = new String[0];

		int firstTwoDigits = 0;
		if (n >= 2) {
			firstTwoDigits = (input.charAt(0) - '0') * 10 + (input.charAt(1) - '0');
			if (firstTwoDigits > 10 && firstTwoDigits <= 26) {
				tempAns2 = getCode(input.substring(2));
			}
		}

		String[] ans = new String[tempAns1.length + tempAns2.length];

		for (int i = 0; i < tempAns1.length; i++) {
			ans[i] = (char)((input.charAt(0) - '0') + 96) + tempAns1[i];
		}

		for (int i = 0; i < tempAns2.length; i++) {
			ans[tempAns1.length + i] = (char)(firstTwoDigits + 96) + tempAns2[i];
		}

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		String output[] = getCode(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
