package fullTest2;

import java.util.*;
import java.lang.*;
class Node{
    int data;
    Node next;
    Node (int key)
    {
        data=key;
        next=null;
    }
}

public class ReverseLL {
	
	/*
	 * Given a linked list of size N. You need to reverse every k nodes (where k is an input to the function) in the linked list.
Input:
First line contains length of linked list and next line contains the linked list elements.
Output:
Single line of output which contains the linked list with every k group elements reversed.
Example:
Input:
8 1 2 2 4 5 6 7 8 4

Output:
4 2 2 1 8 7 6 5

Explanation:
Since, k = 4. So, we have to reverse every group of two elements. Modified linked list is as 4, 2, 2, 1, 8, 7, 6, 5.
	 */
	
	public static Node reverse(Node head, int k)
    {
        //Your code here
        //Make change in the linked list only
        //Return the head of the new Linked list
        return null;
     }
	
	static Node head;
    public static void main (String[] args) {
        Scanner s=new Scanner (System.in);
        int n=s.nextInt();
        int a=s.nextInt();
        Node head=new Node(a);
        Node prev=head;
        for(int i=0;i<n-1;i++)
        {
            a=s.nextInt();
            Node newnode=new Node(a);
            prev.next=newnode;
            prev=newnode;
        }
        int k=s.nextInt();
        Node ans=reverse(head,k);
        prev=ans;
        for(int i=0;i<n;i++)
        {
            System.out.print(prev.data+" ");
            prev=prev.next;
        }
        
    }

}
