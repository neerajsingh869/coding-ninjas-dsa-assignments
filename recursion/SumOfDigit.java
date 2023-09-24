package recursion;

public class SumOfDigit {
	
	/*
	 * Write a recursive function that returns the sum 
	 * of the digits of a given integer.
	 */

	// Time Complexity -> O(logn), Space complexity -> O(logn)
	public static int sumOfDigits(int input){
        if(input == 0){
            return 0;
        }
        return input%10 + sumOfDigits(input/10);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
