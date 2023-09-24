package recursion;

public class PrintPermutationsString {
	
	/*
	 * Given a string, find and print all the possible 
	 * permutations of the input string.
	 */
	
	public static void printPermutations1(String input){
		printPermutations1(input, "");
	}
	
	public static void printPermutations1(String input, String ansSoFar){
        if(input.length() == 0){
            System.out.println(ansSoFar);
            return;
        }
        for(int i = 0; i<input.length(); i++){
            String newInput = input.substring(0, i) + input.substring(i+1);
            printPermutations1(newInput, ansSoFar + input.charAt(i));
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
