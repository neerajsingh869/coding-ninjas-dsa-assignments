package recursion;

import java.util.Scanner;

public class ReturnPermutationsString {
	
	/*
	 * Given a string, find and return all the possible 
	 * permutations of the input string.
	 * 
		Note :
		The order of permutations are not important.
		
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
	
	public static String[] returnPermutationOfString(String input){
		// Write your code here
		if(input.length() == 0){
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        String[] smallOutput = returnPermutationOfString(input.substring(1));
        String[] output = new String[input.length()*smallOutput.length];
        int k = 0;
        for(int i = 0; i<input.length(); i++){
            for(String st : smallOutput){
                output[k++] = st.substring(0, i) + input.charAt(0) + st.substring(i);
            }
        }
        return output;
	}
	
	public static String[] permutationOfString(String input){
		int n = input.length();
		if (n == 0) {
			String[] ans = new String[1];
			ans[0] = "";
			return ans;
		}

		String[] tempAns = permutationOfString(input.substring(1));

		String[] ans = new String[tempAns.length * n];
		int k = 0;
		for (int i = 0; i < tempAns.length; i++) {
			String currStr = tempAns[i];
			for (int j = 0; j < n; j++) {
				ans[k++] = currStr.substring(0, j) + input.charAt(0) + currStr.substring(j);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String output[] = permutationOfString(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

}
