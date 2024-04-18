package strings;

public class ReverseWordWise {
	
	/*
	 * Reverse the given string word wise. That is, the last word 
	 * in given string should come at 1st place, last second word 
	 * at 2nd place and so on. Individual words should remain as it is.
	 */
	
	public static String reverseWordWise1(String input) {
		int n = input.length();
        String ans = "";
        int stIdx = 0;
        for(int endIdx = 0; endIdx<n; endIdx++){
            if(input.charAt(endIdx) == ' '){
                ans = " " + input.substring(stIdx, endIdx) + ans;
                stIdx = endIdx + 1;
            }
        }
        ans = input.substring(stIdx) + ans;
        return ans;
	}
	
	public static String reverseWordWise2(String sentence) {
	    String[] words = sentence.split("\\s+");
	    StringBuilder reversed = new StringBuilder();
	    for (int i = words.length - 1; i >= 0; i--) {
	        reversed.append(words[i]).append(" ");
	    }
	    return reversed.toString().trim();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
