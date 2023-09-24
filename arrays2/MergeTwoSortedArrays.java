package arrays2;

public class MergeTwoSortedArrays {
	
	/*
	 * You have been given two sorted arrays/lists(ARR1 and ARR2) 
	 * of size N and M respectively, merge them into a 
	 * third array/list such that the third array is also sorted.
	 */
	
	public static int[] merge(int arr1[], int arr2[]) {
    	int n = arr1.length, m = arr2.length;
        int i = 0, j = 0, k = 0;
        int[] arr = new int[n+m];
        while(i<n && j<m){
            if(arr1[i] < arr2[j]){
                arr[k++] = arr1[i++];
            }
            else{
                arr[k++] = arr2[j++];
            }
        }
        while(i<n){
            arr[k++] = arr1[i++];
        }
        while(j<m){
            arr[k++] = arr2[j++];
        }
        return arr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
