package optionalLinkedList;

import java.util.Scanner;

class LinkedListNodeF2<T> {
	  T data;
	  LinkedListNodeF2<T> right;
	  LinkedListNodeF2<T> down;

	  LinkedListNodeF2(T data) {
	    this.data = data;
	    this.right = null;
	    this.down = null;
	  }
}

public class FlattenLinkedList2 {
	
	/*
	 * You are given a linked list where each node of the given linked list has two pointers of such that:
1. The first pointer points to the next node of the main linked list (known as "right" pointer).
2. The second pointer points the linked list where this node is head (known as "down" pointer).
It is given that all the linked list are sorted. You have to write a function to flatten this list into a single linked list which should also be sorted.
For example, The given input linked list is:
Alt Text

The output linked list should be:
Al text

Input Format:
The only line of input contains the given linked list such that for each node of the main linked list the down linked list is given first and after that, we will move to the right node of the main linked list.
Output Format:
The only output line contains the flattened sorted linked list.
For the above mentioned example:
Sample Input:
5 8 9 20 -1 6 7 -1 10 30 50 -1 11 12 13 14 -1 -1
Sample Output:
5 6 7 8 9 10 11 12 13 14 20 30 50 
	 */
	
	public static LinkedListNodeF2<Integer> flat(LinkedListNodeF2<Integer> head) {
		if(head == null || head.right == null){
			return head;
		}
		return mergeLL(head, flat(head.right));
	}

	private static LinkedListNodeF2<Integer> mergeLL(LinkedListNodeF2<Integer> head1, LinkedListNodeF2<Integer> head2){
		if(head1 == null){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		if(head1.data < head2.data){
			head1.down = mergeLL(head1.down, head2);
			return head1;
		}
		else{
			head2.down = mergeLL(head1, head2.down);
			return head2;
		}
	}
	
	public static void printList(LinkedListNodeF2<Integer> head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.down;
		}

		System.out.println();
		return;
	}

	public static LinkedListNodeF2<Integer> takeInput(Scanner s) {
		int data = s.nextInt();
		
		LinkedListNodeF2<Integer> head = null;
		LinkedListNodeF2<Integer> tail = null;
		LinkedListNodeF2<Integer> headd = null;
		LinkedListNodeF2<Integer> taild = tail;
		
		while(data != -1) {
			LinkedListNodeF2<Integer> newNode = new LinkedListNodeF2<>(data);  
			headd = null;
			if(head == null) {
				head = newNode;
				tail = newNode;
				taild=tail;
			}
			else {
				tail.right = newNode;
				tail = tail.right;
				taild = tail;
			}
			
			while(data != -1) {
				if(headd == null) {
					headd = newNode; 
				} else {
					newNode = new LinkedListNodeF2<>(data);
					taild.down = newNode;
					taild = taild.down;
				}
				data = s.nextInt();
			}
			data = s.nextInt();
		}
		return head;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		LinkedListNodeF2<Integer> head = takeInput(s);
		head = flat(head);
		printList(head);
	}

}
