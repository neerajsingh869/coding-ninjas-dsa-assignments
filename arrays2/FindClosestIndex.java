package arrays2;

public class FindClosestIndex {
	
	/*
	 * You have been given a sorted(in ascending order) integer 
	 * array/list('nums') of size N and an element 'target'. 
	 * Your task is to return the index of closest element to 
	 * the 'target' in the array 'nums'.

		Example:
		Input: ‘N’ = 7 ‘target’ = 4
		‘A’ = [1, 3, 7, 9, 11, 12, 45]
		
		Output: 1
		
		Explanation: For nums = [1, 3, 7, 9, 11, 12, 45],
		The element 3 is closest to the target element , so we 
		will return the index of 3.
		Hence, the answer is '1'.
		Detailed explanation ( Input/output format, Notes, Images )
		Input format :
		The first line contains an Integer 'N', which denotes 
		the size of the array/list.
		
		The second line contains 'N' single space-separated 
		integers representing the elements in the array/list.
		
		The third line contains the value of 'target' to be 
		searched for in the array/list.
		Output Format :
		Return the index closest or at which 'target' is 
		present for each test case.
		Constraints :
		1 <= N <= 10^4
		1 <= nums[i] <= 10^9
		1 <= target <= 10^9
		Time Limit: 1 sec
		Sample Input 1:
		5
		1 2 3 4 5
		4
		Sample Output 1:
		3
		Explanation of sample output 1:
		For nums = [1, 2, 3, 4, 5],
		The element 4 is already present, so we will return the index of 4.
		Hence, the answer is '3'.
		Sample Input 2:
		7
		6 7 11 13 21 44 46
		22
		Sample Output 2:
		4
		Explanation of sample output 2:
		For nums = [6, 7, 11, 13, 21, 44, 46],
		The element 21 is closest to the target element so we will 
		return the index of element 21.
		Hence, the answer is '4'
	 */
	// Time complexity -> O(n), Space complexity -> O(1)
	public static int binarySearchClosest1(int []nums, int left, int right, int target) {
        int n = nums.length;

        int minDiff = Integer.MAX_VALUE;
        int minDiffIdx = -1;

        for (int i = 0; i < n; i++) {
            if (Math.abs(target - nums[i]) < minDiff) {
                minDiffIdx = i;
                minDiff = Math.abs(target - nums[i]);
            }
        }

        return minDiffIdx;
    }
	
	// Time complexity -> O(log(n)), Space complexity -> O(1)
	public static int binarySearchClosest2(int []nums, int left, int right, int target) {
        int n = nums.length;

        while (left <= right) {
            int midIdx = left + (right - left) / 2;

            if (nums[midIdx] == target) {
                return midIdx;
            } else if (nums[midIdx] > target) {
                right = midIdx - 1;
            } else {
                left = midIdx + 1;
            }
        }

        if (right < 0) return left;
        if (left >= n) return right;

        return (nums[left] - target > target - nums[right]) ? right : left;
    }

}
