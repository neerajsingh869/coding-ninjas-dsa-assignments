package optionalBST;

import java.util.Scanner;

class NodePP {
	int data;
	NodePP left;
	NodePP right;
	NodePP parent;

	NodePP(int data, NodePP left, NodePP right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

public class SetParentPointer {
	
	public static NodePP solve(int[] arr){
		int n = arr.length;
		NodePP[] temp = new NodePP[n];
		for (int i = 0; i < n; i++) {
			if (arr[i] != -1) {
				if (temp[i] == null) {
					temp[i] = new NodePP(arr[i], null, null);
				}
				if (2*i + 1 < n) {
					if (arr[2*i + 1] != -1) {
						temp[i].left =  new NodePP(arr[2*i + 1], null, null);
						temp[i].left.parent = temp[i];
					}
					temp[2*i + 1] = temp[i].left;
				}
				if (2*i + 2 < n) {
					if (arr[2*i + 2] != -1) {
						temp[i].right =  new NodePP(arr[2*i + 2], null, null);	
						temp[i].right.parent = temp[i];
					}
					temp[2*i + 2] = temp[i].right;
				}
			}
		}
		return temp[0];
	}
	
	public static void display(NodePP NodePP) {
		if (NodePP == null) {
			return;
		}

		String str = "";

		str += NodePP.left == null ? "." : NodePP.left.data;
		str += " => " + NodePP.data +  ("[" + (NodePP.parent != null? NodePP.parent.data: "null") + "]") + " <= ";
		str += NodePP.right == null ? "." : NodePP.right.data;

		System.out.println(str);

		display(NodePP.left);
		display(NodePP.right);
	}

	public static void main(String[] args) {
		NodePP root = null;

		Scanner scn = new Scanner(System.in);

		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		root=solve(arr);
		display(root);
	}

}
