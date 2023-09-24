package group1Test;

import java.util.Scanner;

public class NumberStarPattern {
	
	/*
	 * Print the following pattern for given number of rows.
Input format :

Line 1 : N (Total number of rows)

Sample Input :
   5
Sample Output :
1234554321
1234**4321
123****321
12******21
1********1
	 */
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i<=n; i++) {
            // increasing order
            for (int j = 1; j<=n-i+1; j++) {
                System.out.print(j);
            }
            // stars
            for(int j = 1; j<=(i-1)*2; j++){
                System.out.print("*");
            }
            // decreasing order
            for(int j = n-i+1; j>=1; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
