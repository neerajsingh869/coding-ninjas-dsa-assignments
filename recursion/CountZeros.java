package recursion;

public class CountZeros {
	
	/*
	 * Given an integer N, count and return the number of 
	 * zeros that are present in the given integer using recursion.
	 */
	
	// Time Complexity -> O(logn), Space Complexity -> O(logn)
	public static int countZerosRec(int input){
        if(input == 0){
            return 1;
        }
        if(input >= 1 && input <= 9){
            return 0;
        }
        return (input%10 == 0) ? 1 + countZerosRec(input/10) :
        		countZerosRec(input/10);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
