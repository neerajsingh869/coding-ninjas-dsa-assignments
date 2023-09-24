package fullTest1;

import java.util.*;
import java.lang.*;
import java.io.*;

public class InfiniteSequence {
	
	/*
	 * Amit decided to write an infinite sequence. Initially, he wrote 0, and then he started repeating the following process:
* Look at the last element written so far (the l-th element if the sequence has length l so far); let's denote it by x.
*If x does not occur anywhere earlier in the sequence, the next element in the sequence is 0.
*Otherwise, look at the previous occurrence of x in the sequence, i.e. the k-th element, where k<l, this element is equal to x and all elements between the k+1-th and l−1-th are different from x. The next element is l−k, i.e. the distance between the last two occurrences of x.
The resulting sequence is (0,0,1,0,2,0,2,2,1,…): the second element is 0 since 0 occurs only once in the sequence (0), the third element is 1 since the distance between the two occurrences of 0 in the sequence (0,0) is 1, the fourth element is 0 since 1 occurs only once in the sequence (0,0,1), and so on.
Consider the N-th element of the sequence (denoted by x) and the first N elements of the sequence. Find the number of occurrences of x among these N elements.
Input :
The first and only line contains a single integer N.
Output :
 print a single line containing one integer ― the number of occurrences of the N-th element.
Sample Input :
2
Output :
2
Explanation:
(The 2-nd element is 0. It occurs twice among the first two elements, since the first two elements are both 0.)
	 */
	
	public static int nthOccurrence(int n) {
		HashMap<Integer, Integer> prevOccurMap = new HashMap<>();
		ArrayList<Integer> seq = new ArrayList<>();

		seq.add(0);
		for (int i = 0; i < n - 1; i++) {
			int currSeqNum = seq.get(i);

			// add next sequence number
			if (prevOccurMap.containsKey(currSeqNum)) {
				seq.add(i - prevOccurMap.get(currSeqNum));
			} else {
				seq.add(0);
			}

			prevOccurMap.put(currSeqNum, i);
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (seq.get(i) == seq.get(n-1)) {
				ans++;
			}
		}

		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int ans = nthOccurrence(n);

		System.out.println(ans);
	}

}
