package recursion;

public class SumOfArray {
	
	/*
	 * Given an array of length N, you need to find 
	 * and return the sum of all elements of the array.
	 * 
	 * Do this recursively.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static int sum(int input[]) {
        return sum(input, 0);
	}
    
    public static int sum(int input[], int idx){
        int n = input.length;
        if(idx == n){
            return 0;
        }
        return input[idx] + sum(input, idx+1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
