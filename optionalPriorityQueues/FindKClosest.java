package optionalPriorityQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindKClosest {
	
	/*
	 * You are given a N-sized unsorted array and two integers x and k, you have to find k closest values to x and put them in the output array.
Note: If 2 numbers are at same distance and only one of them have to be printed, print the one which is at a smaller index of the array.
Input Format:
 The first line of input contains the size of the given array(N). The second line of input contains the space separated array elements. The last line of input contains the value of x and k separated by space.
Output Format:
The only output line contains k-closest values to x in a sorted manner(sorting is handled internally).
Constraints:
 1<=N<=10000
 0<k<=N
Sample Input:
5
10 15 20 25 30
21 2
Sample Output:
20 25
	 */
	
	public static void closesttox(int arr[], int x, int k, int n, int output[]) { 
		//Write your code here
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[] takeInput() throws IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }
        
		String[] strNums;
		strNums = br.readLine().trim().split(" ");
		
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
        int x,k;
        int[] arr = takeInput();
        int n = arr.length;
        String[] strNums = br.readLine().trim().split(" ");
        x = Integer.parseInt(strNums[0]);
        k = Integer.parseInt(strNums[1]);
        
        int[] output = new int[k];
        closesttox(arr,x,k,n, output);

        Arrays.sort(output);
        printArray(output);

    }

}
