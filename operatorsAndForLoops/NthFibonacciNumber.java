package operatorsAndForLoops;

import java.util.Scanner;

public class NthFibonacciNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0, b = 1;
        for(int i = 2; i<=n; i++){
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println(a);
        sc.close();
	}

}
