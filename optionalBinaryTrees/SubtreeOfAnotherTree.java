package optionalBinaryTrees;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    TreeNode(T val) {
        this.val = val;
        left = right = null;
    }

}

public class SubtreeOfAnotherTree {
	
	/*
	 * Given two binary trees T and S, check whether tree S has exactly the same 
	 * structure and node values with a subtree of T, i.e., check if tree S is a 
	 * subtree of the tree T.
A subtree of a tree T is a tree S consisting of a node in T and all of its descendants 
in T. The subtree corresponding to the root node is the entire tree; the subtree 
corresponding to any other node is called a proper subtree.
Input Format:
The first line of input contains an integer T representing the number of test 
cases. Then the test cases follow.

The first line of each test case contains elements of the first tree in the level 
order form. The line consists of values of nodes separated by a single space. In 
case a node is null, we take -1 in its place.

The second line of each test case contains elements of the second tree in the level 
order form. The line consists of values of nodes separated by a single space. 
In case a node is null, we take -1 in its place.

For example, the input for the tree depicted in the below image would be:
example

1
2 3
4 -1 5 6
-1 7 -1 -1 -1 -1
-1 -1
Explanation:
Level 1:
The root node of the tree is 1

Level 2:
Left child of 1 = 2
Right child of 1 = 3

Level 3:
Left child of 2 = 4
Right child of 2 = null (-1)
Left child of 3 = 5
Right child of 3 = 6

Level 4:
Left child of 4 = null (-1)
Right child of 4 = 7
Left child of 5 = null (-1)
Right child of 5 = null (-1)
Left child of 6 = null (-1)
Right child of 6 = null (-1)

Level 5:
Left child of 7 = null (-1)
Right child of 7 = null (-1)

The first not-null node(of the previous level) is treated as the parent of the 
first two nodes of the current level. The second not-null node (of the previous level) 
is treated as the parent node for the next two nodes of the current level and so on.
The input ends when all nodes at the last level are null(-1).
Note:
The above format was just to provide clarity on how the input is formed for a given tree.
The sequence will be put together in a single line separated by a single space. 
Hence, for the above-depicted tree, the input will be given as:

1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1
Output Format:
For each test case, the only line of output prints true if tree S is a subtree 
of the tree T else prints false.

The output for each test case is in a separate line.
Note:
You do not need to print anything; it has already been taken care of.
Constraints:
1 <= T <= 100
1 <= N, M <= 1000
0 <= data <= 10^6 and data != -1

Where T is the number of test cases, N and M are the number of 
nodes in the given binary trees, and data is the value of the binary tree node.

Time Limit: 1 sec.
Sample Input 1:
2
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
3 6 7 -1 -1 -1 -1
3 4 5 1 2 -1 -1 -1 -1 0 -1 -1 -1
4 1 2 -1 -1 -1 -1
Sample Output 1:
true
false
Explanation of Sample Input 1:
Sample Input 1

For the first test case, the second tree is a subtree of the first tree as the 
second tree has exactly the same structure and node values with a subtree of 
the first tree.

For the second test case, the second tree is not a subtree of the first tree 
because node 2 in the first tree has 1 child having a value 0, whereas node 2 
in the second tree doesn't have any child.
Sample Input 2:
2
26 10 3 4 6 -1 3 -1 30 -1 -1 -1 -1 -1 -1
10 4 6 -1 30 -1 -1 -1 -1
3 4 5 1 2 -1 -1 -1 -1 -1 -1
4 1 -1 -1 -1
Sample Output 2:
true
false
	 */
	// Time complexity -> O(n*n), Space complexity -> O(n + m)
	public static boolean isSubtree1(TreeNode<Integer> T, TreeNode<Integer> S) {
		if (S == null || T == S) {
			return true;
		}
		if (T == null) {
			return false;
		}
		// level order denoting null child identifies a 
		// tree uniquely
		ArrayList<Integer> levelOrderT = getLevelOrder(T);
		ArrayList<Integer> levelOrderS = getLevelOrder(S);
		if (levelOrderT.equals(levelOrderS)) {
			return true;
		} else {
			return (isSubtree1(T.left, S) || isSubtree1(T.right, S));
		}
	}
	
