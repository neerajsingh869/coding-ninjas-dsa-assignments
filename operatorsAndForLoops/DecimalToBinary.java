package operatorsAndForLoops;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long binary = 0, pow = 1;
        while(n > 0){
            binary += (n%2)*pow;
            n /= 2;
            pow *= 10;
        }
        System.out.println(binary);
	}

}
