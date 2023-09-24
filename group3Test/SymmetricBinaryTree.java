package group3Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SymmetricBinaryTree {
	
	/*
	 * Given a binary tree, check whether it is symmetric around its center at every level. That means, return true if the given binary tree and its mirror is exactly same. Otherwise return false.
Input Format :
Nodes in level order form (separated by space). If any node does not have left or right child, take -1 in its place. 
Output Format :
Return true or false.
Constraints :
1 <= Number of Nodes <= 10^5
Sample Input 1 :
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1 :
false
Sample Input 2 :
1 2 2 3 4 4 3 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2 :
true
Sample Input 3 :
1 2 2 -1 3 -1 3 -1 -1 -1 -1
Sample Output 3 :
false
	 */
	
	public static boolean isSymmetric(BinaryTreeNode<Integer> root){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		return false;
	}
	
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		Queue<BinaryTreeNode<Integer>>  pendingNodes = new LinkedList<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7 
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.add(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			currentNode = pendingNodes.remove();
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
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		System.out.println(isSymmetric(root));
	}

}
