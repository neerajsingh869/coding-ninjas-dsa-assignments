package optionalBST;

import java.util.*;
import java.util.Scanner;

public class KthSmallestNode {
	
	/*
	 * Given a BST and an integer K, you need to find the Kth smallest element present in the BST. Return INT_MIN if that is not present in the BST.
Input format :
Line 1: Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Output Format:
Line 1: Kth smallest node
Sample Input :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
3
Sample Output :
6
	 */
	// Time Complexity -> O(n*n), Space Complexity -> O(h)
	public static int kthSmallestNode1(BinaryTreeNode<Integer> root,int K){
		if(root == null){
			return Integer.MIN_VALUE;
		}
		int countLeft = countNode(root.left);
		if(countLeft >= K){
			return kthSmallestNode1(root.left, K);
		}
		else if(countLeft + 1 == K){
			return root.data;
		}
		else {
			return kthSmallestNode1(root.right, K-countLeft-1);
		}
	}

	private static int countNode(BinaryTreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		return 1 + countNode(root.left) + countNode(root.right);
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	static ArrayList<BinaryTreeNode<Integer>> inorder = new ArrayList<>();

	public static int kthSmallestNode2(BinaryTreeNode<Integer> root,int K){
		inorder(root);
		int n = inorder.size();
		return (K-1 < n) ? inorder.get(K-1).data : Integer.MIN_VALUE;
	}

	public static void inorder(BinaryTreeNode<Integer> root){
		if(root == null){
			return;
		}
		inorder(root.left);
		inorder.add(root);
		inorder(root.right);
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(h)
	public static int kthSmallestNode3(BinaryTreeNode<Integer> root,int K){
		Stack<BinaryTreeNode<Integer>> st = new Stack<>();
		BinaryTreeNode<Integer> temp = root;
		int i = 0;
		while(temp != null || !st.isEmpty()){
			while(temp != null){
				st.push(temp);
				temp = temp.left;
			}
			i++;
			if(i == K){
				return st.peek().data;
			}
			temp = st.peek().right;
			st.pop();
		}
		return Integer.MIN_VALUE;
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static int kthSmallestNode4(BinaryTreeNode<Integer> root,int K){
		BinaryTreeNode<Integer> current = root;
		int ans = Integer.MIN_VALUE;
		
		while (current != null) {
			if (current.left == null) {
				K--;
				
				if (K == 0) {
					ans = current.data;
					break;
				}

				current = current.right;
			} else {
				BinaryTreeNode<Integer> temp = current.left;

				while (temp.right != null && temp.right != current) {
					temp = temp.right;
				}

				if (temp.right == current) {
					temp.right = null;

					K--;
				
					if (K == 0) {
						ans = current.data;
						break;
					}

					current = current.right;
				} else {
					temp.right = current;
					current = current.left;
				}
			}
		}

		return ans;
	}
	
	static Scanner s=new Scanner(System.in);
	public static BinaryTreeNode<Integer> takeinputlevelwise(){
		Queue<BinaryTreeNode<Integer>> pendingnodes=new LinkedList<BinaryTreeNode<Integer>>();
		int rootdata=s.nextInt();
		if(rootdata==-1)return null;
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootdata);
		pendingnodes.add(root);
		while(!pendingnodes.isEmpty()){
			BinaryTreeNode<Integer> frontnode=pendingnodes.remove();
			BinaryTreeNode<Integer> currentnode=frontnode;
			int lchild=s.nextInt();
			if(lchild!=-1){
				BinaryTreeNode<Integer> leftchild=new BinaryTreeNode<Integer>(lchild);
				pendingnodes.add(leftchild);
				currentnode.left=leftchild;
			}
			int rchild=s.nextInt();
			if(rchild!=-1){
				BinaryTreeNode<Integer> rightchild=new BinaryTreeNode<Integer>(rchild);
				pendingnodes.add(rightchild);
				currentnode.right=rightchild;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root=null;
		root=takeinputlevelwise();
		int K=s.nextInt();
		System.out.println(kthSmallestNode3(root,K));
	}

}
