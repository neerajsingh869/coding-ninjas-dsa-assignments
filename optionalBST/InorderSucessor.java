package optionalBST;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class LeftRightAnsPair {
	BinaryTreeNode<Integer> ans;
	BinaryTreeNode<Integer> leftMost;
	BinaryTreeNode<Integer> rightMost;

	LeftRightAnsPair(BinaryTreeNode<Integer> ans, BinaryTreeNode<Integer> leftMost, BinaryTreeNode<Integer> rightMost){
		this.ans = ans;
		this.leftMost = leftMost;
		this.rightMost = rightMost;
	}
}

public class InorderSucessor {
	
	/*
	 * You have been given an arbitrary binary tree and a node of this tree. You need to find the inorder successor of this node in the tree.
	The inorder successor of a node in a binary tree is that node that will be visited immediately after the given node in the inorder traversal of the tree. If the given node is visited last in the inorder traversal, then its inorder successor is NULL.
	The inorder traversal of a binary tree is the traversal method in which for any node its left subtree is visited first, then the node itself, and then the right subtree.
	Note
	1. Each node is associated with a unique integer value. 
	
	2. The node for which the successor is to be found is guaranteed to be part of the tree.
	Input Format:
	The first line contains a single integer 'T' representing the number of test cases. 
	
	The first line of each test case will contain the values of the nodes of the tree in the level order form ( -1 for NULL node) Refer to the example for further clarification.
	
	The second and the last line of each test case will contain the value of the node for which the inorder successor is to be found.
	
	Example: 
	Consider the binary tree:
	altImage
	
	The input of the tree depicted in the image above will be like: 
	 1
	 2 3
	 4 -1 5 6
	-1 7 -1 -1 -1 -1
	-1 -1
	
	Explanation :
	Level 1 :
	The root node of the tree is 1
	
	Level 2 :
	Left child of 1 = 2
	Right child of 1 = 3
	
	Level 3 :
	Left child of 2 = 4
	Right child of 2 = null (-1)
	Left child of 3 = 5
	Right child of 3 = 6
	
	Level 4 :
	Left child of 4 = null (-1)
	Right child of 4 = 7
	Left child of 5 = null (-1)
	Right child of 5 = null (-1)
	Left child of 6 = null (-1)
	Right child of 6 = null (-1)
	
	Level 5 :
	Left child of 7 = null (-1)
	Right child of 7 = null (-1)
	
	The first not-null node (of the previous level) is treated as the parent of the first two nodes of the current level. The second not-null node (of the previous level) is treated as the parent node for the next two nodes of the current level and so on.
	
	The input ends when all nodes at the last level are null (-1).
	Output Format:
	For each test case, print a single line that contains the value of the successor node, or NULL if it does not have an inorder successor.
	
	The output of each test case will be printed in a separate line.
	Note:
	You do not need to print anything, it has already been taken care of. Just implement the given function. 
	Constraints:
	1 <= 'T' <= 100
	2 <= 'N' <= 10 ^ 3  
	1 <=  'NODEVALUE' <= 10 ^ 9
	
	Where 'N' is the number of nodes and 'NODEVALUE' is the value of the node.
	
	Time Limit: 1sec.
	Sample Input 1:
	1
	1 2 3 4 5 -1 -1 -1 -1 -1 -1 
	2
	Sample Output 1:
	5
	Explanation of the Sample Input1:
	The tree can be represented as follows:
	altImage
	
	The inorder traversal of this tree will be 4 2 5 1 3.
	As the root is ‘1’, we first visit its left subtree which is rooted at 2, thus then we visit the left subtree of ‘2’, which is rooted at ‘4’. The left subtree of ‘4’ is NULL, so we visit the root i.e ‘4’. This process is continued.
	So the order would be 4 -> 2 -> 5 -> 1 -> 3.
	Clearly after the node with value = 2, the node with value = 5 is visited. So, 5 is the answer
	Sample Input 2:
	1
	10 5 6 -1 -1 -1 -1
	6
	Sample Output 2:
	NULL
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(h)
	public static BinaryTreeNode<Integer> inorderSuccesor1(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
    	return inorderSuccesorHelper1(root, node).ans;
	}

	public static LeftRightAnsPair inorderSuccesorHelper1(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node){
		if(root == null){
			return new LeftRightAnsPair(null, null, null);
		}
		LeftRightAnsPair pairLeft = inorderSuccesorHelper1(root.left, node);
		LeftRightAnsPair pairRight = inorderSuccesorHelper1(root.right, node);
		BinaryTreeNode<Integer> leftMostNode = (pairLeft.leftMost == null) ? root : pairLeft.leftMost;
		BinaryTreeNode<Integer> rightMostNode = (pairRight.rightMost == null) ? root : pairRight.rightMost;
		BinaryTreeNode<Integer> currAns = null;
		if(pairLeft.ans != null){
			currAns = pairLeft.ans;
		}
		else if(pairRight.ans != null){
			currAns = pairRight.ans;
		}
		else{
			if(pairLeft.rightMost == node){
				currAns = root;
			}
			else if(root == node){
				currAns = pairRight.leftMost;
			}
		}
		return new LeftRightAnsPair(currAns, leftMostNode, rightMostNode);
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	static ArrayList<BinaryTreeNode<Integer>> inorder = new ArrayList<>();
	public static BinaryTreeNode<Integer> inorderSuccesor2(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
		inorderSuccesorHelper2(root);
		for(int i = 0; i<inorder.size(); i++){
			if(inorder.get(i) == node){
				return (i+1 < inorder.size()) ? inorder.get(i+1) : null;
			}
		}
		return null;
	}

	public static void inorderSuccesorHelper2(BinaryTreeNode<Integer> root){
		if(root == null){
			return;
		}
		inorderSuccesorHelper2(root.left);
		inorder.add(root);
		inorderSuccesorHelper2(root.right);
	}

	// Time Complexity -> O(n), Space Complexity -> O(h) [New approach]
	private static BinaryTreeNode<Integer> curr;
	private static BinaryTreeNode<Integer> prev;
	public static BinaryTreeNode<Integer> inorderSuccesor3(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
		curr = null;
		prev = null;
		reverseInorder(root, node);
		return prev;
	}

	private static void reverseInorder(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node){
		if(root == null){
			return;
		}
		reverseInorder(root.right, node);
		if(root == node){
			prev = curr;
		}
		curr = root;
		reverseInorder(root.left, node);
	}
	
	static Scanner s = new Scanner(System.in);

    public static BinaryTreeNode<Integer> takeInput(ArrayList<BinaryTreeNode<Integer>> nodes) {
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList();

        int rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        nodes.add(root);

        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = pendingNodes.poll();

            int leftChildData = s.nextInt();

            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.left = leftChild;
                nodes.add(leftChild);
                pendingNodes.add(leftChild);
            }

            int rightChildData = s.nextInt();

            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.right = rightChild;
                nodes.add(rightChild);
                pendingNodes.add(rightChild);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int t = s.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {

            ArrayList<BinaryTreeNode<Integer>> nodes = new ArrayList<>();
            BinaryTreeNode<Integer> root = takeInput(nodes);
            int value = s.nextInt();
            BinaryTreeNode<Integer> ask = null;
            for (BinaryTreeNode<Integer> it : nodes) {
                if (it.data == value) {
                    ask = it;
                    break;
                }
            }

            BinaryTreeNode<Integer> ans = inorderSuccesor3(root, ask);
            if (ans == null || ask == ans) {
                sb.append("NULL\n");
            } else {
                sb.append(ans.data + "\n");
            }
        }

        System.out.print(sb);
    }

}
