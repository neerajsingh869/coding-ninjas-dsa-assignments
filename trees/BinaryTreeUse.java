package trees;

import java.util.Scanner;
import java.util.*;
import linkedLists.Node;

public class BinaryTreeUse {
	
	// ******************** Different ways to Take Input *********************
	
	// Taking input in level order form
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.print("Enter root data: ");
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			BinaryTreeNode<Integer> curr = q.poll();
			System.out.print("Enter left child of " + curr.data + ": ");
			int leftData = s.nextInt();
			if(leftData != -1) {
				curr.left = new BinaryTreeNode<Integer>(leftData);
				q.add(curr.left);
			}
			System.out.print("Enter right child of " + curr.data + ": ");
			int rightData = s.nextInt();
			if(rightData != -1) {
				curr.right = new BinaryTreeNode<Integer>(rightData);
				q.add(curr.right);
			}
		}
		return root;
	}
	
	// Function to make tree from user's input in way which is user readable
	public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft){
		if(isRoot) {
			System.out.print("Enter root data - ");
		}
		else {
			if(isLeft) {
				System.out.print("Enter left child data of " + parentData + " - ");
			}
			else {
				System.out.print("Enter right child data of " + parentData + " - ");
			}
		}
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		BinaryTreeNode<Integer> rootLeft = takeTreeInputBetter(false, rootData, true);
		BinaryTreeNode<Integer> rootRight = takeTreeInputBetter(false, rootData, false);
		
		root.left = rootLeft;
		root.right = rootRight;
		return root;
	}	
	
	public static BinaryTreeNode<Integer> takeTreeInput(){
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		BinaryTreeNode<Integer> rootLeft = takeTreeInput();
		BinaryTreeNode<Integer> rootRight = takeTreeInput();
		
		root.left = rootLeft;
		root.right = rootRight;
		return root;
	}
	
	// ***************** Problems related to Binary Trees ********************
	
	// Can be solved using level order traversal also
	public static boolean search(BinaryTreeNode<Integer> root, int target){
        if(root == null){
            return false;
        }
        if(root.data == target){
            return true;
        }
        return search(root.left, target) || search(root.right, target);
    }
	
	/*
	 * For a given Binary Tree of integers, find and return the sum of all the nodes data.
	 */
	// Time Complexity -> O(n), Space Complexity -> O(h)
	// Can be solved using level order traversal also
	public static int getSum(BinaryTreeNode<Integer> root) {
		//Your code goes here.
        if(root == null){
            return 0;
        }
        return root.data + getSum(root.left) + getSum(root.right);
	}
	
	// Can be solved using level order traversal also
	public static int totalNodes(BinaryTreeNode<Integer> root) {
		if(root == null) return 0;
		return 1 + totalNodes(root.left) + totalNodes(root.right); 
	}
	
	public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	// Better approach (Iterative version of preOrder traversal) 
	public static void preOrder2(BinaryTreeNode<Integer> root) {
		if(root == null) return ;
		Stack<BinaryTreeNode<Integer>> st = new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			BinaryTreeNode<Integer> currRoot = st.pop();
			System.out.print(currRoot.data + " ");
			if(currRoot.right != null) {
				st.push(currRoot.right);
			}
			if(currRoot.left != null) {
				st.push(currRoot.left);
			}
		}
	}
	
	/*
	 * You are given the root node of a binary tree.Print its preorder traversal.
	 */
	public static void inOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return ;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	/*
	 * For a given Binary Tree of integers, print the post-order traversal.
	 */
	public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	// Can be solved using level order traversal also
	public static int largestNodeData(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(root.data, Math.max(largestNodeData(root.left), largestNodeData(root.right)));
	}
	
	/*
	 * For a given a binary tree of integers and an integer X, find and return the total 
	 * number of nodes of the given binary tree which are having data greater than X.
	 */
	// Can be solved using level order traversal also
	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		//Your code goes here
        if(root == null){
            return 0;
        }
        return (root.data > x) ? 1 + countNodesGreaterThanX(root.left, x) + countNodesGreaterThanX(root.right, x)
            					: countNodesGreaterThanX(root.left, x) + countNodesGreaterThanX(root.right, x);
	}
	
	/*
	 * For a given Binary Tree of integers, find and return the height of the tree.
	 */
	// Can be solved using level order traversal also
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
	}
	
	// Can be solved using level order traversal also
	public static int countLeafNodes(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null &&  root.right == null) {
			return 1;
		}
		return countLeafNodes(root.left) + countLeafNodes(root.right); 
	}
	
	public static void printAtDepthK(BinaryTreeNode<Integer> root, int k) {
		if(root == null) {
			return;
		}
		if(k==0) {
			System.out.println(root.data);
			return;
		}
		printAtDepthK(root.left, k-1);
		printAtDepthK(root.right, k-1);
	}
	
	/*
	 * For a given Binary Tree of type integer and a number X, find 
	 * whether a node exists in the tree with data X or not.
	 */
	// Can be solved using level order traversal also
	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    //Your code goes here
        if(root == null){
            return false;
        }
        if(root.data.equals(x)){
            return true;
        }
        return isNodePresent(root.left, x) || isNodePresent(root.right, x);
	}
	
	/*
	 * For a given Binary Tree of type integer, print all the nodes without any siblings.
	 */
	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if(root == null){
            return;
        }
        else if(root.left == null && root.right != null){
            System.out.print(root.right.data + " ");
        }
        else if(root.left != null && root.right == null){
            System.out.print(root.left.data + " ");
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
	}
	
	/*
	 * For a given a Binary Tree of integers, replace each of its data with the depth of the tree.
	 * 
	 * Root is at depth 0, hence the root data is updated with 0. Replicate the same 
	 * further going down the in the depth of the given tree.
	 * 
	 * The modified tree will be printed in the in-order fashion.
	 */
	// Can be solved using level order traversal also
	public static void changeToDepthTree(BinaryTreeNode<Integer> root, int depth){
        if(root == null){
            return;
        }
        root.data = depth++;
        changeToDepthTree(root.left, depth);
        changeToDepthTree(root.right, depth);
    }
    
    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
	    //Your code goes here
        changeToDepthTree(root, 0);
	}
    
    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
    	if(root == null) {
    		return null;
    	}
    	if(root.left == null && root.right == null) {
    		return null;
    	}
    	root.left = removeLeaves(root.left);
    	root.right = removeLeaves(root.right);
    	return root;
    }
    
    /*
     * For a given Binary Tree of type integer, update it with its corresponding mirror image.
     */
    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
       	if(root == null){
            return;
        }
       	BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
