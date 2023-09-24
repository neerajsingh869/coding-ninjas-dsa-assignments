package patterns;

import java.util.Scanner;

public class InvertedTrianglePattern2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		while(i<=n) {
			int stars = 1;
			while(stars<=n-i+1) {
				System.out.print(n-i+1);
				stars++;
			}
			System.out.println();
			i++;
		}
	}

}
