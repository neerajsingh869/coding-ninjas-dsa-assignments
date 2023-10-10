package optionalBinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IterativePostorderTraversalOfBinaryTree {
	
	/*
	 * Given a binary tree, print the iterative postorder traversal of a given tree.
Post-order traversal is: LeftChild RightChild Root
Input format :
Elements in the level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format :
Post-order traversal, elements separated by space.
Sample Input :
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output :
1 4 7 6 3 13 14 10 8
	 */ 
	
	// Time complexity -> O(n), Space complexity -> O(1);
	// Modified preorder (root->right->left) and then reverse output
	// (left->right->root) to print answer
	public static void postOrder(BinaryTreeNode<Integer> root) {
		ArrayList<Integer> ans = new ArrayList<>();
		BinaryTreeNode<Integer> curr = root;
		while(curr != null){
            if(curr.right == null){
            	// Modified preorder is root->right->left, 
            	// hence push this value before going to left
                ans.add(curr.data);
                curr = curr.left;
            }
            else{
                BinaryTreeNode<Integer> temp = curr.right;
                // go to left most node of right subtree
                while(temp.left != null && temp.left != curr){
                    temp = temp.left;
                }
                // Was threaded. It means the left subtree has been traversed. Then go to right 
                // subtree for traversal and remove the link
                if(temp.left == curr){
                	// break the thread
                    temp.left = null;
                    // right subtree has been covered hence now cover the left one.
                    // No need to push this node value as we are here for the second 
                    // time using thread link
                    curr = curr.left;
                }
                // Not threaded yet. It means we are going to traverse left subtree for 1st time.
                // Since this is modified preorder, so push the node in ans
                else{
                	// create thread
                    temp.left = curr;
                    ans.add(curr.data);
                    // go to right to cover right subtree as modified preorder is root->right->left
                    curr = curr.right;
                }
            }
        }
		//reversing root->right->left to left->right->root to make it post order
		Collections.reverse(ans);
		
		for (int i : ans) {
			System.out.print(i + " ");
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
		postOrder(root);
	}

}
