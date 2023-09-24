package test2;

import java.util.Scanner;

public class MaximumNumber {
	
	/*
	 * We are given a 4 digit number using digits 1 to 9. 
	 * What is the maximum 3 digit number that we can make 
	 * by removing one digit from the given integer.
	 */
	
	public static int max_number1(int n) {
		int ans = 0;
		int i = 1;
		while(n/i > 0) {
			int newNum = (n/(i*10))*i + (n%i);
			i*=10;
			if(ans<newNum) {
				ans = newNum;
			}
		}
		return ans;
	}
	
	
	// Easy to understand approach
	public static int max_number2(int n){
		int ans = Integer.MIN_VALUE;
        int power10 = 1;
        int backwardNum = 0;
        while(n > 0){
            int rem = n%10;
            n = n/10;
            int currNum = n*power10 + backwardNum;
            ans = Math.max(ans, currNum);
            backwardNum += rem*power10;
            power10 *= 10;
        }
        return ans;
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(max_number2(n));
	}

}
