package test1;

import java.util.Scanner;

public class PalindromeNumber {
	/*
	 * Write a program to determine if given number 
	 * is palindrome or not. Print true if it is 
	 * palindrome, false otherwise.
	 */

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int temp = n, rev = 0;
		while(temp>0) {
			int rem = temp%10;
			rev = rev*10 + rem;
			temp = temp/10;
		}
		if(n == rev) {
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
	}

}
