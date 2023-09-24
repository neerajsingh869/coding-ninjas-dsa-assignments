package group3Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Pair<T, U> {
	T minimum;
	U maximum;

	Pair(T minimum, U maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

}

public class MaximumSumBST {
	
	/*
	 * Given a binary tree root, the task is to return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).
Input Format:
The first and only line of input contains data of the nodes of the tree in level order form. The order is: data for root node, data for left child to root node,  data for right child to root node and so on and so forth for each node. The data of the nodes of the tree is separated by space. Data -1 denotes that the node doesn't exist.
Output Format:
Print the maximum sum
Sample Input 1:
1 4 3 2 4 2 5 -1 -1 -1 -1 -1 -1 4 6 -1 -1 -1 -1
Sample Output 1:
20
	 */
	
	static int max;
    static public int maxSumBST(BinaryTreeNode<Integer> root) {
        max = 0;
        findMaxSum(root);
        return max;
    }

    static public int[] findMaxSum(BinaryTreeNode<Integer> node){
        if(node==null){
            return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int[] left = findMaxSum(node.left);
        int[] right = findMaxSum(node.right);
        boolean isBST = left[0]==1 && right[0]==1 && node.data>left[1] && node.data<right[2];
        int sum = node.data + left[3] + right[3];
        if(isBST){
            max = Math.max(max, sum);
        }
        return new int[]{isBST?1:0, Math.max(node.data,right[1]), Math.min(node.data,left[2]), sum};
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");

		if (nodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(nodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}

			int leftChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}

			int rightChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}

		return root;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
        System.out.println(maxSumBST(root)); 
	}

}
