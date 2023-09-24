package strings;

public class CountWords {
	
	/*
	 * For a given input string(str), find and return 
	 * the total number of words present in it.
	 * 
	 * It is assumed that two words will have only a single 
	 * space in between. Also, there wouldn't be any leading 
	 * and trailing spaces in the given input string.
	 */
	
	public static int countWords(String str) {	
		int n = str.length();
        if(n == 0){
            return 0;
        }
        int wordCount = 1;
        for(int i = 0; i<n; i++){
            if(str.charAt(i) == ' '){
                wordCount++;
            }
        }
        return wordCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