//        BinaryTreeNode<Integer> temp = root.left;
//        root.left = root.right;
//        root.right = temp;
	}
    
    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
    	if(root == null) {
    		return true;
    	}
    	int hLeft = height(root.left);
    	int hRight = height(root.right);
    	if(Math.abs(hLeft - hRight) > 1) {
    		return false;
    	}
    	else {
    		return isBalanced(root.left) && isBalanced(root.right);
    	}
    }
    
    public static Pair1<Boolean, Integer> isBalanced2_helper(BinaryTreeNode<Integer> root){
    	if(root == null) {
    		return new Pair1<>(true, 0);
    	}
    	Pair1<Boolean, Integer> p1 = isBalanced2_helper(root.left);
    	Pair1<Boolean, Integer> p2 = isBalanced2_helper(root.right);
    	int height = 1 + Math.max(p1.data2, p2.data2);
    	Boolean isBal = true;
    	if(p1.data1 == false || p2.data1 == false) {
    		isBal = false;
    	}
    	if(Math.abs(p1.data2 - p2.data2) > 1) {
    		isBal = false;
    	}
    	return new Pair1<>(isBal, height);
    }
    
    public static boolean isBalanced2(BinaryTreeNode<Integer> root) {
    	Pair1<Boolean, Integer> ans = isBalanced2_helper(root);
    	return ans.data1;
    }
    
    /*
     * For a given Binary of type integer, find and return the ‘Diameter’.
     * The diameter of a tree can be defined as the maximum distance between two leaf nodes.
	 * Here, the distance is measured in terms of the total number of nodes present 
	 * along the path of the two leaf nodes, including both the leaves.
     */
    // Time Complexity -> O(n*n), Space Complexity -> O(h)
    public static int diameterOfBinaryTree1(BinaryTreeNode<Integer> root){
		if(root == null){
            return 0;
        }
		int distThroughRoot = height(root.left) + height(root.right) + 1;
		int leftTreeDia = diameterOfBinaryTree1(root.left);
		int rightTreeDia = diameterOfBinaryTree1(root.right);
		return Math.max(distThroughRoot, Math.max(leftTreeDia, rightTreeDia));
	}
    
    // Time Complexity -> O(n), Space Complexity -> O(n)
	public static int diameterOfBinaryTree2(BinaryTreeNode<Integer> root){
		Pair1<Integer, Integer> ans = helper_diameter(root);
        return ans.data1;
	}
	
	public static Pair1<Integer, Integer> helper_diameter(BinaryTreeNode<Integer> root){
        if(root == null){
            return new Pair1<>(0, 0);
        }
        Pair1<Integer, Integer> pLeft = helper_diameter(root.left);
        Pair1<Integer, Integer> pRight = helper_diameter(root.right);
        int DiaThroughRoot = pLeft.data2 + pRight.data2 + 1;
        int dia = Math.max(Math.max(pLeft.data1, pRight.data1), DiaThroughRoot);
        int height = 1 + Math.max(pLeft.data2, pRight.data2);
        return new Pair1<Integer, Integer>(dia, height);
    }
	
	/*
	 * For a given preorder and inorder traversal of a Binary Tree of type 
	 * integer stored in an array/list, create the binary tree using the given 
	 * two arrays/lists. You just need to construct the tree and return the root.
	 */
	// Time Complexity -> O(n*n), Space Complexity -> O(h)
	public static BinaryTreeNode<Integer> buildTree1(int[] preOrder, int preSt, int preEnd, int[] inOrder, int inSt, int inEnd){
        int n = inEnd-inSt+1;
        if(n <= 0){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[preSt]);
        int pos = -1;
        for(int i = inSt; i<=inEnd; i++){
            if(inOrder[i] == preOrder[preSt]){
                pos = i;
                break;
            }
        }
        root.left = buildTree1(preOrder, preSt+1, preSt+pos-inSt, inOrder, inSt, pos-1);
        root.right = buildTree1(preOrder, preSt+pos-inSt+1, preEnd, inOrder, pos+1, inEnd);
        return root;
    }

	public static BinaryTreeNode<Integer> buildTree1(int[] preOrder, int[] inOrder) {
		int n = preOrder.length;
        return buildTree1(preOrder, 0, n-1, inOrder, 0, n-1);
	}
	
	/*
	 * For a given postorder and inorder traversal of a Binary Tree of type integer 
	 * stored in an array/list, create the binary tree using the given two arrays/lists. 
	 * You just need to construct the tree and return the root.
	 */
	// Time Complexity -> O(n*n), Space Complexity -> O(h)
	public static BinaryTreeNode<Integer> buildTree2(int[] postOrder, int posSt, int posEnd, int[] inOrder, int inSt, int inEnd){
        int n = posEnd - posSt + 1;
        if(n <= 0){
            return null;
        }
        int rootData = postOrder[posEnd];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        int pos = -1;
        for(int i = inSt; i<=inEnd; i++){
            if(inOrder[i] == rootData){
                pos = i;
                break;
            }
        }
        root.right = buildTree2(postOrder, posEnd-inEnd+pos, posEnd-1, inOrder, pos+1, inEnd);
        root.left = buildTree2(postOrder, posSt, posEnd-inEnd+pos-1, inOrder, inSt, pos-1);
        return root;
    }

	public static BinaryTreeNode<Integer> buildTree2(int[] postOrder, int[] inOrder) {
		int n = postOrder.length;
        return buildTree2(postOrder, 0, n-1, inOrder, 0, n-1);
	}
	
	/*
	 * For a given a Binary Tree of type integer, duplicate every node of the tree 
	 * and attach it to the left of itself.
	 * The root will remain the same. So you just need to insert nodes in the given Binary Tree.
	 */
	// Time Complexity -> O(n), Space Complexity -> O(h)
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root == null){
            return ;
        }
        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);
        BinaryTreeNode<Integer> temp = root.left;
        root.left = new BinaryTreeNode<>(root.data);
        root.left.left = temp;
	}
	
	/*
	 * For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.
	 * Return the output as an object of Pair class, which is already created.
	 */
	// Can be solved using level order traversal also
	public static Pair1<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		if(root == null){
            return new Pair1<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
		Pair1<Integer, Integer> leftPair = getMinAndMax(root.left);
		Pair1<Integer, Integer> rightPair = getMinAndMax(root.right);
        Integer min = Math.min(root.data, Math.min(leftPair.data1, rightPair.data1));
        Integer max = Math.max(root.data, Math.max(leftPair.data2, rightPair.data2));
        return new Pair1<>(min, max);
	}
	
	/*
	 * For a given Binary Tree of type integer and a number K, print out all 
	 * root-to-leaf paths where the sum of all the node data along the path is equal to K.
	 */
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		//Your code goes here
		helper_rootToLeafPathsSumToK(root, k, "");
	}
	
	public static void helper_rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k, String ans){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && k == root.data){
            System.out.println(ans + root.data);
            return;
        }
        helper_rootToLeafPathsSumToK(root.left, k-root.data, ans + root.data + " ");
        helper_rootToLeafPathsSumToK(root.right, k - root.data, ans + root.data + " ");
    }
	
	/*
	 * You are given a Binary Tree of type integer, a target node, and an integer value K.
	 * Print the data of all nodes that have a distance K from the target node. 
	 * The order in which they would be printed will not matter.
	 */
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
		printNodesAtDistanceK(root, node, k);
	}
	
	public static int printNodesAtDistanceK(BinaryTreeNode<Integer> root, int target, int k){
        if(root == null){
            return -1;
        }
        if(root.data == target){
            printNodesAtKDepth(root, k);
            return 0;
        }
        int leftDist = printNodesAtDistanceK(root.left, target, k);
        if(leftDist != -1){
            if(leftDist + 1 == k){
                System.out.println(root.data);
            }
            else{
                printNodesAtKDepth(root.right, k-leftDist-2);
            }
            return 1 + leftDist;
        }
        int rightDist = printNodesAtDistanceK(root.right, target, k);
        if(rightDist != -1){
            if(rightDist + 1 == k){
                System.out.println(root.data);
            }
            else{
                printNodesAtKDepth(root.left, k-rightDist-2);
            }
            return 1 + rightDist;
        }
        return -1;
    }

    public static void printNodesAtKDepth(BinaryTreeNode<Integer> root, int k){
        if(root == null || k < 0){
            return ;
        }
        if(k == 0){
        	System.out.println(root.data);
            return;
        }
        printNodesAtKDepth(root.left, k-1);
        printNodesAtKDepth(root.right, k-1);
    }
    
	public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root, int target){
		if(root == null) {
			return new ArrayList<>();
		}
		ArrayList<Integer> ansArr = new ArrayList<>();
		if(root.data == target) {
			ansArr.add(root.data);
			return ansArr;
		}
		ArrayList<Integer> arrLeft = nodeToRootPath(root.left, target);
		if(arrLeft.size() != 0) {
			arrLeft.add(root.data);
			ansArr = arrLeft;
			return ansArr;
		}
		ArrayList<Integer> arrRight = nodeToRootPath(root.right, target);
		if(arrRight.size() != 0) {
			arrRight.add(root.data);
			ansArr = arrRight;
			return ansArr;
		}
		return ansArr;
	}
	
	/*
	 * Given a binary tree, write code to create a separate linked list 
	 * for each level. You need to return the array which contains head 
	 * of each level linked list.
	 */
	public static ArrayList<Node<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		// Write your code here
        if(root == null){
            return null;
        }
        ArrayList<Node<Integer>> ans = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Node<Integer> head = null;
        Node<Integer> tail = null;
        while(!q.isEmpty()){
            BinaryTreeNode<Integer> curr = q.poll();
            if(curr == null){
                ans.add(head);
                head = null;
                tail = null;
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else{
            	Node<Integer> temp = new Node<>(curr.data);
                if(head == null){
                	head = temp;
           	 	}
                else{
                    tail.next = temp;
                }
                tail = temp;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return ans;
	}
	
	// ************** BELOW FUNCTIONS OPERATES ON ****BST**** ***************
	
	/*
	 * Given a BST and an integer k. Find if the integer k is present in given 
	 * BST or not. You have to return true, if node with data k is present, 
	 * return false otherwise.
	 */
	// Time Complexity -> O(h), Space Complexity -> O(h)
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		if(root == null){
            return false;
        }
        if(root.data == k){
            return true;
        }
        return (root.data < k) ? searchInBST(root.right, k) : searchInBST(root.left, k);
	}
	
	public static boolean searchInBST_iterative(BinaryTreeNode<Integer> root, int k) {
		while(root != null) {
			if(root.data == k) {
				return true;
			}
			else if(root.data > k) {
				root = root.left;
			}
			else {
				root = root.right;
			}
		}
		return false;
	}
	
	/*
	 * Given a Binary Search Tree and two integers k1 and k2, find and print 
	 * the elements which are in range k1 and k2 (both inclusive).
	 */
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
		if(root == null){
            return;
        }
        if(root.data < k1){
        	elementsInRangeK1K2(root.right, k1, k2);
        }
        else if(root.data > k2){
            elementsInRangeK1K2(root.left, k1, k2);
        }
        else{
            elementsInRangeK1K2(root.left, k1, k2);
            System.out.print(root.data + " ");
            elementsInRangeK1K2(root.right, k1, k2);	
        }
	}
	
	/*
	 * Given a sorted integer array A of size n, which contains all unique 
	 * elements. You need to construct a balanced BST from this input array. 
	 * Return the root of constructed BST.
	 */
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int st, int end){
        if(end < st){
            return null;
        }
        int mid = st + (end-st)/2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
        root.left = SortedArrayToBST(arr, st, mid-1);
        root.right = SortedArrayToBST(arr, mid+1, end);
        return root;
    }

	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
		return SortedArrayToBST(arr, 0, n-1);
	}
	
	public static int maximum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		int rightMax = maximum(root.right);
		int leftMax = maximum(root.left);
		return Math.max(root.data, Math.max(rightMax, leftMax));
	}	
	
	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		int rightMin = minimum(root.right);
		int leftMin = minimum(root.left);
		return Math.min(root.data, Math.min(rightMin, leftMin));
	}
	
	public static boolean isBST1(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return true;
		}
		int leftMax = maximum(root.left);
		int rightMin = minimum(root.right);
		if(root.data <= leftMax || root.data > rightMin) {
			return false;
		}
		return isBST1(root.left) || isBST1(root.right); 
	}
	
	public static IsBSTReturn isBST2(BinaryTreeNode<Integer> root){
		if(root == null) {
			return new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
		}
		IsBSTReturn leftAns = isBST2(root.left);
		IsBSTReturn rightAns = isBST2(root.right);
		
		int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
		int max= Math.max(root.data, Math.max(leftAns.max, rightAns.max));
		boolean isBST = true;
		if(!leftAns.isBST || !rightAns.isBST) {
			isBST = false;
		}
		if((root.data <= leftAns.max) || (root.data > rightAns.min)) {
			isBST = false;
		}
		return new IsBSTReturn(min, max, isBST);
	}
	
	// Non-intuitive ways of finding whether a tree is BST or not
	// Time Complexity -> O(n), Space Complexity -> O(h)
	public static boolean isBST3(BinaryTreeNode<Integer> root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.data > max || root.data < min) {
			return false;
		}
		return isBST3(root.left, min, root.data-1) && 
				isBST3(root.right, root.data, max);
	}
	
	/*
	 * Given a binary search tree and data of two nodes, find 
	 * 'LCA' (Lowest Common Ancestor) of the given two nodes 
	 * in the BST.
	 * 
	 * LCA of two nodes A and B is the lowest or deepest node 
	 * which has both A and B as its descendants. 
	 */
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		// Base case
        if(root == null){
            return -1;
        }
        boolean isAPresent = isPresent(root, a);
        boolean isBPresent = isPresent(root, b);
        if(isAPresent && isBPresent){
            return getLCA_helper(root, a, b);
        }
        else if(isAPresent){
            return a;
        }
        else if(isBPresent){
            return b;
        }
        else{
            return -1;
        }
	}
	
	// Iterative way to search a element in BST (Since it is similar to Binary Search)
	public static boolean isPresent(BinaryTreeNode<Integer> root, int a){
        while(root != null){
            if(root.data.equals(a)){
                return true;
            }
            else if(root.data > a){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return false;
    }
    
    public static int getLCA_helper(BinaryTreeNode<Integer> root, int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while(root != null){
            if(root.data >= min && root.data <= max){
                return root.data;
            }
            else if(root.data >= max){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return -1;
    }
    
    /*
     * Given a BST, convert it into a sorted linked list. 
     * You have to return the head of LL.
     */
    public static Node<Integer> constructLinkedList1(BinaryTreeNode<Integer> root) {
		if(root == null){
			return null;
		}
		Node<Integer> head;
		Node<Integer> leftHead = constructLinkedList1(root.left);
		Node<Integer> leftTaill = findTail(leftHead);
		Node<Integer> currNode = new Node<>(root.data);
		
		Node<Integer> rightHead = constructLinkedList1(root.right);
		if(leftHead != null){
			leftTaill.next = currNode;
			currNode.next = rightHead;
			head = leftHead;
		}
		else{
			currNode.next = rightHead;
			head = currNode;
		}
		return head;
		
	}

	public static Node<Integer> findTail(Node<Integer> head){
		if(head == null){
			return null;
		}
		while(head.next != null){
			head = head.next;
		}
		return head;
	}
    
    public static Node<Integer> constructLinkedList2(BinaryTreeNode<Integer> root){
		 Pair3 p = constructLinkedList_helper1(root);
		 return p.head;
	 }

	public static Pair3 constructLinkedList_helper1(BinaryTreeNode<Integer> root){
		if(root == null){
			return new Pair3(null, null);
		}
		Pair3 pLeft = constructLinkedList_helper1(root.left);
		Pair3 pRight = constructLinkedList_helper1(root.right);
		Node<Integer> midNode = new Node<>(root.data);
		if(pLeft.head != null){
			pLeft.tail.next = midNode;
			if(pRight.head != null){
				midNode.next = pRight.head;
				return new Pair3(pLeft.head, pRight.tail);
			}
			else{
				return new Pair3(pLeft.head, midNode);
			}
		}
		else{
			if(pRight.head != null){
				midNode.next = pRight.head;
				return new Pair3(midNode, pRight.tail);
			}
			else{
				return new Pair3(midNode, midNode);
			}
		}
	}
	
	public static Pair3 constructLinkedList_helper2(BinaryTreeNode<Integer> root){
		if(root == null){
			return new Pair3(null, null);
		}
		Pair3 pLeft = constructLinkedList_helper2(root.left);
		Pair3 pRight = constructLinkedList_helper2(root.right);
		Node<Integer> midNode = new Node<>(root.data);
		Node<Integer> head = null, tail = null;
		if(pLeft.head != null){
			pLeft.tail.next = midNode;
		}
		midNode.next = pRight.head;
		if(pLeft.head != null) {
			head = pLeft.head;
		} else {
			head = midNode;
		}
		if(pRight.tail != null) {
			tail = pRight.tail;
		} else {
			tail = midNode;
		}
		return new Pair3(head, tail);
	}
	
	/*
	 * Given a binary search tree, you have to replace each node's data with 
	 * the sum of all nodes which are greater or equal than it. You need to 
	 * include the current node's data also. (
	 */
	// Brute force approach (Time complexity -> O(n*n))
	public static void replaceWithLargerNodesSum1(BinaryTreeNode<Integer> root) {
		replaceWithLargerNodesSum1(root, 0);
	}

	public static void replaceWithLargerNodesSum1(BinaryTreeNode<Integer> root, int upSum){
		if(root == null){
			return;
		}
		root.data += upSum + sum(root.right);
		replaceWithLargerNodesSum1(root.right, upSum);
		replaceWithLargerNodesSum1(root.left, root.data);
	}

	public static int sum(BinaryTreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		return root.data + sum(root.left) + sum(root.right);
	}
	
	// Optimized version (Time complexity -> O(n))
	public static void replaceWithLargerNodesSum2(BinaryTreeNode<Integer> root) {
		replaceWithLargerNodesSum2(root, 0);
	}

	public static int replaceWithLargerNodesSum2(BinaryTreeNode<Integer> root, int upSum){
		if(root == null){
			return 0;
		}
		int rightSum = replaceWithLargerNodesSum2(root.right, upSum);
		int prevRootData = root.data;
		root.data += upSum + rightSum;
		int leftSum = replaceWithLargerNodesSum2(root.left, root.data);
		return rightSum + leftSum + prevRootData;
	}
	
	
	
	/*
	 * Given a BST and an integer k. Find and return the path from the 
	 * node with data k and root (if a node with data k is present in given BST) 
	 * in a list. Return empty list otherwise.
	 */
	public static ArrayList<Integer> getPath1(BinaryTreeNode<Integer> root, int data){
		if(root == null){
			return null;
		}
		ArrayList<Integer> ans = null;
		if(root.data.equals(data)){
			ans = new ArrayList<>();
			ans.add(root.data);
		}
		else if(root.data > data){
			ans = getPath1(root.left, data);
			if(ans != null){
				ans.add(root.data);
			}
		}
		else{
			ans = getPath1(root.right, data);
			if(ans != null){
				ans.add(root.data);
			}
		}
		return ans;
	}
	
	public static ArrayList<Integer> getPath2(BinaryTreeNode<Integer> root, int data){
		ArrayList<Integer> ans = new ArrayList<>();
		while(root != null){
			if(root.data.equals(data)){
				ans.add(root.data);
				break;
			}
			else if(root.data > data){
				ans.add(root.data);
				root = root.left;
			}
			else{
				ans.add(root.data);
				root = root.right;
			}
		}
		if(root == null){
			return new ArrayList<>();
		}
		ArrayList<Integer> newAns = new ArrayList<>();
		for(int i = ans.size()-1; i>=0; i--){
			newAns.add(ans.get(i));
		}
		return newAns;
	}
    
	/*
	 * Given a Binary tree, find the largest BST subtree. That is, 
	 * you need to find the BST with maximum height in the given binary 
	 * tree. You have to return the height of largest BST.
	 */
    public static int largestBSTSubtree1(BinaryTreeNode<Integer> root){
        LengthBSTReturn ans = largestBSTSubtree1_helper(root);
        return ans.hBST;
    }
    
    public static LengthBSTReturn largestBSTSubtree1_helper(BinaryTreeNode<Integer> root) {
        if(root == null){
            return new LengthBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
        LengthBSTReturn leftData = largestBSTSubtree1_helper(root.left);
        LengthBSTReturn rightData = largestBSTSubtree1_helper(root.right);
        
        int min = Math.min(root.data, Math.min(leftData.min, rightData.min));
        int max = Math.max(root.data, Math.max(leftData.max, rightData.max));
        
        boolean isBST = true;
        if(root.data < leftData.max || root.data > rightData.min){
            isBST = false;
        }
        if(!leftData.isBST || !rightData.isBST){
            isBST = false;
        }
        
        if(isBST){
            return new LengthBSTReturn(min, max, 1 + Math.max(leftData.hBST, rightData.hBST), isBST);
        }
        else{
            return new LengthBSTReturn(min, max, Math.max(leftData.hBST, rightData.hBST), isBST);
        }
        
	}
    
    // Another way
    public static int largestBSTSubtree2(BinaryTreeNode<Integer> root) {
		if(root == null){
			return 0;
		}
		if(isBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
			return height(root);
		}
		else{
			int heightLeft = largestBSTSubtree2(root.left);
			int heightRight = largestBSTSubtree2(root.right);
			return Math.max(heightLeft, heightRight);
		}
	}
	
    /*
     * Given a binary search tree and an integer S, find pair of nodes 
     * in the BST which sum to S.
     */
    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		if(root == null){
            return;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTreeNode<Integer> curr = q.poll();
            arr.add(curr.data);
            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
        Collections.sort(arr);
        int i = 0, j = arr.size() -1;
    	while(i<j){
            if(arr.get(i) + arr.get(j) == s){
                System.out.println(arr.get(i) + " " + arr.get(j));
                i++;
                j--;
            } 
            else if(arr.get(i) + arr.get(j) > s){
                j--;
            }
            else{
                i++;
            }
        }
	}
	
    // ********* PRINTING FUNCTIONS FOR A TREE ***********
	
	/*
	 * For a given a Binary Tree of type integer, print it in a level order 
	 * fashion where each level will be printed on a new line. Elements on 
	 * every level will be printed in a linear fashion and a single space will separate them.
	 * 
	 * To print the information of a node with data D, you need to follow the exact format :

           	D:L:X,R:Y

		Where D is the data of a node present in the binary tree. 
		X and Y are the values of the left(L) and right(R) child of the node.
		Print -1 if the child doesn't exist.
	 */
    public static void printLevelWise1(BinaryTreeNode<Integer> root) {
		//Your code goes here
        if(root == null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTreeNode<Integer> curr = q.poll();
            Integer currData = curr.data;
            Integer leftData = -1;
            Integer rightData = -1;
            if(curr.left != null){
                q.add(curr.left);
                leftData = curr.left.data;
            }
            if(curr.right != null){
                q.add(curr.right);
                rightData = curr.right.data;
            }
            System.out.println(currData + ":L:" + leftData + ",R:" + rightData);
        }
	}
    
    /*
     * For a given a Binary Tree of type integer, print it in 
     * a level order fashion where each level will be printed 
     * on a new line. Elements on every level will be printed 
     * in a linear fashion and a single space will separate them.
     */
    public static void printLevelWise2(BinaryTreeNode<Integer> root) {
		if(root == null){
			return ;
		}
		Queue<BinaryTreeNode<Integer>> que = new LinkedList<>();
		que.add(root);
		que.add(null);
		while(!que.isEmpty()){
			BinaryTreeNode<Integer> curr = que.poll();
			if(curr == null){
				if(!que.isEmpty()){
					que.add(null);
					System.out.println();
				}
			}
			else{
				if(curr.left != null){
					que.add(curr.left);
				}
				if(curr.right != null){
					que.add(curr.right);
				}
				System.out.print(curr.data + " ");
			}
		}
	}
	
	public static void printBTDetailed(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " : ");
		if(root.left != null) {
			System.out.print("L" + root.left.data + " ");
		}
		if(root.right != null) {
			System.out.print("R" + root.right.data);
		}
		System.out.println();
		printBTDetailed(root.left);
		printBTDetailed(root.right);
	}
	
	public static void printBT(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data);
		printBT(root.left);
		printBT(root.right);
	}

	public static void main(String[] args) {
//		BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, false);
//		preOrder(root);
//		System.out.println();
//		postOrder(root);
//		System.out.println();
//		printBTDetailed(root);
		
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		ArrayList<Integer> ans = nodeToRootPath(root, 5);
		if(ans.size() == 0) {
			System.out.println("Not Found.");
		}
		else{
			for(int i = 0; i<ans.size(); i++) {
				System.out.print(ans.get(i) + " ");
			}
		}
//		preOrder(root);
//		System.out.println();
//		inOrder(root);
//		System.out.println();
//		printLevelWise(root);
	}

}
