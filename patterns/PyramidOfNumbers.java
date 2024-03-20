package patterns;

import java.util.Scanner;

public class PyramidOfNumbers {
	
	/*
	 * Print the following pattern for the given N number of rows.

		Pattern for N = 4
		   1
		  2 2
		 3 3 3
		4 4 4 4
		Detailed explanation ( Input/output format, Notes, Images )
		Constraints
		0 <= N <= 50
		Sample Input 1:
		5
		Sample Output 1:
		    1
		   2 2
		  3 3 3
		 4 4 4 4
		5 5 5 5 5
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            // prefix spaces
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print(" ");
            }
            // numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
	}

}
