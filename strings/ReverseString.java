package strings;

import java.util.Scanner;

public class ReverseString {
	
	/*
	 * You are having a character array (arr) containing ASCII characters. 
	 * You are required to reverse the character array (arr) and return it as a string.

		You must do this by modifying the input array.
		
		Output the reverse of the input array.
		
		Example :
		S = “hello”
		
		Explanation : 
		
		The reverse of the input array is “olleh”.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String reverseString1(String str) {
		String ans = "";
		int n = str.length();
		// Method 1
//		for(int i = n-1; i>=0; i--) {
//			ans += str.charAt(i);
//		}
		// Method 2
		for(int i = 0; i<n; i++) {
			ans = str.charAt(i) + ans;
		}
		return ans;
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String stringReverse2(char[] arr) {
	    // Write your code here.
	    String reversedStr = "";
	    for (int i = 0; i < arr.length; i++) {
	      reversedStr = arr[i] + reversedStr;
	    }

	    return reversedStr;
	  }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String stringReverse3(String input) {
        StringBuilder sb = new StringBuilder(input);
        StringBuilder output = new StringBuilder("");
        for (int i = sb.length() - 1; i >= 0; i--) {
            output = output.append(sb.charAt(i));
        }
        return output.toString();
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String stringReverse4(String input) {
        char[] s = input.toCharArray();
        
        int st = 0;
        int end = s.length - 1;
        while (st < end) {
            char temp = s[st];
            s[st] = s[end];
            s[end] = temp;
            st++;
            temp--;
        }
        
        return new String(s);
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String inp = s.next();
		System.out.println(reverseString1(inp));
	}

}
