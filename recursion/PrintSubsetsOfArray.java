package recursion;

public class PrintSubsetsOfArray {
	
	/*
	 * Given an integer array (of length n), find and print all 
	 * the subsets of input array.
	 */
	
	public static void printSubsets(int input[]) {
        int[] intialAns = new int[0];
        printSubsets(input, 0, intialAns);
	}
	
	public static void printSubsets(int input[], int stIdx, int ansSoFar[]){
        if(stIdx == input.length){
            for(int i : ansSoFar){
             	System.out.print(i + " ");   
            }
            System.out.println();
            return;
        }
        int[] newAns = new int[ansSoFar.length + 1];
        int i = 0;
        while(i < ansSoFar.length){
            newAns[i] = ansSoFar[i];
            i++;
        }
        newAns[i] = input[stIdx];
        printSubsets(input, stIdx+1, newAns);
        printSubsets(input, stIdx+1, ansSoFar);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
