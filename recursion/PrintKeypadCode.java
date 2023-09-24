package recursion;

public class PrintKeypadCode {
	
	/*
	 * Given an integer n, using phone keypad find out 
	 * and print all the possible strings that can be made 
	 * using digits of input n.
	 */
	
	public static void printKeypad(int n) {
		printKeypad_helper(n, "");
	}
	
	public static void printKeypad_helper(int n, String ansSoFar){
        if(n == 0){
            System.out.println(ansSoFar);
            return;
        }
        String key = getKey(n%10);
        for(int i = 0; i<key.length(); i++){
            printKeypad_helper(n/10, key.charAt(i) + ansSoFar);
        }
    }
	
	private static String getKey(int n){
        String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return str[n];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
