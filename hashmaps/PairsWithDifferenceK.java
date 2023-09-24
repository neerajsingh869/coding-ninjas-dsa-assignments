package hashmaps;

import java.util.HashMap;

public class PairsWithDifferenceK {
	
	/*
	 * You are given with an array of integers and an integer K. 
	 * You have to find and print the count of all such pairs 
	 * which have difference K.
	 * 
	 * Note: Take absolute difference between the elements of the array.
	 */
	public static int getPairsWithDifferenceK(int arr[], int k) {
		HashMap<Integer, Integer> freq = new HashMap<>();
		for(int i : arr){
			freq.put(i, freq.getOrDefault(i, 0) + 1);
		}
		int ans = 0;
		for(int i : arr){
			if(freq.containsKey(i)){
				if(k != 0){
					if(freq.containsKey(i - k)){
						ans += freq.get(i)*freq.get(i-k);
					}
					if(freq.containsKey(i + k)){
						ans += freq.get(i)*freq.get(i+k);
					}
				}
				else{
					ans += (freq.get(i)*(freq.get(i)-1))/2;
				}
				freq.remove(i);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
