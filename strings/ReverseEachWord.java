package strings;

public class ReverseEachWord {
	
	/*
	 * Aadil has been provided with a sentence in the form 
	 * of a string as a function parameter. The task is to 
	 * implement a function so as to print the sentence such 
	 * that each word in the sentence is reversed.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String reverseEachWord1(String input) {
		String ans = "", temp = "";
		for(int i = 0; i<input.length(); i++) {
			if(input.charAt(i) == ' ') {
				ans += temp + " ";
				temp = "";
			}
			else{
				temp = input.charAt(i) + temp;
			}
		}
		ans += temp;
		return ans;
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String reverseEachWord2(String str) {
		int n = str.length();
        String ans = "";
        int previousSpaceIndex = -1;
        for(int i = 0; i<n; i++){
            if(str.charAt(i) == ' '){
                ans += reverseWord(str, previousSpaceIndex + 1, i) + " ";
                previousSpaceIndex = i;
            }
        }
        ans += reverseWord(str, previousSpaceIndex + 1, n);
        return ans;
	}
    
    public static String reverseWord(String str, int start, int end){
        String ans = "";
        for(int i = start; i<end; i++){
            ans = str.charAt(i) + ans;
        }
        return ans;
    }

	public static void main(String[] args) {
		String inp = "abc def ghi";
		System.out.println(reverseEachWord1(inp));
	}

}
