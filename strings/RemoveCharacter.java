package strings;

public class RemoveCharacter {
	
	/*
	 * For a given a string(str) and a character X, 
	 * write a function to remove all the occurrences 
	 * of X from the given string.
	 * 
	 * The input string will remain unchanged if the 
	 * given character(X) doesn't exist in the input string.
	 */

	// Time complexity -> O(n), Space complexity -> O(n)
	public static String removeAllOccurrencesOfChar(String str, char ch) {
        int n = str.length();
        String ans = "";
        for(int i = 0; i<n; i++){
            if(str.charAt(i) != ch){
                ans += str.charAt(i);
            }
        }
        return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
