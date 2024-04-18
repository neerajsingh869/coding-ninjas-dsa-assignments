package strings;

import java.util.Scanner;

public class CheckPalindrome {
	
	/*
	 * Given a string, determine if it is a palindrome, 
	 * considering only alphanumeric characters.
	 */
	private static String reverse(String str) {
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			ans = str.charAt(i) + ans;
		}
		return ans;
	}
	
	public static boolean checkPalindrome1(String str) {
		String reverseString = reverse(str);
		return str.equals(reverseString);
	}
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public static void checkPalindrome2(String str) {
		int i = 0, j = str.length() - 1;
		boolean flag = true;
		while(i<j) {
			if(str.charAt(i) != str.charAt(j)) {
				flag = false;
				break;
			}
			i++;
			j--;
		}
		if(flag == false) {
			System.out.println("The string is not Palindrome.");
		}
		else {
			System.out.println("The string is Palindrome.");
		}
	}
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public static boolean checkPalindrome3(String s) {
        char[] newS = s.toCharArray();
        int left = 0;
        int right = newS.length;
        
        while (left <= right) {
            if (newS[left] != newS[right]) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String inp = s.next();
		checkPalindrome2(inp);
	}

}
