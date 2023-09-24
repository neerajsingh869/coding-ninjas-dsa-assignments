package conditionalsAndLoops;

import java.util.Scanner;

public class Factors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int div = 2; div < n; div++){
			if(n%div == 0){
                System.out.print(div + " ");
            }
        }
	}
	
}
