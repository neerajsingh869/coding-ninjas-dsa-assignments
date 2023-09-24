package functions;

import java.util.Scanner;

public class AddTwoNumbers {
	
	// Function to add two numbers
	public static int sum(int a, int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int ans = sum(a, b);
		System.out.println(ans);
	}
}
