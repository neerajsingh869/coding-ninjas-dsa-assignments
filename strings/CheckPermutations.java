package strings;

import java.util.Arrays;

public class CheckPermutations {
	
	/*
	 * For a given two strings, 'str1' and 'str2', check whether 
	 * they are a permutation of each other or not.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public static boolean isPermutation(String str1, String str2) {
		int n = str1.length();
        int m = str2.length();
        if(n != m){
            return false;
        }
        // Total number of characters = 256
        int[] freq = new int[256];
        for(int i = 0; i<n; i++){
            freq[str1.charAt(i)]++;
        }
        for(int i = 0; i<n; i++){
            freq[str2.charAt(i)]--;
        }
        for(int i = 0; i<256; i++){
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
	}

	// Time complexity -> O(nlogn + mlogm), Space complexity -> O(n+m) where
	// n = str1.length() and m = str2.length()
	public static boolean isPermutation1(String str1, String str2) {
		char[] str1Char = str1.toCharArray();
        char[] str2Char = str2.toCharArray();
        Arrays.sort(str1Char);
        Arrays.sort(str2Char);
        
        boolean isPermutation = true;
		for (int i = 0; i < str1.length(); i++) {
			if (str1Char[i] != str2Char[i]) {
				isPermutation = false;
				break;
			}
		}

		return isPermutation;
	}
	
	public static void main(String[] args) {
		
	}

}
