package optionalBinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BinaryTreeNodeT<T> {
	T data;
	BinaryTreeNodeT<T> left;
	BinaryTreeNodeT<T> right;

	public BinaryTreeNodeT(T data) {
		this.data = data;
	}
}

class PairTilt {
    int tilt;
    int sum;

    PairTilt(int tilt, int sum) {
        this.tilt = tilt;
        this.sum = sum;
    }
}

public class TiltOfBinaryTree {
	
	/*
	 * You are given a binary tree and you have to return the tilt of the whole tree.
		Tilt of the whole tree is the sum of all nodes' tilt and the tilt of a node is the 
		absolute difference between the sum of all left subtree node values and the sum of 
		all right subtree node values. The tilt of null nodes is 0.
		Input Format:
		The only input line contains nodes in the level order form (separated by space). 
		If any node does not have left or right child, take -1 in its place.
		Output format:
		The only output line contains the tilt of the whole tree.
		Sample Input:
		1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1
		Sample Output:
		9
		Explanation:
		                    1
		                   / \
		                  2   3
		                 / \   \
		                4   5   6
		Tilt of node 4=0
		Tilt of node 5=0
		Tilt of node 6=0
		Tilt of node 2=|4-5|=1
		Tilt of node 3=|0-6|=6
		Tilt of node 1=|11-9|=2
		Tilt of the whole tree=1+2+6=9
	 */
	
	// Time complexity -> O(n*n), Space complexity -> O(h)
	public static int getTilt1(BinaryTreeNodeT<Integer> root) {
        if (root == null) {
            return 0;
        }
        int rootTilt = Math.abs(treeSum(root.left) - treeSum(root.right));
        return rootTilt + getTilt1(root.left) + getTilt1(root.right);
    }

    private static int treeSum(BinaryTreeNodeT<Integer> root) {
        if (root == null) {
            return 0;
        }
        return root.data + treeSum(root.left) + treeSum(root.right);
    }
    
    // Time complexity -> O(n), Space complexity -> O(h)
    public static int getTilt2(BinaryTreeNodeT<Integer> root) {
        return getTiltHelper(root).tilt;
    }
    
    private static PairTilt getTiltHelper(BinaryTreeNodeT<Integer> root) {
        if (root == null) return new PairTilt(0, 0);

        PairTilt leftAns = getTiltHelper(root.left);
        PairTilt rightAns = getTiltHelper(root.right);

        int rootTiltAns = Math.abs(leftAns.sum - rightAns.sum) + leftAns.tilt + rightAns.tilt;
        int rootSumAns = root.data + leftAns.sum + rightAns.sum;

        return new PairTilt(rootTiltAns, rootSumAns);
    }
	
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNodeT<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNodeT<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNodeT<Integer>>(); // we can skip writing again inside <> after java version 1.7 
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNodeT<Integer> root = new BinaryTreeNodeT<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNodeT<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNodeT<Integer> leftChild = new BinaryTreeNodeT<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNodeT<Integer> rightChild = new BinaryTreeNodeT<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}
	
	public static void printLevelWise(BinaryTreeNodeT<Integer> root){
        if(root == null) return;
        Queue<BinaryTreeNodeT<Integer>> q = new LinkedList<BinaryTreeNodeT<Integer>>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            BinaryTreeNodeT<Integer> front = q.poll();
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
		BinaryTreeNodeT<Integer> root = takeInput();
		System.out.print(getTilt2(root));
	}

}
