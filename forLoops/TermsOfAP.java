package forLoops;

import java.util.Scanner;

public class TermsOfAP {
	/*
	 * Write a program to print first x terms of the 
	 * series 3N + 2 which are not multiples of 4
	 */

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int count = 1, i = 1;
		while(count<=x) {
			if((3*i+2)%4 != 0) {
				System.out.print(3*i+2+" ");
				count++;
			}
			i++;
		}
	}

}
