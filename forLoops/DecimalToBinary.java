package forLoops;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long ans = 0, pow = 1;
		while(n>0) {
			int rem = n%2;
			ans+=rem*pow;
			pow*=10;
			n = n/2;
		}
		System.out.println(ans);
	}

}
