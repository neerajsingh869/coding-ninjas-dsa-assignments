package recursion;

public class CalculatePower {
	
	/*
	 * Write a program to find x to the power n (i.e. x^n). 
	 * Take x and n from the user. You need to return the answer.
	 * 
	 * Do this recursively.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static int power(int x, int n) {
        if(n == 0){
            return 1;
        }
        return x*power(x, n-1);
	}

	public static void main(String[] args) {
	}

}
