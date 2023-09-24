package fullTest1;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class JumpingNumbers {
	
	/*
	 * Given a number x, print all the jumping numbers below or equal to x. A number is called a jumping number if for a number all the adjacent digits differ by 1. All single digit numbers are also jumping numbers.
Eg. 432345, 32, 543, 989, 12, 21 are jumping numbers whereas 843, 485, 9348 are not.
Input Format :
An integer x.
Output Format :
All the jumping numbers smaller than or equal to x, separated by space and generated in increasing order of most significant digit.
Input Constraints :
1 <= x <= 10^5
Sample Input 1 :
10
Sample Output 1 :
0 1 10 2 3 4 5 6 7 8 9
Sample Input 2 :
50
Sample Output 2 :
0 1 12 10 2 23 21 3 34 32 4 45 43 5 6 7 8 9
	 */
	// Time complexity -> O(x) 
	public static void showJumpingNos1(int x) {
		for (int i = 0; i <= x; i++) {
			if (isJumpingNum(i)) {
				System.out.print(i + " " );
			}
		}
	}
	
	private static boolean isJumpingNum(int n) {
		if (n / 10 == 0) {
			return true;
		}
		int digit1 = n % 10;
		n = n / 10;
		while (n > 0) {
			int digit2 = n % 10;
			if (Math.abs(digit1 - digit2) != 1) {
				return false;
			}
			digit1 = digit2;
			n = n / 10;
		}

		return true;
	}
	
	// Time complexity -> O(k) where k is the number
	// of jumping numbers <= x
	public static void showJumpingNos2(int x) {
		System.out.print(0 + " " );

		for (int i = 1; i <= 9 && i <= x; i++) {
			printJumpingNumsWithMSD_I_BFS(x, i);
		}
	}

	private static void printJumpingNumsWithMSD_I_BFS(int x, int msd_I) {
		// que to contains all jumping nums with given msd
		Queue<Integer> que = new LinkedList<>();
		que.add(msd_I);

		// apply BFS algorithm to get all jumping
		// numbers <= x with given MSD
		while (!que.isEmpty()) {
			int currJumpNum = que.poll();

			if (currJumpNum <= x) {
				System.out.print(currJumpNum + " ");

				int lastDigit = currJumpNum % 10;
				// insert next jumping numbers with given msd
				if (lastDigit == 0) {
					que.add(currJumpNum * 10 + (lastDigit + 1));
				} else if (lastDigit == 9) {
					que.add(currJumpNum * 10 + (lastDigit - 1));
				} else {
					que.add(currJumpNum * 10 + (lastDigit + 1));
					que.add(currJumpNum * 10 + (lastDigit - 1));
				}
			}
		}
	}
	
	// Time complexity -> O(k) where k is the number
	// of jumping numbers <= x
	public static void showJumpingNos3(int x) {
		System.out.print(0 + " " );

		for (int i = 1; i <= 9 && i <= x; i++) {
			printJumpingNumsWithMSD_I_DFS(x, i);
		}
	}
	
	private static void printJumpingNumsWithMSD_I_DFS(int x, int msd_I) {
		if (msd_I > x) {
			return;
		}

		System.out.print(msd_I + " ");

		int lastDigit = msd_I % 10;
		if (lastDigit == 0) {
			printJumpingNumsWithMSD_I_DFS(x, msd_I * 10 + (lastDigit + 1));
		} else if (lastDigit == 9) {
			printJumpingNumsWithMSD_I_DFS(x, msd_I * 10 + (lastDigit - 1));
		} else {
			printJumpingNumsWithMSD_I_DFS(x, msd_I * 10 + (lastDigit + 1));
			printJumpingNumsWithMSD_I_DFS(x, msd_I * 10 + (lastDigit - 1));
		}

	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
	    showJumpingNos2(x);

	}

}
