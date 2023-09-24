package recursion;

public class FirstIndexOfNum {
	
	/*
	 * Given an array of length N and an integer x, you need to 
	 * find and return the first index of integer x present in 
	 * the array. Return -1 if it is not present in the array.
	 * 
	 * First index means, the index of first occurrence of x in the input array.
	 * 
	 * Do this recursively. Indexing in the array starts from 0.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static int firstIndex(int input[], int x) {
		return firstIndex(input, 0, x);
	}
	
    public static int firstIndex(int input[], int idx, int x){
        int n = input.length;
        if(idx == n){
            return -1;
        }
        if(input[idx] == x){
            return idx;
        }
        else{
            return firstIndex(input, idx+1, x);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
