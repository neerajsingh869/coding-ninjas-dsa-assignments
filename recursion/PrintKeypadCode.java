package recursion;

import java.util.Scanner;

public class PrintKeypadCode {
	
	/*
	 * Given an integer n, using phone keypad find out and print all 
	 * the possible strings that can be made using digits of input n.
	 * 
		Note :
		The order of strings are not important. Just print different strings 
		in new lines.
		
		Input Format :
		Integer n
		
		Output Format :
		All possible strings in different lines
		
		Constraints :
		1 <= n <= 10^6
		
		Sample Input:
		23
		Sample Output:
		ad
		ae
		af
		bd
		be
		bf
		cd
		ce
		cf
	 */
	
	public static void printKeypad(int n) {
		printKeypad(n, "");
	}
	
	public static void printKeypad(int n, String ansSoFar){
        if(n == 0){
            System.out.println(ansSoFar);
            return;
        }
        String key = getKey(n%10);
        for(int i = 0; i<key.length(); i++){
        	printKeypad(n/10, key.charAt(i) + ansSoFar);
        }
    }
	
	private static String getKey(int n){
        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return str[n];
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		printKeypad(input);
	}

}
