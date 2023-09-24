package forLoops;

import java.util.Scanner;
import java.lang.Math;

public class AllPrimeNumbers {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i = 2; i<=n; i++) {
            boolean flag = true;
			for(int div = 2; div<=Math.sqrt(i); div++) {
				if(i%div == 0) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				System.out.println(i);
			}
		}
	}

}
