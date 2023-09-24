package conditionalsAndLoops;

import java.util.Scanner;

public class SumEvenAndOdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sumOdd = 0, sumEven = 0;
        while(n > 0){
            int lastNum = n%10;
            if(lastNum%2 == 0){
                sumEven += lastNum;
            }
            else{
                sumOdd += lastNum;
            }
            n = n/10;
        }
        System.out.println(sumEven + " " + sumOdd);
	}

}
