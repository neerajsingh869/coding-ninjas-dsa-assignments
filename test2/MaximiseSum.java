package test2;

public class MaximiseSum {
	
	/*
	 * Given 2 sorted arrays (in increasing order), find a path 
	 * through the intersections that produces maximum sum and 
	 * return the maximum sum.

		That is, we can switch from one array to another array only at 
		common elements.
		
		If no intersection element is present, we need to take sum of 
		all elements from the array with greater sum.
		
		Detailed explanation ( Input/output format, Notes, Images )
		Input Format :
		 Line 1 : An integer M i.e. size of first array
		 Line 2 : M integers which are elements of first array, 
		 separated by spaces
		 Line 3 : An integer N i.e. size of second array
		 Line 4 : N integers which are elements of second array, 
		 separated by spaces
		Output Format :
		Maximum sum value
		Constraints :
		1 <= M, N <= 10^6
		
		Sample Input :
		6
		1 5 10 15 20 25
		5
		2 4 5 9 15
		Sample Output :
		81
		Explanation :
		We start from array 2 and take sum till 5 (sum = 11). 
		Then we'll switch to array at element 10 and take till 15. 
		So sum = 36. Now, no elements left in array after 15, 
		so we'll continue in array 1. Hence sum is 81
	 */
	
	public static long maximumSumPath(int[] input1, int[] input2) {
        int n = input1.length;
        int m = input2.length;

        int maxSum = 0;
        int sum1 = 0;
        int sum2 = 0;

        int i = 0; 
        int j = 0;
        while (i < n && j < m) {
            if (input1[i] == input2[j]) {
                maxSum += Math.max(sum1, sum2) + input1[i];

                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            } else if (input1[i] < input2[j]) {
                sum1 += input1[i];
                i++;
            } else {
                sum2 += input2[j];
                j++;
            }
        }

        while (i < n) {
            sum1 += input1[i];
            i++;
        }
        
        while (j < m) {
            sum2 += input2[j];
            j++;
        }

        return maxSum += Math.max(sum1, sum2);
	}

	public static void main(String[] args) {
		
	}

}
