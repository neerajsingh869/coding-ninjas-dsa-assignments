package optionalLinkedList;

import java.util.Scanner;

class DoublyLinkedListNode<T> {
	T data;
	DoublyLinkedListNode<T> next;
	DoublyLinkedListNode<T> prev;
	
	DoublyLinkedListNode(T data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

public class SortBiotonicLinkedList {
	
	/*
	 * You are given a doubly linked list such that it is first increasing and then decreasing. You have to sort this doubly linked list.
Such types of linked lists are called biotonic doubly linked list. A strictly increasing or a strictly decreasing list is also a biotonic doubly linked list.
Input format:
The only input line contains a biotonic doubly-linked list.
Output format:
The only output line contains the sorted doubly linked list.
Sample Input:
1 4 6 7 8 5 3 2 -1
Sample output:
1 2 3 4 5 6 7 8 -1
	 */
	
	public static DoublyLinkedListNode<Integer> sorting(DoublyLinkedListNode<Integer> head) {
        // if list is empty or if it contains
        // a single node only
        if (head == null || head.next == null)
            return head;
 
        DoublyLinkedListNode<Integer> current = head.next;
 
        while (current != null) {
 
            // if true, then 'current' is the first node
            // which is smaller than its previous node
            if (current.data < current.prev.data)
                break;
 
            // move to the next node
            current = current.next;
        }
 
        // if true, then list is already sorted
        if (current == null)
            return head;
 
        // split into two lists, one starting with 'head'
        // and other starting with 'current'
        current.prev.next = null;
        current.prev = null;
 
        // reverse the list starting with 'current'
        current = reverse(current);
        return mergeTwoSortedLinkedLists(head, current);
    }

    private static DoublyLinkedListNode<Integer> mergeTwoSortedLinkedLists(DoublyLinkedListNode<Integer> head1, DoublyLinkedListNode<Integer> head2){
        if (head1 == null)
            return head2;
 
        // If head2 linked list is empty
        if (head2 == null)
            return head1;
 
        // Pick the smaller value
        if (head1.data < head2.data) {
            head1.next = mergeTwoSortedLinkedLists(head1.next, head2);
            head1.next.prev = head1;
            head1.prev = null;
            return head1;
        }
        else {
            head2.next = mergeTwoSortedLinkedLists(head1, head2.next);
            head2.next.prev = head2;
            head2.prev = null;
            return head2;
        }
    }

    private static DoublyLinkedListNode<Integer> reverse(DoublyLinkedListNode<Integer> head){
        DoublyLinkedListNode<Integer> temp = null;
        DoublyLinkedListNode<Integer> current = head;
 
        // swap next and prev for all nodes
        // of doubly linked list
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
 
        // Before changing head, check for the cases
        // like empty list and list with only one node
        if (temp != null)
            head = temp.prev;
        return head;
    }
    
    public static DoublyLinkedListNode<Integer> takeInput() {
		Scanner s = new Scanner(System.in);

		DoublyLinkedListNode<Integer> head = null;
		DoublyLinkedListNode<Integer> tail = null;

		int data = s.nextInt();

		while(data != -1) {
			DoublyLinkedListNode<Integer> newNode = new DoublyLinkedListNode<>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			}

			data = s.nextInt();
		}

		return head;
	}

	public static void printList(DoublyLinkedListNode<Integer> head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		DoublyLinkedListNode<Integer> head = takeInput();
		printList(sorting(head));
	}

}
