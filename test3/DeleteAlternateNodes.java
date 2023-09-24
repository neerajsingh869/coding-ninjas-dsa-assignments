package test3;

import java.util.Scanner;

import linkedLists.Node;

public class DeleteAlternateNodes {
	
	/*
	 * Given a Singly Linked List of integers, 
	 * delete all the alternate nodes in the list.
	 */

	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static void deleteAlternateNodes1(Node<Integer> head) {
        Node<Integer> curr = head;
        Node<Integer> currNext = null;
        while(curr != null && curr.next != null){
            currNext = curr.next;
            curr.next = currNext.next; 
            curr = curr.next;
        }
    }
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static void deleteAlternateNodes2(Node<Integer> head) {
        Node<Integer> fast = head;
        Node<Integer> tail = null;
        while(fast != null && fast.next != null){
            if(tail == null){
                tail = fast;
            }
            else{
                tail.next = fast;
                tail = fast;
            }
            fast = fast.next.next;
        }
        if(tail != null){
            tail.next = null;
        }
    }
	
	static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {

        Node<Integer> list = input();
        deleteAlternateNodes1(list);
        print(list);
    }

    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node<Integer> input() {
        int data = s.nextInt();

        Node<Integer> head = null;
        Node<Integer> tail = null;
        while (data!=-1) {
            Node<Integer> newNode = new Node<Integer>(data);
            if (head == null) {
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

}
