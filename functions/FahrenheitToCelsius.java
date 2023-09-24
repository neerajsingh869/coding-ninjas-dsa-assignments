package functions;

import java.util.Scanner;

public class FahrenheitToCelsius {
	
	// Function to print fahrenheit to celsius table
	public static void fahrenheitToCelsiusTable(int s, int e, int w) {
		for(int i =s; i<=e; i+=w) {
			int celVal = (int)((i-32)*(5.0/9));
			System.out.println(i+"\t"+celVal);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int s = scan.nextInt();
		int e = scan.nextInt();
		int w = scan.nextInt();
		fahrenheitToCelsiusTable(s, e, w);
	}

}
