package stacks;

import java.util.Stack;

public class RedundantBrackets {
	
	/*
	 * For a given expression in the form of a string, find 
	 * if there exist any redundant brackets or not. It is 
	 * given that the expression contains only rounded brackets 
	 * or parenthesis and the input expression will always be balanced.
	 * 
	 * A pair of the bracket is said to be redundant when a 
	 * sub-expression is surrounded by unnecessary or needless brackets.
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static boolean checkRedundantBrackets(String expression) {
		Stack<Character> st = new Stack<>();
		int n = expression.length();
		for(int i = 0; i<n; i++){
			char c = expression.charAt(i);
			if(c == '(' || c == '+' || c == '*' || c == '/' || c == '-'){
				st.push(c);
			}
			else if(c == ')'){
				char top = st.peek();
				if(top == '('){
					return true;
				}
				else{
					while(st.peek() != '('){
						st.pop();
					}
					st.pop();
				}
			}
			else{
				continue;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
