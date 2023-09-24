package optionalBST;

import java.util.Scanner;

public class BSTDeadEnd {
	
	/*
	 * You are given a Binary Search Tree containing positive integer values greater than 0. You have to check whether this tree contains a dead-end or not. The dead-end is a leaf node, after which we are not able to insert any node. That is, a dead end is said to exist in a BST if there is a leaf node to which a new child node cannot be added without violating the properties of a BST.
Input Format:
The first line of input contains the number of nodes(N) to be inserted in the BST. The following line of input contains N space-separated elements to be inserted in the BST.
Output Format:
 The only output line contains "yes" if the dead-end is present in the BST otherwise "no" is printed.
Constraints:
1<=Numberof nodes<=1000
Sample Input:
6
8 7 10 9 13 2
Sample Output:
 yes
Explanation:
The BST is:
                         8
                        / \
                       7   10
                      /    / \
                     2    9  13

We can't insert any element at node 9.  Hence, 9 is a dead-end.
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(h)
	public static boolean deadEnd1(BinaryTreeNode<Integer> root) {
        return deadEnd1(root, 1, Integer.MAX_VALUE);
    }

    private static boolean deadEnd1(BinaryTreeNode<Integer> root, int min, int max){
        if(root == null){
            return false;
        }
        int minLeft = min;
        int maxRight = max;
        int midVal = root.data;
        if(root.left == null && root.right == null){
        	// Below condition can be re-written as (minLeft == maxRight)
            if(minLeft > midVal - 1 && midVal + 1 > maxRight){
                return true;
            }
        }
        return deadEnd1(root.left, minLeft, midVal-1) || deadEnd1(root.right, midVal+1, maxRight);
    }
    
    // Time Complexity -> O(n), Space Complexity -> O(h)
    public static boolean deadEnd2(BinaryTreeNode<Integer> root) {
        return deadEnd2(root, 1, Integer.MAX_VALUE);
    }

    private static boolean deadEnd2(BinaryTreeNode<Integer> root, int min, int max){
        if(root == null){
            return false;
        }
        if(min == max){
            return true;
        }
        return deadEnd2(root.left, min, root.data-1) || deadEnd2(root.right, root.data+1, max);
    }
	
	public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root,int x){
        if(root == null) return new BinaryTreeNode<Integer>(x);
        if(x < root.data) root.left = insert(root.left, x);
        else root.right = insert(root.right, x);
        return root;
    }

  public static void printpreorder(BinaryTreeNode<Integer> root) {
      if (root == null) return;
      System.out.print(root.data + " ");
      printpreorder(root.left);
      printpreorder(root.right); 
    }
    
  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    BinaryTreeNode<Integer> root = null;
        int n = s.nextInt();
        for(int i = 0; i < n; ++i) {
          int k = s.nextInt();
          root = insert(root, k);
        }

    if(deadEnd2(root)) System.out.print("yes");
    else System.out.print("no");
  }

}
