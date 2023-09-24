package hashmaps;

import java.util.HashMap;

public class PairSumTo0 {
	
	/*
	 * Given a random integer array A of size N. Find 
	 * and print the count of pair of elements in the 
	 * array which sum up to 0.
	 * 
	 * Note: Array A can contain duplicate elements as well.
	 */
	
	public static int PairSum(int[] input, int size) {
		HashMap<Integer, Integer> freq = new HashMap<>();
        int ans = 0;
        for(int i : input){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for(int i = 0; i<size; i++){
            if(freq.containsKey(0-input[i])){
                if(input[i] == 0){
                    ans += (freq.get(input[i])*(freq.get(input[i])-1))/2;
                }
                else{
                    ans += freq.get(input[i])*freq.get(0-input[i]);
                }
                freq.remove(input[i]);
                freq.remove(0-input[i]);
            }
        }
        return ans;
	}

	public static void main(String[] args) {
		
	}

}
