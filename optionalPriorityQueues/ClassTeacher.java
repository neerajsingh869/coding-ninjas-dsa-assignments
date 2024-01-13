package optionalPriorityQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ClassTeacher {
	
	/*
	 * A teacher is studying the confidence and the smartness of her students. 
	 * The confidence and the smartness are represented as an integer. 
	 * The teacher wants to know the Nth smallest sum of one confidence 
	 * value and one smartness value for various values of N. The confidence 
	 * and the smartness value may correspond to different students.
	 * 
		You are given two arrays, the first array denotes the confidence value 
		and the second array denotes the smartness value of the students. 
		We can get a set of sums(add one element from the first array and 
		one from the second). For each query ( denoted by an integer 
		qi ( i = 1 to Q ) , Q denotes number of queries ) , find the qi-th 
		element in the set of sums ( in increasing order).
		
		Input Format:
		The first line of input contains two space-separated integers K and 
		Q denoting the number of students and the number of queries .
		The second line of input contains K space-separated integers A1, 
		A2, ..., AK denoting the confidence value of the students.
		The third line of input contains K space-separated integers B1, 
		B2, ..., BK denoting the smartness of the students.
		The next Q lines contains a single integer qi ( for i = 1 to Q ) , 
		find the qi th element in the set of sums.
		
		Output Format:
		For each query of the input, output containing the answer to 
		the query in different lines.
		
		Constraints:
		1 ≤ K ≤ 20000
		1 ≤ Q ≤ 500
		1 ≤ qi ( for i = 1 to Q ) ≤ 10000
		1 ≤ Ai ≤ 10^18 ( for i = 1 to K )
		1 ≤ Bi ≤ 10^18 ( for i = 1 to K )
		
		Sample Input:
		3 2
		1 2 3
		6 7 8
		3
		4
		
		Sample Output:
		8
		9
		Explanation:
		The 9 elements in the set sum are:
		1+6=7
		1+7=8
		2+6=8
		1+8=9
		2+7=9
		3+6=9
		2+8=10
		3+7=10
		3+8=11
	 */
	// Brute force approach (Time complexity -> O(n*n*log(n*n)), Space complexity -> O(n*n))
	private static int returnQthMinSum1(int[] confArr, int[] smartArr, int q) {
		int n = confArr.length;
		int[] minSums = new int[n * n];
		
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				minSums[k++] = confArr[i] + smartArr[j];
			}
		}
		
		Arrays.sort(minSums);
		
		return (q <= n * n) ? minSums[q - 1] : -1;
	}
	
	// Better approach (Time complexity -> O(n*n*log(q)), Space complexity -> O(n*n))
	private static int returnQthMinSum2(int[] confArr, int[] smartArr, int q) {
		int n = confArr.length;
		int[] sums = new int[n * n];
		
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sums[k++] = confArr[i] + smartArr[j];
			}
		}
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < q && i < n * n; i++){
			maxHeap.add(sums[i]);
		}
		
		for(int i = q; i < n * n; i++){
			if(sums[i] < maxHeap.peek()){
				maxHeap.poll();
				maxHeap.add(sums[i]);
			}
		}
		
		return !maxHeap.isEmpty() ? maxHeap.peek() : -1;
	}
	
	public static void main(String[] args) {
		// take input
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int Q = sc.nextInt();
		
		int[] confidenceArr = new int[n];
		for (int i = 0; i < n; i++) {
			confidenceArr[i] = sc.nextInt();
		}
		
		int[] smartnessArr = new int[n];
		for (int i = 0; i < n; i++) {
			smartnessArr[i] = sc.nextInt();
		}
		
//		int[] queries = new int[q];
//		for (int i = 0; i < q; i++) {
//			queries[i] = sc.nextInt();
//		}
		
		while (Q > 0) {
			int q = sc.nextInt();
			int ans = returnQthMinSum2(confidenceArr, smartnessArr, q);
			System.out.println(ans);
			
			Q--;
		}
		
		
	}

}
