package patterns;

import java.util.Scanner;

public class IsoscelesTrianglePattern {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		while(i<=n) {
			// For spaces
			int space = 1;
			while(space<=n-i) {
				System.out.print(" ");
				space++;
			}
			// For elements
			int j = 1;
			while(j<=i) {
				System.out.print(j);
				j++;
			}
			j = j-2;
			while(j>=1) {
				System.out.print(j);
				j--;
			}
			System.out.println();
			i++;
		}
	}

}
