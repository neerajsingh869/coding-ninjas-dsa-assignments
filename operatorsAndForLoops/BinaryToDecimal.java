package operatorsAndForLoops;

import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int decimal = 0, pow = 1;
        while(n > 0){
            decimal += (n%10)*pow;
            n /= 10;
            pow *= 2;
        }
        System.out.println(decimal);
	}

}
