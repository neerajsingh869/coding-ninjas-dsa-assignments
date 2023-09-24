package recursion;

public class ReturnPermutationsString {
	
	/*
	 * Given a string, find and return all the possible 
	 * permutations of the input string.
	 */
	
	public static String[] returnPermutationOfString(String input){
		// Write your code here
		if(input.length() == 0){
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        String[] smallOutput = returnPermutationOfString(input.substring(1));
        String[] output = new String[input.length()*smallOutput.length];
        int k = 0;
        for(int i = 0; i<input.length(); i++){
            for(String st : smallOutput){
                output[k++] = st.substring(0, i) + input.charAt(0) + st.substring(i);
            }
        }
        return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
