package arrays2;

public class SumOfTwoArrays {
	
	/*
	 * Two random integer arrays/lists have been given 
	 * as ARR1 and ARR2 of size N and M respectively. 
	 * Both the arrays/lists contain numbers from 
	 * 0 to 9(i.e. single digit integer is present at every index). 
	 * The idea here is to represent each array/list as 
	 * an integer in itself of digits N and M.
	 * 
	 * You need to find the sum of both the input arrays/list 
	 * treating them as two integers and put the result in another 
	 * array/list i.e. output array/list will also contain only 
	 * single digit at every index.
	 */
	
	public static void sumOfTwoArrays(int arr1[], int arr2[], int output[]) {
        int n = arr1.length;
        int m = arr2.length;
        int p = output.length;
        int i = n-1, j = m-1, k = p-1;
        int carry = 0;
        while(i >= 0 && j >= 0){
        	int tempSum = arr1[i--] + arr2[j--];
            output[k--] = (tempSum + carry)%10;
            carry = (tempSum + carry)/10;
        }
        while(i >= 0){
            output[k--] = (arr1[i] + carry)%10;
            carry = (arr1[i] + carry)/10;
            i--;
        }
        while(j >= 0){
            output[k--] = (arr1[j] + carry)%10;
            carry = (arr1[j] + carry)/10;
            j--;
        }
        output[0] = carry;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
