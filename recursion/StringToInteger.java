package recursion;

public class StringToInteger {
	
	/*
	 * Write a recursive function to convert a given string 
	 * into the number it represents. That is input will be 
	 * a numeric string that contains only numbers, you need 
	 * to convert the string into corresponding integer and 
	 * return the answer.
	 */
	
	// Time Complexity -> O(n*n), Space Complexity -> O(n)
	public static int convertStringToInt(String input){
        int n = input.length();
        if(n == 0){
            return 0;
        }
        return convertStringToInt(input.substring(0, n-1))*10 + (input.charAt(n-1)-48);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
