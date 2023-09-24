package optionalBST;

import java.util.Arrays;
import java.util.Scanner;

public class ReplaceWithLeastGreater {
	
	/*
	 * You are given an N-sized array of integers, replace every element of this array with the least greater element on its right side in the array. If there is no greater element on the right side, replace it with -1.
Input Format:
The first line of input contains the number of elements(N) present in the integer array and the second line of input contains N space-separated array elements.
Output Format:
The only output lines contain the N space-separated elements of the updated array.
Constraints:
1<=N<=1000
Sample Input:
17
8 58 71 18 31 32 63 92 43 3 91 93 25 80 28 2 1
Sample Output:
18 63 80 25 32 43 80 93 80 25 93 -1 28 -1 -1 -1 -1
	 */
	// Time complexity -> O(n*n*log(n)), Space complexity -> O(n)
	public static void replace1(int[] arr, int n) {
        for(int i = 0; i<n; i++) {
            int minVal = -1;
            int[] temp = new int[n-i-1];
            int k = 0;
            for(int j = i+1; j<n; j++){
                temp[k++] = arr[j];
            }
            Arrays.sort(temp);
            for(int j = 0; j<n-i-1; j++){
                if(temp[j] > arr[i]) {
                    minVal = temp[j];
                    break;
                }
            }
            arr[i] = minVal;
        }
    }
	
	// Time complexity -> O(n*h), Space complexity -> O(n)
	public static void replace2(int[] arr, int n) {
        BinaryTreeNode<Integer> root = null;
        for(int i = n-1; i>=0; i--) {
            root = insert(arr[i], root);
            BinaryTreeNode<Integer> inorderSuccessor = getsuccesor(root, arr[i]);
            if(inorderSuccessor == null) {
                arr[i] = -1;
            } else {
                arr[i] = inorderSuccessor.data;
            }
        }
    }

    private static BinaryTreeNode<Integer> insert(int data, BinaryTreeNode<Integer> root) {
        if(root == null) {
            return new BinaryTreeNode<>(data);
        }
        if(data > root.data) {
            root.right = insert(data, root.right);
        } else {
            root.left = insert(data, root.left);
        }
        return root;
    }

     public static BinaryTreeNode<Integer> getsuccesor(BinaryTreeNode<Integer> root, int data){
        BinaryTreeNode<Integer> current=find(root,data);
        if(current==null)
            return null;
        else if(current.right!=null){
            BinaryTreeNode<Integer> temp = current.right;
            while(temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }else{
            BinaryTreeNode<Integer> succesor=null, ancestor=root;
            while(ancestor!=current){
                if(current.data < ancestor.data){
                    succesor=ancestor;
                    ancestor=ancestor.left;
                }
                else{
                    ancestor=ancestor.right;
                }
            }
            return succesor;
        }
    }

     public static BinaryTreeNode<Integer> find(BinaryTreeNode<Integer> root, int data){
        if(root==null)
            return null;
        else if (root.data==data)
            return root;
        else if(root.data<data)
            return find(root.right,data);
        else
            return find(root.left,data);
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = s.nextInt();
		}
		replace2(arr, n);
		for(int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
	}

}
