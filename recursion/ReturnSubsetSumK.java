package recursion;

public class ReturnSubsetSumK {
	
	/*
	 * Given an array A of size n and an integer K, 
	 * return all subsets of A which sum to K.
	 * 
	 * Subsets are of length varying from 0 to n, that contain 
	 * elements of the array. But the order of elements should 
	 * remain same as in the input array.
	 */
	
	public static int[][] subsetsSumK(int input[], int k) {
		return subsetsSumK(input, 0, k);
	}

	private static int[][] subsetsSumK(int input[], int idx, int k){
		if(idx == input.length && k != 0){
			return new int[0][0];
		}
		if(k == 0){
			return new int[1][0];
		}
		int[][] smallAns1 = subsetsSumK(input, idx+1, k - input[idx]);
		int[][] smallAns2 = subsetsSumK(input, idx+1, k);
		int[][] ans = new int[smallAns1.length + smallAns2.length][];
		int kRow = 0;
		for(int i = 0; i<smallAns2.length; i++){
			ans[kRow] = new int[smallAns2[i].length];
			for(int j = 0; j<smallAns2[i].length; j++){
				ans[kRow][j] = smallAns2[i][j];
			}
			kRow++;
		}
		for(int i = 0; i<smallAns1.length; i++){
			ans[kRow] = new int[smallAns1[i].length + 1];
			ans[kRow][0] = input[idx];
			for(int j = 0; j<smallAns1[i].length; j++){
				ans[kRow][j+1] = smallAns1[i][j];
			}
			kRow++;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
