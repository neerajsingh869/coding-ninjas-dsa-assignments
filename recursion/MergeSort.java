package recursion;

public class MergeSort {
	
	/*
	 * Sort an array A using Merge Sort.
	 */
	
	// Time complexity -> O(n*logn), Space complexity -> O(n)
	public static void mergeSort1(int[] input){
        int n = input.length;
        mergeSort1(input, 0, n-1);
	}
    
    public static void mergeSort1(int[] input, int st, int end){
        if(st >= end){
            return;
        }
        int mid = st + (end-st)/2;
        mergeSort1(input, st, mid);
        mergeSort1(input, mid+1, end);
        merge1(input, st, mid, end);
    }
    
    public static void merge1(int[] input, int st, int mid, int end){
        int n1 = mid-st+1;
        int n2 = end-mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int k = st;
        for(int i = 0; i<n1; i++){
        	arr1[i] = input[k++];
        }
        for(int i = 0; i<n2; i++){
            arr2[i] = input[k++];
        }
        int i = 0, j = 0;
        k = st;
        while(i < n1 && j < n2){
            if(arr1[i] < arr2[j]){
                input[k++] = arr1[i++];
            }
            else{
                input[k++] = arr2[j++];
            }
        }
        while(i < n1){
            input[k++] = arr1[i++];
        }
        while(j < n2){
            input[k++] = arr2[j++];
        }
    }
    
    // Time complexity -> O(n*logn), Space complexity -> O(n)
    public static void mergeSort2(int[] input){
        int n = input.length;
        if(n == 0 || n == 1){
            return;
        }
        int mid = n/2;
        int[] arr1 = new int[mid];
        int[] arr2 = new int[n-mid];
        int k = 0;
        for(int i = 0; i<arr1.length; i++){
            arr1[i] = input[k++];
        }
        for(int i = 0; i<arr2.length; i++){
            arr2[i] = input[k++];
        }
        mergeSort2(arr1);
        mergeSort2(arr2);
        merge2(input, arr1, arr2);
	}
    
    public static void merge2(int[] input, int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0, k = 0;
        while(i < n1 && j < n2){
            if(arr1[i] < arr2[j]){
                input[k++] = arr1[i++];
            }
            else{
                input[k++] = arr2[j++];
            }
        }
        while(i < n1){
            input[k++] = arr1[i++];
        }
        while(j < n2){
            input[k++] = arr2[j++];
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
