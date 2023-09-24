package recursion;

public class ReturnSubsetsOfArray {
	
	/*
	 * Given an integer array (of length n), find and return 
	 * all the subsets of input array.
	 * 
	 * Subsets are of length varying from 0 to n, that contain 
	 * elements of the array. But the order of elements should 
	 * remain same as in the input array.

	 * Note : The order of subsets are not important.
	 */
	
	public static int[][] returnSubsets(int input[]) {
		return returnSubsets(input, 0);
	}
	
	public static int[][] returnSubsets(int input[], int stIdx){
        if(stIdx == input.length){
            return new int[1][0];
        }
        int[][] smallOutput = returnSubsets(input, stIdx+1);
        int[][] output = new int[2*smallOutput.length][];
        int k = 0;
        for(; k<smallOutput.length; k++){
            output[k] = smallOutput[k];
        }
        for(; k<2*smallOutput.length; k++){
            output[k] = new int[smallOutput[k-smallOutput.length].length + 1];
            output[k][0] = input[stIdx];
            for(int j = 0; j<smallOutput[k-smallOutput.length].length; j++){
                output[k][j+1] = smallOutput[k-smallOutput.length][j];
            }
        }
        return output;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
