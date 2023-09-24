package test2;

import java.util.Scanner;

public class NumberStarPattern {
	
	/*
	 * Print the following pattern for given number of rows.
	 * 
	 * For n = 5,
	 * 			1234554321
	 * 			1234**4321
	 * 			123****321
	 * 			12******21
	 * 			1********1
	 */

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=n-i+1; j++){
                System.out.print(j);
            }
            for(int j = 1; j<=2*i-2; j++){
                System.out.print('*');
            }
            for(int j = n-i+1; j>=1; j--){
                System.out.print(j);
            }
			System.out.println();
		}
		
		// Another approach
//		for(int i = 1; i<=n; i++){
//            // First part
//            for(int j = 1; j<=n-i+1; j++){
//                System.out.print(j);
//            }
//            for(int j = 1; j<=i-1; j++){
//                System.out.print("*");
//            }
//            // Second part (Mirror of First part)
//            for(int j = i-1; j>=1; j--){
//                System.out.print("*");
//            }
//            for(int j = n-i+1; j>=1; j--){
//                System.out.print(j);
//            }
//            System.out.println();
//        }
	}

}
