package strings;

import java.util.Scanner;

public class CheckPalindrome {
	
	/*
	 * Given a string, determine if it is a palindrome, 
	 * considering only alphanumeric characters.
	 */
	
	public static void checkPalindrome(String str) {
		int i = 0, j = str.length() - 1;
		boolean flag = true;
		while(i<j) {
			if(str.charAt(i) != str.charAt(j)) {
				flag = false;
				break;
			}
			i++;
			j--;
		}
		if(flag == false) {
			System.out.println("The string is not Palindrome.");
		}
		else {
			System.out.println("The string is Palindrome.");
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String inp = s.next();
		checkPalindrome(inp);
	}

}
