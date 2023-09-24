package test1;

import java.util.Scanner;

public class CheckAP {
	/*
	 * Given input consists of n numbers. Check 
	 * whether those n numbers form an arithmetic 
	 * progression or not. Print true or false.
	 */
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int prev = s.nextInt();
		int curr = s.nextInt();
		int diff = curr-prev;
		for(int i = 1; i<=n-2; i++) {
			prev = curr;
			curr = s.nextInt();
			if(curr-prev != diff) {
				System.out.println(false);
				return;
			}
		}
		System.out.println(true);
	}
}
