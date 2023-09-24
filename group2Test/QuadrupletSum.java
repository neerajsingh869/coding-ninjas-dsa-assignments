package group2Test;

import java.util.List;
import java.util.*;
import java.io.*;

public class QuadrupletSum {
	
	/*
	 * Given an array nums of n integers and integer x, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == x
Store all such possible quadruplets in an 2D array, and return it. The order of the quadruplets does not matter.
Input Format:
First line of input contains an integer n, representing the size of the array.
Second line of input contains n space separated integers.
Third line of input contains an integer x.
Constraints:
1 <= nums.length <= 200
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Output Format:
Return all possible quadruplets
Sample Input 1:
6
1 0 -1 0 -2 2 
0
Sample Output1:
-2 -1 1 2   
-2 0 0 2
-1 0 0 1
	 */
	
	static public List<List<Integer>> quadruplets(int[] nums, int x) 
    {
        // Write your code here
		return null;
    }

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine().trim());

        int arr[] = new int[n];

        StringTokenizer tk = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++)
        {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        int x = Integer.parseInt(br.readLine().trim());

        List<List<Integer>> answer = quadruplets(arr, x);

        for (int p = 0; p < answer.size(); p++)
        {
            for (int q = 0; q < 4; q++)
            {
                System.out.print(answer.get(p).get(q) + " ");
            }
            System.out.println();
        }
    }

}
