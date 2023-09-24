package optionalLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FindIntersection {
	
	/*
	 * Write a function to get the intersection point of two Linked Lists in no extra space and O(n) time complexity (head of both linked lists must be different).
You are given two Singly Linked List of integers, which are merging at some node. Find the data of the node at which merging starts. If there is no merging, return -1.

Input Format:
The input format contains three lines consisting of three singly-linked lists. 

All three lines contain the elements of the singly linked list separated by a single space and terminated by -1.  

So first linked list would contain
       a1, a2, ...an, c1, -1. 

Similarly, the second line would contain
       b1,b2, ...bm, c1, -1. 

The third line would contain 
       c2, c3, ....ck, -1.
Output format :
The only line of output contains data of the first merged node. If there is no merging output should contain -1.

You don't have to explicitly print by yourself. It has been taken care of.
Constraints :
0 <= N <= 10^5
0 <= M <= 10^5
0 <= K <= 10^5.
-10^9 <= data <= 10^9 and data != -1


 Time Limit: 1 sec
Sample Input 1 :
4 1 8 -1
5 6 1 8 -1
4 5 -1
Sample Output 1 :
8
Sample Input 2 :
1 9 1 2 -1
3 2 -1
4 -1
Sample Output 2 :
2
Sample Input 3 :
2 6 4 -1
1 5 -1
-1
Sample Output 3 :
-1
	 */
	
	// Time Complexity -> O(n*n)
	public static int findIntersection1(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) {
		if(firstHead == null || secondHead == null){
			return -1;
		}
		LinkedListNode<Integer> tempFirst = firstHead;
		while(tempFirst != null){
			LinkedListNode<Integer> tempSecond = secondHead;
			while(tempSecond != null){
				if(tempSecond == tempFirst){
					return tempFirst.data;
				}
				tempSecond = tempSecond.next;
			}
			tempFirst = tempFirst.next;
		}
		return -1;		
	}
	
	// Time Complexity -> O(n)
	public static int findIntersection2(LinkedListNode<Integer> firstHead, LinkedListNode<Integer> secondHead) {
		if(firstHead == null || secondHead == null){
			return -1;
		}
		int countFirst = countNodes(firstHead);
		int countSecond = countNodes(secondHead);
		LinkedListNode<Integer> tempFirst = firstHead;
		LinkedListNode<Integer> tempSecond = secondHead;
		if(countFirst > countSecond){
			for(int i = 0; i<(countFirst - countSecond); i++){
				tempFirst = tempFirst.next;
			}
		}
		else{
			for(int i = 0; i<(countSecond - countFirst); i++){
				tempSecond = tempSecond.next;
			}
		}
		while(tempFirst != null && tempSecond != null){
			if(tempSecond == tempFirst){
				return tempFirst.data;
			}
			tempFirst = tempFirst.next;
			tempSecond = tempSecond.next;
		}
		return -1;		
	}

	private static int countNodes(LinkedListNode<Integer> head){
		int count = 0;
		while(head != null){
			count++;
			head = head.next;
		}
		return count;
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
	
	public static void attach(LinkedListNode<Integer> head1 , LinkedListNode<Integer> head2) {
		
		LinkedListNode<Integer> temp1 = head1;
		while(temp1!= null && temp1.next!=null) {
			temp1 = temp1.next;
		}
		LinkedListNode<Integer> temp2 = head2;
		LinkedListNode<Integer> prev = null;
		
		
		while(temp2.next!=null) {
			prev = temp2;
			temp2 = temp2.next;
		}
		if(prev == null) {
			if(temp1.data.equals(head2.data))
			   temp1.next = head2;
		}
		else {
			if(temp2.data.equals(temp1.data))
		        prev.next = temp1;
		}
	}

	public static void main(String[] args) throws IOException {
		
		LinkedListNode<Integer> head1  = takeInput();
		LinkedListNode<Integer> head2  = takeInput();
		LinkedListNode<Integer> head3  = takeInput();
		
		LinkedListNode<Integer> temp = head1;
		while(temp!= null) {
			temp = temp.next;
		}
		
		
		if(head1 != null && head2 != null)
		  attach(head1, head2);
		
		//Create Intersection
		LinkedListNode<Integer> temp1 = head1;
		while(temp1 != null && temp1.next!=null) {
			temp1 = temp1.next;
		}
		
		if(temp1 != null)
		   temp1.next = head3;
		
		int ans = findIntersection2(head1, head2);
		
		System.out.println(ans);
		
	}

}
