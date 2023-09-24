package optionalDynamicProgramming;

import java.util.Scanner;
import java.util.TreeSet;

public class FindNthUglyNumber {
	
	/*
	 * You have a sequence 1,2,3,4,5,6,8,9,10,12,15,.....showing first 11 ugly numbers. Ugly numbers are the numbers whose only prime factors are 2,3 or 5. 1 is also considered as an ugly number. Now, your task is to find the nth ugly of the sequence if n is given to you.
Input Format:
The only line of input contains the value of n.
Output Format:
The only output line contains the value of nth ugly number.
Constraints:
1<=n<=1500
Sample Input:
 8
Sample Output:
9
	 */
	
	public static int uglyNumber1(int n) {
        int count = 0;
        int i = 0;
        while(count < n){
            i++;
            if(checkFactors235(i)){
                count++;
            }
        }
        return i;
    }
	
	private static boolean checkFactors235(int number){
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }
	
	// Time complexity -> O(n*log(n)), Space complexity -> O(n)
	public static int uglyNumber2(int n) {
        TreeSet<Integer> uglyNumSeq = new TreeSet<>();
        uglyNumSeq.add(1);
        int count = 0;
        int ans = 0;
        while(count < n){
            ans = uglyNumSeq.pollFirst();
            uglyNumSeq.add(ans*2);
            uglyNumSeq.add(ans*3);
            uglyNumSeq.add(ans*5);
            count++;
        }
        return ans;
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static int uglyNumber(int n) {
        int[] uglyNum = new int[n];
        uglyNum[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int mult_2 = 2, mult_3 = 3, mult_5 = 5;
        for(int i = 1; i<n; i++){
            uglyNum[i] = Math.min(mult_2, Math.min(mult_3, mult_5));
            if(uglyNum[i] == mult_2){
                i2++;
                mult_2 = uglyNum[i2]*2;
            }
            if(uglyNum[i] == mult_3){
                i3++;
                mult_3 = uglyNum[i3]*3;
            }
            if(uglyNum[i] == mult_5){
                i5++;
                mult_5 = uglyNum[i5]*5;
            }
        }
        return uglyNum[n-1];
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.print(uglyNumber2(n));
	}	

}
