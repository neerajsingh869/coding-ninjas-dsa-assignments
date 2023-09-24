package recursion;

public class CheckNumInArr {
	
	/*
	 * Given an array of length N and an integer x, you need to 
	 * find if x is present in the array or not. Return true or false.
	 * 
	 * Do this recursively.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static boolean checkNumber(int input[], int x) {
		return checkNumber(input, 0, x);
	}
    
    public static boolean checkNumber(int input[], int idx, int x){
        int n = input.length;
        if(idx == n){
            return false;
        }
        if(input[idx] == x){
            return true;
        }
        else{
            return checkNumber(input, idx+1, x);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
