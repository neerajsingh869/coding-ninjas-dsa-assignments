package forLoops;

import java.util.Scanner;

public class SumOrProduct {
	/*
	 * Write a program that asks the user for a number N 
	 * and a choice C. And then give them the possibility 
	 * to choose between computing the sum and computing 
	 * the product of all integers in the range 1 to N 
	 * (both inclusive).
	 */

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int c = s.nextInt();
		if(c == 1) {
			int sum = 0;
			for(int i = 1; i<=n; i++) {
				sum+=i;
			}
			System.out.println(sum);
		}
		else if(c == 2) {
			int prod = 1;
			for(int i = 1; i<=n; i++) {
				prod*=i;
			}
			System.out.println(prod);
		}
		else {
			System.out.println(-1);
		}
	}

}
