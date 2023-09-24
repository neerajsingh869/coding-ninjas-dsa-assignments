package arrays2;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PairWithSmallestDifference {
	
	/*
	 * Given two unsorted arrays of non-negative integers, 'arr1' and 'arr2' of size 'N' and 'M', respectively. Your task is to find the pair of elements (one from each array), such that their absolute (non-negative) difference is the smallest, and return the difference.
	Example :
	N = 3, arr1 = [10, 20, 30]
	M = 2, arr2 = [17, 15]
	The smallest difference pair is (20, 17) with an absolute difference of 3. So, the answer is 3.
	Note :
	Both the arrays are unsorted, and all array elements are non-negative integers.
	Input format :
	The first line of input contains an integer ‘T’ denoting the number of test cases.
	
	The first line of each test case contains two space-separated integers, 'N' and 'M', where 'N' and 'm' are the sizes of array 'arr1' and 'arr2', respectively.
	
	The second line of each test case contains 'N' space-separated integers denoting the elements of array 'arr1'.
	
	The third line of each test case contains 'M' space-separated integers denoting the elements of array 'arr2'.
	Output format :
	For each test case, return the smallest absolute difference.
	Note:
	You do not need to print anything; it has already been taken care of. Just implement the function.
	Constraints :
	1 <= T <= 10
	1 <= N, M <= 1000
	0 <= arr1[i], arr2[i] <=10^6
	
	Time Limit: 1 second
	Sample input 1 :
	2
	3 3
	12 7 5
	4 4 6
	3 2
	10 20 30 
	17 15
	Sample output 1 :
	1
	3
	Explanation For Sample Input 1 :
	Test Case 1 :
	The smallest difference pairs are (7, 6) and (5, 6) with an absolute difference of 1, so the answer is 1.
	
	Test Case 2 :
	The smallest difference pair is (20, 17) with an absolute difference of 3, so the answer is 3.
	Sample input 2 :
	2
	4 4
	1 5 12 3
	16 9 10 20
	2 4
	20 10
	10 13 19 16
	Sample output 2 :
	2
	0
	 */
	// Time Complexity -> O(n*log(n) + m*log(m)), Space Complexity -> O(1)
	public static int smallestDifferencePair(int []arr1, int n, int []arr2, int m) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int minDiff = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(i < n && j < m){
            minDiff = Math.min(Math.abs(arr2[j] - arr1[i]), minDiff);
            if(arr1[i] <= arr2[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return minDiff;
    }
	
	public static class FastReader {

        BufferedReader br;
        StringTokenizer root;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (root == null || !root.hasMoreTokens()) {
                try {
                    root = new StringTokenizer(br.readLine());
                } catch (Exception r) {
                    r.printStackTrace();
                }
            }
            return root.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static FastReader sc = new FastReader();

    private static int t;
    private static int []n;
    private static int []m;
    private static int [][]arr1;
    private static int [][]arr2;

    private static void takeInput() {
        t = sc.nextInt();
        n = new int[t];
        m = new int[t];
        arr1 = new int[t][];
        arr2 = new int[t][];
        for (int i = 0; i < t; ++i) {
            n[i] = sc.nextInt();
            m[i] = sc.nextInt();
            arr1[i] = new int[n[i]];
            arr2[i] = new int[m[i]];
            for(int j = 0; j < n[i]; j++) {
                arr1[i][j] = sc.nextInt();
            }
            for(int j = 0; j < m[i]; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
    }

    private static void execute() {
        int [][]arr1Cpy = arr1.clone();
        int [][]arr2Cpy = arr2.clone();
        for (int i = 0; i < t; ++i) {
            int ans = smallestDifferencePair(arr1Cpy[i], n[i], arr2Cpy[i], m[i]);
        }
    }

    private static void executeAndPrintOutput() {
        for (int i = 0; i < t; ++i) {
            int ans = smallestDifferencePair(arr1[i], n[i], arr2[i], m[i]);
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        takeInput();
        executeAndPrintOutput();
        out.close();
    }

}
