package trees;

public class BST {
	
	private BinaryTreeNode<Integer> root;
	private int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	
	// Static since the method is independent on object of the BST class
	private static boolean isPresentHelper(BinaryTreeNode<Integer> root, int target) {
		if(root == null) {
			return false;
		}
		boolean ans = false;
		if(root.data == target) {
			ans = true;
		}
		else if(root.data > target) {
			ans = isPresentHelper(root.left, target);
		}
		else {
			ans = isPresentHelper(root.right, target);
		}
		return ans;
	}
	
	// Time complexity = O(H) = Space complexity
	public boolean isPresent(int target) {
		return isPresentHelper(root, target);
	}
	
	private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data){
        if(root == null){
            return new BinaryTreeNode<>(data);
        }
        if(root.data < data){
            root.right = insertHelper(root.right, data);
        }
        else{
            root.left = insertHelper(root.left, data);
        }
        return root;
    }
	
	// Time complexity = O(H) = Space complexity
	public void insert(int value) {
		root = insertHelper(root, value);
        size++;
	}
	
	private static BinaryTreeNode<Integer> deleteHelper(BinaryTreeNode<Integer> root, int value){
		if(root == null) {
			return null;
		}
		if(root.data > value) {
			root.left = deleteHelper(root.left, value);
		}
		else if(root.data < value) {
			root.right = deleteHelper(root.right, value);
		}
		else {
			// If root has 0 child
			if(root.left == null && root.right == null) {
				root = null;
			}
			// If root has 1 child
			else if(root.left == null) {
				root = root.right;
			}
			// If root has 1 child
			else if(root.right == null) {
				root = root.left;
			}
			// If root has 2 child
			else {
				BinaryTreeNode<Integer> temp = root.right;
				while(temp.left != null) {
					temp = temp.left;
				}
				root.data = temp.data;
				root.right = deleteHelper(root.right, temp.data);
			}
		}
		return root;
	}
	
	// Time complexity = O(H) = Space complexity
	public boolean deleteData(int value) {
		boolean isPresent = isPresent(value);
		if(isPresent == true) {
			size--;
			root = deleteHelper(root, value);
			return true;
		}
		return false;
	}
	
	public int size() {
		return size;
	}
	
	public static void printTreeHelper(BinaryTreeNode<Integer> root) {
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
		printTreeHelper(root.left);
		printTreeHelper(root.right);
	}
	
	// Time complexity = O(n), Space complexity = O(H)
	public void printTree() {
		printTreeHelper(root);
	}
	
}
