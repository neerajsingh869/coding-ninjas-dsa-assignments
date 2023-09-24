package optionalBinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PairChild {
    int left = Integer.MIN_VALUE;
    int right = Integer.MIN_VALUE;

    PairChild(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class ConstructBinaryTreeFromParentArray {
	
	/*
	 * You are given an N-sized array that represents a binary tree such that array indexes are values in tree nodes and array values give the parent node of that particular index (or node). The value of the root index is -1 as there is no parent of the root node. You have to construct a binary tree from the given parent array.
Note:
You have to return the root of the constructed tree. The Output will be the sorted level order traversal of the tree.
Input Format:
The first line of input contains the size of the parent array(N). The next line input contains the space-separated elements of the input parent array.
Output Format:
The Output will be the sorted level order traversal of the tree. Each level of the tree is printed in a new line and in a sorted manner.
Sample Input:
7
6 0 6 2 2 3 -1
Sample Output:
6 
0 2 
1 3 4 
5
Explanation
                        6
                       / \
                      0   2
                     /   / \
                    1   3   4
                       /
                      5
Value at index 6 is -1. So, 6 is the root of the tree.
6 is present at indexes 0 and 2. As 0 is smaller than 2 so, 0 is the left child and 2 is the right child of 6.
0 is present at index 1. As, 1 is the only child of 0 so it is inserted as the left child of 0.
2 is present at  indexes 3 and 4. As 3 is smaller than 4 so, 3 is the left child and 4 is the right child of 2.
5 is present at index 3. As, 5 is the only child of 3 so it is inserted as the left child of 3.
	 */
	
	// Time complexity -> O(n*n), Space complexity -> O(h)
	public static BinaryTreeNode<Integer> constructBT1(int[] parent, int n) {
        int rootData = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                rootData = i;
                break;
            }
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        constructBT1(root, parent, n);

        return root;
    }

    private static void constructBT1(BinaryTreeNode<Integer> root, int[] parent, int n) {
        if (root == null) {
            return;
        }

         int leftData = -1, rightData = -1;

         for (int i = 0; i < n; i++) {
             if (parent[i] == root.data) {
                 if (leftData == -1) {
                     leftData = i;
                     root.left = new BinaryTreeNode<>(leftData);
                 } else {
                     rightData = i;
                     root.right = new BinaryTreeNode<>(rightData);
                 }
             }
         }
         
         constructBT1(root.left, parent, n);
         constructBT1(root.right, parent, n);
    }  
	 
	 // Time complexity -> O(n*n), Space complexity -> O(n)
	 public static BinaryTreeNode<Integer> constructBT2(int[] parent, int n) {
         Queue<BinaryTreeNode<Integer>> que = new LinkedList<>();

         int rootData = -1;
         for (int i = 0; i < n; i++) {
             if (parent[i] == -1) {
                 rootData = i;
                 break;
             }
         }

         BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
         que.add(root);

         while(!que.isEmpty()) {
             BinaryTreeNode<Integer> curr = que.poll();
             int leftData = -1, rightData = -1;

             for (int i = 0; i < n; i++) {
                 if (parent[i] == curr.data) {
                     if (leftData == -1) {
                         leftData = i;
                         curr.left = new BinaryTreeNode<>(leftData);
                         que.add(curr.left);
                     } else {
                         rightData = i;
                         curr.right = new BinaryTreeNode<>(rightData);
                         que.add(curr.right);
                     }
                 }
             }
             
         }

         return root;
     }
	 
	// Time complexity -> O(n), Space complexity -> O(n)
	 public static BinaryTreeNode<Integer> constructBT3(int[] parent, int n) {
         Queue<BinaryTreeNode<Integer>> que = new LinkedList<>();
         // used HashMap to store left and right child value of all 
         // non-left nodes
         HashMap<Integer, PairChild> map = new HashMap<>();

         int rootData = -1;
         for (int i = 0; i < n; i++) {
             if (parent[i] == -1) {
                 rootData = i;
             }
             if (map.containsKey(parent[i])) {
                 PairChild p = map.get(parent[i]);
                 p.right = i;
                 map.put(parent[i], p);
             } else {
                 map.put(parent[i], new PairChild(i, Integer.MIN_VALUE));
             }
         }

         BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
         que.add(root);

         while (!que.isEmpty()) {
             BinaryTreeNode<Integer> curr = que.poll();

             if (map.containsKey(curr.data)) {
                 PairChild p = map.get(curr.data);
                 if (p.left != Integer.MIN_VALUE) {
                     curr.left = new BinaryTreeNode<>(p.left);
                     que.add(curr.left);
                 }
                 if (p.right !=Integer.MIN_VALUE) {
                     curr.right = new BinaryTreeNode<>(p.right);
                     que.add(curr.right);
                 }
             }
         }

         return root;
     }
	 
	 // Best approach (Time complexity -> O(n), Space complexity -> O(n))
	 public static BinaryTreeNode<Integer> constructBT4(int[] parent, int n) {
         HashMap<Integer, BinaryTreeNode<Integer>> isVisited = new HashMap<>();
         
         for (int i = 0; i < n; i++) {
             isVisited.put(i, null);
         }

         BinaryTreeNode<Integer> root = null;
         for (int i = 0; i < n; i++) {
             if (isVisited.get(i) == null) {
                 isVisited.put(i, new BinaryTreeNode<>(i));
             }

             if (parent[i] == -1) {
                 root = isVisited.get(i);
             } else {
                 if (isVisited.get(parent[i]) == null) {
                     BinaryTreeNode<Integer> parentNode = new BinaryTreeNode<>(parent[i]);
                     parentNode.left = isVisited.get(i);
                     isVisited.put(parent[i], parentNode);
                 } else {
                     if ( isVisited.get(parent[i]).left == null) {
                          isVisited.get(parent[i]).left = isVisited.get(i);
                     } else {
                         isVisited.get(parent[i]).right = isVisited.get(i);
                     }  
                 }
             }
         }

         return root;
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
		   ArrayList<Integer> arr = new ArrayList<Integer>();
		   q.add(root);
		   q.add(null);
		   while(!q.isEmpty()){
			   BinaryTreeNode<Integer> front = q.poll();
			   arr.add(front.data);
			   if(front.left != null) q.add(front.left);
			   if(front.right != null) q.add(front.right);
			   if(!q.isEmpty() && q.peek()==null){
				   Collections.sort(arr);
				   for(int ele : arr) System.out.print(ele + " ");
				   arr = new ArrayList<Integer>();
				   System.out.println();
				   q.poll();
				   if(!q.isEmpty()) q.add(null);
			   }
		   }
	   }
	   public static void main(String[] args) {
		   int n = s.nextInt();
		   int[] parent = new int[n];
			 for(int i = 0; i < n; ++i) {
			   parent[i] = s.nextInt();
			 }
			 BinaryTreeNode<Integer> root = constructBT4(parent, n);
		   printLevelWise(root);
	   }

}
