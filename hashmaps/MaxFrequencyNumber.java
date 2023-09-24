package hashmaps;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxFrequencyNumber {
	
	/*
	 * You are given an array of integers that contain numbers in random order. 
	 * Write a program to find and return the number which occurs the maximum 
	 * times in the given input.
	 * 
		If two or more elements are having the maximum frequency, return the element 
		which occurs in the array first.
		
		Input Format:
		The first line of input contains an integer, that denotes the value of 
		the size of the array. Let us denote it with the symbol N.
		The following line contains N space separated integers, that denote the 
		value of the elements of the array.
		
		Output Format :
		The first and only line of output contains most frequent element in the
		given array.
		
		Constraints:
		0 <= N <= 10^8
		Time Limit: 1 sec
		
		Sample Input 1 :
		13
		2 12 2 11 12 2 1 2 2 11 12 2 6 
		Sample Output 1 :
		2
		
		Sample Input 2 :
		3
		1 4 5
		Sample Output 2 :
		1
	 */
	
	// Time complexity -> O(n*n), Space complexity -> O(1)
	public static int maxFrequencyNumber1(int[] arr){
        int n = arr.length;
        int maxFreq = Integer.MIN_VALUE;
        int maxNum = 0;
        for(int i = 0; i<n; i++){
            int tempCount = 0;
            for(int j = 0; j<n; j++){
                if(arr[i] == arr[j]){
                    tempCount++;
                }
            }
            if(tempCount > maxFreq){
                maxFreq = tempCount;
                maxNum = arr[i];
            }
        }
        return maxNum;
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static int maxFrequencyNumber2(int[] arr){
        int n = arr.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        int maxNum = 0;
        for(int i : arr){
//            if(freq.containsKey(i)){
//                freq.put(i, freq.get(i) + 1);
//            }
//            else{
//                freq.put(i, 1);
//            }
        	freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for(int i : arr){
            if(freq.get(i) > maxFreq){
                maxFreq = freq.get(i);
                maxNum = i;
            }
        }
        return maxNum;
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
        System.out.println(maxFrequencyNumber2(arr));


    }

}
