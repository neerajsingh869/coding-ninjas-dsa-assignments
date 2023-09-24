package recursion;

public class IsArraySorted {
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static boolean isArraySorted(int[] input) {
		return isArraySorted(input, 0);
	}
	
	public static boolean isArraySorted(int[] input, int idx) {
		int n = input.length;
		if(idx + 1 == n || idx == n) {
			return true;
		}
		if(input[idx] > input[idx+1]) {
			return false;
		}
		else {
			return isArraySorted(input, idx+1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
