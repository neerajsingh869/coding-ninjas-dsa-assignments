package fundamentals;

import java.util.Scanner;

public class EvenOdd {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a;
		a = s.nextInt();
		if(a%2 == 0) {
			System.out.println("Number is Even!");
		}
		else {
			System.out.println("Number is Odd!");
		}
	}
}
