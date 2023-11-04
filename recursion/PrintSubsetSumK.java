package recursion;

import java.util.Scanner;

public class PrintSubsetSumK {
	
	/*
	 * Given an array A and an integer K, print all subsets of A which sum to K.
		Subsets are of length varying from 0 to n, that contain elements of the array. 
		But the order of elements should remain same as in the input array.
		
		Note :
		The order of subsets are not important. Just print them in different lines.
		
		Input format :
		Line 1 : Size of input array
		Line 2 : Array elements separated by space
		Line 3 : K 
		
		Sample Input:
		9 
		5 12 3 17 1 18 15 3 17 
		6
		Sample Output:
		3 3
		5 1
	 */
	
	public static void printSubsetsSumTok1(int input[], int k) {
		printSubsetsSumTok1(input, 0, k, "");
	}

	private static void printSubsetsSumTok1(int input[], int idx, int k, String ansTillNow) {
		int n = input.length;
		// base case
		if (k == 0 && idx <= n) {
			System.out.println(ansTillNow);
			return;
		}
		if (n == idx) {
			return;
		}

		printSubsetsSumTok1(input, idx + 1, k, ansTillNow);
		printSubsetsSumTok1(input, idx + 1, k - input[idx], ansTillNow + input[idx] + " ");
	}
	
	public static void printSubsetsSumTok(int input[], int k) {
		int[] ansTillNow = new int[0];
		printSubsetsSumTok(input, 0, k, ansTillNow);
	}

	private static void printSubsetsSumTok(int input[], int idx, int k, int[] ansTillNow) {
		int n = input.length;
		// base case
		if (k == 0 && idx <= n) {
			for (int i = 0; i < ansTillNow.length; i++) {
				System.out.print(ansTillNow[i] + " ");
			}
			System.out.println();
			return;
		}
		if (n == idx) {
			return;
		}
		
		// induction hypothesis 1
		printSubsetsSumTok(input, idx + 1, k, ansTillNow);
		
		// induction step
		int[] newAns = new int[ansTillNow.length + 1];
		for (int i = 0; i < ansTillNow.length; i++) {
			newAns[i] = ansTillNow[i];
		}
		newAns[ansTillNow.length] = input[idx];
		
		// induction hypothesis 2
		printSubsetsSumTok(input, idx + 1, k - input[idx], newAns);
	}

	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int k = s.nextInt();
		printSubsetsSumTok(input, k);
	}

}
