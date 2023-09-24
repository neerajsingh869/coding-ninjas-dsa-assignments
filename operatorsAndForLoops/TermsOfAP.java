package operatorsAndForLoops;

import java.util.Scanner;

public class TermsOfAP {
	
	/*
	 * Write a program to print first x terms of the 
	 * series 3N + 2 which are not multiples of 4.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = 1;
        while(x > 0){
            int term = 3*n + 2;
            n++;
            if(term%4 == 0){
                continue;
            }
            System.out.print(term + " ");
            x--;
        }
        sc.close();
	}

}
