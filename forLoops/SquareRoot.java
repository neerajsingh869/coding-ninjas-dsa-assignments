package forLoops;

import java.util.Scanner;

public class SquareRoot {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int ans = 0;
		while(ans*ans<=n) {
			ans++;
		}
		System.out.println(ans-1);
	}
}
