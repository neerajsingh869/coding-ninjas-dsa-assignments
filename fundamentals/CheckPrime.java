package fundamentals;

import java.util.Scanner;
import java.lang.Math;

public class CheckPrime {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		// Edge cases
		if(n <= Math.sqrt(n)) {
			System.out.println("Not Prime");
		}
		// General cases
		int div = 2;
		boolean isPrime = true;
		while(div < n) {
			if(n%div == 0) {
				isPrime = false;
			}
			div++;
		}
		if(isPrime) {
			System.out.println("Prime");
		}
		else {
			System.out.println("Not Prime");
		}
	}
}
