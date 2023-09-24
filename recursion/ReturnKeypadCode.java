package recursion;

public class ReturnKeypadCode {
	
	/*
	 * Given an integer n, using phone keypad find out all 
	 * the possible strings that can be made using digits of 
	 * input n.
	 * 
	 * Return empty string for numbers 0 and 1.
	 * 
	 * Note : 	1. 	The order of strings are not important.
	 * 			2. 	Input and output has already been managed for you. 
	 * 				You just have to populate the output array and return 
	 * 				the count of elements populated in the output array.
	 */
	
	public static String[] returnKeypad(int n){
		// Write your code here
        if(n == 0 || n == 1){
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        String[] smallOutput = returnKeypad(n/10);
        String key = getKey(n%10);
        
        int sizeSmall = smallOutput.length;
        int sizeKey = key.length();
        
		String[] output = new String[sizeKey*sizeSmall];
        
        int k = 0;
        for(int i = 0; i<sizeKey; i++){
            for(int j = 0; j<sizeSmall; j++){
				output[k++] = smallOutput[j] + key.charAt(i);
            }
        }
        return output;
	}
	
	private static String getKey(int n){
        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return str[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
