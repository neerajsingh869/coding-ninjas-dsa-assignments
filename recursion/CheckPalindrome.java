package recursion;

public class CheckPalindrome {
	
	/*
	 * Check whether a given String S is a palindrome using 
	 * recursion. Return true or false.
	 */

	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static boolean isStringPalindrome1(String input) {
        int n = input.length();
        return isStringPalindrome1(input, 0, n-1);
	}
    
    public static boolean isStringPalindrome1(String input, int st, int end){
        if(st >= end){
            return true;
        }
        if(input.charAt(st) == input.charAt(end)){
            return isStringPalindrome1(input, st+1, end-1);
        }
        else{
            return false;
        }
    }
    
    // Time Complexity -> O(n), Space Complexity -> O(n)
    public static boolean isStringPalindrome2(String input) {
        int n = input.length();
        if(n <= 1){
            return true;
        }
        if(input.charAt(0) == input.charAt(n-1)){
            return isStringPalindrome2(input.substring(1, n-1));
        }
        else{
            return false;
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
