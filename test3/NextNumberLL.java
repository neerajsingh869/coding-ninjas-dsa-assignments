package test3;

import java.util.Scanner;

import linkedLists.Node;

public class NextNumberLL {
	
	/*
	 * Given a large number represented in the form of a linked list. 
	 * Write code to increment the number by 1 in-place(i.e. without 
	 * using extra space).
	 */
	
	public static Node<Integer> nextLargeNumber1(Node<Integer> head) {
		if(head == null){
			return head;
		}
		Node<Integer> newHead = reverse(head);
		Node<Integer> temp = newHead;
		Node<Integer> prev = null;
		int carry = 1;
		while(temp != null){
			int newNum = temp.data + carry;
			temp.data = newNum%10;
			carry = newNum/10;
			prev = temp;
			temp = temp.next;
		}
		if(carry == 1){
			Node<Integer> newNode = new Node<>(carry);
			prev.next = newNode;
		}
		return reverse(newHead);

	}
	
	// Optimized one
	public static Node<Integer> nextLargeNumber2(Node<Integer> head) {
		if(head == null){
			return head;
		}
		Node<Integer> newHead = reverse(head);
		Node<Integer> temp = newHead;
		int newNum = temp.data + 1;
		int carry = (temp.data + 1)/10;
		temp.data = (temp.data + 1)%10;
		if(carry != 0){
			Node<Integer> prev = temp;
			temp = temp.next;
			while(temp != null){
				newNum = temp.data + carry;
				temp.data = newNum%10;
				carry = newNum/10;
				prev = temp;
				temp = temp.next;
			}
			if(carry == 1){
				Node<Integer> newNode = new Node<>(carry);
				prev.next = newNode;
			}
		}
		return reverse(newHead);

	}

	public static Node<Integer> reverse(Node<Integer> head){
		Node<Integer> prev = null, curr = head, fwd = head;
		while(curr != null){
			fwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = fwd;
		}
		return prev;
	}

	public static Node<Integer> takeInput() {
		Scanner s = new Scanner(System.in);
		Node<Integer> head = null, tail = null;
		int data = s.nextInt();
		while(data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
	
	public static void print(Node<Integer> head){
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
		
	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		head = nextLargeNumber1(head);
		print(head);
		
	}

}
