package recursion;

public class ReplaceCharacter {
	
	/*
	 * Given an input string S and two characters c1 and c2, 
	 * you need to replace every occurrence of character 
	 * c1 with character c2 in the given string.
	 *
	 * Do this recursively.
	 */
	
	// Time complexity -> O(n*n), Space complexity -> O(n)
	// Since we have used substring() method
	public static String replaceCharacter1(String input, char c1, char c2) {
        int n = input.length();
        if(n == 0){
            return "";
        }
        String smallAns = replaceCharacter1(input.substring(1), c1, c2);
        return (input.charAt(0) == c1) ? c2 + smallAns : 
        		input.charAt(0) + smallAns;
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String replaceCharacter2(String input, char c1, char c2) {
        return replaceCharacter2(input, 0, c1, c2);
	}
    
    public static String replaceCharacter2(String input, int idx, char c1, char c2){
        int n = input.length();
        if(n == idx){
            return "";
        }
        String smallAns = replaceCharacter2(input, idx+1, c1, c2);
        return (input.charAt(idx) == c1) ? c2 + smallAns : 
        		input.charAt(idx) + smallAns;
    }

	public static void main(String[] args) {
		
	}
	
}
