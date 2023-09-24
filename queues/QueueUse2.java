package queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUse2 {

	public static void main(String[] args){
		Queue<Integer> que = new LinkedList<>();
		int[] arr = {10, 20, 30, 40};
		for(int elem:arr) {
			que.add(elem);
		}
		while(!que.isEmpty()) {
			System.out.println(que.poll());
		}
	}

}
