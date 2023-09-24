package timeComplexity;

public class ArrayEquilibrium {
	
	/*
	 * For a given array/list(ARR) of size 'N,' find and 
	 * return the 'Equilibrium Index' of the array/list.
	 * 
	 * Equilibrium Index of an array/list is an index 'i' 
	 * such that the sum of elements at indices [0 to (i - 1)] 
	 * is equal to the sum of elements at indices [(i + 1) to (N-1)]. 
	 * One thing to note here is, the item at the index 'i' is 
	 * not included in either part.
	 * 
	 * If more than one equilibrium indices are present, then 
	 * the index appearing first in left to right fashion should 
	 * be returned. Negative one(-1) if no such index is present.
	 */
	
	// Time Complexity -> O(n*n), Space Complexity -> O(1)
	public static int arrayEquilibriumIndex1(int[] arr){  
		int n = arr.length;
        for(int i = 0; i<n; i++){
            int leftSum = 0, rightSum = 0;
            for(int j = 0; j<n; j++){
                if(j == i){
                    continue;
                }
                if(j < i){
                    leftSum += arr[j];
                }
                else{
                    rightSum += arr[j];
                }
            }
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static int arrayEquilibriumIndex2(int[] arr){  
		int n = arr.length;
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        int leftSum = 0;
        for(int i = 0; i<n; i++){
            if(2*leftSum == sum - arr[i]){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static int arrayEquilibriumIndex3(int[] arr){  
		int n = arr.length;
        int leftSum = 0, rightSum = 0;
        for(int i : arr){
            rightSum += i;
        }
        
        for(int i = 0; i<n; i++){
            rightSum -= arr[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
