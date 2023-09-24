package patterns;

import java.util.Scanner;

public class NumberTriangle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		while(i<=n) {
			int space = 1;
			while(space<=n-i) {
				System.out.print(" ");
				space++;
			}
			int star = i;
			while(star<=2*i-1) {
				System.out.print(star);
				star++;
			}
			star = star-2;
			while(star>=i) {
				System.out.print(star);
				star--;
			}
			System.out.println();
			i++;
		}
	}

}
