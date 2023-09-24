package optionalHashmaps;

import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindAllAnagramsInString {
	
	public static ArrayList<Integer> findAnagramsIndices(String str, int n, String ptr, int m){
        // Write your code here.
		return null;
    }
	
	private static int t;
    private static ArrayList<String> allStrings;

    private static void takeInput() throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine().split(" ")[0]);

        allStrings = new ArrayList<String>(2*t);

        for (int i = 0; i < t; i++) 
        {
            String str=br.readLine();
            allStrings.add(br.readLine().trim());
            allStrings.add(br.readLine().trim());
        }
    }

    private static void execute() 
    {
        ArrayList<String> allStringsCopy = new  ArrayList<String>(allStrings);

        for (int i = 0; i < 2*t;) 
        {
            ArrayList<Integer> ans = findAnagramsIndices(allStringsCopy.get(i), allStringsCopy.get(i++).length(), allStringsCopy.get(i), allStringsCopy.get(i++).length());
        }
    }

    private static void executeAndPrintOutput() 
    {
        for (int i = 0; i < 2*t;) 
        {

            ArrayList<Integer> ans = findAnagramsIndices(allStrings.get(i), allStrings.get(i++).length(), allStrings.get(i), allStrings.get(i++).length());

            for(int j:ans){
                System.out.print(j+" ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        takeInput();
        executeAndPrintOutput();
    }

}
