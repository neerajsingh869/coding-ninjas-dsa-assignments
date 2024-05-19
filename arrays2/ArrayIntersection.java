package arrays2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class ArrayIntersection {
	
	/*
	 * You have been given two integer arrays/list(ARR1 and ARR2) 
	 * of size N and M, respectively. You need to print their 
	 * intersection; An intersection for this problem can be 
	 * defined when both the arrays/lists contain a particular 
	 * value or to put it in other words, when there is a common 
	 * value that exists in both the arrays/lists.

		Note :
		Input arrays/lists can contain duplicate elements.
		
		The intersection elements printed would be in ascending order.
		
		
		Detailed explanation ( Input/output format, Notes, Images )
		Input format :
		The first line contains an Integer 't' which denotes the 
		number of test cases or queries to be run. Then the test 
		cases follow.
		
		The first line of each test case or query contains an integer 'N' 
		representing the size of the first array/list.
		
		The second line contains 'N' single space separated integers 
		representing the elements of the first the array/list.
		
		The third line contains an integer 'M' representing the size 
		of the second array/list.
		
		The fourth line contains 'M' single space separated integers 
		representing the elements of the second array/list.
		Output format :
		For each test case, print the intersection elements in a row, 
		separated by a single space.
		
		Output for every test case will be printed in a separate line.
		Constraints :
		1 <= t <= 10^2
		0 <= N <= 10^4
		0 <= M <= 10^4
		
		Time Limit: 1 sec 
		Sample Input 1 :
		2
		6
		2 6 8 5 4 3
		4
		2 3 4 7 
		2
		10 10
		1
		10
		Sample Output 1 :
		2 3 4
		10
		Sample Input 2 :
		1
		4
		2 6 1 2
		5
		1 2 3 4 2
		Sample Output 2 :
		1 2 2
		Explanation for Sample Output 2 :
		Since, both input arrays have two '2's, the intersection of the arrays 
		also have two '2's. The first '2' of first array matches with the first 
		'2' of the second array. Similarly, the second '2' of the first array
		 matches with the second '2' if the second array.
	 */
	// Time complexity -> O(n*log(n) + m*log(m))
	public static void intersection1(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (arr1[i] == arr2[j]) {
				System.out.print(arr1[i] + " ");
				i++;
				j++;
			} else if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
		}
	}
	
	// Time complexity -> O(k*log(k) + l) where k = min(n, m), and l = max(n, m)
	public static void intersection(int[] arr1, int[] arr2) {
		// arr1 is smaller array
	    int n = arr1.length;
		// arr2 is larger array
		int m = arr2.length;

		if (n > m) {
			int[] temp = arr2;
			arr2 = arr1;
			arr1 = temp;

			int tempSize = n;
			n = m;
			m = tempSize;
		}

		HashMap<Integer, Integer> freqArr2 = new HashMap<>();

		for (int j = 0; j < m; j++) {
			freqArr2.put(arr2[j], freqArr2.getOrDefault(arr2[j], 0) + 1);
		}

		Arrays.sort(arr1);

		for (int i = 0; i < n; i++) {
			if (freqArr2.containsKey(arr1[i]) && freqArr2.get(arr1[i]) > 0) {
				System.out.print(arr1[i] + " ");
				freqArr2.put(arr1[i], freqArr2.get(arr1[i]) - 1);
			}
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
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {
            int[] arr1 = takeInput();
            int[] arr2 = takeInput();
            intersection1(arr1, arr2);
            System.out.println();

            t -= 1;
        }
    }

}
