package optionalDynamicProgramming;

import java.util.Scanner;
import java.util.Stack;

public class LongestBracket {
	
	/*
	 * Bracket sequence is called regular, if parenthesis in the given expression are balanced. You are given a string s, consisting of only '(' and ')' characters. You need to find its longest substring which is a regular bracket sequence. You have to find the number of such substrings as well.
Print first the length of output substring and then count of these. If no such substring exists, print "0 1" (without quotes).
Input format :
Line 1 : String s    
Constraints :
1 <= n (Length of string s) <= 10^6
Sample Input 1 :
)((())))(()())
Sample Output 1 :
6 2
Sample Input 2 :
))(
Sample Output 2 :
0 1
	 */
	
	// Brute force approach (Time complexity -> O(n*n*n), Space complexity -> O(n))
	public static void sol1(String str)
	{
		int n = str.length();
		int maxLength = Integer.MIN_VALUE;
		int maxCount = 0;
		for(int i = 0; i<n-1; i++){
			String tempStr = str.charAt(i) + "";
			for(int j = i+1; j<n; j++){
				tempStr += str.charAt(j);
				if(tempStr.length() % 2 == 0 && isBalanced(tempStr)){
					if(tempStr.length() == maxLength){
						maxCount++;
					}
					else if(tempStr.length() > maxLength){
						maxCount = 1;
						maxLength = tempStr.length();
					}
				}
			}
		}
		System.out.println(maxLength + " " + maxCount);
	}

	private static boolean isBalanced(String str){
		Stack<Character> st = new Stack<>();
		int n = str.length();
		for(int i = 0; i<n; i++){
			char ch = str.charAt(i);
			if(ch == '('){
				st.push(ch);
			}
			else{
				if(st.isEmpty()){
					return false;
				}
				else{
					st.pop();
				}
			}
		}
		return st.isEmpty() ? true : false;
	}
	
	// Best approach (Time complexity -> O(n), Space complexity -> O(n))
	public static void sol2(String str)
	{
		int n = str.length();
		// dp[i] = length of longest valid bracket including the bracket
		// at i-th index
		int[] dp = new int[n];
		int maxLength = Integer.MIN_VALUE;
		int countFreqOfMaxLength = 1;
		for(int i = 0; i<n; i++){
			if(str.charAt(i) == '('){
				dp[i] = 0;
			}
			else{
				if(i - 1 >= 0){
					int toSkip = dp[i-1];
					if(i-1-toSkip >= 0 && str.charAt(i-1-toSkip) == '('){
						dp[i] = 2 + dp[i-1] + (i-2-toSkip >= 0 ? dp[i-2-toSkip] : 0);
					}
					else{
						dp[i] = 0;
					}
				}
				else{
					dp[i] = 0;
				}
			}
			if(maxLength == dp[i]){
				countFreqOfMaxLength++;
			}
			else if(maxLength < dp[i]){
				maxLength = dp[i];
				countFreqOfMaxLength = 1;
			}
		}
		System.out.println(maxLength + " " + countFreqOfMaxLength);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String str;
		str = s.nextLine();
	    sol2(str);

	}

}
