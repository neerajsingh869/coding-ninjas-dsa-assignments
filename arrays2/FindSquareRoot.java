package arrays2;

import java.util.Scanner;

public class FindSquareRoot {
	
	// Time complexity -> O(root of N)
	public static int sqrtN1(long N) {
		int ans = 1;
		while (ans*ans < N) {
			ans++;
		}

		return (ans*ans == N) ? ans : ans - 1;
	}
	
	// Time complexity -> O(log(N))
	public static int sqrtN2(long N) {
		if (N == 1) return 1;
		double i = 0, j = N;

		double ans = -1;
		while (Math.floor(i) <= Math.floor(j)) {
			double mid = i + (j - i) / 2;

			if (mid * mid >= N) {
				j = mid - 1;
				ans = mid;
			} else {
				i = mid + 1;
			}
		}

		long newAns = (long)(Math.floor(ans));

		if (newAns * newAns <= N) {
			return (int)newAns;
		} else  {
			return (int)(newAns) - 1;
		}

	}
	
	// Time complexity -> O(log(N))
	public static int sqrtN3(long N) {
		if (N == 0 || N == 1) return (int)N;

		long low = 2, high = N;

		while (low < high) {
			long mid = low + (high - low) / 2;

			if (mid <= (N / mid)) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return (int)low - 1;
	}
	
	public static void main(String[] args)
    {
        Scanner sr = new Scanner(System.in);
        long n = sr.nextLong();
        int ans = sqrtN2(n);
        System.out.println(ans);
    }

}
