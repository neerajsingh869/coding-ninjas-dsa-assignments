package test1;

import java.util.Scanner;

public class CheckArmstrong {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int temp = num, n = 0;
        while(temp > 0){
            temp /= 10;
            n++;
        }
        temp = num;
        int sum = 0;
        while(temp > 0){
            int ans = 1, currDigit = temp%10;
            // To calculate (curr digit)^n
            for(int i = 1; i<=n; i++){
                ans *= currDigit;
            }
            sum += ans;
            temp /= 10;
        }
		System.out.println(sum == num);
	}

}
