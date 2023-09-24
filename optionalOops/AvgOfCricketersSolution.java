package optionalOops;

import java.util.Scanner;

/*
 * Given a player class which has the following members:
1. p_name - name of the player
2. jnumber - jersey number of the player
3. t_runs - total runs scored
4. innings - number of innings played
5. notouts - number of times the player remained not out.
6. avg - the average runs scored by the player in each inning (of type int - get the integer value of the average only).
7. set() - to assign all the details of the player i.e., name, jersey number, total runs, innings, not outs .
8. findavg() - a function to find the average of the player. See note below to find how average of a player is calculated.
9. print() - to print the details of the player(in order 1,2,3,4,5,6 separated by a single space).
Note: the average of a player is calculated as the total number of runs scored divided by the number of times the player got out.


Complete the class player to set and print the desired output.
Input format:
Line 1 : N (Number of players).
Line 2 to Line N + 1 : name, jersey number, total runs, innings played and not outs of each player.
Output format :
Print the data of each player in a separate line.
Sample Input 1 :
1
Sachin 10 18426 452 41
Sample Output 1 :
Sachin 10 18426 452 41 44
Sample Input 2 :
5
Virat 18 11867 239 39
Dhoni 7 10773 297 84
Rahul 17 10889 318 40
Sachin 10 18426 452 41
Pandey 15 184 45 4 
Sample Output 2 :
Virat 18 11867 239 39 59
Dhoni 7 10773 297 84 50
Rahul 17 10889 318 40 39
Sachin 10 18426 452 41 44
Pandey 15 184 45 4 4
 */

class Player{
    String p_name;
    int jnumber, t_runs, innings, notouts;
    int avg;
    // complete the functions below to print the output in desired format
    void set(String name,int number,int runs,int inn,int nos){
        p_name = name;
        jnumber = number;
        t_runs = runs;
        innings = inn;
        notouts = nos;
        findavg();
        
    }
    void findavg(){
        double average = t_runs/(innings - notouts);
        avg = (int)(average);
    }

    void print(){
        String output = p_name + " " + jnumber + " " + t_runs +
                                " " + innings + " " + notouts + " " + avg;
        System.out.println(output);
    }
    
}

public class AvgOfCricketersSolution {
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0)
		{
		    String name=s.next();
		    int num=s.nextInt();
		    int runs=s.nextInt();
		    int inn=s.nextInt();
		    int nos=s.nextInt();
		    Player p=new Player();
		    p.set(name,num,runs,inn,nos);
		    p.print();
		}
	}
}
