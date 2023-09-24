package stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue<T> {
	private Queue<T> q1;
	private Queue<T> q2;
	
	public StackUsing2Queue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
	
	public int getSize() { 
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.size() == 0;
    }

    public void push(T element) {
        q1.add(element);
    }

    public T pop() throws StackEmptyException {
        if(q1.size() == 0){
        	throw new StackEmptyException();
        }
        T ans;
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        ans = q1.peek();
        q1.poll();
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        // CAN ALSO SWAP THESE TWO QUEUES	
        // Queue<Integer> temp = q1;
        // q1 = q2;
        // q2 = temp;
        return ans;
    }

    public T top() throws StackEmptyException {
        if(q1.size() == 0){
            throw new StackEmptyException();
        }
        T ans;
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        ans = q1.poll();
        q2.add(ans);
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
        return ans;
    }
}
