package arrays1;

import java.util.Arrays;

public class TripletSum {
	
	/*
	 * You have been given a random integer array/list(ARR) 
	 * and a number X. Find and return the triplet(s) in the 
	 * array/list which sum to X.

		Note :
		Given array/list can contain duplicate elements.
		Detailed explanation ( Input/output format, Notes, Images )
		Input format :
		The first line contains an Integer 't' which denotes the 
		number of test cases or queries to be run. Then the test 
		cases follow.
		
		First line of each test case or query contains an integer 'N' 
		representing the size of the first array/list.
		
		Second line contains 'N' single space separated integers 
		representing the elements in the array/list.
		
		Third line contains an integer 'X'.
		Output format :
		For each test case, print the total number of triplets 
		present in the array/list.
		
		Output for every test case will be printed in a separate line.
		Constraints :
		1 <= t <= 10^2
		0 <= N <= 10^3
		0 <= X <= 10^9
		
		Time Limit: 1 sec
		Sample Input 1:
		1
		7
		1 2 3 4 5 6 7 
		12
		Sample Output 1:
		5
		Sample Input 2:
		2
		7
		1 2 3 4 5 6 7 
		19
		9
		2 -5 8 -6 0 5 10 11 -3
		10
		Sample Output 2:
		0
		5
		
		
		 Explanation for Input 2:
		Since there doesn't exist any triplet with sum equal to 19 
		for the first query, we print 0.
		
		For the second query, we have 5 triplets in total that sum 
		up to 10. They are, (2, 8, 0), (2, 11, -3), (-5, 5, 10), 
		(8, 5, -3) and (-6, 5, 11)
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
	
	// Time Complexity -> O(n*n), Space Complexity -> O(log(n)) because 
	// space complexity of arrays.sort(arr) is O(log(n))
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
    
    // function to return true if triplet exists else false
    public static boolean findSumOfThree3(int nums[], int target) {
		// Sort the input list
		Arrays.sort(nums);
		int low, high, triples;

		// Fix one integer at a time and find the other two
		for (int i = 0; i < nums.length - 2; i++) {
			// Initialize the two pointers
			low = i + 1;
			high = nums.length - 1;

			// Traverse the list to find the triplet whose sum equals the target
			while (low < high) {
				triples = nums[i] + nums[low] + nums[high];

				// The sum of the triplet equals the target
				if (triples == target) {
					return true;
				}
				// The sum of the triplet is less than target, so move the low pointer forward
				else if (triples < target) {
					low++;
				} 
				// The sum of the triplet is greater than target, so move the high pointer backward
				else {
					high--;
				}
			}
		}

		// No such triplet found whose sum equals the given target
		return false;
	}

    // Driver code
	public static void main(String[] args) {
		int[][] numsList = {{3, 7, 1, 2, 8, 4, 5},
	                   {-1, 2, 1, -4, 5, -3},
	                   {2, 3, 4, 1, 7, 9},
	                   {1, -1, 0},
	                   {2, 4, 2, 7, 6, 3, 1}};
					   
		int[] testList = {10, 7, 20, -1, 8};
	
		
		for (int i=0; i<testList.length; i++) {
			System.out.print(i+1);
			System.out.println(".\tInput array: " + Arrays.toString(numsList[i]));
			
			if (findSumOfThree3(numsList[i], testList[i])) {
			System.out.println("\tSum for " + testList[i] + " exists ");
			} else {
			System.out.println("\tSum for " + testList[i] + " does not exist ");
			}
			
			System.out.println(new String(new char[100]).replace('\0', '-'));
		}
	}

}
