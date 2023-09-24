package stacks;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	
	/*
	 * For a given a string expression containing only round 
	 * brackets or parentheses, check if they are balanced or 
	 * not. Brackets are said to be balanced if the bracket 
	 * which opens last, closes first.
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static boolean isBalanced1(String expression) {
        Stack<Character> st = new Stack<>();
        int n = expression.length();
        for(int i = 0; i<n; i++){
            char c = expression.charAt(i);
            if(c == '('){
                st.push(expression.charAt(i));
            }
            else if(c == ')'){
                if(!st.isEmpty()){
                    char top = st.pop();
                    if((c == ')' && top != '(')){
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                continue;
            }
        }
        return st.isEmpty();
    }
	
	// Better and simpler approach
	public static boolean isBalanced2(String expression) {
        int n = expression.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<n; i++){
            if(expression.charAt(i) == '('){
                st.push('(');
            }
            else {
                if(st.isEmpty() || st.peek() != '('){
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }

	public static void main(String[] args) 
    {
        Scanner sr = new Scanner(System.in);
        String expression = sr.next();
        System.out.println(isBalanced2(expression));
    }

}
