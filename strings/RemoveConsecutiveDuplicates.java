package strings;

public class RemoveConsecutiveDuplicates {
	
	/*
	 * For a given string(str), remove all the consecutive duplicate characters.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String removeConsecutiveDuplicates1(String str) {
		int n = str.length();
        if(n == 0){
            return "";
        }
        String ans = "";
        for(int i = 0; i<n-1; i++){
            if(str.charAt(i) != str.charAt(i+1)){
                ans += str.charAt(i);
            }
        }
        ans += str.charAt(n-1);
        return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
