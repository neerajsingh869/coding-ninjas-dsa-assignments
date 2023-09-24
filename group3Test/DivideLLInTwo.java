package group3Test;

import java.util.Scanner;
import java.util.ArrayList;

class ListNode<t> {
	t data;
	 ListNode<t> next;
	 ListNode(t data)
	 {
		 this.data=data;
	 }
}

public class DivideLLInTwo {

/*
	 * Write a function that takes one list and divides up its nodes to create two smaller lists A and B. The sub lists should be made from alternating elements in the original list.
Nodes should be in the reverse order of which they occurred in the source list.
Print both linked lists in different lines.
Input format :
Line 1 : Linked list elements of length n (separated by space and terminated by -1)
Output format :
Line 1 : Output Linked List 1 elements (separated by space)
Line 2 : Output Linked List 2 elements (separated by space)
Constraints :
1 <= n <= 10^4
Sample Input :
 8 2 5 9 1 4 3 7 -1
Note : -1 at the end of input is just a terminator representing the end of linked list. This -1 is not part of the linked list. Size of given linked list is 8.
Sample Output :
 3 1 5 8
 7 4 9 2
	 */	
	public static void make2List(ListNode<Integer> head) {
		
		ArrayList<Integer> arr = new ArrayList<>();
		while(head!=null){
			arr.add(head.data) ;
			head = head.next;
		} 
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();

		int x=0;
		for(int i=arr.size()-1 ; i>=0; i--){
			if(x%2==0)arr1.add(arr.get(i));
			else arr2.add(arr.get(i));
			x++;
		}

		for(int i:arr1)System.out.print(i+" ");
		System.out.println();
		for(int i:arr2)System.out.print(i+" ");
		
	}

	static Scanner s=new Scanner(System.in);

	public static ListNode<Integer> createlist(){
	   ListNode<Integer> head=null;
	   ListNode<Integer> rear=null;
	   int data=s.nextInt();
	   while(data!=-1)
	   {
		   ListNode<Integer> newnode=new ListNode<Integer>(data);
		   if(head==null)
		   {
			   head=newnode;
			   rear=head;
		   }
		   else
		   {
			   rear.next=newnode;
			   rear=rear.next;
		   }
		   data=s.nextInt();
	   }
	   return head;
	}

	public static void main(String[] args) {
		ListNode<Integer> head=createlist();
		make2List(head);
	}

}
