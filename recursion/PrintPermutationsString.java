package recursion;

import java.util.Scanner;

public class PrintPermutationsString {
	
	/*
	 * Given a string, find and print all the possible permutations of the input string.
	 * 
		Note :
		The order of permutations are not important. Just print them in different lines.
		Sample Input :
		abc
		Sample Output :
		abc
		acb
		bac
		bca
		cab
		cba
	 */
	
	public static void printPermutations1(String input){
		printPermutations1(input, "");
	}
	
	public static void printPermutations1(String input, String ansSoFar){
        if(input.length() == 0){
            System.out.println(ansSoFar);
            return;
        }
        for(int i = 0; i<input.length(); i++){
            String newInput = input.substring(0, i) + input.substring(i+1);
            printPermutations1(newInput, ansSoFar + input.charAt(i));
        }
    }
	
	public static void printPermutations2(String input){
		printPermutations2(input, "");
	}

	private static void printPermutations2(String input, String ansTillNow) {
		int n = input.length();
		if (n == 0) {
			System.out.println(ansTillNow);
			return;
		}

		for (int i = 0; i <= ansTillNow.length(); i++) {
			String newAnsTillNow = ansTillNow.substring(0, i) + input.charAt(0) + ansTillNow.substring(i);

			printPermutations2(input.substring(1), newAnsTillNow);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		printPermutations1(input);
	}
}
