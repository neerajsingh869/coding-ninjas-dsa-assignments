package test2;

import java.util.Scanner;

public class CountAndSay {
	
	
	/*
	 * Write as you speak is a special sequence of string that
	 * starts with string "1" and after one iteration you rewrite
	 * the sequence as whatever you speak.
	 */
	public static String writeAsYouSpeak(int n) 
    {
        String prevIterAns = "1";
        String currIterAns = "1";

        for (int i = 2; i <= n; i++) {
            int prevIterAnsSize = prevIterAns.length();
            currIterAns = "";
            int tempCount = 1;

            for (int j = 0; j < prevIterAnsSize - 1; j++) {
                if (prevIterAns.charAt(j) == prevIterAns.charAt(j + 1)) {
                    tempCount++;
                } else {
                    currIterAns += String.valueOf(tempCount) + prevIterAns.charAt(j);
                    tempCount = 1;
                }
            }

            currIterAns += String.valueOf(tempCount) + prevIterAns.charAt(prevIterAnsSize - 1);
            prevIterAns = currIterAns;
        }

        return currIterAns;
    }

	public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        StringBuffer sb = new StringBuffer();

        while (t-- > 0) {
            int n = s.nextInt();
            String ans = writeAsYouSpeak(n);
            sb.append(ans + "\n");
        }
        System.out.print(sb);
    }
}
