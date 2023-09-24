package optionalBST;

import java.util.Scanner;

public class ConstructBSTFromLevelorder {
	
	/*
	 * You are given level order traversal of a Binary Search Tree in N-sized array, you have to construct a BST from this level order traversal.
Input Format:
The first line of input contains the number of nodes present in the BST. The following line of input elements of the N-sized array containing the level order traversal of BST.
Output Format:
The output contains the constructed tree where the levelorder traversal of the BST is printed.
Constraints:
1<=Numberof nodes<=1000
Sample Input:
6
1 3 4 6 7 8
Sample Output:
1 3 4 6 7 8
	 */
	// Time complexity -> O(n*n), Space complexity -> O(n*n)
	public static BinaryTreeNode<Integer> constructBST1(int[] levelorder, int n) {
        return constructBST1(levelorder);
    }

    private static BinaryTreeNode<Integer> constructBST1(int[] levelorder) {
        int n = levelorder.length;
        if(n == 0){
            return null;
        }
        int rootData = levelorder[0];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        int sizeLeftTree = 0;
        int sizeRightTree = 0;
        for(int i = 1; i<n; i++){
            if(rootData > levelorder[i]){
                sizeLeftTree++;
            }
            else{
                sizeRightTree++;
            }
        }
        int[] leftTreeNodes = new int[sizeLeftTree];
        int ltn = 0, rtn = 0;
        int[] rightTreeNodes = new int[sizeRightTree];
        for(int i = 1; i<n; i++){
            if(rootData > levelorder[i]){
                leftTreeNodes[ltn++] = levelorder[i];
            }
            else{
                rightTreeNodes[rtn++] = levelorder[i];
            }
        }
        root.left = constructBST1(leftTreeNodes);
        root.right = constructBST1(rightTreeNodes);
        return root;
    }
    
    // Time complexity -> O(n*n), Space complexity -> O(h)
    public static BinaryTreeNode<Integer> constructBST2(int[] levelorder, int n) {
        BinaryTreeNode<Integer> root = null;
        
        for (int i = 0; i < n; i++) {
            root = placeValueAtRightPos(root, levelorder[i]);
        }

        return root;
    }

    private static BinaryTreeNode<Integer> placeValueAtRightPos(BinaryTreeNode<Integer> root, int value) {
        if (root == null) {
            return new BinaryTreeNode<>(value);
        }

        if (root.data > value) {
            root.left = placeValueAtRightPos(root.left, value);
        } else {
            root.right = placeValueAtRightPos(root.right, value);
        }

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
		int n = s.nextInt();
    	int[] levelorder = new int[n];
    	for(int i = 0; i < n; ++i) {
			levelorder[i] = s.nextInt();
    	}
    	BinaryTreeNode<Integer> root = constructBST2(levelorder, n);
    	printpreorder(root);
	}	

}
