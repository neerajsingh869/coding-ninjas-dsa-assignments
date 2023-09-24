package recursion;

public class CheckAB {
	
	/*
	 * Suppose you have a string, S, made up of only 'a's 
	 * and 'b's. Write a recursive function that checks if 
	 * the string was generated using the following rules:
	 * 			
	 * 			a. The string begins with an 'a'
	 * 			b. Each 'a' is followed by nothing or an 'a' or "bb"
	 * 			c. Each "bb" is followed by nothing or an 'a'
	 * 
	 * If all the rules are followed by the given string, 
	 * return true otherwise return false.
	 */
	
	// Time Complexity -> O(n*n), Space Complexity -> O(n)
	public static boolean checkAB1(String input) {
        int n = input.length();
        if(n == 0){
            return true;
        }
        if(input.charAt(0) == 'a'){
            if(input.substring(1).length() > 1 && input.substring(1, 3).equals("bb")){
                return checkAB1(input.substring(3));
            }
            else{
                return checkAB1(input.substring(1));
            }
        }
        return false;
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static boolean checkAB2(String input) {
    	return checkAB2(input, 0);
	}
    
    public static boolean checkAB2(String input, int idx){
        int n = input.length();
        if(idx == n){
            return true;
        }
        if(input.charAt(idx) == 'a'){
            if(n-idx-1 > 1 && (input.charAt(idx+1) == 'b' && input.charAt(idx+2) == 'b')){
                return checkAB2(input, idx+3);
            }
            else{
                return checkAB2(input, idx+1);
            }
        }
        return false;
    }

	public static void main(String[] args) {
		
	}

}
