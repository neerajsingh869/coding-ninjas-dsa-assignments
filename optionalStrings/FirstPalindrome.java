package optionalStrings;

import java.util.Scanner;

public class FirstPalindrome {
	
	/*
	 * Given a string S, you need to find and return the lexicographically first palindrome string that can be made using characters of S.
Return an empty string if no palindrome can be created using S.
Input Format :
String S
Output Format :
Required palindrome
Constraints :
1 <= Length of S <= 1000
Sample Input 1 :
abcca
Sample Output 1 :
acbca
Sample Input 2 :
azxyaaz
Sample Output 2 :
"" (Empty String)
	 */
	
	public static String nextPalindrome(String input) {
		int[] charFreq = new int[26];
		int n = input.length();
		for(int i = 0; i<n; i++){
			charFreq[input.charAt(i) - 'a']++;
		}
		int oddCount = 0;
		String oddChar = "";
		for(int i = 0; i<26; i++){
			if(charFreq[i] % 2 != 0){
				oddCount++;
				oddChar = oddChar + (char)('a'+i);
			}
		}
		if(oddCount > 1){
			return "";
		}
		String front = "", rear = "";
		for(int i = 0; i<26; i++){
			int currCharFreq = charFreq[i];
			if(currCharFreq % 2 == 0){
				String temp = "";
				for(int j = 0; j<currCharFreq/2; j++){
					temp = temp + (char)('a'+i);
				}
				front = front + temp;
				rear = temp + rear;
			}
			
		}
		return front + oddChar + rear;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		System.out.println(nextPalindrome(input));
	}

}
