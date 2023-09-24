package exceptionHandling;

public class DivideTwoNumbers {
	
	/*
	 * Method 1 of Exception handling: Is to throw error to who so ever
	 * has called the function
	 */
	public static int divide(int a, int b) throws DivideByZeroException{
		if(b == 0) {
			throw new DivideByZeroException();
		}
		return a/b;
	}
	
	/*
	 * Again throwing the got exception from the function in the main()
	 * function
	 */
	public static void main(String[] args) throws DivideByZeroException{
		System.out.println(divide(4, 0));
	}

}
