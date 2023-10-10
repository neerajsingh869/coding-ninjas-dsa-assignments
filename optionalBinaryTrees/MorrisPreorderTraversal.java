package optionalBinaryTrees;

import java.util.Scanner;

public class MorrisPreorderTraversal {
	
	/*
	 * Given a binary tree, print the Morris preorder traversal of the given tree.
Using Morris Traversal, we can traverse the tree without using stack and recursion.
Pre-order traversal is: Root LeftChild RightChild
Input format :
Elements in the level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
Pre-order traversal, elements separated by space
Sample Input :
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output :
8 3 1 6 4 7 10 14 13
Explanation:
             8
           /   \
          3     10
         / \      \
         1   6     14
            / \    /
           4   7  13
	 */
	// Time Complexity -> O(n), Space Complexity -> O(1) {Little different from 
	// morris inorder approach}
	public static void preOrder1(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> curr = root;
        while(curr != null){
        	// Print the root data
            System.out.print(curr.data + " " );
            // If no left subtree exists, then move to right
            // subtree
            if(curr.left == null){
                curr = curr.right;
            }
            // If no right subtree exists, then move to left
            // subtree
            else if(curr.right == null){
                curr = curr.left;
            }
            else{
            	// If left and right subtree exists, then find the left subtree 
            	// right most element to check its link with root's right element
            	BinaryTreeNode<Integer> temp = curr.left;
                while(temp.right != null && temp.right != curr.right){
                    temp = temp.right;
                }
                // If link is already present that means left subtree has 
                // been traversed, unlink them and move to right subtree
                if(temp.right == curr.right){
                    temp.right = null;
                    curr = curr.right;
                }
                // If no link is present, make link and then traverse left subtree
                else{
                    temp.right = curr.right;
                    curr = curr.left;
                }
            }
        }
    }
	
	// Time Complexity -> O(n), Space Complexity -> O(1) {SAME APPROACH AS INORDER}
	public static void preOrder2(BinaryTreeNode<Integer> root) {
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
                // It means the left subtree has been traversed. Then go to right 
                // subtree for traversal and remove the link
                if(temp.right == curr){
                    // Link removing in order to keep the tree same
                    temp.right = null;
                    curr = curr.right;
                }
                // It means we are going to traverse left subtree for 1st time.
                // So, print the root node first and then traverse the left subtree.
                // Also, link must be made from left subtree right most node
                // to root in order to come back to root to traverse right subtree.
                else{
                    temp.right = curr;
                    System.out.print(curr.data + " " );
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
		preOrder2(root);
	}

}
