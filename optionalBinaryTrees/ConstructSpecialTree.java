package optionalBinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructSpecialTree {
	
	/*
	 * You are given an array(preor) representing preorder traversal of a special binary tree where each node of this binary tree has either 0 or 2 children. One more array(preorLN) is given to you to represent if the current node is the leaf node or not with values "L" or "N" respectively. You have to write a function to construct this special tree and return the root of this tree.
Note: No need to print the tree. The printing of this special tree is already handled.
Input Format:
The first line of input contains the number of nodes present in the tree. The following line of input contains space-separated elements of the array preor. And the last line of input contains space-separated elements of the array preorLN.
Output Format:
The output contains the constructed special tree printed in the level-wise order. For printing a node with data N, you need to follow the exact format -
N:L:x, R:y
where N is data of any node present in the binary tree. x and y are the values of the left and right child of node N. Print -1. if any child is null.
Sample Input:
5
10 30 20 5 15
N N L L L
Sample Output:
10:L:30,R:15
30:L:20,R:5
15:L:-1,R:-1
Explanation:
The input tree given is:
       10
      /  \
     30   15
    /  \
  20    5
	 */
	// Time Complexity -> O(n), Space Complexity -> O(h)
	private static int start = 0;
    public static BinaryTreeNode<Integer> specialtree(int[] preor, char[] preorLN, int n) {
      if(start >= n){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preor[start]);
        char currNodeLN = preorLN[start];
        start++;
        if(currNodeLN == 'N'){
        
            root.left = specialtree(preor, preorLN, n);
            root.right = specialtree(preor, preorLN, n);
        }
        return root;
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
		
		public static void print(BinaryTreeNode<Integer> root) {
			if(root == null) return;
			Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
			q.add(root);
	  		while(!q.isEmpty()) {
			  BinaryTreeNode<Integer> node = q.poll();
			  
	          if(node == null) {
	            System.out.println();
	         	if(!q.isEmpty()) q.add(null);
	          }
	          else {
	            System.out.print(node.data + ":L:");
	            if(node.left != null) {
				  	q.add(node.left);
				  	System.out.print(node.left.data + ",");
	            }
	            else {
					System.out.print("-1,");
				}
				System.out.print("R:");
	            if(node.right != null) {
				  	q.add(node.right);
				  	System.out.println(node.right.data);
	          	}
	            else {
					System.out.println("-1");
	            }
	          }
	    	}
		}
		
		public static void main(String[] args) {
			int n = s.nextInt();
			int[] preor = new int[n];
		    for(int i = 0; i < n; ++i) { 
				preor[i] = s.nextInt();
			}
			char[] preorLN = new char[n];
			for(int i = 0; i < n; ++i) {
				preorLN[i] = s.next().charAt(0);
			}
			BinaryTreeNode<Integer> root = specialtree(preor, preorLN, n);
			print(root);
		}

}
