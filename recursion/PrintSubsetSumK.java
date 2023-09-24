package recursion;

public class PrintSubsetSumK {
	
	/*
	 * Given an array A and an integer K, print all subsets of A which sum to K.
	 */
	
	public static void printSubsetsSumTok(int input[], int k) {
        int[] initialAns = new int[0];
        printSubsetsSumTok(input, 0, k, initialAns);
	}
	
	private static void printSubsetsSumTok(int input[], int stIdx, int k, int ansSoFar[]){
        if(stIdx == input.length && k != 0){
            return;
        }
        if(k == 0){
            for(int i : ansSoFar){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        printSubsetsSumTok(input, stIdx+1, k, ansSoFar);
        int[] newAns = new int[ansSoFar.length + 1];
        int i = 0;
        while(i<ansSoFar.length){
            newAns[i] = ansSoFar[i];
            i++;
        }
        newAns[i] = input[stIdx];
        printSubsetsSumTok(input, stIdx+1, k-input[stIdx], newAns);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
