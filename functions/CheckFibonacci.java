package functions;

import java.util.Scanner;

public class CheckFibonacci {
	
	// Function to check whether the number is
	// fibonacci or not
	public static boolean isFibonacci(int num) {
		int first = 0, second = 1;
		while(first<num) {
			int temp = first+second;
			first = second;
			second = temp;
		}
		return (first == num) ? true : false;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(isFibonacci(n));
	}

}
