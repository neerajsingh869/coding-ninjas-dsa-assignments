package strings;

import java.util.Scanner;

public class PrintAllChars {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String inp = s.next();
		for(int i = 0; i<inp.length(); i++) {
			System.out.println(inp.charAt(i));
		}
	}

}
