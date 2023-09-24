package test1;

import java.util.Scanner;

public class ZerosAndStarsPattern {
	
	/*
	 * Print the following pattern
			Pattern for N = 4
	 			*000*000*
				0*00*00*0
				00*0*0*00
				000***000
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++){
            // Part1
            for(int j = 1; j<=n; j++){
                if(i == j){
                    System.out.print("*");
                }
                else{
                    System.out.print(0);
                }
            }
            // Part2
            System.out.print("*");
            // Part3 (Miror of Part1 pattern)
            for(int j = n; j>=1; j--){
                if(i == j){
                    System.out.print("*");
                }
                else{
                    System.out.print(0);
                }
            }
            System.out.println();
        }
	}
	
}
