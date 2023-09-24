package group3Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class ValidStackPermutation {
	
	/*
	 * You have been given two arrays having an equal number of elements. You have to find whether one array is the valid stack permutation of the other. An array is said to be a valid stack permutation of the other if and only if after applying some push and pop operations onto the sequence of elements in that array, will result in the other array.
Example:
Consider array : 2 4 6.
Valid stack permutations are as follows:
2 4 6
    push ‘2’
    pop ‘2’
    push ‘4’
    pop ‘4’
    push ‘6’
    pop ‘6’
2 6 4
    push ‘2’
    pop ‘2’
    push ‘4’
    pop ‘6’
    push ‘6’
    pop ‘4’
4 2 6
    push ‘2’ 
    pop ‘4’ 
    push ‘4’ 
    pop ‘2’ 
    push ‘6’ 
    pop ‘6’ 
4 6 2
    push ‘2’ 
    pop ‘4’ 
    push ‘4’ 
    pop ‘6’ 
    push ‘6’ 
    pop ‘6’ 
6 4 2
    push ‘2’ 
    pop ‘4’ 
    push ‘6’ 
    pop ‘6’ 
    push ‘4’ 
    pop ‘6’ 

Now, If the other array is [2,4,6], [2,6,4], [4,2,6], [4,6,2], or [6,4,2] then the answer is “YES” otherwise “NO”.
Note:
Please note that the arrays will only contain unique elements.
Input Format:
The first line contains a single integer ‘T’ representing the number of test cases. 

The first line of each test case will contain an integer ‘N’ which represents the total number of elements in both arrays.

The second line of each test case contains the ‘N’ space-separated integers which represent the elements of the 'FIRST' array.

The third line of each test case contains the ‘N’ space-separated integers which represent the elements of the 'OTHER' array.
Output Format:
For each test case, print “YES” if the first array is a valid stack permutation of the other. Otherwise, print “NO”.
Note:
You don’t need to print anything; It has already been taken care of.
Constraints:
1 <= T <= 10
1 <= N <= 10000
0 <= FIRST[i], OTHER[i] <= 10^5

Where 'FIRST[i]' and 'OTHER[i]' denote the value of the i-th element of the input arrays.

Time limit: 1 sec
Sample Input 1:
2
3
2 4 6
4 6 2
3
2 4 6
6 2 4
Sample Output 1:
YES
NO
Explanation of Sample Output 1:
In test case 1, The explanation is already given in the example.

In test case 2, The explanation is already given in the example.
Sample Input 2:
2
3
2 4 6
2 3 4
1
5
5
Sample Output 2:
NO
YES
Explanation for Sample Output 2:
In test case 1, the 'FIRST' array does not contain 3 but the 'OTHER' array contains 3. So, the other is not the valid stack permutation.

In test case 2, the only array containing ‘5’ as an element is the valid stack permutation of the array [5].
	 */
	
	public static boolean validStackPermutation(ArrayList<Integer> first, ArrayList<Integer> other) {
		Stack<Integer> st = new Stack<Integer>();

		int p = 0;
		for (int i = 0; i < first.size(); i++) {
            st.push(first.get(i));
			while (!st.empty() && (other.get(p).intValue() == st.peek().intValue())) {
				p++;
				st.pop();
			}
		}
		if (st.empty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static int t;
	static ArrayList<Integer> allN;

	static ArrayList<ArrayList<Integer>> allArr1, allArr2;

	private static void takeInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine().split(" ")[0]);

		allN = new ArrayList<Integer>(t);

		allArr1 = new ArrayList<ArrayList<Integer>>(t);
		allArr2 = new ArrayList<ArrayList<Integer>>(t);
		for (int i = 0; i < t; i++) {
			String nums[] = br.readLine().split(" ");

			allN.add(Integer.parseInt(nums[0]));

			ArrayList<Integer> temp = new ArrayList<Integer>(allN.get(i));

			nums = br.readLine().split(" ");

			for (int j = 0; j < allN.get(i); j++) {
				temp.add(Integer.parseInt(nums[j]));
			}

			allArr1.add(temp);

			nums = br.readLine().split(" ");
			ArrayList<Integer> temp1 = new ArrayList<Integer>(allN.get(i));
			for (int j = 0; j < allN.get(i); j++) {
				temp1.add(Integer.parseInt(nums[j]));
			}

			allArr2.add(temp1);

		}
	}

	private static void execute() {
		ArrayList<ArrayList<Integer>> allArrCopy1 = allArr1;
		ArrayList<ArrayList<Integer>> allArrCopy2 = allArr2;

		for (int i = 0; i < t; i++) {
			validStackPermutation(allArrCopy1.get(i), allArrCopy2.get(i));
		}
	}

	private static void executeAndPrintOutput() {
		ArrayList<ArrayList<Integer>> allArrCopy1 = allArr1;
		ArrayList<ArrayList<Integer>> allArrCopy2 = allArr2;

		for (int i = 0; i < t; i++) {
			boolean ans = validStackPermutation(allArrCopy1.get(i), allArrCopy2.get(i));

			if (ans) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		takeInput();
		executeAndPrintOutput();
	}

}
