package hashmaps;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PairSumTo0 {
	
	/*
	 * Given a random integer array A of size N. Find and print the 
	 * count of pair of elements in the array which sum up to 0.
	 * 
		Note: Array A can contain duplicate elements as well.
		
		Input format:
		The first line of input contains an integer, that denotes the value of 
		the size of the array. Let us denote it with the symbol N.
		The following line contains N space separated integers, that denote the 
		value of the elements of the array.
		
		Output format :
		The first and only line of output contains the count of pair of elements 
		in the array which sum up to 0. 
		
		Constraints :
		0 <= N <= 10^4
		Time Limit: 1 sec
		
		Sample Input 1:
		5
		2 1 -2 2 3
		Sample Output 1:
		2
		Explanation
		(2,-2) , (-2,2) will result in 0 , so the answer for the above problem is 2.
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

	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }
        
		String[] strNums;
		strNums = br.readLine().split("\\s");
		
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        int[] arr = takeInput();
        System.out.print(PairSum(arr,arr.length));


    }

}
