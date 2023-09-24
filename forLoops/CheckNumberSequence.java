package forLoops;

import java.util.Scanner;

public class CheckNumberSequence {
	/*
	 * You are given S, a sequence of n integers i.e. 
	 * S = s1, s2, ..., sn. Compute if it is possible 
	 * to split S into two parts : s1, s2, ..., si and 
	 * si+1, si+2, ….., sn (0 <= i <= n) in such a way 
	 * that the first part is strictly decreasing while 
	 * the second is strictly increasing one
	 */

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int prev = s.nextInt();
		boolean ans = true;
		boolean isDec = true;
		for(int i =1; i<n; i++) {
			int curr = s.nextInt();
			// If the sequence is not strictly increasing
			// or strictly decreasing, then straight away
			// return false;
			if(curr == prev) {
				ans = false;
				break;
			}
			// If curr < prev and the sequence was decreasing, 
			// then it's ok. But if the sequence was increasing,
			// then straight away return false;
			else if(curr < prev) {
				if(!isDec) {
					ans = false;
					break;
				}
			}
			// If curr > prev and the sequence was increasing, 
			// then it's ok. If the sequence was decreasing, 
			// then change the isDec value from true to false
			else {
				if(isDec) {
					isDec = false;
				}
			}
			prev = curr;
		}
		System.out.println(ans);
	}

}
