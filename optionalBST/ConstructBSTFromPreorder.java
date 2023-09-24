package optionalBST;

import java.util.*;
import optionalBinaryTrees.*;

public class ConstructBSTFromPreorder {
	
	/*
	 * You are given preorder traversal of a Binary Search Tree, you have to construct a BST from this preorder traversal.
Input Format:
The first line of input contains the number of nodes present in the BST. The following line of input contains the preorder traversal of BST.
Output Format:
The output contains the constructed tree where each level is printed in a new line.
Constraints:
1<=Numberof nodes<=100
Sample Input:
6
20 10 2 14 80 100
Sample Output:
20
10 80
2 14 100
	 */
	
	// Using Inorder and Preorder data
	// Time complexity -> O(n*n), Space complexity -> O(n)
	public static BinaryTreeNode<Integer> constructBST1(int[] preorder) {
        int n = preorder.length;
        if(n == 0){
            return null;
        }
        int[] inorder = new int[n];
        for(int i = 0; i<n; i++){
            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
        return constructBST1(inorder, 0, n-1, preorder, 0, n-1);
    }

    private static BinaryTreeNode<Integer> constructBST1(int[] inorder, int i, int j, int[] preorder, int k, int l){
        if(i > j){
            return null;
        }
        int rootData = preorder[k];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        int rDI = j+1;
        for(int x = i; x<=j; x++){
            if(inorder[x] == rootData){
                rDI = x;
                break;
            }
        }
        root.left = constructBST1(inorder, i, rDI-1, preorder, k+1, k+rDI-i);
        root.right = constructBST1(inorder, rDI+1, j, preorder, k+rDI-i+1, l);
        return root;

    }
    
    // Using only Preorder data
    // Time complexity -> O(n*n), Space complexity -> O(n)
    public static BinaryTreeNode<Integer> constructBST2(int[] preorder) {
        int n = preorder.length;
        if(n == 0){
            return null;
        }
        return constructBST2(preorder, 0, n-1);
    }

    private static BinaryTreeNode<Integer> constructBST2(int[] preorder, int i, int j){
        if(i > j || i<0){
            return null;
        }
        int rootData = preorder[i];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        // j+1 instead of -1 since it is possible that there is no 
        // element greater than current root, so there will be
        // no right subtree. Also, we are using this to calculate
        // left subtree end node so it should not be -1.
        int rootRightIdx = j+1;
        for(int k = i; k<=j; k++){
            if(rootData < preorder[k]){
                rootRightIdx = k;
                break;
            }
        }
        root.left = constructBST2(preorder, i+1, rootRightIdx-1);
        root.right = constructBST2(preorder, rootRightIdx, j);
        return root;
    }
	
	public static void printLevelATNewLine(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
          BinaryTreeNode<Integer> first = q.poll();
          if(first == null) {
            if(q.isEmpty()) {
              break;
            }
            System.out.println();
            q.add(null);
            continue;
          }
          System.out.print(first.data + " ");
          if(first.left != null) {
            q.add(first.left);
          }
          if(first.right != null) {
            q.add(first.right);
          }
        }
      }
      
      public static void main(String[] args) {
          Scanner s = new Scanner(System.in);
          int n = s.nextInt();
          int[] preorder = new int[n];
          for(int i = 0; i < n; ++i) {
              preorder[i] = s.nextInt();
          }
          BinaryTreeNode<Integer> root = constructBST2(preorder);
          printLevelATNewLine(root);
      }

}
