package forLoops;

import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int ans = 0, pow = 1;
		while(n>0) {
			int rem = n%10;
            ans+=rem*pow;
            pow*=2;
			n = n/10;
		}
		System.out.println(ans);
	}

}
