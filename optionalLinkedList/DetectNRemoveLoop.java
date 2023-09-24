package optionalLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class NodeDNR {
	  int data;
	  NodeDNR next;

	  NodeDNR(int data) {
	    this.data = data;
	    this.next = null;
	  }
}

public class DetectNRemoveLoop {
	
	/*
	 * Given a singly linked list, you have to detect the loop and remove the loop from the linked list, if present. You have to make changes in the given linked list itself and return the updated linked list.
Expected Complexity: Try doing it in O(n) time complexity and O(1) space complexity. Here, n is the number of nodes in the linked list.
Input format:
The first line of input contains two values: the number of nodes in the linked list and the value of the kth node from which the last node connects to form the loop while the second line of input contains the given linked list.
The value of k should be greater than or equal to 0 and less than equal to n. For, k equal to 0, there is no loop present in the linked list and for k equal to n, the last node is connected to itself to form the cycle.
Output Format:
The only output line contains the linked list after removing the loop if present.
Constraints:
1 <= N <= 100000.
1 <= ‘VAL’ <= 1000 .  

Time limit: 1 sec
Sample Input:
6 2
1 2 3 4 5 6 
Sample Output:
1 2 3 4 5 6
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static NodeDNR removeLoop(NodeDNR head) {
	    if(head == null){
	      return head;
	    }
	    NodeDNR fast = head, slow = head;
	    // Cycle detection Algorithm
	    boolean loopFound = false;
	    while(fast != null && fast.next != null){
	      fast = fast.next.next;
	      slow = slow.next;
	      if(fast == slow){
	        loopFound = true;
	        break;
	      }
	    }
	    if(!loopFound){
	      return head;
	    }
	    fast = head;
	    // Finding Starting point of Loop
	    while(fast != slow){
	      fast = fast.next;
	      slow = slow.next;
	    }
	    fast = slow;
	    // Finding last NodeDNR of Loop
	    while(fast.next != slow){
	      fast = fast.next;
	    }
	    // Removing Loop
	    fast.next = null;
	    return head;
	  }
	
	public static boolean loopChecker(NodeDNR head){

	    if (head == null || head.next == null) {
	        return false;  
	    }

	    //  Slow Pointer - This will be incremented by 1 NodeDNRs
	    NodeDNR slow = head;  
	    
	    // Fast Pointer  - This will be incremented by 2 NodeDNRs
	    NodeDNR fast = head; 
	    
	    while (true){

	        // We reached the end of the List and haven't found any Cycle
	        if (fast == null || fast.next == null) {
	            return false;  
	        }

	        slow = slow.next;
	        fast = fast.next.next;
	        if (slow == fast){
	            return true;
	        }
	    }
	}

	public static void print(NodeDNR head) 
	{ 
	    NodeDNR NodeDNR = head;

	    if(loopChecker(head)){
	    	System.out.println("Cycle exists");
	    }else{
	        while (NodeDNR != null) { 
	        	System.out.print(NodeDNR.data + " ");
	            NodeDNR = NodeDNR.next; 
	        }
	        System.out.println();
	    } 
	}

	public static NodeDNR makeList(ArrayList<Integer> arr , int k){

	    NodeDNR head = new NodeDNR(arr.get(0));
	    k = k - 1;
	    NodeDNR cur = head;
	    NodeDNR temp  = null;

	    if (k == 0){
	        temp = head;  
	    }

	    for (int i = 1 ; i < arr.size(); i++){
	        cur.next = new NodeDNR(arr.get(i));
	        cur = cur.next;
	        
	        if (i == k)
	            temp = cur;
	    }

	    if (temp != null)
	        cur.next = temp;
	    
	    return head;
	}
	
    private static int n,k;
    private static ArrayList<Integer> arr;

    private static void takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []data;
        data = br.readLine().trim().split(" ");
        n = Integer.parseInt(data[0]);
        k = Integer.parseInt(data[1]);
        arr = new ArrayList<Integer>(n);
        data = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {                  
                arr.add(Integer.parseInt(data[i]));
        }

    }

    private static void executeAndPrintOutput() {
        	NodeDNR head = makeList(arr, k);
            NodeDNR ans = removeLoop(head);
            print(ans);
    }

    public static void main(String[] args) throws IOException {
        takeInput();
        executeAndPrintOutput();
    }

}
