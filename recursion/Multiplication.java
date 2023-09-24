package recursion;

public class Multiplication {
	
	/*
	 * Given two integers M & N, calculate and return their 
	 * multiplication using recursion. You can only use 
	 * subtraction and addition for your calculation. No 
	 * other operators are allowed.
	 */

	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static int multiplyTwoIntegers(int m, int n){
        if(n == 0){
            return 0;
        }
        return m + multiplyTwoIntegers(m, n-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