	public static ArrayList<Integer> getLevelOrder(TreeNode<Integer> root) {
		ArrayList<Integer> levelOrder = new ArrayList<>();
		Queue<TreeNode<Integer>> que = new LinkedList<>();
		que.add(root);
		
		while ( !que.isEmpty() ) {
			TreeNode<Integer> curr = que.poll();
			if (curr != null) {
				levelOrder.add(curr.val);
				que.add(curr.left);
				que.add(curr.right);
			} else {
				levelOrder.add(-1);
			}
		}
		
		return levelOrder;
	}
	
	// Time complexity -> O(n*m), Space complexity -> O(h)
	public static boolean isSubtree2(TreeNode<Integer> T, TreeNode<Integer> S) {
		if (S == null || T == S) {
			return true;
		}
		if (T == null) {
			return false;
		}
		if ( isIdentical(T, S) ) {
			// duplicates can exists, therefore returning true
			// only when trees are identical in case their roots
			// are same
			return true;
		}
		return isSubtree2(T.left, S) || isSubtree2(T.right, S);
	}
	
	// Time complexity -> O(m)
	public static boolean isIdentical(TreeNode<Integer> T, TreeNode<Integer> S) {
		if (T == null && S == null) {
			return true;
		}
		if (T == null || S == null || !T.val.equals(S.val)) {
			return false;
		}
		return isIdentical(T.left, S.left) && isIdentical(T.right, S.right); 
	}
	
	// Time complexity -> O(n*m), Space complexity -> O(h)
	// contains method has O(n*m) time complexity
	public static boolean isSubtree3(TreeNode<Integer> T, TreeNode<Integer> S) {
		if (S == null || T == S) {
			return true;
		}
		if (T == null) {
			return false;
		}
		
		String inorderS = inorder(S);
		String inorderT = inorder(T);
		
		if (!inorderT.contains(inorderS)) {
			return false;
		}
		
		String preorderS = preorder(S);
		String preorderT = preorder(T);
		
		if (!preorderT.contains(preorderS)) {
			return false;
		}
		
		return true;
	}
	
	// can use morris inorder traversal algo for space complexity O(1)
	private static String inorder(TreeNode<Integer> node) {

        // Base case.
		if (node == null) {
			return null;
		}

		return inorder(node.left) + " " + String.valueOf(node.val) + " " + inorder(node.right);
	}
	
	// can use morris preorder traversal algo for space complexity O(1)
	private static String preorder(TreeNode<Integer> node) {

        // Base case.
		if (node == null) {
			return null;
		}

		return String.valueOf(node.val) + " " + preorder(node.left) + " " + preorder(node.right);
	}
	
	// Best approach
	// Time complexity -> O(n + m), Space complexity -> O(h) where h is height of T
	// Approach is same as isSubtree3 but search algorithm has changed
	public static boolean isSubtree4(TreeNode<Integer> T, TreeNode<Integer> S) {
		if (S == null || T == S) {
			return true;
		}
		if (T == null) {
			return false;
		}
		
		String inorderS = inorder(S);
		String inorderT = inorder(T);
		
		if (!KMPSearch(inorderS, inorderT)) {
			return false;
		}
		
		String preorderS = preorder(S);
		String preorderT = preorder(T);
		
		if (!KMPSearch(preorderS, preorderT)) {
			return false;
		}
		
		return true;
	}
	
	public static boolean KMPSearch(String pat, String txt) {
		int n = pat.length();
		int m = txt.length();
		
		int[] lps = new int[n];
		
		calculateLPSArray(pat, lps);
		
		int i = 0, j = 0;
		while (i < m) {
			if (pat.charAt(j) == txt.charAt(i)) {
				i++;
				j++;
			}
			if (j == n) {
				// pattern match successful
				j = lps[j-1];
				return true;
			} else if (i < m && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0) {
					j = lps[j-1];
				} else {
					i++;
				}
			}
		}
		
