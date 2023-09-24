package group3Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class KeepScoreOfBrackets {
	
	/*
	 * Vaibhavi loves to play with strings of brackets. She likes the balanced string of brackets, so much so, that she has decided to score them. She follows the following grading system:
1. A bracket group like () has score of  3
2. XY has a score of score X + Y, where X and Y are balanced parentheses strings.
3. A bracket group like (A) has score 3 * A, where A is a balanced parentheses string.
Given a balanced paranthesis string, your job is to find the score of it and solve the riddle.
Input Format:
First and only line of input contains a balanced paranthesis string, S.
Constraints:
S is a balanced parentheses string, containing only ( and ).
2 <= S.length <= 50
Output Format:
Print the score of the input string.
Sample Input:
(()(()))
Sample Output:
36
Explanation:
Let us break down the () first.
(3(3)) 
Now, (3) evaluates to 9
(3 9)
3 and 9 are two pairs of balanced results, hence add them
(12)
This evaluates to 24.
	 */
	
	static public int scoreOfParentheses(String S) {
        Stack<String> s = new Stack<>();
	 
	    int i = 0;
	    int ans = 0;
	 
	    while (i < S.length()){
	 
	      if (S.charAt(i) == '(')
	        s.add("(");
	      else{
	        if (s.peek() == "("){
	          s.pop();
	          s.add("3");
	        }else{	 
	          long count = 0;
	 	       while (s.peek() != "("){	 
	            count += Integer.parseInt(s.peek());
	            s.pop();
	          }
	          s.pop();	 
	          s.add(String.valueOf(3 * count));
	        }
	      }	 
	      i++;
	    }
	 
	    while (!s.isEmpty()){	 
	      ans += Integer.parseInt(s.peek());
	      s.pop();
	    }
	    return ans;
   }
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String expression = br.readLine().trim();
        System.out.println(scoreOfParentheses(expression));
    }

}
