package recursion;

public class RemoveX {
	
	/*
	 * Given a string, compute recursively a new 
	 * string where all 'x' chars have been removed.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String removeX1(String input){
		return removeX1(input, 0);
	}
    
    public static String removeX1(String input, int idx){
        int n = input.length();
        if(idx == n){
            return "";
        }
        return (input.charAt(idx) == 'x') ? removeX1(input, idx+1) :
        		input.charAt(idx) + removeX1(input, idx+1);
    }
    
    // Time complexity -> O(n*n), Space complexity -> O(n)
 	// Since we have used substring() method
    public static String removeX2(String input){
		int n = input.length();
        if(n == 0){
            return "";
        }
        return (input.charAt(0) == 'x') ? removeX2(input.substring(1)) :
        		input.charAt(0) + removeX2(input.substring(1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
