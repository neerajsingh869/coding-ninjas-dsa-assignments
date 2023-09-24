package test7;

import java.util.Scanner;

public class BobAndStrings {
	
	/*
	 * King Bob is in playful mood today. He started playing 
	 * with string S. As he was playing, a weird question came 
	 * in his mind. He wondered what is the maximum number of 
	 * characters, between any two same characters in the string. 
	 * He needs your help in solving this question. 
	 * Can you help him solve this question?
	 * 
	 * Note: String S is composed of lowercase letters of the Latin 
	 * alphabet. If there are no two same characters in the string, print -1.
	 */
	
	// Brute force approach
	public static int maxChars1(String s){
        int ans = Integer.MIN_VALUE;
        int n = s.length();
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(s.charAt(j) == s.charAt(i)){
                    ans = Math.max(ans, j-i-1);
                }
            }
        }
        return (ans == Integer.MIN_VALUE) ? -1 : ans;
    }
	
	// Best approach
	public static int maxChars2(String s){
        int n = s.length();
        int[] freq = new int[26];
        for(int i = 0; i<26; i++){
            freq[i] = -1;
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(freq[s.charAt(i) - 'a'] == -1){
                freq[s.charAt(i) - 'a'] = i;
            }
            else{
                ans = Math.max(i-freq[s.charAt(i) - 'a']-1, ans);
            }
        }
        return (ans == Integer.MIN_VALUE) ? -1 : ans;
    }
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            String s = sc.next();
            int ans = maxChars2(s);
            System.out.println(ans);
            t--;
        }
	}

}
