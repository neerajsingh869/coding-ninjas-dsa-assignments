package optionalStrings;

import java.util.Scanner;

public class LargestPalindrome {
	
	/*
	 * You are given a string of all digits, you have to convert this string to a palindrome by changing at most K digits. If many solutions are possible then you have to print lexicographically largest possible string.
If it is not possible to convert this string to a palindrome by changing at most k digits then print NOT POSSIBLE.
Input Format:
The first line of input contains the input string and the following line of input contains the value of k.
Output Format:
The only output line contains the palindrome string.
Sample Input:
41415
3
Sample Output:
91919
Explanation:
Lexicographically largest palindrome 
after 3 changes is "91919"
	 */
	
	private static String largestPalindrome(String str, int k){
		char[] newStr = str.toCharArray();
		int i = 0, j = newStr.length-1;
		while(i < j){
			if(newStr[i] != newStr[j]){
				char max = (newStr[i] > newStr[j]) ? newStr[i] : newStr[j];
				newStr[i] = newStr[j] = max;
				k--;
			}
			i++;
			j--;
		}
		if(k < 0){
			return "NOT POSSIBLE";
		}
		i = 0;
		j = newStr.length-1;
		while(i <= j){
			if(i == j){
				if(k > 0){
					newStr[i] = '9';
				}
			}
			else{
				if(newStr[i] < '9'){
					if(k >= 2 && (newStr[i] == str.charAt(i) && newStr[j] == str.charAt(j))){
						k-=2;
						newStr[i] = newStr[j] = '9';
					}
					else if(k > 0 && (newStr[i] != str.charAt(i) || newStr[j] != str.charAt(j))){
						k--;
						newStr[i] = newStr[j] = '9';
					}
				}
			}
			i++;
			j--;
		}
		return new String(newStr);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int k = sc.nextInt();
		System.out.println(largestPalindrome(s, k));
	}

}
