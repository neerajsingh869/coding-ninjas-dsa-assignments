package optionalBinaryTrees;

import java.util.Scanner;

public class InorderTraversalWithoutRecursionOrStack {
	
	/*
	 * Given a binary tree, print the inorder traversal of a given tree without using recursion and stack.
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
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static void inOrder(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> curr = root;
        while(curr != null){
            if(curr.left == null){
                System.out.print(curr.data + " " );
                curr = curr.right;
            }
            else{
                BinaryTreeNode<Integer> temp = curr.left;
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }
                // It means the left subtree has been traversed. So, 
                // print the root and then go to right subtree for traversal
                // and remove the link
                if(temp.right == curr){
                	// Link removing in order to keep the tree same
                	temp.right = null;
                    System.out.print(curr.data + " " );
                    curr = curr.right;
                }
                // It means we are going to traverse left subtree for 1st time.
                // So, link must be made from left subtree right most node
                // to root in order to come back to root to traverse right subtree
                else{
                    temp.right = curr;
                    curr = curr.left;
                }
            }
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
