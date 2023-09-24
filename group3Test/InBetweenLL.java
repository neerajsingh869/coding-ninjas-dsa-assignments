package group3Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    
    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class InBetweenLL {
	
	/*
	 * You are given two linked lists: list1 and list2 of sizes n and m respectively.
Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
Input Format
First line of input contains list1
Second line of input contains two space separated integers representing a and b.
Third line of input contains list2
Constraints
3 <= list1.length <= 10^4
1 <= a <= b < list1.length - 1
1 <= list2.length <= 10^4
Sample Input 1:
0 1 2 3 4 5 -1
3 4
101 102 103 -1
Sample Output 1:
0 1 2 101 102 103 5

	 */
	private static LinkedListNode<Integer> mergeInBetween(LinkedListNode<Integer> head1, int a, int b,
			LinkedListNode<Integer> head2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }
    
    public static void print(LinkedListNode<Integer> head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException { 
        LinkedListNode<Integer> head1 = takeInput();
        String[] strNums = br.readLine().trim().split(" ");
        int a = Integer.parseInt(strNums[0]);
        int b = Integer.parseInt(strNums[1]);
        LinkedListNode<Integer> head2 = takeInput();

        LinkedListNode<Integer> newHead = mergeInBetween(head1, a, b, head2);
        print(newHead);
    }

	

}
