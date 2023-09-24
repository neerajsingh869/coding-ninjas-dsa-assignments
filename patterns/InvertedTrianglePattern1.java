package patterns;

import java.util.Scanner;

public class InvertedTrianglePattern1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		while(i<=n) {
			int stars = 1;
			while(stars<=n-i+1) {
				System.out.print("*");
				stars++;
			}
			System.out.println();
			i++;
		}
	}

}
