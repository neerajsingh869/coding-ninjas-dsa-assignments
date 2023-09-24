package strings;

import java.util.Scanner;

public class ReverseString {
	
	public static String reverseString(String str) {
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

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String inp = s.next();
		System.out.println(reverseString(inp));
	}

}
