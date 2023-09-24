package arrays1;

import java.util.Arrays;

public class TripletSum {
	
	/*
	 * You have been given a random integer array/list(ARR) 
	 * and a number X. Find and return the number of triplets 
	 * in the array/list which sum to X.
	 */
	
	// Time Complexity -> O(n*n*n), Space Complexity -> O(1)
	public static int tripletSum1(int[] arr, int x) {
    	//Your code goes here
        int n = arr.length, ans = 0;
        for(int i = 0; i<n-2; i++){
            for(int j = i+1; j<n-1; j++){
                for(int k = j+1; k<n; k++){
                    if(arr[i] + arr[j] + arr[k] == x){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
	
	// Time Complexity -> O(n*n), Space Complexity -> O(1)
	public static int tripletSum2(int[] arr, int num) {
		int n = arr.length;
        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans += pairSum(arr, i+1, num-arr[i]);
        }
        return ans;
	}
    
    public static int pairSum(int[] arr, int idx, int num) {
		int n = arr.length;
        int i = idx, j = n-1, ans = 0;
        while(i < j){
            if(arr[i] + arr[j] > num){
                j--;
            }
            else if(arr[i] + arr[j] < num){
                i++;
            }
            else{
                int num1 = arr[i];
                int num2= arr[j];
                if(num1 == num2){
                    int count = j-i+1;
                    ans += (count*(count-1))/2;
                    break;
                }
                int k1 = i, k2 = j;
                while(k1 <= k2 && arr[k1] == num1){
                    k1++;
                }
                int count1 = k1-i;
                while(k2 >= k1 && arr[k2] == num2){
                    k2--;
                }
                int count2 = j-k2;
                i = k1;
                j = k2;
                ans += count1*count2; 
            }
        }
        return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
