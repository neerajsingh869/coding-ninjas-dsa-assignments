package conditionalsAndLoops;

import java.util.Scanner;

public class FahrenToCel {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int s, e, w;
        s = sc.nextInt();
        e = sc.nextInt();
        w = sc.nextInt();
        
        int i = s;
        while(i <= e){
            int cel = ((i-32)*5)/9;
            System.out.println(i + " " + cel);
            i+=w;
        }
	}

}
