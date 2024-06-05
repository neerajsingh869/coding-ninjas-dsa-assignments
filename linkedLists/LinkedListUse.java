package linkedLists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LinkedListUse {
	
	public static Node<Integer> createLinkedList(){
		Node<Integer> n1 = new Node<>(10);
		Node<Integer> n2 = new Node<>(20);
		Node<Integer> n3 = new Node<>(30);
		Node<Integer> n4 = new Node<>(40);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		return n1;
	}
	
	public static Node<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head = null;
		Node<Integer> currTail = head;
		while(data != -1) {
			Node<Integer> newTail = new Node<>(data);
			if(head == null) {
				head = newTail;
			}
			else {
				currTail.next = newTail;
			}
			currTail = newTail;
			data = s.nextInt();
		}
		return head;
	}
	
	// Iterative way to Print Linked List
	public static<T> void printLinkedList(Node<T> head) {
		Node<T> temp = head;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	// Recursive way to Print Linked List
	public static void printLinkedList_recursive(Node<Integer> head) {
		// Base case
		if(head == null) {
			return;
		}
		// Small calculation (IS)
		System.out.print(head.data + " ");
		// Recursive call (IH)
		printLinkedList_recursive(head.next);
	}
	
	public static void printIthNode1(Node<Integer> head, int i){
		Node<Integer> temp = head;
        while(i >= 0 && temp != null){
            if(i == 0){
                System.out.println(temp.data);
                return;
            }
            temp = temp.next;
            i--;
        }
	}
	
	public static void printIthNode2(Node<Integer> head, int i){
		Node<Integer> temp = head;
        int pos = 0;
        while(temp != null && pos < i) {
        	temp = temp.next;
        	pos++;
        }
        if(temp != null) {
        	System.out.println(temp.data);
        }
	}
	
	public static<T> int length(Node<T> head) {
		Node<T> temp = head;
		int ans = 0;
		while(temp != null) {
			ans++;
			temp = temp.next;
		}
		return ans;
	}
	
	/*
	 * You have been given a singly linked list of integers, 
	 * an integer value called 'data' and a position with 
	 * the name 'pos.'
 	 * 
 	 * Write a function to add a node to the list with the 
 	 * 'data' at the specified position, 'pos.'
	 */
	// Iterative way to insert a node in linked list
	public static Node<Integer> insert1(Node<Integer> head, int pos, int data){
		Node<Integer> newNode = new Node<>(data);
        if(pos == 0){
            newNode.next = head;
            head = newNode;
            return head;
        }
        int idx = 0;
        Node<Integer> temp = head;
        while(temp != null){
            if(idx == pos-1){
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
            idx++;
        }
        return head;
	}
	
	public static Node<Integer> insert2(Node<Integer> head, int pos, int data){
		if(head == null){
            return null;
        }
        int idx = 0;
        Node<Integer> newNode = new Node<>(data);
        Node<Integer> curr = null;
        do{
            if(curr == null){
                curr = head;
            }
            else{
                curr = curr.next;
            }
            idx++;
        }while(curr != null && idx < pos);
        if(curr != null){
            if(pos == 0){
                newNode.next = head;
                head = newNode;
            }
            else{
                newNode.next = curr.next;
                curr.next = newNode;
            }
        }
        return head;
	}
	
	// Best approach to insert a node iteratively
	public static Node<Integer> insert3(Node<Integer> head, int pos, int data){
        int idx = 0;
        Node<Integer> newNode = new Node<>(data);
        // To insert at front
        if(pos == 0) {
        	newNode.next = head;
        	return newNode;
        }
        Node<Integer> curr = head;
        Node<Integer> prev = null;
        while(curr != null && idx < pos){
            prev = curr;
            curr = curr.next;
            idx++;
        }
        // To insert at the mid and end
        if(idx == pos){
        	newNode.next = curr;
            prev.next = newNode;
        }
        return head;
	}
	
	// Recursive way to insert a node in linked list
	public static Node<Integer> insert_recursive(Node<Integer> head, int pos, int data){
		// Base case
		if(head == null && pos > 0) {
			return head;
		}
		// Small calculation (IS)
		if(pos == 0) {
			Node<Integer> newNode = new Node<>(data);
			newNode.next = head;
			head = newNode;
			return head;
		}
		// Recursive call (IH)
		Node<Integer> tempHead = insert_recursive(head.next, pos-1, data);
		// Small calculation
		head.next = tempHead;
		return head;
	}
	
	/*
	 * You have been given a linked list of integers. 
	 * Your task is to write a function that deletes a 
	 * node from a given position, 'POS'.
	 */
	// Iterative way to delete a node in linked list
	public static Node<Integer> deleteNode1(Node<Integer> head, int pos) {
        if(head == null || pos < 0){
            return head;
        }
		if(pos == 0){
            return head.next;
        }
        int idx = 0;
        Node<Integer> temp = head;
        while(temp.next!=null && idx < pos-1){
            idx++;
            temp = temp.next;
        }
        if(temp.next != null){
            temp.next = temp.next.next;
        }
        return head;
	}
	
	public static Node<Integer> deleteNode2(Node<Integer> head, int pos) {
		if(head == null){
			return head;
		}
		if(pos == 0){
			return head.next;
		}
		Node<Integer> curr = head;
		Node<Integer> prev = null;
		int idx = 0;
		while(curr != null){
			if(idx == pos){
				prev.next = curr.next;
				break;
			}
			prev = curr;
			curr = curr.next;
			idx++;
		}
		return head;
	}
	
	// Recursive way to delete a node in linked list
	public static Node<Integer> deleteNode_recursive(Node<Integer> head, int pos) {
		// Base case
    	if(head == null){
            return head;
        }
    	// Small Calculation (IS)
        if(pos == 0){
            return head.next;
        }
        // Recursive call (IH) and small calculation
        head.next = deleteNode_recursive(head.next, pos-1);
        return head;
	}
	
	/*
	 * You have been given a singly linked list of integers. 
	 * Write a function that returns the index/position of 
	 * integer data denoted by 'N' (if it exists). Return -1 
	 * otherwise.
	 */
	public static int findNode(Node<Integer> head, int n) {
		int pos = 0;
		Node<Integer> temp = head;
        while(temp != null){
            if(temp.data.equals(n)){
                return pos;
            }
            pos++;
            temp = temp.next;
        }
        return -1;
	}
	
	public static int findNode_recursive(Node<Integer> head, int n) {
		return findNode_recursive(head, 0, n);
	}

	public static int findNode_recursive(Node<Integer> head, int idx, int n){
		if(head == null){
			return -1;
		}
		if(head.data.equals(n)){
			return idx;
		}
		else{
			return  findNode_recursive(head.next, 1+ idx, n);
		}
	}
	
	/*
	 * You have been given a singly linked list of integers 
	 * along with an integer 'N'. Write a function to append
	 * the last 'N' nodes towards the front of the singly linked
	 * list and returns the new head to the list.
	 */
	public static Node<Integer> appendLastNToFirst1(Node<Integer> head, int n) {
        if(head == null || head.next == null || n == 0){
            return head;
        }
        if(n >= length(head)){
            return head;
        }
        Node<Integer> newTail = null;
        Node<Integer> tail = head;
        int idx = 0, pos = length(head) - n - 1;
        while(tail.next != null){
            if(idx == pos){
                newTail = tail;
            }
            idx++;
            tail = tail.next;
        }
        tail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
	}
	
	// Best way (Fast and Slow Pointers)
	public static Node<Integer> appendLastNToFirst2(Node<Integer> head, int n) {
        if(head == null || head.next == null || n == 0){
            return head;
        }
        Node<Integer> newTail = head;	// slow pointer
        Node<Integer> tail = head;		// fast pointer
        for(int i = 0; i<n; i++){
            tail = tail.next;
        }
        while(tail.next != null){
            newTail = newTail.next;
            tail = tail.next;
        }
        tail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
	}
	
	// Better approach
	public static Node<Integer> appendLastNToFirst3(Node<Integer> head, int n) {
		if(head == null){
			return head;
		}
		int m = length(head);
		if(n >= m) {
			return head;
		}
		Node<Integer> newTail = head;
		Node<Integer> tail = head;
		// can also use while loop
		for(int i = 1; i<m-n; i++){
			newTail = newTail.next;
		}
		// can also use while loop
		for(int i = 1; i<m; i++){
			tail = tail.next;
		}
		tail.next = head;
		head = newTail.next;
		newTail.next = null;
		return head;
	}
	
	/*
	 * You have been given a singly linked list of integers where 
	 * the elements are sorted in ascending order. Write a function
	 * that removes the consecutive duplicate values such that the
	 * given list only contains unique elements and returns the
	 * head to the updated list.
	 */
	// Simplest Approach
	public static Node<Integer> removeDuplicates1(Node<Integer> head) {
        if(head == null){
            return head;
        }
        Node<Integer> temp = head;
        while(temp.next != null){
        	// Note that the data is reference of type Integer
            if(temp.data.equals(temp.next.data)){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
	}
	
	public static Node<Integer> removeDuplicates2(Node<Integer> head) {
		Node<Integer> temp = head;
        while(temp != null && temp.next != null){
            if(temp.data.equals(temp.next.data)){
            	Node<Integer> temp_dash = temp;
                while(temp.next != null && temp.data.equals(temp.next.data)){
                    temp = temp.next;
                }
                temp_dash.next = temp.next;
                temp = temp.next;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
	}
	
	public static Node<Integer> removeDuplicates3(Node<Integer> head) {
		if(head == null){
			return head;
		}
		Node<Integer> temp1 = head;
		while(temp1 != null){
			Node<Integer> temp2 = temp1;
			while(temp2 != null && temp2.data.equals(temp1.data)){
				temp2 = temp2.next;
			}
			temp1.next = temp2;
			temp1 = temp2;
		}
		return head;
	}
	
	// Better approach
	public static Node<Integer> removeDuplicates4(Node<Integer> head) {
		if (head == null) return head;
		
		Node<Integer> curr = head;
		// fon -> first ocurrence node
		Node<Integer> fon = curr;

		while (curr != null) {
			if (curr.next != null && !curr.next.data.equals(curr.data)) {
				fon.next = curr.next;
				curr = curr.next;
				fon = curr;
			} else {
				curr = curr.next;
			}
		}

		fon.next = null;
		return head;
	}
	
	// Best approach
	public static Node<Integer> removeDuplicates5(Node<Integer> head) {
		if (head == null) return head;
		
		Node<Integer> curr = head;

		while (curr != null) {
			if (curr.next != null && curr.next.data.equals(curr.data)) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}

		return head;
	}
	
	/*
	 * You have been given a singly linked list of integers. 
	 * Write a function to print the list in a reverse order.
	 */
	public static void printReverse(Node<Integer> root) {
		//Your code goes here
        if(root == null){
            return;
        }
        printReverse(root.next);
        System.out.print(root.data + " ");
	}
	
	/*
	 * You have been given a head to a singly linked list of 
	 * integers. Write a function check to whether the list 
	 * given is a 'Palindrome' or not.
	 */
	// Time complexity -> O(n*n), Space complexity -> O(1)
	public static boolean isPalindrome1(Node<Integer> head) {
        int n = length(head);
        Node<Integer> temp_left = head;
        for(int i = 0; i<n/2; i++){
        	Node<Integer> temp_right = head;
            for(int j = 0; j<n - i-1; j++){
                temp_right = temp_right.next;
            }
            if(!temp_left.data.equals(temp_right.data)){
                return false;
            }
            temp_left = temp_left.next;
        }
        return true;
	}
	
	// Another way to check if the ll is palindromic or not
	// Time complexity -> O(n), Space complexity -> O(n)
	public static boolean isPalindrome2(Node<Integer> head) {
		Node<Integer> reverseHead = createReverseLL(head);
		Node<Integer> temp1 = reverseHead;
		Node<Integer> temp2 = head;
		while(temp1 != null && temp2 != null){
			if(!temp1.data.equals(temp2.data)){
				return false;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		if(temp1 == null && temp2 == null){
			return true;
		}
		return false;
	}
	
	public static Node<Integer> createReverseLL(Node<Integer> head){
		Node<Integer> newHead = null;
		Node<Integer> temp = head;
		while(temp != null){
			Node<Integer> newNode = new Node<>(temp.data);
			newNode.next = newHead;
			newHead = newNode;
			temp = temp.next;
		}
		return newHead;
    }
	
	// Another way to check if the ll is palindromic or not
	// Time complexity -> O(n), Space complexity -> O(1)
	public static boolean isPalindrome3(Node<Integer> head) {
		Node<Integer> head2 = splitLL(head);
        head2 = reverseLL1(head2);
        while(head != null){
            if(!head.data.equals(head2.data)){
                return false;
            }
            head2 = head2.next;
            head = head.next;
        }
        // In the last, rejoin the two split LL
        return true;
	}
	
	public static Node<Integer> splitLL(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        int pos = length(head)/2 - 1, idx = 0;
        Node<Integer> head2 = null;
        while(head != null){
            if(idx == pos){
                head2 = head.next;
                head.next = null;
                break;
            }
            idx++;
            head = head.next;
        }
        return head2;
    }
    
    public static Node<Integer> reverseLL1(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> prev = null;
        Node<Integer> curr = head;
        Node<Integer> fwd = head.next;
        while(curr.next != null){
            curr.next = prev;
            prev = curr;
            curr = fwd;
            fwd = fwd.next;
        }
        curr.next = prev;
        return curr;
    }
	
	// Best Approach to check if the ll is palindromic or not
    // Time complexity -> O(n), Space complexity -> O(1)
	public static boolean isPalindrome4(Node<Integer> head) {
		if(head == null || head.next == null){
			return true;	
        }
        // 1. Find the head of second sublist
		Node<Integer> fast = head;
		Node<Integer> slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node<Integer> secondHead = slow.next;
        slow.next = null;
        // 2. Reverse the second sublist
        secondHead = reverseLL2(secondHead);
        // 3. Compare the two sublist
        Node<Integer> firstSubList = head;
        Node<Integer> secondSubList = secondHead;
        while(secondSubList != null){
            if(!secondSubList.data.equals(firstSubList.data)){
                return false;
            }
            firstSubList = firstSubList.next;
            secondSubList = secondSubList.next;
        }
        // 4. Rejoin both the sublist to get the original LL
        firstSubList = head;
        secondSubList = reverseLL2(secondHead);
        while(firstSubList.next != null){
            firstSubList = firstSubList.next;
        }
        firstSubList.next = secondSubList;
        return true;
	}
	
	// Iterative way to reverse a Linked List
	public static Node<Integer> reverseLL2(Node<Integer> head){
		Node<Integer> prev = null;
		Node<Integer> curr = head;
		Node<Integer> fwd = head; // can also be null
        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
	
	// Time Complexity = O(n), Space Complexity -> O(n)
	public static boolean isPalindrome5(Node<Integer> head) {
		Node<Integer> head1 = createDublicateLL(head);
		Node<Integer> head2 = reverseLL(head);
		while(head1 != null && head2 != null){
			if(!head1.data.equals(head2.data)){
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return true;
	}

	public static Node<Integer> createDublicateLL(Node<Integer> head){
		Node<Integer> newHead = null;
		Node<Integer> newTail = null;
		while(head != null){
			if(newHead == null){
				newHead = new Node<>(head.data);
				newTail = newHead;
			}
			else{
				newTail.next = new Node<>(head.data);
				newTail = newTail.next;
			}
			head = head.next;
		}
		return newHead;
	}

	public static Node<Integer> reverseLL(Node<Integer> head){
		if(head == null  || head.next == null){
			return head;
		}
		Node<Integer> temp = reverseLL(head.next);
		head.next.next = head;
		head.next = null;
		return  temp;
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static boolean isPalindrome6(Node<Integer> head) {
		String str = "";
		String revStr = "";
		Node<Integer> temp = head;
		while(temp != null){
			str += temp.data;
			revStr = temp.data + revStr;
			temp = temp.next;
		}
		if(revStr.equals(str)){
			return true;
		}
		return false;
	}
	
	// Recursive way 1 to reverse a linked list (Time complexity = O(n^2))
	public static Node<Integer> findTail(Node<Integer> head){
        if(head == null){
            return head;
        }
        Node<Integer> tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        return tail;
    }

	public static Node<Integer> reverseLinkedList_recursive1(Node<Integer> head) {
		if(head == null || head.next == null){
            return head;
        }
		Node<Integer> newHead = reverseLinkedList_recursive1(head.next);
		Node<Integer> tail = findTail(newHead);
        tail.next = head;
        head.next = null;
        head = newHead;
        return head;
	}
	
	// Recursive way 2 to reverse a linked list (Time complexity = O(n))
	public static Node<Integer> reverseLinkedList_recursive2(Node<Integer> curr, 
															Node<Integer> prev, 
															Node<Integer> fwd){
        // Base case
        if(curr == null){
            return prev;
        }
        // Small calculations (IS)
        fwd = curr.next;
        curr.next = prev;
        prev = curr;
        curr = fwd;
        // Recursive call (IH)
        return reverseLinkedList_recursive2(curr, prev, fwd);
    }

	public static Node<Integer> reverseLinkedList_recursive2(Node<Integer> head) {
		return reverseLinkedList_recursive2(head, null, null);
	}
	
	// Recursive way 3 (Simplest way) to reverse a linked list (Time complexity = O(n))
	public static Node<Integer> reverseLinkedList_recursive3(Node<Integer> head) {
		// Base case
		if(head == null || head.next == null){
            return head;
        }
		// Recursive call (IH)
		Node<Integer> newHead = reverseLinkedList_recursive3(head.next);
		// Small calculations (IS)
        head.next.next = head;
        head.next = null;
        head = newHead;
        return head;
	}
	
	// Recursive way 4 (Very beautiful way) to raver a linked list(Time complexity = O(n))
	public static DoubleNode reverseLinkedList_recursive4(Node<Integer> head){
		DoubleNode ans;
		if(head == null || head.next == null) {
			ans = new DoubleNode(head, head);
			return ans;
		}
		DoubleNode smallAns = reverseLinkedList_recursive4(head.next);
		smallAns.tail.next = head;
        head.next = null;
        ans = new DoubleNode(smallAns.head, head);
        return ans;
	}
	
	public static Node<Integer> reverseLinkedList_recursive4_helper(Node<Integer> head){
		DoubleNode ans = reverseLinkedList_recursive4(head);
		return ans.head;
	}
	
	/*
	 * For a given singly linked list of integers, find and 
	 * return the node present at the middle of the list.
	 */
	public static Node<Integer> midPoint(Node<Integer> head) {
        if(head == null){
            return head;
        }
        Node<Integer> fast = head.next;
        Node<Integer> slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
	
	/*
	 * Write a function to merge them in such a way that the resulting 
	 * singly linked list is also sorted(in ascending order) and return 
	 * the new head to the list.
	 */
	// Created new Linked List. Time Complexity -> O(n+m), Space Complexity -> O(n+m)
	public static Node<Integer> mergeTwoSortedLinkedLists1(Node<Integer> head1, Node<Integer> head2) {
		Node<Integer> newHead = null;
		Node<Integer> tail = newHead;
        while(head1 != null && head2 != null){
            if(Integer.compare(head1.data, head2.data) <= 0){
            	Node<Integer> temp = new Node<>(head1.data);
                if(newHead == null){
                    newHead = temp;
                }
                else{
                    tail.next = temp;
                }
                tail = temp;
                head1 = head1.next;
            }
            else{
            	Node<Integer> temp = new Node<>(head2.data);
                if(newHead == null){
                    newHead = temp;
                }
                else{
                    tail.next = temp;
                }
                tail = temp;
                head2 = head2.next;
            }
        }
        while(head1 != null){
        	Node<Integer> temp = new Node<>(head1.data);
            if(newHead == null){
                newHead = temp;
            }
            else{
                tail.next = temp;
            }
            tail = temp;
            head1 = head1.next;
        }
        while(head2 != null){
        	Node<Integer> temp = new Node<>(head2.data);
        	if(newHead == null){
        	    newHead = temp;
        	}
        	else{
        	    tail.next = temp;
        	}
        	tail = temp;
        	head2 = head2.next;
        }
        return newHead;
    }
	
	// Another way of merging two sorted ll (Time complexity = O(n+m) 
	// and space complexity = O(1))
	public static Node<Integer> mergeTwoSortedLinkedLists2(Node<Integer> head1, Node<Integer> head2) {
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        Node<Integer> newHead = null;
        /*
         * Here I did not made tail, therefore I need to find the
         * tail again and again to establish the right connection
         */
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                if(newHead == null){
                    newHead = head1;
                }
                while(head1.next != null && head1.next.data <= head2.data){
                	head1 = head1.next;
            	}
                Node<Integer> temp = head1.next;
                head1.next = head2;
                head1 = temp;
            }
            else{
                if(newHead == null){
                    newHead = head2;
                }
                while(head2.next != null && head2.next.data < head1.data){
                	head2 = head2.next;
            	}
                Node<Integer> temp = head2.next;
                head2.next = head1;
                head2 = temp;
            }
        }
        return newHead;
    }
	
	// Another way of merging two sorted ll (Time complexity = O(n+m) 
	// and space complexity = O(1))
	public static Node<Integer> mergeTwoSortedLinkedLists3(Node<Integer> head1, Node<Integer> head2) {
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        Node<Integer> newHead = null;
        Node<Integer> tail = newHead;
        while(head1!=null && head2!=null){
            if(Integer.compare(head1.data, head2.data) <= 0){
                if(newHead == null){
                    newHead = head1;
                }
                else{
                    tail.next = head1;
                }
                tail = head1;
                head1 = head1.next;
            }
            else{
                if(newHead == null){
                    newHead = head2;
                }
                else{
                    tail.next = head2;
                }
                tail = head2;
                head2 = head2.next;
            }
        }
        if(head1 == null){
            tail.next = head2;
        }
        else{
            tail.next = head1;
        }
        return newHead;
	}
	
	// Another version of above function (Best way)
	public static Node<Integer> mergeTwoSortedLinkedLists4(Node<Integer> head1, Node<Integer> head2) {
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        Node<Integer> newHead = null;
        Node<Integer> tail = newHead;
        if(head1.data <= head2.data){
            newHead = head1;
            tail = head1;
            head1 = head1.next;
        }
        else{
            newHead = head2;
            tail = head2;
            head2 = head2.next;
        }
        while(head1!=null && head2!=null){
            if(head1.data <= head2.data){
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            }
            else{
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        if(head1 == null){
            tail.next = head2;
        }
        if(head2 == null){
            tail.next = head1;
        }
        return newHead;
    }
	
	public static Node<Integer> mergeSort(Node<Integer> head){
		// Base case
		if(head == null || head.next == null) {
			return head;
		}
		// Split the LL into two sublists and then call mergeSort
		// on them
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Node<Integer> firstSublistHead = head;
		Node<Integer> secondSublistHead = slow.next;
		slow.next = null;
		// After that, call mergeSort function to sort these two
		// unsorted sublists
		Node<Integer> firstSortedHead = mergeSort(firstSublistHead);
		Node<Integer> secondSortedHead = mergeSort(secondSublistHead);
		// Call merge function to merge these two sorted sublists
		Node<Integer> finalSortedHead = mergeTwoSortedLinkedLists3(firstSortedHead, secondSortedHead);
		return finalSortedHead;
	}
	
	// Bubble sort for Linked List
	public static Node<Integer> bubbleSort1(Node<Integer> head) {
		int n = length(head);
        for(int i = 0; i<n-1; i++){
        	Node<Integer> prev = null, curr = head;
            for(int j = 0; j<n-i-1; j++){
                if(curr.data <= curr.next.data){
                    prev = curr;
                    curr = curr.next;
                }
                else{
                	Node<Integer> newPrev = curr.next;
                    curr.next = newPrev.next;
                    newPrev.next = curr;
                    if(j == 0){
                        head = newPrev;
                    }
                    else{
                        prev.next = newPrev;
                    }
                    prev = newPrev;
                }
            }
        }
        return head;
	}
	
	public static Node<Integer> bubbleSort2(Node<Integer> head) {
		int n = length(head);
		for(int i = 1; i<n; i++){
			Node<Integer> prev = null;
			Node<Integer> curr = head;
			Node<Integer> fwd = head;
			while(fwd != null && fwd.next != null){
				fwd = fwd.next;
				if(curr.data > fwd.data){
					curr.next = fwd.next;
					fwd.next = curr;
					if(prev == null){
						head = fwd;
					}
					else{
						prev.next = fwd;
					}
					prev = fwd;
					fwd = curr;
				}
				else{
					prev = curr;
					curr = fwd;
				}
			}
		}
		return head;
	}
	
	// Simple approach
	public static Node<Integer> bubbleSort3(Node<Integer> head) {
		if(head == null || head.next == null) return head;
		Node<Integer> iterTemp = head;
		while(iterTemp != null){
			Node<Integer> curr = head, fwd = curr;
			while(curr.next != null){
				fwd = curr.next;
				if(Integer.compare(fwd.data, curr.data) <= 0){
					int temp = fwd.data;
					fwd.data = curr.data;
					curr.data = temp;
				}
				curr = fwd;
			}
			iterTemp = iterTemp.next;
		}
		return head;
	}
	
	/*
	 * For a given singly linked list of integers, arrange the 
	 * elements such that all the even numbers are placed after 
	 * the odd numbers. The relative order of the odd and even 
	 * terms should remain unchanged.
	 */
	// Solving without splitting the linked list into two parts
	public static Node<Integer> evenAfterOdd1(Node<Integer> head) {
		Node<Integer> curr = head, evenTail = null, oddTail = null;
        while(curr!=null){
            if(curr.data%2 == 0){
                evenTail = curr;
                curr = curr.next;
            }
            else{
                if(oddTail == null && evenTail == null){
                    oddTail = curr;
                    head = curr;
                    curr = curr.next;
                }
                else if(oddTail == null){
                    evenTail.next = curr.next;
                    curr.next = head;
                    head = curr;
                    curr = evenTail.next;
                    oddTail = head;
                }
                else if(evenTail == null){
                    oddTail = curr;
                    curr = curr.next;
                }
                else{
                	Node<Integer> evenHead = oddTail.next;
                    oddTail.next = curr;
                    evenTail.next = curr.next;
                    curr.next = evenHead;
                    oddTail = curr;
                    curr = evenTail.next;
                }
            }
        }
        return head;
	}
	
	// Smart way to solve the above problem (First splitting the LL into 
	// even part and odd part, then linking these two in desired fashion)
	public static Node<Integer> evenAfterOdd2(Node<Integer> head) {
		Node<Integer> oddHead = null, evenHead = null, oddTail = null, evenTail = null;
		Node<Integer> curr = head;
        while(curr!=null){
            if(curr.data %2 == 0){
                if(evenHead == null){
                    evenHead = curr;
                    evenTail = curr;
                }
                else{
                    evenTail.next = curr;
                    evenTail = curr;
                }
            }
            else{
                if(oddHead == null){
                    oddHead = curr;
                    oddTail = curr;
                }
                else{
                    oddTail.next = curr;
                    oddTail = curr;
                }
            }
            curr = curr.next;
        }
        if(oddHead == null){
            return evenHead;
        }
        else{
        	oddTail.next = evenHead;
        }
        if(evenHead != null) {
        	evenTail.next = null;
        }
        return oddHead;
	}
	
	public static Node<Integer> evenAfterOdd3(Node<Integer> head) {
		Node<Integer> oddHead = null;
        Node<Integer> evenHead = null;
        Node<Integer> oddTail = null;
        Node<Integer> evenTail = null;
        Node<Integer> curr = head;

        while (curr != null) {
            Node<Integer> temp = curr.next;
            
            if (curr.data % 2 != 0) {
                if (oddHead == null) {
                    oddHead = curr;
                    oddTail = oddHead;
                } else {
                    oddTail.next = curr;
                    oddTail = curr;
                }

                if (evenTail != null) {
                    curr.next = evenHead;
                    evenTail.next = temp;
                }
            } else {
                if (evenHead == null) {
                    evenHead = curr;
                    evenTail = evenHead;
                } else {
                    evenTail.next = curr;
                    evenTail = curr;
                }
            }

            curr = temp;
        }

        return oddHead == null ? evenHead : oddHead;
	}
	
	/*
	 * Function to delete N nodes after every M nodes.
	 */
	public static Node<Integer> skipMdeleteN1(Node<Integer> head, int M, int N) {
		if(head == null || N == 0) return head;
        if(M == 0) return null;
		Node<Integer> newTail = head, curr = head;
        while(curr != null){
            // skip M nodes
            for(int i = 1; i<M && curr.next != null; i++){
                curr = curr.next;
            }
            newTail = curr;
            // delete N nodes
            for(int i = 1; i<=N+1 && curr != null; i++){
                curr = curr.next;
            }
            if(curr == null){
                newTail.next = curr;
                return head;
            }
            newTail.next = curr;
            newTail = curr;
        }
        return head;
	}
	
	// Another approach to solve the above problem
	public static Node<Integer> skipMdeleteN2(Node<Integer> head, int M, int N) {
		if(head == null || N == 0) return head;
        if(M == 0) return null;
        Node<Integer> curr = head, tail = null;
        while(curr != null){
            int take = 0, skip = 0;
            while(curr != null && take < M){
                if(tail == null){
                	tail = curr;
                }
                else{
                	tail.next = curr;
                	tail = curr;
                }
                curr = curr.next;
                take++;
            }
            while(curr != null && skip < N){
                curr = curr.next;
                skip++;
            }
        }
        tail.next = null;
        return head;
	}
	
	// Average solution (Above 2 are better as they are short & concise)
	public static Node<Integer> skipMdeleteN3(Node<Integer> head, int M, int N) {
		if(head == null || N == 0) return head;
        if(M == 0) return null;
        Node<Integer> curr = head;
        while(curr != null){
        	Node<Integer> lastM = curr;
            int m = 1;
            while(curr != null && m < M){
                curr = curr.next;
                m++;
            }
            if(curr == null){
                break;
            }
            lastM = curr;
            curr = curr.next;
            int n = 1;
            while(curr != null && n < N){
                curr = curr.next;
                n++;
            }
            if(curr == null){
                lastM.next = null;
                break;
            }
            curr = curr.next;
            lastM.next = curr;
        }
        return head;
	}
	
	/*
	 * Function to Swap the nodes that are present at the 'i-th' and 'j-th' positions
	 */
	public static Node<Integer> swapNodes1(Node<Integer> head, int i, int j) {
        if(head == null || i == j){
            return head;
        }
		int idx = 0;
		Node<Integer> curr = head, prev1 = null, prev2 = null;
		Node<Integer> node1 = null, node2 = null, prev = null;
        while(curr!=null){
            if(idx == i){
                prev1 = prev;
                node1 = curr;
            }
            if(idx == j){
                prev2 = prev;
                node2 = curr;
            }
            prev = curr;
            curr = curr.next;
            idx++;
        }
        if(prev1 != null){
            prev1.next = node2;
        }
        else{
            head = node2;
        }
        if(prev2 != null){
            prev2.next = node1;
        }
        else{
            head = node1;
        }
        Node<Integer> fwd1 = node1.next, fwd2 = node2.next;
        node1.next = fwd2;
        node2.next = fwd1;
        return head;
	}
	
	public static Node<Integer> swapNodes2(Node<Integer> head, int i, int j) {
		if(head == null || i == j){
            return head;
        }
        if(i > j){
            i = i + j;
            j = i - j;
            i = i - j;
        }
        Node<Integer> prevI = null, prevJ = null;
        Node<Integer> currI = head, currJ = head;
        Node<Integer> temp = head;
        while(j - 1 >= 0){
            if(i - 1 == 0){
                prevI = temp;
                currI = temp.next;
            }
            if(j - 1 == 0){
                prevJ = temp;
                currJ = temp.next;
            }
            i--;
            j--;
            temp = temp.next;
        }
        Node<Integer> fwdI = currI.next, fwdJ = currJ.next;
        if(prevI == null){
            // i.e j == i + 1
            if(prevJ == currI){
                currJ.next = currI;
                currI.next = fwdJ;
                head = currJ;
            }
            else{
                currJ.next = fwdI;
                prevJ.next = currI;
                currI.next = fwdJ;
                head = currJ;
            }
        }
        else{
            // i.e j == i + 1
            if(prevJ == currI){
                prevI.next = currJ;
                currJ.next = currI;
                currI.next = fwdJ;
            }
            else{
                prevI.next = currJ;
                currJ.next = fwdI;
                prevJ.next = currI;
                currI.next = fwdJ;
            }
        }
        return head;
	}
	
	/*
	 * Given a singly linked list of integers, reverse the nodes 
	 * of the linked list 'k' at a time and return its modified list.
	 * (k<=length of LL)
	 * Time complexity = O(n) {T(n) = T(n-k) + O(k)}
	 * Space complexity = O(n/k)
	 */
	public static Node<Integer> kReverse1(Node<Integer> head, int k) {
		if(head == null){
            return null;
        }
		Node<Integer> curr = head;
        int idx = 0;
        while(curr.next != null && idx<k-1){
            curr = curr.next;
            idx++;
        }
        Node<Integer> tempHead = kReverse1(curr.next, k);
        curr.next = null;
        Node<Integer> newHead = reverseLL2(head);
        head.next =tempHead;
        return newHead;
	}
	
	// Another way of solving above problem
	public static Node<Integer> kReverse2(Node<Integer> head, int k) {
		if(head == null){
            return null;
        }
		Node<Integer> curr = head;
        int idx = 0;
        while(curr.next != null && idx<k-1){
            curr = curr.next;
            idx++;
        }
        Node<Integer> newCurr = curr.next;
        curr.next = null;
        Node<Integer> newHead = reverseLL2(head);
        Node<Integer> tempHead = kReverse2(newCurr, k);
        head.next =tempHead;
        return newHead;
	}
	
	// Another way of solving the above problem (this time without
	// using reverse function) -> Best Approach
	// Time and space complexity are same.
	public static Node<Integer> kReverse3(Node<Integer> head, int k) {
		if(head == null || k == 0) return head;
        Node<Integer> prev = null, curr = head, fwd = head;
        int i = 0;
        while(curr!=null && i<k){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
            i++;
        }
        head.next = kReverse3(curr, k);
        return prev;
	}
	
	// Best approach to solve
	// Time complexity -> O(n), Space complexity -> O(1)
	public static Node<Integer> kReverse4(Node<Integer> head, int k) {
		if (head == null || head.next == null || k == 0 || k == 1) return head;

        Node<Integer> curr = head;
        Node<Integer> prev = null;
        Node<Integer> prevTail = null;
        Node<Integer> currHead = curr;

        while (curr != null) {
            int i = 0;
            for (; i < k && curr != null; i++) {
                Node<Integer> temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            if (prevTail == null) {
                head = prev;
            }

            currHead.next = curr;
            if (prevTail != null) {
                prevTail.next = prev;
            }
            prevTail = currHead;
            currHead = curr;
            prev = null;
        }

        return head;
	}
	
	/*
	 * Given a large number represented in the form of a linked list. 
	 * Write code to increment the number by 1 in-place(i.e. without 
	 * using extra space).
	 * Time complexity = O(n^2) and Space complexity = O(1)
	 */
	public static Node<Integer> nextLargeNumber1(Node<Integer> head) {
		// Initially take carry as 1 as we have to add 1
		int n = length(head), carry = 1;
        for(int i = 0; i<n; i++){
        	Node<Integer> curr = head;
            for(int j = 0; j<n-1-i; j++){
                curr = curr.next;
            }
            int newCarry = (curr.data+carry)/10;
            curr.data = (curr.data+carry)%10; 
            carry = newCarry;
        }
        if(carry == 1){
        	Node<Integer> newHead = new Node<>(carry);
            newHead.next = head;
            return newHead;
        }
        return head;
	}
	
	// Better way to solve above problem
	// Time complexity = O(n) and Space complexity = O(1)
	public static Node<Integer> nextLargeNumber2(Node<Integer> head) {
		Node<Integer> newHead = reverseLL2(head);
    	int carry = 1;
    	Node<Integer> curr = newHead, tail = null;
        while(curr!=null){
            int newCarry = (curr.data + carry)/10;
            curr.data = (curr.data + carry)%10;
            carry = newCarry;
            tail = curr;
            curr = curr.next;
        }
        if(carry == 1){
        	Node<Integer> newTail = new Node<>(carry);
            tail.next = newTail;
        }
        return reverseLL2(newHead);
	}
	
	/*
	 * Given a singly linked list, remove the nth node from the end 
	 * of the list and return its head.
	 */
	// Time complexity -> O(n), Space complexity -> O(1)
	public static Node<Integer> removeNthLastNode(Node<Integer> head, int n) {
		// Point two pointers, right and left, at head.
		Node<Integer> right = head;
		Node<Integer> left = head;

	    // Move right pointer n elements away from the left pointer.
	    for (int i = 0; i < n; i++) {
	      right = right.next;
	    }

	    // Removal of the head node.
	    if (right == null) {
	      return head.next;
	    }

	    // Move both pointers until right pointer reaches the last node.
	    while (right.next != null) {
	      right = right.next;
	      left = left.next;
	    }

	    // At this point, left pointer points to (n-1)th element.
	    // So link it to next to next element of left.
	    left.next = left.next.next;

	    return head;
    }
	
	// Main function to check the correctness of above functions
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static Node<Integer> takeInput1() throws IOException {
        Node<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            Node<Integer> newNode = new Node<Integer>(data);
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
    
    public static void print(Node<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            Node<Integer> head = takeInput1(); 

            boolean ans = isPalindrome1(head);
            System.out.println(ans);

            t -= 1;

        }
        
    }

}
