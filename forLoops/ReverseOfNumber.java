package forLoops;

import java.util.Scanner;

public class ReverseOfNumber {
	/*
	 * Write a program to generate the reverse of a given 
	 * number N. Print the corresponding reverse number
	 */

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int ans = 0;
		while(n>0) {
			int rem = n%10;
			ans = ans*10 + rem;
			n = n/10;
		}
		System.out.println(ans);
	}

}
