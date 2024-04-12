package arrays1;

import java.util.Arrays;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PairSum {
	
	/*
	 * You have been given an integer array/list(ARR) and a 
	 * number X. Find and return the total number of pairs 
	 * in the array/list which sum to X.
	 * Given array/list can contain duplicate elements. 
	 */

	// Time Complexity -> O(n*n), Space Complexity -> O(1)
	public static int pairSum1(int arr[], int x) {
    	//Your code goes here
        int n = arr.length, ans = 0;
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(arr[i] + arr[j] == x){
                    ans++;
                }
            }
        }
        return ans;
    }
	
	// Time Complexity -> O(n*log(n)), Space Complexity -> O(1)
	public static int pairSum2(int[] arr, int num) {
		int n = arr.length;
        Arrays.sort(arr);
        int i = 0, j = n-1, ans = 0;
        while(i < j){
            if(arr[i] + arr[j] > num){
                j--;
            }
            else if(arr[i] + arr[j] < num){
                i++;
            }
            else{
            	if(arr[i] == arr[j]){
                    ans += (j-i+1)*(j-i)/2;
                }
                else{
                    int currI = i, currJ = j;
                    while(i < currJ && arr[i] == arr[currI]){
                        i++;
                    }
                    while(j > currI && arr[j] == arr[currJ]){
                        j--;
                    }
                    ans += (i - currI)*(currJ - j);
                }
            }
        }
        return ans;
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static int pairSum3(int[] arr, int num) {
		int n = arr.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int ans = 0;
        for(int i : arr){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for(int i = 0; i<n; i++){
            if(freq.containsKey(num-arr[i])){
                if(arr[i] == num-arr[i]){
                    ans += (freq.get(arr[i])*(freq.get(arr[i])-1))/2;
                }
                else{
                    ans += freq.get(arr[i])*freq.get(num-arr[i]);
                }
                freq.remove(arr[i]);
                freq.remove(num-arr[i]);
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
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[] arr = takeInput();
            int num = Integer.parseInt(br.readLine().trim());
            System.out.println(pairSum3(arr, num));

            t -= 1;
        }
    }

}
