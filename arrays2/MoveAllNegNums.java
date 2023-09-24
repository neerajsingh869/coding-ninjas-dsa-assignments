package arrays2;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MoveAllNegNums {
	
	/*
	 * You are given an array 'ARR' consisting of 'N' integers. You need to rearrange the array elements such that all negative numbers appear before all positive numbers.
		Follow Up:
		Can you solve this in O(1) auxiliary space?
		Note:
		The order of elements in the resulting array is not important.
		Example:
		Let the array be [1, 2, -3, 4, -4, -5]. On rearranging the array such that all negative numbers appear before all positive numbers we get the resulting array [-3, -5, -4, 2, 4, 1].
		Input format:
		The very first line of input contains an integer ‘T’ denoting the number of test cases. 
		
		The first line of every test case contains an integer ‘N’ denoting the number of elements present in the array.
		
		The second line of every test case contains ‘N’ space-separated integers denoting the elements present in the array.
		Output format:
		For each test case, “Yes” is printed if the resulting array is correct otherwise “No”.
		
		Output for each test case is printed on a separate line.
		Constraints:
		1 <= T <= 10
		1 <= N <= 5 * 10^4
		-10^5 <= ARR[i] <= 10^5
		
		Where  ‘T’ represents the number of test cases and ‘N’ represents the number of elements present in the array.
		
		Time Limit: 1 sec
		Sample Input 1:
		2
		5
		1 -4 -2 5 3
		2
		2 1    
		Sample Output 1:
		Yes
		Yes
		Explanation for Sample Input 1:
		For the first test case we have, array: [1, -4, -2, 5, 3] and N = 5. On rearranging the array such that all negative numbers appear before all positive numbers we get the resulting array [-2, -4, 1, 5, 3].
		
		For the second test case we have, array: [2, 1] and N = 2. There are no negative numbers. Hence, we do not require any rearrangement.
		Sample Input 2:
		3
		4
		1 -5 -5 3
		5
		-1 -2 3 4 5
		1
		-2
		Sample Output 2:
		Yes 
		Yes
		Yes
		Explanation for Sample Input 2:
		For the first test case we have, array: [1, -5, -5,  3] and N = 4. On rearranging the array such that all negative numbers appear before all positive numbers we get the resulting array [-5, -5, 1, 3].
		
		For the second test case we have, array: [-1, -2, 3, 4, 5] and N = 5. There are already arranged in required way. Hence, we do not require any rearrangement.
		
		For the third test case we have, array: [-2 ] and N = 1. The array is already arranged in required way. Hence, we do not require any rearrangement.
	 */
	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static int[] separateNegativeAndPositive1(int a[]) {
        int n = a.length;
        int countNeg = 0;
        for(int i = 0; i<n; i++){
            if(a[i] < 0){
                countNeg++;
            }
        }
        int[] negArr = new int[countNeg];
        int[] posArr = new int[n - countNeg];
        int j = 0, k = 0;
        for(int i = 0; i<n; i++){
            if(a[i] < 0){
                negArr[j++] = a[i];
            }
            else{
                posArr[k++] = a[i];
            }
        }
        int i = 0;
        j = 0;
        while(j < countNeg){
            a[i++] = negArr[j++];
        }
        k = 0;
        while(k < n - countNeg){
            a[i++] = posArr[k++];
        }
        return a;
    }
	
	// Time Complexity -> O(n*log(n)), Space Complexity -> O(1)
	public static int[] separateNegativeAndPositive2(int a[]) {
        Arrays.sort(a);
        return a;
    }
	
	// Time Complexity -> O(n*n), Space Complexity -> O(1)
	public static int[] separateNegativeAndPositive3(int a[]) {
        int n = a.length;
        for(int i = 0; i<n; i++){
            if(a[i] < 0) {
                continue;
            }
            else{
                int j = i;
                for(; j<n; j++){
                    if(a[j] < 0){
                        break;
                    }
                }
                if(j < n){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static int[] separateNegativeAndPositive4(int a[]) {
        int i = 0, j = a.length-1;
        while(i < j){
            if(a[i] < 0){
                i++;
            }
            else{
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j--;
            }
        }
        return a;
    }
	
	private static int t;
    private static int [][] arr;

    private static void takeInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine().split(" ")[0]);

        arr = new int [t][];

        String[] data;

        for (int i = 0; i < t; i++) {
            int n;
            n = Integer.parseInt(br.readLine().split(" ")[0]);
            arr[i] = new int[n];

            data = br.readLine().trim().split(" ");

            for (int j = 0; j < n; j++) {
                arr[i][j]= Integer.parseInt(data[j]);
            }
        }
    }

    private static boolean checkValid(int ans[], int n, HashMap < Integer, Integer > mp) {
        if (ans.length != n) {
            return false;
        }

        int i = 0;
        // Iterating over negative values.
        while (i < n && ans[i] < 0) {
            Integer val = mp.get(ans[i]);

            if (mp.containsKey(ans[i]) == false || val == null || val <= 0) {
                return false;
            } else {
                mp.put(ans[i], val - 1);
            }
            ++i;
        }

        // Iterating over positive values.
        while (i < n) {
            if (ans[i] < 0) {
                return false;
            }

            Integer val = mp.get(ans[i]);

            if (mp.containsKey(ans[i]) == false || val == null || val <= 0) {
                return false;
            } else {
                mp.put(ans[i], val - 1);
            }
            ++i;
        }

        return true;
    }

    private static void executeAndPrintOutput() {

        for (int i = 0; i < t; i++) {

            int n = arr[i].length;

            HashMap < Integer, Integer > mp = new HashMap < Integer, Integer > ();

            for (int j = 0; j < n; j++) {
                Integer val = mp.get(arr[i][j]);

                if (val == null) {
                    val = 0;
                }
                mp.put(arr[i][j], val + 1);
            }
            
            int []ans = separateNegativeAndPositive4(arr[i]);

            if (checkValid(ans, n, mp)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
    private static void execute() {
        int [][]aCpy = arr.clone();
        for (int i = 0; i < t; ++i) {
            int []ans = separateNegativeAndPositive4(aCpy[i]);
        }
    }
    public static void main(String[] args) throws IOException {
        takeInput();
        executeAndPrintOutput();
    }

}
