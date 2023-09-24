package optionalBinaryTrees;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

 @SuppressWarnings("serial")
class QueueEmptyException extends Exception {
}

class QueueUsingLL<T> {

	class Node<T> {
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public T front() throws QueueEmptyException{
		if(size == 0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}

		return head.data;
	}


	public void enqueue(T element){
		Node<T> newNode = new Node<T>(element);

		if(head == null){
			head = newNode;
			tail = newNode;
		}
		else{
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	public T dequeue() throws QueueEmptyException{
		if(head == null){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		if(head == tail){
			tail = null;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
}


public class InorderTraversalWithoutRecursion {
	
	/*
	 * Given a binary tree, print the inorder traversal of a given tree without using recursion.
	Inorder traversal is: LeftChild Root RightChild
	Input format :
	Elements in the level order form (separated by space)
	(If any node does not have left or right child, take -1 in its place)
	Output Format :
	Inorder traversal, elements separated by space.
	Sample Input:
	1 2 3 4 5 -1 -1 -1 -1 -1 -1
	Sample Output:
	4 2 5 1 3
	Explanation:
	The input tree given to you is:
	                        1
	                      /   \
	                     2     3
	                    / \
	                   4   5
	The inorder traversal of the given tree will be :
	4 2 5 1 3
	 */
	
	// Time complexity -> O(n), Space complexity -> O(h)
	public static void inOrder(BinaryTreeNode<Integer> root) {
        Stack<BinaryTreeNode<Integer>> st = new Stack<>();
        BinaryTreeNode<Integer> temp = root;
        while(temp != null || !st.isEmpty()){
            while(temp != null){
                st.push(temp);
                temp = temp.left;
            }
            BinaryTreeNode<Integer> tempAns = st.peek();
            System.out.print(tempAns.data + " ");
            st.pop();
            temp = tempAns.right;
        }
    }
	
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7 
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}
	
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		inOrder(root);	
	}
}
