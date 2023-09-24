package optionalBST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class ClosestElement {
	
	/*
	 * You are given a BST in the level order form and a target node K. You have to find a node having the minimum absolute difference with target value K and print the value of that minimum absolute difference.
Note: You have to return the value of the node having the minimum absolute difference with target value K, printing the minimum absolute difference is handled automatically.
Input Format
Line 1: Nodes in the level order form (separated by space). If any node does not have left or right child, take -1 in its place
Line 2: Value of the target node K
Output Format:
The minimum absolute difference of a node with given target value K.
Constraints:
1<=Number of nodes<=1000
Sample Input:
9 4 17 3 6 -1 22 -1 -1 5 7 20 -1 -1 -1 -1 -1 -1 -1
18
Sample Output:
1
Explanation:
Here K=18, The node that has value nearest to K is 17 so it's difference with k is 1 is the answer.
	 */
	
	// Time Complexity -> O(h), Space Complexity -> O(h)
	public static int minDiff(BinaryTreeNode<Integer> root, int k) {
        if(root == null){
			return Integer.MAX_VALUE;
		}
		int ans = Integer.MAX_VALUE;
		int rootLevelDiff = Math.abs(root.data - k);
		if(k < root.data){
			int minNodeLeft = minDiff(root.left, k);
			int subtreeLevelDiff = Math.abs(minNodeLeft-k);
			ans = (Math.min(rootLevelDiff, subtreeLevelDiff) == rootLevelDiff) ? root.data : minNodeLeft;
		}
		else {
			int minNodeRight = minDiff(root.right, k);
			int subtreeLevelDiff = Math.abs(minNodeRight-k);
			ans = (Math.min(rootLevelDiff, subtreeLevelDiff) == rootLevelDiff) ? root.data : minNodeRight;
		}
		return ans;
    }
	
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7 
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
	
	public static void printLevelWise(BinaryTreeNode<Integer> root){
        if(root == null) return;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            BinaryTreeNode<Integer> front = q.poll();
            System.out.print(front.data + " ");
            if(front.left != null) q.add(front.left);
            if(front.right != null) q.add(front.right);
            if(!q.isEmpty() && q.peek()==null){
                System.out.println();
                q.poll();
                if(!q.isEmpty()) q.add(null);
            }
        }
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		int k = s.nextInt();
		System.out.print(Math.abs(k - minDiff(root, k)));
	}

}
