package test2;

import java.util.Scanner;

public class MinimumLengthWord {
	
	/*
	 * Given a string S (that can contain multiple words), you need to find the word which has minimum length.
Note : If multiple words are of same length, then answer will be first minimum length word in the string.
Words are seperated by single space only.
Input Format :
String S
Output Format :
Minimum length word
Constraints :
1 <= Length of String S <= 10^5
Sample Input 1 :
this is test string
Sample Output 1 :
is
Sample Input 2 :
abc de ghihjk a uvw h j
Sample Output 2 :
a
	 */

	// Time complexity -> O(n), Space complexity -> O(n)
	public static String minLengthWord1(String input){
		int n = input.length();
        int minWordLen = Integer.MAX_VALUE;
        int wordLen = 0;
        String minWord = "";
        String word = "";
        for(int i = 0; i<n; i++){
            if(input.charAt(i) == ' '){
                if(wordLen < minWordLen){
                    minWordLen = wordLen;
                    minWord = word;
                }
                wordLen = 0;
                word = "";
            }
            else{
                wordLen++;
                word += input.charAt(i);
            }   
        }
        if(wordLen < minWordLen){
            minWordLen = wordLen;
            minWord = word;
        }
        return minWord;
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String minLengthWord2(String input){
		int n = input.length();
		int minLength = Integer.MAX_VALUE;
		String minWord = "";
		String tempWord = "";

		for (int i = 0; i < n; i++) {
			if (input.charAt(i) == ' ') {
				if (tempWord.length() < minLength) {
					minWord = tempWord;
					minLength = tempWord.length();
					
				} 
				tempWord = "";
			}	else {
				tempWord += input.charAt(i);
			}
		}

		if (tempWord.length() < minLength) {
			minWord = tempWord;
			minLength = tempWord.length();
		}

		return minWord;
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String minLengthWord3(String input){
		int n = input.length();
		String minWord = "";
		int minLength = Integer.MAX_VALUE;
		int i = 0, j = 0;
		while (j < n) {
			if (input.charAt(j) == ' ') {
				if (j - i < minLength) {
					minLength = j - i;
					minWord = input.substring(i, j);
				}
				i = j + 1;
			}

			j++;
		}

		if (j - i < minLength) {
			minLength = j - i;
			minWord = input.substring(i, j);
		}

		return minWord;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		System.out.println(minLengthWord3(str));
	}

}
