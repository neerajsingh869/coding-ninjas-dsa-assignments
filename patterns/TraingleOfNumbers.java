package patterns;

import java.util.Scanner;

public class TraingleOfNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++){
			for(int j = 1; j<=n-i; j++){
                System.out.print(" ");
            }
            int num = i;
            for(int j = 1; j<=i; j++){
                System.out.print(num++);
            }
            num -= 2;
            for(int j = 1; j<i; j++){
                System.out.print(num--);
            }
            System.out.println();
        }
	}

}
