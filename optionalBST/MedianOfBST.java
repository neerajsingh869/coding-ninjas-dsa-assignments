package optionalBST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int pos1;
	int pos2;
	Pair(int pos1, int pos2){
		this.pos1 = pos1;
		this.pos2 = pos2;
	}
}

public class MedianOfBST {
	
	/*
	 * You are given a BST, return the integral part of the median of the given BST.
If the number of nodes are even, then median=((n/2)th node+(n/2+1)th node)/2
If the number of nodes are odd, then median=(n/2)th node
Note: The time complexity should be O(n) and space complexity should be O(1).
Input Format:
The first line of input contains number of nodes present in BST and the second line of the input contains the values of the nodes present in BST.
Output Format:
The only line of output contains the median of the given BST.
Constraints:
1<Number of node<=1000
Sample Input:
7
5 3 7 2 4 6 8
Sample Output:
5
Explanation:
The given BST is:
                     5
                   /    \
                 3        7
                /  \     /  \
               2    4   6    8
Sorted BST: 2 3 4 5 6 7 8
Number of nodes are odd, so median=5
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	static ArrayList<BinaryTreeNode<Integer>> inorder = new ArrayList<>();

	public static int median1(BinaryTreeNode<Integer> root){
		inorder(root);
		int n = inorder.size();
		return (n%2 == 0) ? (inorder.get(n/2-1).data + inorder.get(n/2).data)/2 : inorder.get(n/2).data;
	}

	public static void inorder(BinaryTreeNode<Integer> root){
		if(root == null){
			return;
		}
		inorder(root.left);
		inorder.add(root);
		inorder(root.right);
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static int median2(BinaryTreeNode<Integer> root){
		int n = countNodes(root);
		Pair medianPos = getMedianPositions(n);
		int medianPos1 = medianPos.pos1;
		int medianPos2 = medianPos.pos2;
		// int medianOddPos = (n%2 != 0) ? (n+1)/2 : -1;
		// int medianEvenPos1 = (n%2 == 0) ? n/2 : -1;
		// int medianEvenPos2 = (n%2 == 0) ? n/2 + 1 : -1;
		BinaryTreeNode<Integer> curr = root;
		int count = 0;
		int medianEle1 = Integer.MIN_VALUE;
		int medianEle2 = Integer.MIN_VALUE;
		// int medianOddEle = Integer.MIN_VALUE;
		// int medianEvenEle1 = Integer.MIN_VALUE;
		// int medianEvenEle2 = Integer.MIN_VALUE;
        while(curr != null){
            if(curr.left == null){
				count++;
				if(count == medianPos1){
					medianEle1 = curr.data;
				}
				if(count == medianPos2){
					medianEle2 = curr.data;
				}
                curr = curr.right;
            }
            else{
                BinaryTreeNode<Integer> temp = curr.left;
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }
                // It means the left subtree has been traversed. Go
				// to right subtree for traversal and remove the link
                if(temp.right == curr){
                	// Link removing in order to keep the tree same
                	temp.right = null;
					count++;
					if(count == medianPos1){
						medianEle1 = curr.data;
					}
					if(count == medianPos2){
						medianEle2 = curr.data;
					}
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
		if(n%2 != 0){
			return medianEle1;
		}
		else{
			return (medianEle1 + medianEle2)/2;
		}
	}

	private static Pair getMedianPositions(int n){
		if(n % 2 != 0){
			return new Pair((n+1)/2, 0);
		}
		else{
			return new Pair(n/2, n/2 + 1);
		}
	}

	private static int countNodes(BinaryTreeNode<Integer> root){
		int count = 0;
		BinaryTreeNode<Integer> curr = root;
        while(curr != null){
            if(curr.left == null){
				count++;
                curr = curr.right;
            }
            else{
                BinaryTreeNode<Integer> temp = curr.left;
                while(temp.right != null && temp.right != curr){
                    temp = temp.right;
                }
                // It means the left subtree has been traversed. Go
				// to right subtree for traversal and remove the link
                if(temp.right == curr){
                	// Link removing in order to keep the tree same
                	temp.right = null;
					count++;
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
		return count;
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

	public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) { 
    if (root == null) {
    	BinaryTreeNode<Integer>  temp =  new BinaryTreeNode<Integer>(data);  
    	return temp; 
	}
	int rd = root.data;  
	    if (data < rd) {
	        root.left  = insert(root.left, data); 
	    }
	    else if (data > root.data) { 
	        root.right = insert(root.right, data); 
	  	}
	    return root; 
	} 
	public static void main(String[] args) {
		int n = s.nextInt();
		int data = s.nextInt();
		BinaryTreeNode<Integer> root = null; 
		root = insert(root, data);
  		for(int i = 1; i < n; ++i) {
   	 		data = s.nextInt();
			insert(root, data); 
		}
		System.out.print(median2(root));
	}

}
