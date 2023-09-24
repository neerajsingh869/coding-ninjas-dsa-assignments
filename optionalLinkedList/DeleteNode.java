package optionalLinkedList;

import java.util.Scanner;

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
		this.next = null;
	}
}

public class DeleteNode {
	
	/*
	 * You are given a pointer to a node and you have to delete that node from the singly linked list using only the given pointer.
Note: Head pointer is not given to you. And the node to be deleted can never be the last node.
Input Format:
The first line of input contains the linked list and the second line of input contains the number k pointing to the node which is to be deleted from the singly-linked list.
The value of k is greater than or equal to 1 but less than the length of the singly linked list.
Output Format:
The output line contains the updated linked list after deleting the node.
Sample Input:
15 10 3 4 9 16 7 -1
5
Sample Output:
15 10 3 4 16 7
Explanation:
Given the linked list: 
15->10->3->4->9->16->7->NULL
From the given linked list you have to delete the 5th node.So, the updated linked list will be:
15->10->3->4->16->7->NULL
	 */
	
	// Time Complexity -> O(n)
	public static void deleteNode1(LinkedListNode<Integer> node) {
		if(node == null || node.next == null){
			return ;
		}
		while(node.next.next != null){
			node.data = node.next.data;
			node = node.next;
		}
		node.data = node.next.data;
		node.next = null;
	}
	
	// Time Complexity -> O(1)
	public static void deleteNode2(LinkedListNode<Integer> node) {
		if(node == null || node.next == null){
			return ;
		}
		node.data = node.next.data;
		node.next = node.next.next;
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

		LinkedListNode<Integer> head = takeInput(s);
		int k = s.nextInt();

		LinkedListNode<Integer> temp = head;

		int count = 1;

		while(count < k) {
			temp = temp.next;
			count += 1;
		}


		deleteNode2(temp);
		printList(head);
	}	

}
