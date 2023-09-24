package optionalLinkedList;

import java.util.ArrayList;
import java.util.Scanner;

class Node<T> {
	T data;
	Node<T> next;
	Node<T> arb;

	Node(T data) {
		this.data = data;
		this.next = null;
		this.arb = null;
	}
}

public class CloneLinkedList {
	
	/*
	 * A singly linked list is given to you with N nodes where each node is pointing to its next node and some of its nodes are pointing to the arbitrary nodes. You are given with M arbitrary pointers, where you have M pairs denoting that two nodes a and b are connected i.e. a's arbitrary pointer is pointing towards b (a->arb=b). You have to write a function to clone the original linked list given to you and return its head. We will validate whether the linked list is a copy of the original linked list or not.
Note: If there is any node whose arbitrary pointer is not given then its by default null.
Input Format:
The first line of input contains the value of two integers N and M. 
The next line of input contains the linked list with N nodes and the last line of input contains M pairs denoting arbitrary connecting nodes such that ith node is connected to jth node.
Output Format:
The only output line contains 1 if the linked list is successfully cloned.
Sample Input:
5 3
1 2 3 4 5
1 3 2 4 3 5
Sample Output:
1
	 */
	
	// Time Complexity -> O(n*n), Space Complexity -> O(1)
	public static Node<Integer> clone1(Node<Integer> head) {
        Node<Integer> cloneHead = null;
        Node<Integer> cloneTail = null;
        Node<Integer> temp = head;
        while(temp != null){
            Node<Integer> newNode = new Node<>(temp.data);
            if(cloneHead == null){
                cloneHead = newNode;
                cloneTail = newNode;
            }
            else{
                cloneTail.next = newNode;
                cloneTail = newNode;
            }
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.arb != null){
                Node<Integer> toConnect = null;
                Node<Integer> connectWith = null;
                Node<Integer> newTemp = cloneHead;
                while(newTemp != null){
                    if(temp.data.equals(newTemp.data)){
                        toConnect = newTemp;
                    }
                    if(temp.arb.data.equals(newTemp.data)){
                        connectWith = newTemp;
                    }
                    newTemp = newTemp.next;
                }
                toConnect.arb = connectWith;
            }
            temp = temp.next;
        }
        return cloneHead;
    }
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static Node<Integer> clone2(Node<Integer> head) {
        Node<Integer> cloneHead = null;
        Node<Integer> cloneTail = null;
        Node<Integer> temp = head;
        ArrayList<Node<Integer>> nextNodeArr = new ArrayList<>();
        while(temp != null){
            Node<Integer> newNode = new Node<>(temp.data);
            if(cloneHead == null){
                cloneHead = newNode;
                cloneTail = newNode;
            }
            else{
                cloneTail.next = newNode;
                cloneTail = newNode;
            }
            cloneTail.arb = temp;
            nextNodeArr.add(temp.next);
            Node<Integer> newTemp = temp.next;
            temp.next = cloneTail;
            temp = newTemp;
        }
        temp = cloneHead;
        while(temp != null){
            if(temp.arb.arb == null){
                temp.arb = null;
            }
            else{
                temp.arb = temp.arb.arb.next;
            }
            temp = temp.next;
        }
        temp = head;
        for(Node<Integer> next : nextNodeArr){
            temp.next = next;
            temp = temp.next;
        }
        return cloneHead;
    }
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static Node<Integer> clone3(Node<Integer> head) {
        Node<Integer> temp = head;
        // Linking cloned LL (without arb nodes) with Original LL
        // to make single LL
        while(temp != null){
            Node<Integer> newNode = new Node<>(temp.data);
            Node<Integer> newTemp = temp.next;
            temp.next = newNode;
            newNode.next = newTemp;
            temp = newTemp;
        }
        temp = head;
        // Cloning arb nodes of Original LL
        while(temp != null){
            if(temp.next != null){
                if(temp.arb != null){
                    temp.next.arb = temp.arb.next;
                }
                temp = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        temp = head;
        // Detaching cloned LL from Original LL
        Node<Integer> cloneHead = temp.next;
        Node<Integer> cloneTemp = temp.next;
        while(temp != null && cloneTemp != null){
            if(temp.next != null){
                temp.next = temp.next.next;
            }
            if(cloneTemp.next != null){
                cloneTemp.next = cloneTemp.next.next;
            }
            temp = temp.next;
            cloneTemp = cloneTemp.next;
        }
        return cloneHead;
    }
	
	private static Node<Integer> takeInput(int n, Scanner s) {
		int count = 1;
		int data = s.nextInt();

		Node<Integer> head = null;
		Node<Integer> tail = null;

		Node<Integer> newNode = new Node<>(data);

		head = newNode;
		tail = newNode;

		while(count < n) {
			data = s.nextInt();
			newNode = new Node<>(data);

			tail.next = newNode;
			tail = newNode;

			count += 1;
		}

		return head;
	}

	public static boolean validate(Node<Integer> head, Node<Integer> result) {
		if(head==result) {
			return false;
		}
		
		Node<Integer> temp1=head;
		Node<Integer> temp2=result;
		
		int length1=0,length2=0;
		
		while(temp1 != null) {
			length1++;
			temp1 = temp1.next;
		}
		while(temp2 != null) {
			length2++;
			temp2=temp2.next;
		}
		if(length1!=length2) {
			return false;
		}
		System.out.println("Ans till now: No Issue found");
		temp1=head;
		temp2=result;
		while(temp1 != null) {
			if(temp1.data != temp2.data) {
				return false;
			}
			
			if(temp1.arb != null && temp2.arb != null) {
				if(temp1.arb.data != temp2.arb.data) {
					System.out.println("Ans till now: Issue found Line 113");
					return false;
				}
			} else if(temp1.arb != null && temp2.arb == null) {
				System.out.println("Ans till now: Issue found Line 117");
				return false;
			} else if(temp1.arb == null && temp2.arb != null) {
				System.out.println("Ans till now: Issue found Line 120");
				return false;
			}
			
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		
		return true;
	}


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int m = s.nextInt();

		Node<Integer> head = takeInput(n, s);
		
		for(int i = 1; i <= m; i++) {
			int data1 = s.nextInt();
			int data2 = s.nextInt();

			Node<Integer> tempa = head;
			int count = -1;
			while(tempa != null) {
				count++;
				if(count == data1-1) {
					break;
				}

				tempa = tempa.next;
			}

			Node<Integer> tempb = head;
			count = -1;
			while(tempb != null) {
				count++;
				if(count == data2-1) {
					break;
				}

				tempb = tempb.next;
			}

			if(data1 <= n) {
				tempa.arb = tempb;
			}
		}
		
		Node<Integer> result = clone3(head); 
		
		if(validate(head, result)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	
		s.close();
	}

}
