package optionalBST;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Node {
	int data;
	Node left;
	Node right;
	int size;
	int sum;

	Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class SumTillKthSmallestNode {
	
	/*
	 * You are given an integer K and elements of a binary search tree in level order form. You have to return the sum of elements which are smaller than or equal to Kth smallest element of the tree.
Input format :
The first line of input contains an integer that denotes the value of K. The following line contains an integer that represents the size of array. Let the size of array be denoted by the symbol n. n elements are required to represent binary search tree in level order form. In level order form, an element at an index i is parent to elements at index 2*i+1 and 2*i+2. The index of left child and right child are 2*i+1 and 2*i+2 respectively. So, the following line contains n space separated integers, that represents the elements in level order form (If any node does not have left or right child, take -1 in its place).
Output Format :
Elements/ nodes are printed using inorder traversal. Each node is printed in a new line. The nodes are printed in the following format:
Data of left child “ => ” Data of node “[” Data of parent “]” “=>” Data of right child
If left child or right child is null, then it is to be represented by “.”. If the parent is null, then it is to be represented by “null”.
Sample Input 1:
3
15
50 25 75 12 37 62 87 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
74
	 */
	// Time complexity -> O(n*n), Space complexity -> O(n)
	public static int solve1(Node node, int k){
		if(node == null) {
			return 0;
		}
		
		int countLeft = count(node.left);
		int sum = 0;
		
		if(countLeft >= k) {
			sum = solve1(node.left, k);
		} else if(countLeft + 1 == k) {
			sum = solve1(node.left, countLeft) + node.data;
		} else {
			sum = solve1(node.left, countLeft) + node.data + 
					solve1(node.right, k - (countLeft + 1));
		}
		
		return sum;
	}

	private static int count(Node root){
		if(root == null){
			return 0;
		}
		return 1 + count(root.left) + count(root.right);
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static int solve2(Node node, int k){
		ArrayList<Integer> inorder = new ArrayList<>();
		getInorder(node, inorder);
		int sum = 0;
		// Assuming there are no duplicates
		for(int i = 0; i<k && i<inorder.size(); i++){
			sum += inorder.get(i);
		}
		return sum;
	}

	private static void getInorder(Node node, ArrayList<Integer> inorder){
		if(node == null) {
			return;
		}
		getInorder(node.left, inorder);
		inorder.add(node.data);
		getInorder(node.right, inorder);
	}
	
	// Time complexity -> O(k), Space complexity -> O(h)
	public static int solve3(Node node, int k){
		Stack<Node> st = new Stack<>();
		Node temp = node;
		int sum = 0;

		while(temp != null || !st.isEmpty()) {
			while(temp != null) {
				st.push(temp);
				temp = temp.left;
			}
			k--;
			sum += st.peek().data;
			if(k == 0) {
				break;
			}
			temp = st.peek().right;
			st.pop();
		}
		
		return sum;
	}
	
	// Time complexity -> O(k), Space complexity -> O(1)
	public static int solve(Node node, int k){
		Node current = node;
		int sum = 0;
		// apply morris inorder traversal algorithm
		while(current != null) {
			if(current.left == null) {
				k--;
				sum += current.data;
				if(k == 0) break;
				current = current.right;
			}
			else {
				Node temp = current.left;
				while(temp.right != null && temp.right != current) {
					temp = temp.right;
				}
				if(temp.right == current) {
					temp.right = null;
					k--;
					sum += current.data;
					if(k == 0) break;
					current = current.right;
				} else {
					temp.right = current;
					current = current.left;
				}
			}
		}
		return sum;
	}
	
	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		str += node.left == null ? "." : node.left.data;
		str += " => " + node.data + " <= ";
		str += node.right == null ? "." : node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Node root = null;

		Scanner scn = new Scanner(System.in);

		int k = scn.nextInt();
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		Node[] nodes = new Node[arr.length];
		int size = 0;
		for (int i = 0; i < nodes.length; i++) {
			if (arr[i] != -1) {
				nodes[i] = new Node(arr[i], null, null);
				size++;

				if (i > 0) {
					int pi = (i - 1) / 2;

					if (i == 2 * pi + 1) {
						nodes[pi].left = nodes[i];
					} else {
						nodes[pi].right = nodes[i];
					}
				}
			}
		}

		root = nodes[0];
		int sum=solve2(root, k);
		System.out.println(sum);
	}

}
