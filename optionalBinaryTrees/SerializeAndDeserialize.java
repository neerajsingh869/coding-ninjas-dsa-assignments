package optionalBinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class SerializeAndDeserialize {
	
	/*
	 * You are given a binary tree and you have to serialize and deserialize 
	 * the given binary tree. Serialization is to store the tree in an array 
	 * so that it can be restored later while deserialization reading tree 
	 * back from that array.
	 * 
		The structure of the tree must be maintained while serializing or deserializing the 
		binary tree. You have to complete the function serialization and deserialization.
		
		Input Format:
		The first line contains an integer N denoting the no of edges of the tree and then 
		in the next line are N space-separated queries. The query on the tree are of two types:
		a) a b L  (Represents that b is the left child of a)
		b) a b R (Represents that b is the right child of a)
		
		Output Format:
		The output will be the inorder traversal of the returned tree after deserialization.
		
		Constraints:
		0<= Number of nodes<= 100
		1 <= Data of a node<= 100
		
		Sample Input:
		4
		8 100 L 8 120 R 100 140 L 100 170 R
		Sample Output:
		140 100 170 8 120
	 */
	// Time complexity -> O(n), Space complexity -> O(n)
	public static void serialize(BinaryTreeNode<Integer> root, ArrayList<Integer> tree) {
		Queue<BinaryTreeNode<Integer>> que = new LinkedList<>();
		que.add(root);
		
		while ( !que.isEmpty() ) {
			BinaryTreeNode<Integer> curr = que.poll();
			// If current node is not null, then add it in tree array
			// and also, add its left and child node in queue if they exists
			if (curr != null) {
				tree.add(curr.data);
				
				if (curr.left != null) {
					que.add(curr.left);
				} else {
					que.add(null);
				}
				
				if (curr.right != null) {
					que.add(curr.right);
				} else {
					que.add(null);
				}
			} else {
				tree.add(-1);
			}
		}
    }   
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static BinaryTreeNode<Integer> deSerialize(ArrayList<Integer> tree) {
		int n = tree.size();
		if (n == 0) {
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(tree.get(0));
		
		Queue<BinaryTreeNode<Integer>> que = new LinkedList<>();
		que.add(root);
		int i = 0;
		
		while ( !que.isEmpty() ) {
			BinaryTreeNode<Integer> curr = que.poll();
			
			if (curr != null) {
				int leftChildIdx = 2*i + 1;
				if (leftChildIdx < n && tree.get(leftChildIdx) != -1) {
					curr.left = new BinaryTreeNode<>(tree.get(leftChildIdx));
					que.add(curr.left);
				}
				
				int rightChildIdx = 2*i + 2;
				if (rightChildIdx < n && tree.get(rightChildIdx) != -1) {
					curr.right = new BinaryTreeNode<>(tree.get(rightChildIdx));
					que.add(curr.right);
				}
			}
			
			i++;
		}
		
		return root;
	}

	// Time complexity -> O(n*n), Space complexity -> O(n)
    public static BinaryTreeNode<Integer> deSerialize_worst(ArrayList<Integer> tree) {
        int n = tree.size();
        int i = 0;
        
        boolean isRoot = false;
        BinaryTreeNode<Integer> root = null;
        
        while (i < n) {
        	int currNodeData = tree.get(i);
        	// if data = -1, then it is not any valid node
        	if (currNodeData != -1) {
        		// to get root node of the tree
        		if (!isRoot) {
        			root = new BinaryTreeNode<>(currNodeData);;
        			isRoot = true;
        		}
        		// if left child exists and is valid, then create node 
        		// and put it on left side of current node
        		int leftChildIdx = 2*i + 1;
        		if (leftChildIdx < n && tree.get(leftChildIdx) != -1) {
        			insertLeftChild(root, currNodeData, tree.get(leftChildIdx));
        		}
        		// if right child exists and is valid, then create node 
        		// and put it on right side of current node
        		int rightChildIdx = 2*i + 2;
        		if (rightChildIdx < n && tree.get(rightChildIdx) != -1) {
        			insertRightChild(root, currNodeData, tree.get(rightChildIdx));
        		}
        	}
        	// Move to next index
        	i++;
        }
        
        return root;
    }
    
    public static void insertLeftChild(BinaryTreeNode<Integer> root, int parentData, int LeftNodeData) {
    	if (root == null) {
    		return;
    	}
    	if (root.data.equals(parentData)) {
    		root.left = new BinaryTreeNode<>(LeftNodeData);
    		return;
    	}
    	insertLeftChild(root.left, parentData, LeftNodeData);
    	insertLeftChild(root.right, parentData, LeftNodeData);
    }
    
    public static void insertRightChild(BinaryTreeNode<Integer> root, int parentData, int RightNodeData) {
    	if (root == null) {
    		return;
    	}
    	if (root.data.equals(parentData)) {
    		root.right = new BinaryTreeNode<>(RightNodeData);
    		return;
    	}
    	insertRightChild(root.left, parentData, RightNodeData);
    	insertRightChild(root.right, parentData, RightNodeData);
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

	public static void inorder(BinaryTreeNode<Integer> root) {
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public static void main(String[] args) {
		TreeMap<Integer, BinaryTreeNode<Integer>> m = new TreeMap<Integer, BinaryTreeNode<Integer>>();
     	int n = s.nextInt();
     	BinaryTreeNode<Integer> root = null;
     	BinaryTreeNode<Integer> child;
     	while (n > 0) {
			--n;
			BinaryTreeNode<Integer> parent;
			int n1 = s.nextInt();
			int n2 = s.nextInt();
			char pos = s.next().charAt(0);
        	if (!m.containsKey(n1)) {
           		parent = new BinaryTreeNode<Integer>(n1);
           		m.put(n1, parent);
           		if (root == null) {
             		root = parent;
           		}
        	}
        	else {
           		parent = m.get(n1);
        	}
        	child = new BinaryTreeNode<Integer>(n2);
        	if (pos == 'L'){
          		parent.left = child;
        	}
        	else{
          		parent.right = child;
			}
			m.put(n2, child);
		}
		ArrayList<Integer> tree = new ArrayList<Integer>();
    	serialize(root,tree);
    	BinaryTreeNode<Integer> newroot = deSerialize(tree);
    	inorder(newroot);
	}

}
