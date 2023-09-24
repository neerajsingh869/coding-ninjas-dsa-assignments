package optionalLinkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class NodeF {
	int data;
	NodeF next;
	NodeF down;

	public NodeF(int data, NodeF next, NodeF down) {
		this.data = data;
		this.next = next;
		this.down = down;
	}
}

public class FlattenLinkedList3 {
	
	/*
	 * You are given a linked list in which each node has two pointers: next and child. Each child pointer will have its own next and child pointer. This results in a multilevel data structure. For example, let us take following multi level linked list:
Alt Text

You have to flatten this multilevel linked list and form a singly linked list such that all the nodes in the first level should come first, then nodes of second level and so on.
The above multilevel linked list will be converted into following singly linked list:
10->5->12->7->11->4->20->13->17->6->2->16->9->8->3->19->15
Input Format:
The input has already been managed for you. You just have to write a void function. You are provided with head of the multilevel linked list as an argument to given function. You have to make changes in the input linked list itself.
Constraints:
Time Limit: 1 second 
The total number of nodes in this multilevel linked list will lie in the range: [1, 100].
Output Format:
The output has already been managed for you. In output, we use the head node (provided to you in the function argument) to print the singly linked list.  
Sample Input 1:
5
10 Y 4 N Y 20 Y 2 N n Y 13 Y 16 Y 3 N N N N 5 N 12 N 7 Y 17 y 9 y 19 n y 15 n n y 8 n n y 6 n n 11 N
Sample Output 1:
10 5 12 7 11 4 20 13 17 6 2 16 9 8 3 19 15
	 */

	public static void flattenListCorrect1(NodeF hp) {
        if(hp == null){
            return ;
        }
        Queue<NodeF> que = new LinkedList<>();
        que.add(hp);
        while(!que.isEmpty()){
            NodeF curr = que.poll();
            NodeF tempTail = curr;
            while(curr != null){
                if(curr.next == null){
                    tempTail = curr;
                }
                if(curr.down != null){
                    que.add(curr.down);
                }
                curr = curr.next;
            }
            tempTail.next = que.peek();
        }
    }
	
	public static void flattenListCorrect2(NodeF hp) {
        if(hp == null){
            return ;
        }
        NodeF tail = hp;
        while(tail.next != null){
            tail = tail.next;
        }
        while(hp != null){
            if(hp.down != null){
                tail.next = hp.down;
                hp.down = null;
                while(tail.next != null){
                    tail = tail.next;
                }
            }
            hp = hp.next;
        }
    }
	
	static NodeF head;
	static NodeF tail;
	static int size;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		// This is for the main linked list of size n
		for (int i = 0; i < n; i++) {
			int a = scn.nextInt();
			NodeF np = insert(a);
			// do you have down child
			char choice = scn.next().charAt(0);
			if (choice == 'Y' || choice == 'y') {
				// make recursive calls with np
				np.down = insertbelow(scn);
			} else {
				continue;
			}
		}
		flattenListCorrect2(head);
		display(head);

	}

	private static NodeF insertbelow(Scanner scn) {
		NodeF np=null;
		np = new NodeF(scn.nextInt(), null, null);
		// Do you have down child
		char choice = scn.next().charAt(0);
		if (choice == 'Y' || choice == 'y') {
			// create a NodeF and then call
			
			np.down = insertbelow(scn);
		}
		// do you have right child
		choice = scn.next().charAt(0);
		if (choice == 'Y' || choice == 'y') {
			// create a NodeF and then call
			np.next = insertbelow(scn);

		}
		return np;
	}


	private static NodeF insert(int data) {
		NodeF nn = new NodeF(data, null, null);
		if (head == null) {
			head = nn;
			tail = nn;
		} else {
			tail.next = nn;
			tail = nn;
		}
		return nn;

	}
	
	public static void display(NodeF n) {
		for (NodeF NodeF = n; NodeF != null; NodeF = NodeF.next) {
			System.out.print(NodeF.data + " ");
		}
	}

}
