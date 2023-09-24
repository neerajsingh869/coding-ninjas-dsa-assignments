package patterns;

import java.util.Scanner;

public class CharacterPattern4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = n;
        while(i>=1){
            int j = 1;
            while(j<=n-i+1){
                System.out.print((char)('A'+i+j-2));
                j++;
            }
            System.out.println();
            i--;
        }
	}

}
