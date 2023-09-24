package fullTest1;

import java.util.Scanner;
import java.util.Stack;

public class BackspaceProblem {
	
	/*
	 * Given a string consisting of lower case characters and hashes(#) where each hash represents a back space .
Find the resultant string after removing the backspaces from the given input string.
(Note : there will be no condition where we use backspace on empty string )
Example :
Input: xy#z
Output: xz
	 */
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String backspace(String s){
	    int n = s.length();
	    Stack<Character> st = new Stack<>();
	
	    for (int i = 0; i < n; i++) {
	      char c = s.charAt(i);
	      if (c == '#') {
	        if (!st.isEmpty()) {
	          st.pop();
	        }
	      } else {
	        st.push(c);
	      }
	    }
	
	    String ans = "";
	    while (!st.isEmpty()) {
	      ans = st.pop() + ans;
	    }
	
	    return ans;
	}
	
	public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        String n=s.next();
        String x=backspace(n);
        System.out.print(x);
    }

}
