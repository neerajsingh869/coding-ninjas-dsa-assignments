package trees;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class GenericTreeUse {
	
	public static GenericTreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.print("Enter root data: ");
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		GenericTreeNode<Integer> root = new GenericTreeNode<>(rootData);
		Queue<GenericTreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			GenericTreeNode<Integer> curr = q.poll();
			System.out.print("Number of children of " + curr.data + ": ");
			int rootChildCount = s.nextInt();
			for(int i = 0; i<rootChildCount; i++) {
				System.out.print("Enter child " + (i+1) + " node data: ");
				int childData = s.nextInt();
				GenericTreeNode<Integer> child = new GenericTreeNode<>(childData);
				curr.children.add(child);
				q.add(child);
			}
		}
		return root;
	}
	
	public static GenericTreeNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		// Just to handle edge case when
		// the tree is null
		if(rootData == -1) {
			return null;
		}
		
		int rootChildCount = s.nextInt();
		GenericTreeNode<Integer> root = new GenericTreeNode<>(rootData);
		for(int i = 0; i<rootChildCount; i++) {
			root.children.add(takeInput());
		}
		return root;
	}
	
	// ***************** Problems related to Generic Trees ********************
	// (In most of problem related to Generic Trees, there is hidden base case like 
	// the no. of children a node has is acting as a base case. So, don't need to 
	// write base case explicitly.)
	
	public static int totalNodes(GenericTreeNode<Integer> root) {
		// Edge case not base case
		if(root == null) {
			return 0;
		}
		int ans = 0;
		int n = root.children.size();
		for(int i = 0; i<n; i++) {
			ans += totalNodes(root.children.get(i));
		}
		return ans+1;
	}
	
	public static int sumOfAllNodes(GenericTreeNode<Integer> root) {
		// Edge case not base case
		if(root == null) {
			return 0;
		}
		int sum = 0;
		int n = root.children.size();
		for(int i = 0; i<n; i++) {
			sum += sumOfAllNodes(root.children.get(i));
		}
		return sum+root.data;
	}
	
	/*
	 * Given a tree and an integer x, find and return number 
	 * of Nodes which are greater than x.
	 */
	public static int numNodeGreater(GenericTreeNode<Integer> root,int x){

		if(root == null){
            return 0;
        }
        int ans = 0;
        for(GenericTreeNode<Integer> child : root.children){
            ans += numNodeGreater(child, x);
        }
        return (root.data > x) ? ans + 1 : ans;
	}
	
	/*
	 * Given a generic tree, find and return the height of given tree.
	 */
	public static int getHeight(GenericTreeNode<Integer> root){
        // Not a base case, just an edge case
        if(root == null){
            return 0;
        }
        int maxSubTreeHeight = 0;
        for(GenericTreeNode<Integer> child : root.children){
            maxSubTreeHeight = Math.max(maxSubTreeHeight, getHeight(child));
        }
        return maxSubTreeHeight + 1;
	}
	
	/*
	 * Given a generic tree, count and return the number of leaf 
	 * nodes present in the given tree.
	 */
	public static int countLeafNodes(GenericTreeNode<Integer> root){        
        // Edge case
        if(root == null){
            return 0;
        }		
        // Base case
        if(root.children.size() == 0){
            return 1;
        }        
        int ans = 0;
        for(GenericTreeNode<Integer> child : root.children){
            ans += countLeafNodes(child);
        }
        return ans;
	}
	
	/*
	 * Given a generic tree and an integer x, check if x is present 
	 * in the given tree or not. Return true if x is present, return 
	 * false otherwise.
	 */
	public static boolean checkIfContainsX(GenericTreeNode<Integer> root, int x){
		// Edge case
        if(root == null){
            return false;
        }
        if(root.data == x){
            return true;
        }
        for(GenericTreeNode<Integer> child : root.children){
            if(checkIfContainsX(child, x)){
                return true;
            }
        }
        return false;
	}
	
	
	
	/*
	 * Given a tree, find and return the node for which sum 
	 * of data of all children and the node itself is maximum. 
	 * In the sum, data of node itself and data of immediate 
	 * children is to be taken.
	 */
	public static GenericTreeNode<Integer> maxSumNode1(GenericTreeNode<Integer> root){
		return maxSumNode1_helper(root).maxSumNode;
	}
	
	public static MaxSumNodeReturn maxSumNode1_helper(GenericTreeNode<Integer> root){
        // Edge case
        if(root == null){
            return new MaxSumNodeReturn(null, Integer.MIN_VALUE);
        }
        int sum = root.data;
        for(GenericTreeNode<Integer> child : root.children){
            sum += child.data;
        }
        MaxSumNodeReturn ans = new MaxSumNodeReturn(root, sum);
        for(GenericTreeNode<Integer> child : root.children){
            MaxSumNodeReturn childAns = maxSumNode1_helper(child);
            if(childAns.maxSum >= ans.maxSum){
                ans = childAns;
            }
        }
        return ans;
    }
	
	// Another way (Brute Force)
	public static GenericTreeNode<Integer> maxSumNode2(GenericTreeNode<Integer> root){
		if(root == null){
			return null;
		}
		int currMaxSum = root.data;
		GenericTreeNode<Integer> currMaxNode = root;
		for(GenericTreeNode<Integer> child : root.children){
			currMaxSum += child.data;
		}
		for(GenericTreeNode<Integer> child : root.children){
			GenericTreeNode<Integer> tempNode = maxSumNode2(child);
			int tempSum = tempNode.data;
			for(GenericTreeNode<Integer> subChild : tempNode.children){
				tempSum += subChild.data;
			}
			if(tempSum > currMaxSum){
				currMaxSum = tempSum;
				currMaxNode = tempNode;
			}
		}
		return currMaxNode;
	}
	
	/*
	 * Given two Generic trees, return true if they are structurally 
	 * identical i.e. they are made of nodes with the same values arranged in the same way.
	 */
	public static boolean checkIdentical(GenericTreeNode<Integer> root1, GenericTreeNode<Integer> root2){
		// Edge case
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
		int n = root1.children.size();
        int m = root2.children.size();
        if(n != m){
            return false;
        }
        for(int i = 0; i<n; i++){
            boolean tempAns = checkIdentical(root1.children.get(i), root2.children.get(i));
            if(!tempAns){
                return false;
            }
        }
        return (root1.data.equals(root2.data)) ? true : false;
	}
	
	/*
	 * Given a generic tree and an integer n. Find and return the 
	 * node with next larger element in the Tree i.e. find a node 
	 * with value just greater than n
	 * (Solved using ITERATION)
	 */
	public static GenericTreeNode<Integer> findNextLargerNode1(GenericTreeNode<Integer> root, int n){
		if(root == null) {
			return null;
		}
		GenericTreeNode<Integer> ans = null;
        Queue<GenericTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
        	GenericTreeNode<Integer> curr = q.poll();
            if(curr.data > n){
                ans = (ans == null) ? curr : 
                	new GenericTreeNode<>(Math.min(curr.data, ans.data));
            }
            for(GenericTreeNode<Integer> child : curr.children){
                q.add(child);
            }
        }
        return ans;
	}
	
	public static GenericTreeNode<Integer> findNextLargerNode2(GenericTreeNode<Integer> root, int n){
		if(root == null){
			return null;
		}

		GenericTreeNode<Integer> nleNode = null;
		int nle = Integer.MAX_VALUE;

		Queue<GenericTreeNode<Integer>> que = new LinkedList<>();
		que.add(root);
		while(!que.isEmpty()){
			GenericTreeNode<Integer> curr = que.poll();

			for(GenericTreeNode<Integer> child : curr.children){
				que.add(child);
			}
			
			if (curr.data > n && curr.data < nle) {
				nle = curr.data;
				nleNode = curr;
			}
		}

		return nleNode;
	}
	
	/*
	 * Given a generic tree and an integer n. Find and return the 
	 * node with next larger element in the Tree i.e. find a node 
	 * with value just greater than n.
	 * (Solved using RECURSION)
	 */
	public static GenericTreeNode<Integer> findNextLargerNodeRec1(GenericTreeNode<Integer> root, int n){
		if(root == null) {
			return null;
		}
		GenericTreeNode<Integer> ans = null;
        for(GenericTreeNode<Integer> child : root.children){
        	GenericTreeNode<Integer> tempAns = findNextLargerNodeRec1(child, n);
            if(tempAns != null){
                ans = (ans == null) ? tempAns : new GenericTreeNode<>(Math.min(ans.data, tempAns.data));
            }
        }
        if(root.data > n){
            ans = (ans == null) ? root : new GenericTreeNode<>(Math.min(ans.data, root.data));
        }
        return ans;
	}
	
	public static GenericTreeNode<Integer> findNextLargerNodeRec2(GenericTreeNode<Integer> root, int n){
		if (root == null) return null;

		int nle = (root.data > n) ? root.data : Integer.MAX_VALUE;
		GenericTreeNode<Integer> nleNode = (root.data > n) ? root : null;

		for (GenericTreeNode<Integer> child : root.children) {
			GenericTreeNode<Integer> tempNleNode = findNextLargerNodeRec2(child, n);
			if (tempNleNode != null) {
				if (tempNleNode.data < nle) {
					nle = tempNleNode.data;
					nleNode = tempNleNode;
				}
			}
		}

		if (nle == Integer.MAX_VALUE) {
			return null;
		} else {
			return nleNode;
		}

	}
	
	/*
	 * Given a generic tree and an integer n. Find and return the 
	 * node with next smaller element in the Tree i.e. find a node 
	 * with value just smaller than n
	 */
	public static GenericTreeNode<Integer> findNextSmallerNodeRec(GenericTreeNode<Integer> root, int n){
        if(root == null) {
			return null;
		}
        GenericTreeNode<Integer> ans = null;
        for(GenericTreeNode<Integer> child : root.children){
        	GenericTreeNode<Integer> tempAns = findNextSmallerNodeRec(child, n);
            if(tempAns != null){
                ans = (ans == null) ? tempAns : new GenericTreeNode<>(Math.max(ans.data, tempAns.data));
            }
        }
        if(root.data < n){
            ans = (ans == null) ? root : new GenericTreeNode<>(Math.max(ans.data, root.data));
        }
        return ans;
	}
	
	/*
	 * In a given Generic Tree, replace each node with its depth value. 
	 * You need to just update the data of each node, no need to return or print anything.
	 */
	public static void replaceWithDepthValue1(GenericTreeNode<Integer> root){

		if(root == null){
            return;
        }
        Queue<GenericTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = 0;
        while(!q.isEmpty()){
        	GenericTreeNode<Integer> curr = q.poll();
            if(curr == null){
                if(!q.isEmpty()){
                    level++;
					q.add(null);
                }
            }
            else{
                curr.data = level;
                int n = curr.children.size();
                for(int i = 0; i<n; i++){
                    q.add(curr.children.get(i));
                }
            }
        }
		
	}
	
	public static void replaceWithDepthValue2_helper(GenericTreeNode<Integer> root, int level){
        // Edge case
		if(root == null){
            return;
        }
        root.data = level++;
        for(GenericTreeNode<Integer> child : root.children){
        	replaceWithDepthValue2_helper(child, level);
        }
    }
    
	/*
	 * In a given Generic Tree, replace each node with its depth value. 
	 * You need to just update the data of each node, no need to return or print anything.
	 * (Solved using RECURSION)
	 */
	public static void replaceWithDepthValue2(GenericTreeNode<Integer> root){

		replaceWithDepthValue2_helper(root, 0);
		
	}
	
	/*
	 * Given a generic tree, find and return the node with second largest 
	 * value in given tree. Return NULL if no node with required value is present.
	 */
	public static GenericTreeNode<Integer> findSecondLargest1(GenericTreeNode<Integer> root){

		return findSecondLargest1_helper(root).second;

	}
	
	public static Pair2<GenericTreeNode<Integer>> findSecondLargest1_helper(GenericTreeNode<Integer> root){
        if(root == null){
            return new Pair2<>(null, null);
        }
        Pair2<GenericTreeNode<Integer>> ans = new Pair2<>(root, null);
        for(GenericTreeNode<Integer> child : root.children){
        	Pair2<GenericTreeNode<Integer>> tempAns = findSecondLargest1_helper(child);
            if(tempAns.first.data > ans.first.data){
                if(tempAns.second == null || (ans.first.data > tempAns.second.data)){
                    ans.second = ans.first;
                }
                else{
                    ans.second = tempAns.second;
                }
                ans.first = tempAns.first;
            }
            else if(tempAns.first.data.equals(ans.first.data)){
                if(tempAns.second != null){
                    if(ans.second == null || tempAns.second.data > ans.second.data){
                    	ans.second = tempAns.second;
                	}
                }
            	
            }
            else{
               	if(ans.second == null || tempAns.first.data > ans.second.data){
                   ans.second = tempAns.first;
               	}
            }
        }
        return ans;
    }
	
	// Better approach
	public static GenericTreeNode<Integer> findSecondLargest2(GenericTreeNode<Integer> root){
		if (root == null) {
			return null;
		}
		Queue<GenericTreeNode<Integer>> q = new LinkedList<>();
		GenericTreeNode<Integer> maxNode = null;
		int max = Integer.MIN_VALUE;
		GenericTreeNode<Integer> max2Node = null;
		int max2 = Integer.MIN_VALUE;
		q.add(root);
		while (!q.isEmpty()) {
			GenericTreeNode<Integer> curr = q.poll();
			int n = curr.children.size();
			for (int i = 0; i < n; i++) {
				q.add(curr.children.get(i));
			}
			if(curr.data > max){
				max2Node = maxNode;
				max2 = max;
				maxNode = curr;
				max = curr.data;
			}
			else{
				if(!curr.data.equals(max) && curr.data > max2){
					max2 = curr.data;
					max2Node = curr;
				}
			}
		}
		return max2Node;
	}
	
	// ********* PRINTING FUNCTIONS FOR A TREE ***********
	
	/*
	 * Given a generic tree, print the input tree in level wise order. 
	 * That is, print the elements at same level in one line (separated by space). 
	 * Print different levels in different lines.
	 */
	public static void printLevelWise(GenericTreeNode<Integer> root){
		if(root == null){
            return;
        }
        Queue<GenericTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
        	GenericTreeNode<Integer> curr = q.poll();
            if(curr == null){
                System.out.println();
                if(!q.isEmpty()){
					q.add(null);
                }
            }
            else{
               	System.out.print(curr.data + " ");
                int n = curr.children.size();
                for(int i = 0; i<n; i++){
                    q.add(curr.children.get(i));
                }
            }
        }
	}
	
	public static void printLevelWiseNotNull(GenericTreeNode<Integer> root) {
		if(root == null){
            return;
        }
		Queue<GenericTreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
        	GenericTreeNode<Integer> curr = q.poll();
            System.out.print(curr.data + " ");
            int n = curr.children.size();
            for(int i = 0; i<n; i++){
                q.add(curr.children.get(i));
            }
        }
	}
	
	/*
	 * Given a generic tree, print the post-order traversal of given tree.
	 */
	public static void printPostOrder(GenericTreeNode<Integer> root){
        // Edge case
        if(root == null){
            return;
        }
        for(GenericTreeNode<Integer> child : root.children){
            printPostOrder(child);
        }
        System.out.print(root.data + " ");
	}
	
	public static void printTreeDetailed(GenericTreeNode<Integer> root) {
		// It is not base case but an edge case
		// There is no need of base case in the problem
		if(root == null) {
			return;
		}
		System.out.print(root.data + ": ");
		int n = root.children.size();
		for(int i = 0; i<n; i++) {
			System.out.print(root.children.get(i).data + " ");
		}
		System.out.println();
		for(int i = 0; i<n; i++) {
			printTreeDetailed(root.children.get(i));
		}
	}
	
	public static void printTree(GenericTreeNode<Integer> root) {
		// It is not base case but an edge case
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		int n = root.children.size();
		for(int i = 0; i<n; i++) {
			printTree(root.children.get(i));
		}
	}

	public static void main(String[] args) {
//		GenericTreeNode<Integer> root = new GenericTreeNode<Integer>(4);
//		GenericTreeNode<Integer> rootNode1 = new GenericTreeNode<Integer>(2);
//		GenericTreeNode<Integer> rootNode2 = new GenericTreeNode<Integer>(3);
//		GenericTreeNode<Integer> rootNode3 = new GenericTreeNode<Integer>(1);
//		GenericTreeNode<Integer> node2Node1 = new GenericTreeNode<Integer>(5);
//		GenericTreeNode<Integer> node2Node2 = new GenericTreeNode<Integer>(6);
//		
//		root.children.add(rootNode1);
//		root.children.add(rootNode2);
//		root.children.add(rootNode3);
//		
//		rootNode2.children.add(node2Node1);
//		rootNode2.children.add(node2Node2);
		
		GenericTreeNode<Integer> root = takeInputLevelWise();
		printTreeDetailed(root);
		System.out.println("Total Nodes: " + totalNodes(root));
		
	}

}
