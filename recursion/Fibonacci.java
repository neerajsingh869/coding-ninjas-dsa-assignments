package recursion;

public class Fibonacci {
	
	// Time Complexity -> Exponential, Space Complexity -> O(n)
	public static int fibonacci(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}