package exceptionHandling;

public class DivideTwoNumbers2 {
	
	public static int divide(int a, int b) throws DivideByZeroException{
		if(b == 0) {
			throw new DivideByZeroException();
		}
		return a/b;
	}
	
	/*
	 * Method 2 of Exception handling: Is to catch the exception and
	 * handle it
	 */
	public static void main(String[] args) throws DivideByZeroException{
		try {
			System.out.println(divide(4, 0));
		}
		catch(DivideByZeroException d){
			System.out.println("Divide by Zero exception raised");
		}
		
	}

}
