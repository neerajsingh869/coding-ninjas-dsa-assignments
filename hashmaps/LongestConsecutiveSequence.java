package hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestConsecutiveSequence {
	
	/*
	 * You are given an array of unique integers that contain numbers in random order. 
	 * You have to find the longest possible sequence of consecutive numbers using 
	 * the numbers from given array.
	 * 
		You need to return the output array which contains starting and ending element. If
		 the length of the longest possible sequence is one, then the output array must 
		 contain only single element.
		 
		Note:
		1. Best solution takes O(n) time.
		2. If two sequences are of equal length, then return the sequence starting with 
		the number whose occurrence is earlier in the array.
		
		Input format:
		The first line of input contains an integer, that denotes the value of the size 
		of the array. Let us denote it with the symbol n.
		The following line contains n space separated integers, that denote the value of 
		the elements of the array.
		
		Output format:
		The first and only line of output contains starting and ending element of the 
		longest consecutive sequence. If the length of  the longest consecutive sequence is 1, 
		then just print the starting element.
		
		Constraints :
		0 <= n <= 10^6
		Time Limit: 1 sec
		
		Sample Input 1 :
		13
		2 12 9 16 10 5 3 20 25 11 1 8 6 
		Sample Output 1 :
		8 12 
		Sample Input 2 :
		7
		3 7 2 1 9 8 41
		Sample Output 2 :
		7 9
		Explanation: Sequence should be of consecutive numbers. Here we have 2 sequences 
		with same length i.e. [1, 2, 3] and [7, 8, 9], but we should select [7, 8, 9] 
		because the starting point of [7, 8, 9] comes first in input array and therefore, 
		the output will be 7 9, as we have to print starting and ending element of the 
		longest consecutive sequence.
		
		Sample Input 3 :
		7
		15 24 23 12 19 11 16
		Sample Output 3 :
		15 16
	 */
	// Time complexity -> O(n*n), Space complexity -> O(n)
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence1(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], true);
		}

		int maxCount = 1;
		int maxFirstNum = arr[0];
		int maxSecondNum = arr[0];

		for (int i = 0; i < arr.length; i++) {
			int currNum = arr[i];
			int tempFirstNum = currNum;
			int count = 0;
			
			while (map.containsKey(currNum)) {
				count++;
				currNum += 1;
			}
			
			int tempSecondNum = currNum - 1;
			if (count > maxCount) {
				maxCount = count;
				maxFirstNum = tempFirstNum;
				maxSecondNum = tempSecondNum;
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		if (maxFirstNum == maxSecondNum) {
			ans.add(maxFirstNum);
			return ans;
		}
		
		ans.add(maxFirstNum);
		ans.add(maxSecondNum);
		return ans;
    }
	
	// Time complexity -> O(n*n), Space complexity -> O(n)
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence2(int[] arr) {
		int n = arr.length;
		HashMap<Integer, Boolean> map = new HashMap<>();
		
		for(int i = 0; i<n; i++){
			map.put(arr[i], true);
		}
		
		int maxCount = 1;
		int maxFirstNum = arr[0];
		
		for(int i = 0; i<n; i++){
			int firstNum = arr[i];
			int j = arr[i];
			int count = 0;
			
			while(map.containsKey(j)){
				count++;
				j++;
			}
			
			if(count > maxCount){
				maxCount = count;
				maxFirstNum = firstNum;
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		ans.add(maxFirstNum);
		
		if(maxCount > 1){
			ans.add(maxFirstNum + maxCount - 1);
		}
		
		return ans;
    }
	
	// Best approach 1 (Time complexity -> O(n), Space complexity -> O(n))
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence3(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}

		int maxCount = 1;
		int maxFirstNumIdx = 0;

		for (int i = 0; i < arr.length; i++) {
			if ( map.containsKey(arr[i]) ) {
				int countBwd = 0, countFwd = 0;

				map.remove(arr[i]);

				int curr = arr[i] - 1;
				int firstNumIdx = i;

				while ( map.containsKey(curr) ) {
					firstNumIdx = map.get(curr);
					map.remove(curr);
					curr--;
					countBwd++;
				}

				curr = arr[i] + 1;

				while ( map.containsKey(curr) ) {
					map.remove(curr);
					curr++;
					countFwd++;
				}
				
				int count = countBwd + countFwd + 1;

				if (count >= maxCount) {
					if (count == maxCount) {
						if (firstNumIdx < maxFirstNumIdx) {
							maxCount = count;
							maxFirstNumIdx = firstNumIdx;
						}
					} else {
						maxCount = count;
						maxFirstNumIdx = firstNumIdx;
					}
				}
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();

		ans.add(arr[maxFirstNumIdx]);

		if (maxCount > 1) {
			ans.add(arr[maxFirstNumIdx] + maxCount - 1);
		}

		return ans;
    }
	
	// Best approach 2 (Time complexity -> O(n), Space complexity -> O(n))
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence4(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Boolean> vis = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
			vis.put(arr[i], false);
		}

		int maxCount = 1;
		int maxFirstNumIdx = 0;

		for (int i = 0; i < arr.length; i++) {
			if ( vis.get(arr[i]) == false ) {
				int countBwd = 0, countFwd = 0;

				vis.put(arr[i], true);

				int curr = arr[i] - 1;
				int firstNumIdx = i;

				while ( vis.containsKey(curr) && vis.get(curr) == false ) {
					firstNumIdx = map.get(curr);
					vis.put(curr, true);
					curr--;
					countBwd++;
				}

				curr = arr[i] + 1;

				while ( vis.containsKey(curr) && vis.get(curr) == false ) {
					vis.put(curr, true);
					curr++;
					countFwd++;
				}
				
				int count = countBwd + countFwd + 1;

				if (count >= maxCount) {
					if (count == maxCount) {
						if (firstNumIdx < maxFirstNumIdx) {
							maxCount = count;
							maxFirstNumIdx = firstNumIdx;
						}
					} else {
						maxCount = count;
						maxFirstNumIdx = firstNumIdx;
					}
				}
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();

		ans.add(arr[maxFirstNumIdx]);

		if (maxCount > 1) {
			ans.add(arr[maxFirstNumIdx] + maxCount - 1);
		}

		return ans;
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

    public static void printArray(ArrayList<Integer> arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] arr = takeInput();
        ArrayList<Integer> ans = longestConsecutiveIncreasingSequence4(arr);
        printArray(ans);
    }

}
