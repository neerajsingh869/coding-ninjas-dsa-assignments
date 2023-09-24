package functions;

import java.util.Scanner;
import java.lang.Math;

public class CheckPrime {
	
	// Function to check whether a number is 
	// prime or not
	public static void isPrime(int n) {
		for(int div = 2; div<=Math.sqrt(n); div++) {
			if(n%div == 0) {
				System.out.println("Not Prime.");
				return;
			}
		}
		System.out.println("Prime!");
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		isPrime(n);
	}
}
