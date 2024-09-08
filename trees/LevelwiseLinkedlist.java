package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelwiseLinkedlist {
	
	/*
	 * Given a binary tree, write code to create a separate linked 
	 * list for each level. You need to return the array which 
	 * contains head of each level linked list.

		Detailed explanation ( Input/output format, Notes, Images )
		Input format :
		The first line of input contains data of the nodes of the tree 
		in level order form. The data of the nodes of the tree is separated 
		by space. If any node does not have left or right child, take -1 in 
		its place. Since -1 is used as an indication whether the left or 
		right nodes exist, therefore, it will not be a part of the data of any node.
		Output format :
		Each level linked list is printed in new line (elements are s
		eparated by space).
		Constraints:
		Time Limit: 1 second
		Sample Input 1:
		5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
		Sample Output 1:
		5 
		6 10 
		2 3 
		9
	 */
	// Time complexity -> O(n), Space complexity -> O(n)
	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		if (root == null) {
			return null;
		}
		
		Queue<BinaryTreeNode<Integer>> que = new LinkedList<>();
		que.add(root);
		que.add(null);

		ArrayList<LinkedListNode<Integer>> ans = new ArrayList<>();
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		while (!que.isEmpty()) {
			BinaryTreeNode<Integer> currNode = que.poll();
			
			if (currNode == null) {
				if (!que.isEmpty()) {
					que.add(null);
				}

				ans.add(head);
				head = null;
				tail = null;
			} else {
				LinkedListNode<Integer> tempNode = new LinkedListNode<>(currNode.data);
				if (head == null) {
					head = tempNode;
					tail = head;
				} else {
					tail.next = tempNode;
					tail = tempNode;
				}

				if (currNode.left != null) {
					que.add(currNode.left);
				}
				if (currNode.right != null) {
					que.add(currNode.right);
				}
			}
		}

		return ans;
	}

}
