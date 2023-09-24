package queues;

//import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {
	
	public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		int n = input.size();
		if(n == 0 || k <= 0 || k > n) {
			return input;
		}
		Stack<Integer> st = new Stack<>();
		for(int i  = 0; i<k; i++){
			st.push(input.poll());
		}
		while(!st.isEmpty()){
			input.add(st.pop());
		}
		for(int i = 0; i<n-k; i++){
			input.add(input.poll());
		}
		return input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
