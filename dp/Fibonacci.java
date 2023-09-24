package dp;

public class Fibonacci {
	
	// Solving fibonacci problem using recursion
	public static int fib(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	
	// Solving fibonacci problem using Memoization (Top Down Approach)
	public static int fibMemoi(int n) {
		int tab[] = new int[n+1];
		for(int i = 0; i<=n; i++) {
			tab[i] = -1;
		}
		return fibMemoi_helper(n, tab);
	}
	
	public static int fibMemoi_helper(int n, int tab[]) {
		if(n == 0 || n == 1) {
			return n;
		}
		if(tab[n] != -1) {
			return tab[n];
		}
		return tab[n] = fibMemoi_helper(n-1, tab) + fibMemoi_helper(n-2, tab);
	}
	
	// Solving fibonacci problem using Tabulation (Bottom up Approach)
	public static int fibTabu1(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		int tab[] = new int[n+1];
		tab[0] = 0;
		tab[1] = 1;
		for(int i = 2; i<n+1; i++) {
			tab[i] = tab[i-1] + tab[i-2];
		}
		return tab[n];
	}
	
	// Optimized version of above approach
	public static int fibTabu2(int n) {
		int a = 0, b = 1;
		for(int i = 2; i<n+1; i++) {
			int temp = a + b;
			a = b;
			b = temp;
		}
		return b;
	}
	
	public static void main(String[] args) {
		System.out.println(fibTabu2(30));
	}
	
}
