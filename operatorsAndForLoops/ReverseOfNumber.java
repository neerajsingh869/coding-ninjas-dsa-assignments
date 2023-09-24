package operatorsAndForLoops;

import java.util.Scanner;

public class ReverseOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        while(n>0){
            ans = ans*10 + (n%10);
            n /= 10;
        }
        System.out.println(ans);
	}

}
