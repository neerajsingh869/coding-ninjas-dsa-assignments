package recursion;

import java.util.Scanner;

public class ReturnKeypadCode {
	
	/*
	 * Given an integer n, using phone keypad find out all the possible 
	 * strings that can be made using digits of input n.
	 * 
		Return empty string for numbers 0 and 1.
		
		Note :
		1. The order of strings are not important.
		2. Input and output has already been managed for you. You just have to 
		populate the output array and return the count of elements populated in 
		the output array.
		
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
	
	public static String[] returnKeypad1(int n){
		// Write your code here
        if(n == 0 || n == 1){
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        String[] smallOutput = returnKeypad1(n/10);
        String key = getKey(n%10);
        
        int sizeSmall = smallOutput.length;
        int sizeKey = key.length();
        
		String[] output = new String[sizeKey*sizeSmall];
        
        int k = 0;
        for(int i = 0; i<sizeKey; i++){
            for(int j = 0; j<sizeSmall; j++){
				output[k++] = smallOutput[j] + key.charAt(i);
            }
        }
        return output;
	}
	
	private static String getKey(int n){
        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return str[n];
    }
	
	private static final String[] KEYPAD_CODE = {"", "", "abc", "def", "ghi", "jkl", 
													"mno", "pqrs", "tuv", "wxyz"};

	public static String[] returnKeypad2(int n){
		// base case
		if (n == 0 || n == 1) {
			String ans[] = new String[1];
			ans[0] = "";
			return ans;
		}

		 // induction hypothesis (larger part of calculation)
		 String[] tempAns = returnKeypad2(n / 10);
		 int tempN = tempAns.length;

		 // induction step (smaller part of calculation)
		String keyCode = KEYPAD_CODE[n % 10];
		String[] ans = new String[tempN * keyCode.length()];

		for (int i = 0; i < keyCode.length(); i++) {
			char c = keyCode.charAt(i);

			for (int j = 0; j < tempN; j++) {
				ans[i * tempN + j] = tempAns[j] + c;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		
		String output[] = returnKeypad2(input);
		
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
