package operatorsAndForLoops;

import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        while(i*i<=n){
            i++;
        }
        System.out.println(i-1);
	}

}
