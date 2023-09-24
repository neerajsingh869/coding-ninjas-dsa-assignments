package optionalArrays;

import java.util.Scanner;

public class SuccessorProblem {
	
	/*
	 * 1. CodingNinjas has given you a number. You have to 
	 * print number, preceded by given number in lexicographically 
	 * sorted permutation of all digits of given number.
	 * 2. If the number is last element of lexicographically sorted 
	 * permutation of all digits of given number, then print the 
	 * first element of the sorted list.
	 * 3. For Example: 123 -> 132 and 5243 -> 5324 and 321 -> 123
	 
	 * Explanation: The lexicographically sorted list of permutation 
	 * of all digits of ‘123’ is:
		123
		132
		213
		231
		312
		321.
	   And the number which succeeds 123 in this list is 132 and hence, the answer. Similarly, since 321 is the last element of this list, I have to return 123, which is first element of the list.
	
	 * Input Format:
	   The first and only line of input contains an integer.
	
	 * Output Format:
	   The only line of output must contain number, preceded by given number in lexicographically sorted permutation of all digits of given number.
	
	 * Constraints:
		0 <= n <= 10^9
	
	 * Sample Input 1:
		123
		Sample Output 1:
		132
	
	 * Sample Input 2 :
		402356
		Sample Output 2 :
		402365
	 */
	
	// Time Complexity -> O(digit*digit), Space Complexity -> O(digit)
	private static int successorNum1(int n){
		int digit = calcDigit(n);
		int[] numArr = new int[digit];
		int k = digit-1;
		while(n!=0){
			numArr[k--] = n%10;
			n /= 10;
		}
		boolean isSwaped = false;
		for(int i = digit-1; i>=0; i--){
			int j = i-1;
			for(; j>=0; j--){
				if(numArr[j] < numArr[i]){
					swap(numArr, i, j);
					isSwaped = true;
					break;
				}
			}
			if(isSwaped){
				reverse(numArr, j+1, digit-1);
				break;
			}
		}
		if(!isSwaped){
			reverse(numArr, 0, digit-1);
		}
		return convertArrToNum(numArr);
	}
	
	private static int successorNum2(int n){
		int digit = calcDigit(n);
		if(digit == 1){
			return n;
		}
		int[] numArr = new int[digit];
		int k = digit-1;
		while(n!=0){
			numArr[k--] = n%10;
			n /= 10;
		}
		int i = digit-2;
		while(i >= 0){
			if(numArr[i] < numArr[i+1]){
				break;	
			}
			i--;
		}
		if(i!=-1){
			int swapIdx = i+1;
			for(int j = i+1; j<digit; j++){
				if(numArr[j] > numArr[i] && numArr[j] < numArr[i+1]){
					swapIdx = j;
				}
			}
			swap(numArr, i, swapIdx);
		}
		reverse(numArr, i+1, digit-1);
		return convertArrToNum(numArr);
	}

	private static int convertArrToNum(int[] arr){
		int num = 0;
		for(int i = 0; i<arr.length; i++){
			num = num*10 + arr[i];
		}
		return num;
	}

	private static void reverse(int[] arr, int i, int j){
		while(i < j){
			swap(arr, i, j);
			i++;
			j--;
		}
	}

	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static int calcDigit(int n){
		int digit = 0;
		while(n!=0){
			digit++;
			n/=10;
		}
		return digit;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(successorNum1(n));
	}

}
