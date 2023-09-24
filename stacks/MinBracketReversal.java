package stacks;

import java.util.Stack;

public class MinBracketReversal {
	
	/*
	 * For a given expression in the form of a string, 
	 * find the minimum number of brackets that can be 
	 * reversed in order to make the expression balanced. 
	 * The expression will only contain curly brackets.
	 * 
	 * If the expression can't be balanced, return -1.
	 */
	
	public static int countBracketReversals(String input) {
		Stack<Character> st = new Stack<>();
		int n = input.length();
		if(n == 0){
			return 0;
		}
		if(n % 2 != 0){
			return -1;
		}
		for(int i = 0; i<n; i++){
			char c = input.charAt(i);
			if(c == '{'){
				st.push(c);
			}
			else{
				if(!st.isEmpty() && st.peek() == '{'){
					st.pop();
				}
				else{
					st.push(c);
				}
			}
		}
		int count = 0;
		while(!st.isEmpty()){
			char c1 = st.pop();
			char c2 = st.pop();
			if(c1 != c2){
				count += 2;
			}
			else{
				count += 1;
			}
		}
		return count;
		
	}
	
	// Another approach (Better to understand)
	public static int countBracketReversals2(String input) {
		int n = input.length();
		if(n % 2 != 0) {
			return -1;
		}
		Stack<Character> st = new Stack<>();
		for(int i = 0; i<n; i++) {
			if(input.charAt(i) == '}' && !st.isEmpty() && st.peek() == '{') {
				st.pop();
			} else {
				st.push(input.charAt(i));
			}
		}
		int countOpen = 0, countClose = 0;
		while(!st.isEmpty()) {
			if(st.peek() == '{') {
				countOpen++;
			} else {
				countClose++;
			}
			st.pop();
		}
		if(countClose % 2 == 0) {
			return (countClose + countOpen) / 2;
		} else {
			return (countOpen + countClose - 2)/2 + 2;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
