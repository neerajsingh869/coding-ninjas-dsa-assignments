package strings;

public class CompressString {
	
	/*
	 * Write a program to do basic string compression. 
	 * For a character which is consecutively repeated 
	 * more than once, replace consecutive duplicate 
	 * occurrences with the count of repetitions.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(n);
	public static String getCompressedString(String str) {
		int n = str.length();
        if(n == 0){
            return "";
        }
        int charCount = 0;
        String ans = "";
        for(int i = 0; i<n-1; i++){
        	charCount++;
            if(str.charAt(i) != str.charAt(i+1)){
                ans += str.charAt(i);
                if(charCount > 1){
                    ans += charCount;
                }
                charCount = 0;
            }
        }
        charCount++;
        ans += str.charAt(n-1);
        if(charCount > 1){
            ans += charCount;
        }
        return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
