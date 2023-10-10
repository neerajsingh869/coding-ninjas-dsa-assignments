package optionalBinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

class BinaryTreeNodeC<T> {
	T data;
	BinaryTreeNodeC<T> left;
	BinaryTreeNodeC<T> right;
	BinaryTreeNodeC<T> random;
	public BinaryTreeNodeC(T data) {
		this.data = data;
	}
}

public class CloneBinaryTree {
	
	/*
	 * You are given a binary tree with random pointers. A random pointer 
	 * of a node points to any random node of the binary tree and it 
	 * can even point to NULL. You have to clone this binary tree and 
	 * return the root of the cloned binary tree.
		Input Format:
		The first line contains an integer N denoting the no of edges of the 
		tree and then in the next line are N space-separated queries.
		The query on the tree are of three types
		a) a b L  (Represents that b is the left child of a)
		b) a b R (Represents that b is the right child of a)
		c) a b X (Represents a random pointer from node a to node b)  
		Output Format:
		Your function should return the root of the cloned tree. The output 
		will be 1 if the tree is successfully cloned.
		Constraints:
		0 <=Number of nodes<= 100
		1 <=Data of a node<= 1000
		Sample Input:
		6
		6 3 L 6 8 R 3 1 L 3 5 R 1 3 X 5 6 X
		Sample Output:
		1
	 */
	
	// Time Complexity -> O(n*n), Space Complexity -> O(h)
	private static BinaryTreeNodeC<Integer> clonedTreeRoot = null;
    private static int countForRoot = 1;
    public static BinaryTreeNodeC<Integer> clonedTree1(BinaryTreeNodeC<Integer> root) {
       constructCloneTree(root);
       connectRandomNodes(root);
       return clonedTreeRoot;
    }

    public static BinaryTreeNodeC<Integer> constructCloneTree(BinaryTreeNodeC<Integer> root){
        if(root == null){
           return null;
       }
        BinaryTreeNodeC<Integer> newRoot = new BinaryTreeNodeC<>(root.data);
        if(countForRoot > 0){
            clonedTreeRoot = newRoot;
            countForRoot--;
        }
        newRoot.left = constructCloneTree(root.left);
        newRoot.right = constructCloneTree(root.right);
        return newRoot;
    }

    public static void connectRandomNodes(BinaryTreeNodeC<Integer> root){
        if(root == null){
            return;
        }
        if(root.random != null){
        	BinaryTreeNodeC<Integer> toConnect = search(clonedTreeRoot, root);
        	BinaryTreeNodeC<Integer> connectWith = search(clonedTreeRoot, root.random);
            toConnect.random = connectWith;
        }
        connectRandomNodes(root.left);
        connectRandomNodes(root.right);
    }
    
    public static BinaryTreeNodeC<Integer> search(BinaryTreeNodeC<Integer> root, BinaryTreeNodeC<Integer> target){
        if(root == null){
            return null;
        }
        if(target.data.equals(root.data)){
            return root;
        }
        BinaryTreeNodeC<Integer> leftAns = search(root.left, target);
        return (leftAns == null) ? search(root.right, target) : leftAns;
    }
    
    // Time Complexity -> O(n), Space Complexity -> O(h)
    public static BinaryTreeNodeC<Integer> clonedTree2(BinaryTreeNodeC<Integer> root) {
        // Step 1 -> Attach Cloned Tree without Random Nodes in Original Tree 
        attachCloneTreeToGivenTree(root);
        // Step 2 -> Cloning random nodes from Original Tree
        connectRandomNodesInClonedTree(root);
        // Step 3 -> Detach cloned Tree from Original Tree to get answer
        BinaryTreeNodeC<Integer> clonedTreeRoot = detachCloneTreeFromGivenTree(root);
        return clonedTreeRoot;
    }

    private static void attachCloneTreeToGivenTree(BinaryTreeNodeC<Integer> root){
        if(root == null){
            return ;
        }
        BinaryTreeNodeC<Integer> clonedRoot = new BinaryTreeNodeC<>(root.data);
        BinaryTreeNodeC<Integer> rootLeft = root.left;
        root.left = clonedRoot;
        clonedRoot.left = rootLeft;
        attachCloneTreeToGivenTree(root.left.left);
        attachCloneTreeToGivenTree(root.right);
        if(root.left != null && root.right != null){
            root.left.right = root.right.left;
        }
    }

