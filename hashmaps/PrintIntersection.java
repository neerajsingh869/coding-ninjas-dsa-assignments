package hashmaps;

import java.util.Arrays;
import java.util.HashMap;

public class PrintIntersection {
	
	/*
	 * You have been given two integer arrays/list(ARR1 and ARR2) 
	 * of size N and M, respectively. You need to print their 
	 * intersection; An intersection for this problem can be 
	 * defined when both the arrays/lists contain a particular 
	 * value or to put it in other words, when there is a common 
	 * value that exists in both the arrays/lists.
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
