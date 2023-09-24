package hashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintIntersection {
	
	/*
	 * You have been given two integer arrays/lists (ARR1 and ARR2) 
	 * of size N and M, respectively. You need to print their intersection; 
	 * An intersection for this problem can be defined when both the 
	 * arrays/lists contain a particular value or to put it in other words, 
	 * when there is a common value that exists in both the arrays/lists.
	 * 
		Note :
		Input arrays/lists can contain duplicate elements.
		The intersection elements printed would be in the order they appear 
		in the second array/list (ARR2).
		
		
		Input format :
		The first line of input contains an integer 'N' representing the size 
		of the first array/list.
		The second line contains 'N' single space separated integers representing 
		the elements of the first the array/list.
		The third line contains an integer 'M' representing the size of the 
		second array/list.
		The fourth line contains 'M' single space separated integers representing 
		the elements of the second array/list.
		
		Output format :
		Print the intersection elements. Each element is printed in a separate line.
		
		Constraints :
		0 <= N <= 10^6
		0 <= M <= 10^6
		Time Limit: 1 sec 
		
		Sample Input 1 
		6
		2 6 8 5 4 3
		4
		2 3 4 7 
		Sample Output 1 :
		2
		3 
		4
		
		Sample Input 2 :
		4
		2 6 1 2
		5
		1 2 3 4 2
		Sample Output 2 :
		1 
		2 
		2
	 */
	
	// Time complexity -> O(n1*n2), Space complexity -> O(1)
	public static void intersection1(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        Arrays.sort(arr1);
        for(int i = 0; i<n1; i++){
            for(int j = 0; j<n2; j++){
                if(arr1[i] == arr2[j]){
                    System.out.print(arr1[i] + " ");
                    arr2[j] = Integer.MAX_VALUE;
                    break;
                }
            }
        }
	}
	
	// Time complexity -> O(n1*log(n1) + n2*log(n2)), Space complexity -> O(1)
	public static void intersection2(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(arr1[i] == arr2[j]){
                System.out.print(arr1[i] + " ");
               	i++;
                j++;
            }
            else if(arr1[i] > arr2[j]){
                j++;
            }
            else{
                i++;
            }
        }
	}
	
	// Time complexity -> O(n2*log(n2)), Space complexity -> O(n1)
	public static void intersection3(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // No need to sort if we want to maintain the order
         Arrays.sort(arr2);
        for(int i : arr2){
            if(map.containsKey(i) && map.get(i) > 0){
                System.out.print(i + " ");
                map.put(i, map.get(i) - 1);
            }
        }
	}
	
	// Time complexity -> O(n1 + n2), Space complexity -> O(n1)
	public static void intersection4(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // Order maintained as in arr2
        for(int i : arr2){
            if(map.containsKey(i) && map.get(i) > 0){
                System.out.print(i + " ");
                map.put(i, map.get(i) - 1);
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


        int[] arr1 = takeInput();
        int[] arr2 = takeInput();
        intersection4(arr1,arr2);


    }

}
