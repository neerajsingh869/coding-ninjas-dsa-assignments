package optionalStrings;

import java.util.Scanner;

public class LongestNonPalindromicString {
	
	/*
	 * You are given a string. You have is to find the length of the largest possible substring which is not a palindrome.
Input Format:
The only input line contains the input string.
Output Format:
The only output line contains the length of the largest non-palindromic string.
Sample Input:
abcba
Sample Output:
4
	 */
	
	private static int longestNonPalindro(String s){
		int n = s.length();
		int ans = n, i = 0, k =1;
		for(; k<s.length(); k++){
			if(s.charAt(k) != s.charAt(i)){
				break;
			}
		}
		if(k == n){
			return 0;
		}
		if(isPalindrome(s)){
			ans = n-1;
		}
		return ans;
	}

	private static boolean isPalindrome(String s){
		int i = 0, j = s.length()-1;
		while(i < j){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(longestNonPalindro(s));
	}

}
