package arrays2;

public class FindInversions {
	
	/*
	 * Given an array of size n, return the number of inversions
	 * present in the array.
	 */
	// Time complexity -> O(n * n)
	public static int getInversions(int[] arr, int n){
        int inversions = 0;
        
        for (int i = 0; i < n; i++) {
            int minEleIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minEleIdx]) {
                    minEleIdx = j;
                }
            }

            // swap ith ele with min ele
            int temp = arr[minEleIdx];
            arr[minEleIdx] = arr[i];
            arr[i] = arr[minEleIdx];
            inversions += (minEleIdx - i);
        }

        return inversions;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