    private static void connectRandomNodesInClonedTree(BinaryTreeNodeC<Integer> root){
        if(root == null || root.left == null || root.random == null){
            return;
        }
        root.left.random = root.random.left;
        connectRandomNodesInClonedTree(root.left.left);
        connectRandomNodesInClonedTree(root.right);
    }

    private static BinaryTreeNodeC<Integer> detachCloneTreeFromGivenTree(BinaryTreeNodeC<Integer> root){
        if(root == null || root.left == null){
            return null;
        }
        BinaryTreeNodeC<Integer> clonedRoot = root.left;
        root.left = root.left.left;
        if(clonedRoot.left != null){
            clonedRoot.left = clonedRoot.left.left;
        }
        detachCloneTreeFromGivenTree(root.left);
        detachCloneTreeFromGivenTree(root.right);
        return clonedRoot;
    }
	
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNodeC<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNodeC<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNodeC<Integer>>(); // we can skip writing again inside <> after java version 1.7 
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNodeC<Integer> root = new BinaryTreeNodeC<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNodeC<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNodeC<Integer> leftChild = new BinaryTreeNodeC<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNodeC<Integer> rightChild = new BinaryTreeNodeC<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}
	
	public static void print(BinaryTreeNodeC<Integer> root) {
		if(root == null) return;
		Queue<BinaryTreeNodeC<Integer>> q = new LinkedList<BinaryTreeNodeC<Integer>>();
		q.add(root);
  		while(!q.isEmpty()) {
		  BinaryTreeNodeC<Integer> node = q.poll();
		  
          if(node == null) {
            System.out.println();
         	if(!q.isEmpty()) q.add(null);
          }
          else {
            System.out.print(node.data + ":L:");
            if(node.left != null) {
			  	q.add(node.left);
			  	System.out.print(node.left.data + ",");
            }
            else {
				System.out.print("-1,");
			}
			System.out.print("R:");
            if(node.right != null) {
			  	q.add(node.right);
			  	System.out.println(node.right.data);
          	}
            else {
				System.out.println("-1");
            }
          }
    	}
	}

	public static int validate(BinaryTreeNodeC<Integer> original,BinaryTreeNodeC<Integer> cloned) {
	if((original == null) ^ (cloned == null)) return 0;	
    if ((original==null && cloned==null) || (original.random==null && cloned.random==null))
    {
        return 1;
    }
    if((original.random.data.equals(cloned.random.data)) && (validate(original.left,cloned.left) == 1) && (validate(original.right,cloned.right) == 1))
    {
        return 1;
    }
    return 0;
}
	
	public static void main(String[] args) {
		TreeMap<Integer, BinaryTreeNodeC<Integer>> m = new TreeMap<Integer, BinaryTreeNodeC<Integer>>();
     	int n = s.nextInt();
     	BinaryTreeNodeC<Integer> root = null;
     	BinaryTreeNodeC<Integer> child;
     	while (n > 0) {
			--n;
			BinaryTreeNodeC<Integer> parent;
			int n1 = s.nextInt();
			int n2 = s.nextInt();
        	char pos = s.next().charAt(0);
        	if (!m.containsKey(n1)) {
				parent = new BinaryTreeNodeC<Integer>(n1);
				m.put(n1, parent);   
           		if (root == null) {
					 root = parent;
				}
        	}
        	else {
				parent = m.get(n1);
			}
        	child = new BinaryTreeNodeC<Integer>(n2);
        	if (pos == 'L') {
				parent.left = child;
				m.put(n2, child);
        	}
        	else if(pos == 'R') {
				parent.right = child;
				m.put(n2, child);
        	}
        	else {
          		parent.random = m.get(n2);
        	}
     	}
     	BinaryTreeNodeC<Integer> clonedroot = clonedTree2(root);
     	if(root != null) {
      		if(clonedroot == root) {
				System.out.println(0);
      		}
      		else {
        		System.out.print(validate(root,clonedroot));
      		}
    	}
     	else {
        	System.out.print(1);
      	}
      	System.out.println();
	}

}
