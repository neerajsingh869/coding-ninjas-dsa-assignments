package forLoops;

import java.util.Scanner;

public class FibonacciNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int first = 1, second = 1;
		for(int i = 3;i<=n; i++) {
			int sum = first+second;
			first = second;
			second = sum;
		}
		System.out.println(second);
	}

}
