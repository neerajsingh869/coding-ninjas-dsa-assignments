package optionalLinkedList;

import java.util.Scanner;

public class Sum2Numbers {
	
	/*
	 * You are given two numbers represented by two different linked list. You have to write a function to return the sum of both the numbers in a linked list.
Note: You are not allowed to use extra space. Try doing this problem using recursion. You don't have to modify the given linked lists.


Input format:
The first line of input contains the first number represented by a linked list. The second line of input contains the second number represented by a linked list.
Output Format:
The only output line contains the sum of both the numbers represented by a linked list.
Sample Input:
4 5 6 7 -1
6 7 8 9 -1
Sample Output:
1 1 3 5 6
	 */
	
	public static LinkedListNode<Integer> addNumbers(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) { 
		int countHead1 = countNodes(head1);
		int countHead2 = countNodes(head2);
		LinkedListNode<Integer> newHead1;
		LinkedListNode<Integer> newHead2;
		if(countHead1 > countHead2){
			newHead1 = reverseLL(head1);
			newHead2 = reverseLL(head2);
		} 
		else{
			newHead1 = reverseLL(head2);
			newHead2 = reverseLL(head1);
		}
		LinkedListNode<Integer> tempHead1 = newHead1;
		LinkedListNode<Integer> tempHead2 = newHead2;
		int carry = 0;
		while(tempHead1 != null && tempHead2 != null){
			int num = tempHead1.data + tempHead2.data + carry;
			tempHead1.data = num%10;
			carry = num/10; 
			tempHead1 = tempHead1.next;
			tempHead2 = tempHead2.next;
		}
		while(tempHead1 != null){
			int num = tempHead1.data + carry;
			tempHead1.data = num%10;
			carry = num/10; 
			tempHead1 = tempHead1.next;
		}
		tempHead1 = reverseLL(newHead1);
		if(carry != 0){
			LinkedListNode<Integer> msb = new LinkedListNode<>(1);
			msb.next = tempHead1;
			tempHead1 = msb;
		}
		return tempHead1;
	}

	private static int countNodes(LinkedListNode<Integer> head){
		int count = 0;
		while(head != null){
			count++;
			head = head.next;
		}
		return count;
	}

	private static LinkedListNode<Integer> reverseLL(LinkedListNode<Integer> head){
		LinkedListNode<Integer> curr = head, prev = null, fwd = curr;
		while(curr != null){
			fwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = fwd;
		}
		return prev;
	}
	
	public static void printList(LinkedListNode<Integer> head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();
		return;
	}

	public static LinkedListNode<Integer> takeInput(Scanner s) {
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;

		int data = s.nextInt();

		while(data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<>(data);

			if(head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		LinkedListNode<Integer> head1 = takeInput(s);
		LinkedListNode<Integer> head2 = takeInput(s);

		
		printList(addNumbers(head1, head2));
	}

}
