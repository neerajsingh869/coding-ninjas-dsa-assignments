package recursion;

public class NumberOfDigits {
	
	/*
	 * Given the number 'n', find out and return the 
	 * number of digits present in a number recursively.
	 */
	
	// Time complexity -> O(no. of digits), Space complexity -> O(no. of digits)
	// Also, no. of digits ~ log(n)
	public static int count(int n){
		if(n == 0){
            return 0;
        }
        return 1 + count(n/10);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
