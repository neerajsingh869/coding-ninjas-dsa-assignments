package test7;

import java.util.Scanner;
import java.util.Arrays;

public class HelpAroma {
	
	/*
	 * Teaching Assistants at Coding Ninjas are working day and 
	 * night for resolving doubts of students. On a particular day, 
	 * Aroma had solved lot of doubts. There is still one left 
	 * unsolved, so, she is asking for help.
	 * 
	 * The description of the doubt is - "Help me solve this question."
	 * 
	 * The question is described as - "You are given a word M 
	 * and K queries. In every query, there are four integers: 
	 * W, X, Y and Z. Let us form another word P by the characters 
	 * at positions: [W, X] of a given word M (characters at position 
	 * W and X are inclusive). Let us form another word Q by the 
	 * characters at positions [Y, Z] of the given word M (characters 
	 * at positions Y and Z are inclusive). For every query, you must 
	 * answer if it is possible to rearrange the letters of word Q and 
	 * form word P."
	 * 
	 * Your task is to help Aroma and write code for this problem.
	 */

	public static boolean canQbecomeP1(String m, int w, int x, int y, int z){
        char[] pChar = m.substring(w-1, x).toCharArray();
        char[] qChar = m.substring(y-1, z).toCharArray();
        Arrays.sort(pChar);
        Arrays.sort(qChar);
        String p = new String(pChar);
        String q = new String(qChar);
        return (p.equals(q)) ? true : false;
    }
	
	public static boolean canQbecomeP2(String m, int w, int x, int y, int z){
        String p = m.substring(w-1, x);
        String q = m.substring(y-1, z);
        int[] pFreq = new int[26];
        int[] qFreq = new int[26];
        for(int i = 0; i<p.length(); i++){
            pFreq[p.charAt(i) - 'a']++;
        }
        for(int i = 0; i<q.length(); i++){
            qFreq[q.charAt(i) - 'a']++;
        }
        for(int i = 0; i<26; i++){
            if(pFreq[i] != qFreq[i]){
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String m = sc.next();
        int k = sc.nextInt();
        while(k > 0){
            int w = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            boolean ans = canQbecomeP2(m, w, x, y, z);
            System.out.println(ans);
            k--;
        }
	}
	
}
