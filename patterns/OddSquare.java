package patterns;

import java.util.Scanner;

public class OddSquare {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		while(i<=n) {
			int j = 1, ele = 2*i-1;
			while(j<=n) {
				System.out.print(ele%(2*n));
				ele+=2;
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
