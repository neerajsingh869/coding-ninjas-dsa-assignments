package optionalBinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AncestorMatrixFromBinaryTree {
	
	/*
	 * You are given a binary tree in level wise order where all the values are from 0 to n-1. 
	 * You have to construct an ancestor matrix of size n x n from the given binary tree.

	Note: You have to write a function to print the ancestor matrix. The matrix given to 
	you as the function argument is initialised with 0.
	
	Ancestor matrix is defined as:
	matrix[i][j] = 1 if i is ancestor of j
	matrix[i][j] = 0, otherwise
	
	Input format:
	The first line of input contains the number of nodes in binary tree and the following line 
	of input has elements in the level order form (separated by space)
	(If any node does not have left or right child, take -1 in its place)
	Output Format:
	Ancestor matrix in n lines and n columns.
	Sample Input:
	5
	0 1 2 3 4 -1 -1 -1 -1 -1 -1
	Sample Output:
	0 1 1 1 1
	0 0 0 1 1
	0 0 0 0 0
	0 0 0 0 0
	0 0 0 0 0
	Explanation:
                            0
                          /   \
                         1     2
                        / \
                       3   4
	 */
	// Time complexity -> O(n*n), Space complexity -> O(h)
	public static void ancestor(BinaryTreeNode<Integer> root, int[][] matrix) {
        int n = matrix.length;
        
        fillMatrix(root, matrix, n);
        
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		System.out.print(matrix[i][j] + " ");
        	}
        	System.out.println();
        }
    }
	
	private static void fillMatrix(BinaryTreeNode<Integer> root, int[][] matrix, int size) {
		if (root == null) {
			return ;
		}
		
		fillMatrix(root.left, matrix, size);
		fillMatrix(root.right, matrix, size);
		
		if (root.left != null) {
			matrix[root.data][root.left.data] = 1;
			for (int j = 0; j < size; j++) {
				if (matrix[root.left.data][j] == 1) {
					matrix[root.data][j] = 1;
				}
			}
		}
		
		if (root.right != null) {
			matrix[root.data][root.right.data] = 1;
			for (int j = 0; j < size; j++) {
				if (matrix[root.right.data][j] == 1) {
					matrix[root.data][j] = 1;
				}
			}
		}
	}
	
	static Scanner s = new Scanner(System.in);
	   public static BinaryTreeNode<Integer> takeInput(){
		   Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
		   int rootData = s.nextInt();
		   if(rootData == -1) return null;
		   BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		   pendingNodes.add(root);

		   while(!pendingNodes.isEmpty()){
			    BinaryTreeNode<Integer> currentNode;
				currentNode = pendingNodes.poll();
			   
			   int leftChildData = s.nextInt();
			   if(leftChildData != -1){
				   BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				   currentNode.left = leftChild;
				   pendingNodes.add(leftChild);
			   }
			   int rightChildData = s.nextInt();
			   if(rightChildData != -1){
				   BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				   currentNode.right = rightChild;
				   pendingNodes.add(rightChild);
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
		   BinaryTreeNode<Integer> root = takeInput();
		   int[][] matrix = new int[n][n];
		   for(int i = 0; i < n; ++i) {
			   for(int j = 0; j < n; ++j) {
				   matrix[i][j] = 0;
			   }
		   }
		   ancestor(root, matrix);
	   }

}
