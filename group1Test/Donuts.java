package group1Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Donuts {
	
	/*
	 * Ninja loves eating donuts. He consumes 4 donuts per day. When he eats 4 donuts such that their weight is w1 <= w2 <= w3 <= w4 , he gains weight w2 (second minimum value in the group).
You are given an array that contains the weight of n donuts. Your task is to determine the maximum total weight Ninja can gain by eating the donuts optimally each day.
Note: n is always a multiple of 4
Input Format:
First line of input contains integer t, denoting the number of test cases.
For each test case, you are given two things.
First line of input of each test case contains integer n
Second line of input of each test case contains n space separated integers representing the weights of donuts.
Constraints
1 <= t <= 1000
1 <= n <= 4*1000
Time Limit: 1 second
Output Format
You have to print the maximum total weight Ninja can gain by eating the donuts optimally each day.
Sample Input 1
1
4
2 4 3 5 
Sample Output 1
3
Explanation:
There is only one possible group of 4 donuts, out of which 3 is the second minimum weight.
Sample Input 2
2
8
1 9 4 10 6 18 4 5
12
3 4 10 19 17 23 6 6 12 5 20 27
Sample Output 2:
13
38
	 */
	
	/*
	 * Approach: 
	 * 		Out of 4 donuts, 3 must be as max as possible and 
	 * 		1 must be the minimum possible
	 */
	
	// Brute force (Time complexity -> O(n*log(n)))
	public static int donuts1(int[] arr) {
        int n = arr.length;
        int i = n-3, j = 0, ans = 0;
        Arrays.sort(arr);
        while(i > j) {
            ans += arr[i];
            // eat 3 max donuts
            i -= 3;
            // eat 1 min donut
            j += 1;
        }
        return ans;
    }
	
	 public static int donuts2(int[] arr) {
        PriorityQueue<Integer> pMax
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        for(int i = 0; i<arr.length; i++){
            pMax.add(arr[i]);
        }
        int ans = 0;
        for(int i = 0; i<arr.length/4; i++){
            for(int j = 0; j<2; j++) {
                pMax.poll();
            }
            ans += pMax.poll();
        }
        return ans;
    }
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            int ans = donuts2(arr);
            System.out.println(ans);
            t--;
        }
    }

}
