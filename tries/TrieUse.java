package tries;

import java.io.IOException;
import java.util.Scanner;

public class TrieUse {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		TrieNew t = new TrieNew();
        String[] string = sc.nextLine().split("\\s"); 

        int choice = Integer.parseInt(string[0]);
        String word = "Null";
        if (string.length!=1)        
        {
            word = string[1];
        }
        		
		
		while(choice != -1) {
			switch(choice) {
				case 1 : // insert
					t.add(word);
					break;
				case 2 : 
					t.remove(word);
					break;
				case 3 : 
					System.out.println(t.countWords());
					break;
				default :
						return;
			}

            string = sc.nextLine().split("\\s");
            choice = Integer.parseInt(string[0]);
            if (string.length!=1){
                word = string[1];
            }
		}
	}

}
