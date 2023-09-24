package recursion;

public class LastIndexOfNum {
	
	/*
	 * Given an array of length N and an integer x, you need to 
	 * find and return the last index of integer x present in 
	 * the array. Return -1 if it is not present in the array.
	 * 
	 * Last index means - if x is present multiple times in 
	 * the array, return the index at which x comes last in the array.
	 * 
	 * You should start traversing your array from 0, not from (N - 1).
	 * 
	 * Do this recursively. Indexing in the array starts from 0.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static int lastIndex1(int input[], int x) {
        return lastIndex1(input, 0, x);
	}
	
    public static int lastIndex1(int input[], int idx, int x){
        int n = input.length;
        if(idx == n){
            return -1;
        }
        int smallOutput = lastIndex1(input, idx+1, x);
        if(smallOutput == -1){
            if(input[idx] == x){
                return idx;
            }
        }
        return smallOutput;
    }
    
    // Time complexity -> O(n), Space complexity -> O(n)
    public static int lastIndex2(int input[], int x) {
        int n = input.length;
        return lastIndex2(input, n, x);
	}
	
    public static int lastIndex2(int input[], int n, int x){
        if(n == 0){
            return -1;
        }
        if(input[n-1] == x){
            return n-1;
        }
        else{
            return lastIndex2(input, n-1, x);
        }
    }

	public static void main(String[] args) {

	}

}
