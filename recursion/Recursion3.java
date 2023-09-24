package recursion;

public class Recursion3 {
	
	// Print and Return factorial solutions
	public static void printFactorial_helper(int n, int ansSoFar) {
		if(n == 0) {
			System.out.println(ansSoFar);
			return;
		}
		printFactorial_helper(n-1, n*ansSoFar);
	}
	
	public static void printFactorial(int n) {
		printFactorial_helper(n, 1);
	}
	
	public static int returnFactorial(int n) {
		if(n == 0) {
			return 1;
		}
		return returnFactorial(n-1)*n;
	}
	
	// Print and Return Minimum element in Array
	public static void printMinimumInArray_helper(int[] arr, int idx, int minSoFar) {
		if(idx == arr.length) {
			System.out.println(minSoFar);
			return;
		}
		printMinimumInArray_helper(arr, idx+1, Math.min(arr[idx], minSoFar));
	}
	
	public static void printMinimumInArray(int[] arr) {
		printMinimumInArray_helper(arr, 0, Integer.MAX_VALUE);
	}
	
	public static int returnMinimumInArray(int[] arr, int stIdx) {
		if(stIdx == arr.length) {
			return Integer.MAX_VALUE;
		}
		int tempAns = returnMinimumInArray(arr, stIdx+1);
		return Math.min(arr[stIdx], tempAns);
	}
	
	// Print and return all combinations that can be formed from keypads
	public static void printKeypad(int n) {
		printKeypad_helper(n, "");
	}
	
	public static void printKeypad_helper(int n, String ansSoFar){
        if(n == 0){
            System.out.println(ansSoFar);
            return;
        }
        String key = getKey(n%10);
        for(int i = 0; i<key.length(); i++){
            printKeypad_helper(n/10, key.charAt(i) + ansSoFar);
        }
    }
	
	public static String[] returnKeypad(int n){
		// Write your code here
        if(n == 0 || n == 1){
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        String[] smallOutput = returnKeypad(n/10);
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
	
	public static String getKey(int n){
        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return str[n];
    }
	
	// Print and return subsequences
	public static void printSubsequences(String str, String ansSoFar) {
		if(str == "") {
			System.out.println(ansSoFar);
			return;
		}
		printSubsequences(str.substring(1), ansSoFar);
		printSubsequences(str.substring(1), ansSoFar+str.charAt(0));
	}
	
	public static String[] returnSubsequences(String str) {
		if(str == "") {
			String[] output = new String[1];
			output[0] = "";
			return output;
		}
		String[] smallOutput = returnSubsequences(str.substring(1));
		int nSmall = smallOutput.length;
		String[] output = new String[2*nSmall];
		for(int i = 0; i<2*nSmall; i++) {
			if(i<nSmall) {
				output[i] = smallOutput[i];
			}
			else {
				output[i] = str.charAt(0) + smallOutput[i-nSmall];
			}
		}
		return output;
	}
	
	// Print and return all the subsets whose sum is equal to K
	public static int[][] returnSubsetsSumK_helper(int input[], int stIdx, int k){
        if(stIdx == input.length){
            if(k == 0){
                return new int[1][0];
            }
            return new int[0][0];
        }
        int[][] smallOutput1 = returnSubsetsSumK_helper(input, stIdx+1, k-input[stIdx]);
        int[][] smallOutput2 = returnSubsetsSumK_helper(input, stIdx+1, k);
        int row1 = smallOutput1.length;
        int row2 = smallOutput2.length;
        int[][] output = new int[row1 + row2][];
        int idx = 0;
        for(int i = 0; i<row1; i++){
            output[idx] = new int[smallOutput1[i].length + 1];
            output[idx][0] = input[stIdx];
            for(int j = 1; j<output[idx].length; j++){
                output[idx][j] = smallOutput1[i][j-1];
            }
           	idx++;
        }
        for(int i = 0; i<row2; i++){
            output[idx++] = smallOutput2[i];
        }
        return output;
    }

	public static int[][] returnSubsetsSumK(int input[], int k) {
		return returnSubsetsSumK_helper(input, 0, k);
	}
	
	public static void printSubsetsSumTok_helper(int input[], int stIdx, int k, int ansSoFar[]){
        if(stIdx == input.length && k != 0){
            return;
        }
        if(k == 0){
            for(int i : ansSoFar){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        printSubsetsSumTok_helper(input, stIdx+1, k, ansSoFar);
        int[] newAns = new int[ansSoFar.length + 1];
        int i = 0;
        while(i<ansSoFar.length){
            newAns[i] = ansSoFar[i];
            i++;
        }
        newAns[i] = input[stIdx];
        printSubsetsSumTok_helper(input, stIdx+1, k-input[stIdx], newAns);
    }
    
	public static void printSubsetsSumTok(int input[], int k) {
        int[] initialAns = new int[0];
		printSubsetsSumTok_helper(input, 0, k, initialAns);
	}
	
	/*
	 * Return and Print all the subsets of given array
	 */
	public static int[][] returnSubsets_helper(int input[], int stIdx){
        if(stIdx == input.length){
            return new int[1][0];
        }
        int[][] smallOutput = returnSubsets_helper(input, stIdx+1);
        int[][] output = new int[2*smallOutput.length][];
        int k = 0;
        for(; k<smallOutput.length; k++){
            output[k] = smallOutput[k];
        }
        for(; k<2*smallOutput.length; k++){
            output[k] = new int[smallOutput[k-smallOutput.length].length + 1];
            output[k][0] = input[stIdx];
            for(int j = 0; j<smallOutput[k-smallOutput.length].length; j++){
                output[k][j+1] = smallOutput[k-smallOutput.length][j];
            }
        }
        return output;
    } 

	public static int[][] returnSubsets(int input[]) {
		return returnSubsets_helper(input, 0);
	}
	
	public static void printSubsets_helper(int input[], int stIdx, int ansSoFar[]){
        if(stIdx == input.length){
            for(int i : ansSoFar){
             	System.out.print(i + " ");   
            }
            System.out.println();
            return;
        }
        int[] newAns = new int[ansSoFar.length + 1];
        int i = 0;
        while(i < ansSoFar.length){
            newAns[i] = ansSoFar[i];
            i++;
        }
        newAns[i] = input[stIdx];
        printSubsets_helper(input, stIdx+1, newAns);
        printSubsets_helper(input, stIdx+1, ansSoFar);
    }
    
	public static void printSubsets(int input[]) {
        int[] intialAns = new int[0];
        printSubsets_helper(input, 0, intialAns);
	}
	
	/*
	 * Return and Print all the permutations of given String
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
	
	// You can also use this way to print the answers (Applied to all above problems too)
	public static void printPermutations1_helper(String input, String ansSoFar){
        if(input.length() == 0){
            System.out.println(ansSoFar);
            return;
        }
        for(int i = 0; i<input.length(); i++){
            String newInput = input.substring(0, i) + input.substring(i+1);
            printPermutations1_helper(newInput, ansSoFar + input.charAt(i));
        }
    }

	public static void printPermutations1(String input){
		printPermutations1_helper(input, "");
	}
	
}
