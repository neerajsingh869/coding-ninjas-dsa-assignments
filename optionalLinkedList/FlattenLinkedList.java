package optionalLinkedList;

import java.util.Scanner;

class LinkedListNodeF<T> {
	T data;
	LinkedListNodeF<T> next;
	LinkedListNodeF<T> down;

	LinkedListNodeF(T data) {
		this.data = data;
		this.next = null;
		this.down = null;
	}
}

class PairOfNodes {
	LinkedListNodeF<Integer> head;
	LinkedListNodeF<Integer> tail;
	
	public PairOfNodes() {
		this.head = null;
		this.tail = null;
	}
} 

public class FlattenLinkedList {
	
	private static Scanner sc = new Scanner(System.in);
	
	/*
	 * You are given a linked list in which each node has two pointers: next and child. Each child pointer will have its own next and child pointer. This results in a multilevel data structure. You may refer to the figure for better understanding.
Alt Text

You have to flatten this multilevel linked list and form a singly linked list such that the child node is printed before the next node for every node.
The above multilevel linked list will be converted into following singly linked list:
10->4->20->2->13->16->3->5->12->7->17->9->19->15->8->6->11
Input Format:
The input has already been managed for you. You just have to write a function. You are provided with the head of the multilevel linked list as an argument to the given function. You have to make changes in the input linked list itself and return the head of the flattened linked list
Constraints:
Time Limit: 1 second 
The total number of nodes in this multilevel linked list will lie in the range: [1, 100].
Output Format:
The output has already been managed for you. In the output, we use the head node (provided to you in the function argument) to print the singly linked list.  
Sample Input:
10
10 Y 4 N Y 20 Y 2 N n Y 13 Y 16 Y 3 N N N N 5 N 12 N 7 Y 17 y 9 y 19 n y 15 n n y 8 n n y 6 n n 11 N 12 N 13 N 14 N 15 N 16 N
Sample Output:
10 4 20 2 13 16 3 5 12 7 17 9 19 15 8 6 11 12 13 14 15 16
	 */
	
	public static LinkedListNodeF<Integer> flattenList1(LinkedListNodeF<Integer> node) { 
        if(node == null){
            return null;
        }
        LinkedListNodeF<Integer> tempNextNode = flattenList1(node.next);
        LinkedListNodeF<Integer> tempChildNode = flattenList1(node.down);
        if(tempChildNode == null){
            node.next = tempNextNode;
        }
        else{
            node.next = tempChildNode;
            LinkedListNodeF<Integer> tempChildTail = tempChildNode;
            while(tempChildTail.next != null){
                tempChildTail = tempChildTail.next;
            }
            tempChildTail.next = tempNextNode;
        }
        return node;
    }
	
	public static LinkedListNodeF<Integer> flattenList2(LinkedListNodeF<Integer> node) { 
        if(node == null){
            return null;
        }
        LinkedListNodeF<Integer> tempNextNode = flattenList2(node.next);
        LinkedListNodeF<Integer> tempChildNode = flattenList2(node.down);
        node.next = tempChildNode;
        LinkedListNodeF<Integer> tail = node;
         while(tail.next != null){
                tail = tail.next;
        }
        tail.next = tempNextNode; 
        return node;
    }
	
	public static LinkedListNodeF<Integer> insertBelow(char choic) {
		int data = sc.nextInt();

		LinkedListNodeF<Integer> np = new LinkedListNodeF<>(data);
		char choice = sc.next().charAt(0);

		if (choice == 'Y' || choice == 'y') {
			// create a node and then call

			np.down = insertBelow(choice);
		}

		// do you have right child
		choice = sc.next().charAt(0);

		if (choice == 'Y' || choice == 'y') {
			// create a node and then call
			np.next = insertBelow(choice);
		}
		return np;
	}

	public static LinkedListNodeF<Integer> insert(int data, PairOfNodes p) {

		LinkedListNodeF<Integer> nn = new LinkedListNodeF<>(data);

		if (p.head == null) {
			p.head = nn;
			p.tail = nn;
		} else {
			p.tail.next = nn;
			p.tail = nn;
		}
		return nn;
	}

	public static void printList(LinkedListNodeF<Integer> head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		
		PairOfNodes p = new PairOfNodes();
		
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			LinkedListNodeF<Integer> np = insert(a, p);
			char choice = sc.next().charAt(0);

			if(choice == 'Y' || choice == 'y') {
				// make recursive calls with np
				np.down = insertBelow(choice);
			} else {
				continue;
			}
		}

		flattenList2(p.head);
		printList(p.head);
	}

}

