package strings;

public class HighestOccuringCharacter {
	
	/*
	 * For a given a string(str), find and return 
	 * the highest occurring character.
	 * 
	 * If there are two characters in the input string with 
	 * the same frequency, return the character which comes first.
	 */
	
	// Time complexity -> O(n*n), Space complexity = O(1)
	public static char highestOccuringChar1(String str) {
		int n = str.length();
        int maxCount = Integer.MIN_VALUE;
        char maxChar = '\0';
        for(int i = 0; i<n; i++){
            int tempCount = 0;
            for(int j = 0; j<n; j++){
                if(str.charAt(i) == str.charAt(j)){
                    tempCount++;
                }
            }
            if(tempCount > maxCount){
                maxCount = tempCount;
                maxChar = str.charAt(i);
            }
        }
        return maxChar;
	}
	
	// Time complexity -> O(n), Space complexity = O(1)
	public static char highestOccuringChar2(String str) {
		int n = str.length();
        int maxCount = Integer.MIN_VALUE;
        char maxChar = '\0';
        int[] freq = new int[256];
        for(int i = 0; i<n; i++){
            freq[str.charAt(i)]++;
        }
        for(int i = 0; i<n; i++){
            if(freq[str.charAt(i)] > maxCount){
                maxCount = freq[str.charAt(i)];
                maxChar = str.charAt(i);
            }
        }
        return maxChar;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
