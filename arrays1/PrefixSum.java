package arrays1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrefixSum {
	
	/*
	 * For Array A of size n, the prefix sum of A is another array P of size n+1, 
	 * where P[i] represents the sum of the first i elements of A. That is,
				P[0] = A[0]
				P[1] = A[0] + A[1]
				P[2] = A[0] + A[1] + A[2]
				...
				P[n-1] = A[0] + A[1] + ... + A[n-1]
		You will given an array arr of length n along with an output array 
		of the same length. Your objective is to populate the output array 
		as required, without the need to print or return anything.
		Input Format:
		First line of the input contains the size 'N' of the array arr.
		Next line contains N integers separated by a single space. 
		Output Format:
		Output contains N integers representing Prefix sums array i.e. 'output' array.
		Constraints:
		1<=N<=10000
		0<=arr[i]<=10000
		Input 1:
		5
		1 2 3 4 5
		Output 1:
		1 3 6 10 15
		Input 2:
		4
		4 8 9 11
		Output 2:
		4 12 21 32
	 */
	// Time complexity -> O(n)
	public static void prefixSum(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i-1];
        }
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
            int[] input = takeInput();
            prefixSum(input);
            printArray(input);

    }

}
