package optionalPriorityQueues;

public class MergeFunction {
	
	/*
	 * You are given the merge function of the merge Sort algorithm(1- based indexing):
void merge(int a[], int b[], int n1, int n2, int c[]
{
	int i = 1, j = 1, k = 1;
	while (i <= n1 && j <= n2) {
	    if (a[i] <= b[j]) { 
	        c[k] = a[i];
	        i++;
	    }
	    else {
	        c[k] = b[j];
	        j++;
	    }
	    k++;
	}
	while (i <= n1) {
	    c[k] = a[i];
	    i++;
	    k++;
	}
	while (j <= n2) {
	    c[k] = b[j];
	    j++;
	    k++;
	}
}
Now, in the function above, let us denote the maximum number of comparisons needed in the worst case while merging 2 arrays of sizes n1 and n2 as X. We are given M sorted arrays of size n1, n2, n3, ..., nM. To make a larger array of size n1 + n2 + n3 + ... + nM, you perform the following operation:
1. If only 1 array is left then stop.
2. Else Pick any 2 sorted arrays and merge them using the above operation.
Assume, that while merging any 2 arrays, it always takes worst case in the number of comparisons. You are required to minimise the number of comparison operations.
Input Format:
The input consists of 2 lines. The first line contain an integer M, denoting the number of arrays. The second line consists of the sizes of arrays, n1, n2, n3, ... nM.
Output Format:
Output line contains the minimum number of comparisons while merging the M arrays into the final array.
Constraints:
2 ≤ M ≤ 10^5
2 ≤ ni ≤ 10^9
Sample Input:
3
4 3 4
Sample Output:
16
Explanation:
Merge the arrays with sizes 3 and 4 to obtain array of size 7. The number of comparisons in worst case is 6. Merge the arrays with sizes 4 and 7 to obtain array of size 11. The number of comparisons in worst case is 10. The total number of comparisons is 6 + 10 = 16
	 */
	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here

	}

}
