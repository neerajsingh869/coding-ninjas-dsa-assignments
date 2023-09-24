package operatorsAndForLoops;

import java.util.Scanner;

public class AllPrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 2; i<=n; i++){
            boolean isPrime = true;
            for(int div = 2; div*div<=i; div++){
                if(i%div == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime || i == 2){
                System.out.println(i);
            }
        }
		sc.close();
	}

}