		return false;
	}
	
	public static void calculateLPSArray(String pat, int[] lps) {
		int n = pat.length();
		
		// length of the previous longest prefix suffix
		int len = 0;
		int i = 1;
		
		lps[0] = 0;
		
		while (i < n) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				// This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
				if (len != 0) {
					len = lps[len-1];
					// not incrementing i here
				} else {
					lps[i] = 0;
					// or lps[i] = len
					i++;
				}
			}
		}
	}
	
	 public static class FastReader {

	        BufferedReader br;
	        StringTokenizer root;

	        public FastReader() {
	            br = new BufferedReader(new InputStreamReader(System.in));
	        }

	        String next() {
	            while (root == null || !root.hasMoreTokens()) {
	                try {
	                    root = new StringTokenizer(br.readLine());
	                } catch (Exception r) {
	                    r.printStackTrace();
	                }
	            }
	            return root.nextToken();
	        }

	        int nextInt() {
	            return Integer.parseInt(next());
	        }
	    }

	    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	    public static FastReader sc = new FastReader();

	    private static int t;
	    private static ArrayList<TreeNode<Integer>> arr1,arr2;

	    private static TreeNode<Integer> takeTreeInput() {
	        int val = sc.nextInt();
	        if (val == -1) {
	            return null;
	        }
	        TreeNode<Integer> root = new TreeNode<>(val);
	        Queue<TreeNode<Integer>> q = new LinkedList<>();
	        q.add(root);
	        while (!q.isEmpty()) {
	            TreeNode<Integer> cur = q.remove();
	            int left, right;
	            left = sc.nextInt();
	            if (left != -1) {
	                TreeNode<Integer> lnode = new TreeNode<>(left);
	                cur.left = lnode;
	                q.add(lnode);
	            }
	            right = sc.nextInt();
	            if (right != -1) {
	                TreeNode<Integer> rnode = new TreeNode<>(right);
	                cur.right = rnode;
	                q.add(rnode);
	            }

	        }
	        return root;

	    }

	    private static void takeInput() {
	        t = sc.nextInt();
	        arr1 = new ArrayList<>();
	        arr2 = new ArrayList<>();
	        for (int i = 0; i < t; ++i) {
	            arr1.add(takeTreeInput());
	            arr2.add(takeTreeInput());
	        }
	    }

	    private static TreeNode<Integer> copyTree(TreeNode<Integer> root) {
	        if (root == null) {
	            return null;
	        }

	        TreeNode<Integer> copyRoot = new TreeNode<>(root.val);

	        copyRoot.left = copyTree(root.left);
	        copyRoot.right = copyTree(root.right);

	        return copyRoot;
	    }

	    private static void printTree(TreeNode<Integer> root) {
	        Queue<TreeNode<Integer>> q = new LinkedList<>();
	        q.add(root);
	        while (!q.isEmpty()) {
	            TreeNode<Integer> cur = q.remove();
	            out.print(cur.val + " ");

	            if (cur.left != null) {
	                q.add(cur.left);
	            }
	            else out.print("-1 ");
	            if (cur.right != null) {
	                q.add(cur.right);
	            }
	            else {
	                out.print("-1 ");
	            }
	        }
	    }

	    private static void execute() {

	        for (int i = 0; i < t; ++i) {
	            TreeNode<Integer> copy1 = copyTree(arr1.get(i));
	            TreeNode<Integer> copy2 = copyTree(arr2.get(i));
	            boolean ans = isSubtree2(copy1, copy2);
	        }
	    }

	    private static void executeAndPrintOutput() {
	        for (int i = 0; i < t; ++i) {
	            boolean ans = isSubtree2(arr1.get(i), arr2.get(i));
	            System.out.println(ans);
	        }
	    }

	    public static void main(String[] args) {
	        takeInput();
	        executeAndPrintOutput();
	        out.close();
	    }

}
