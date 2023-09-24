package patterns;

import java.util.Scanner;

public class MirrorImagePattern2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		while(i<=n) {
			int j = 1;
			// For space
			while(j<=n-i) {
				System.out.print(" ");
				j++;
			}
			// For star
			int ele = 1;
			while(j<=n) {
				System.out.print(ele);
				ele++;
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
