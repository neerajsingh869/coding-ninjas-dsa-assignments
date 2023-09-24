package queues;

public class QueueUse1 {

	public static void main(String[] args) throws QueueFullException, QueueEmptyException{
//		QueueUsingArray1 que1 = new QueueUsingArray1(10);
//		QueueUsingArray3 que3 = new QueueUsingArray3();
		QueueUsingLL<Integer> que4 = new QueueUsingLL<>();
		int[] arr = {10, 20, 30, 40};
		for(int elem:arr) {
			que4.enqueue(elem);
		}
		while(!que4.isEmpty()) {
			System.out.println(que4.dequeue());
		}
	}

}
