package operatorsAndForLoops;

import java.util.Scanner;

public class SumOrProduct {
	
	/*
	 * Write a program that asks the user for a number 
	 * N and a choice C. And then give them the possibility 
	 * to choose between computing the sum and computing the 
	 * product of all integers in the range 1 to N (both inclusive).
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int ans;
        switch(c){
            case 1:
              	ans = 0;
            	for(int i = 1; i<=n; i++){
            		ans += i;
            	}
                break;
            case 2:
                ans = 1;
            	for(int i = 1; i<=n; i++){
					ans *= i;
            	}
                break;
            default:
                ans = -1;
        }
        System.out.println(ans);
        sc.close();
	}

}
