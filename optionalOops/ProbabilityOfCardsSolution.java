package optionalOops;

import java.util.*;

/*
 * You are given a deck of cards (initially 52). We can perform two operations using the deck now.
1. Remove a card from the given deck.
2. Calculate the probability of Drawing out a card from the given deck (multiplied by 1000 and return the integer value.).
Note :
Perform the following steps :

1. Create a class deck to manage the no. of elements left in the deck and the cards left in the deck.
2. Create a function Probability in class deck(return type int).
Input Format:
1 -> to remove a card from the deck.
    Next Line - The card to be removed. e.g. '4 a' means 4 of hearts is removed form the deck. Now 51 cards remain in the deck.
   {'a' means heart, 'b' means diamond, 'c' means spade and 'd' means club} 

2 -> to calculate the probability of drawing a card 
    Next Line - The card whose draw probability is to be calculated (Only a number would be given and you would need to calculate the probability of drawing a card that has that  number).
e.g. : '4' (Now we have 51 cards left in the deck after the first '4 a' input previously out of which 3 cards have a 4 on them) So we need to calculate the probability of drawing a 4 from a deck of 51, which will be 3 * 1000 / 51 = 58.

-1 -> to exit main
Output Format:
For every probability query print the probability multiplied by 1000 in a new line.
Sample Input 1:
1
10 a
1
4 b
1
5 c
2
5
-1
Sample Output 1:
 61
Sample Input 2:
1
10 a
2
10
-1
Sample Output 2:
 58
 */

class Deck{
	int count;
	boolean[][] deck;
	Deck(){
		count = 52;
		deck = new boolean[4][13];
	}
    public void remove(int card,char c)
    {
		deck[c-'a'][card] = true;
		count--;
    }
    public int probability(int num)
    {
        int indeck = 0;
		for(int i = 0; i<4; i++){
			if(!deck[i][num]){
				indeck++;
			}
		}
		double ans = indeck*1000/count;
		return (int)(ans);
    }
}
public class ProbabilityOfCardsSolution {
	public static void main (String[] args) {
		Scanner s=new Scanner(System.in);
		Deck d=new Deck();
		int x=s.nextInt();
		while(x!=-1)
		{
		    if(x==1)
		    {
		        int card=s.nextInt();
		        char suite=s.next().charAt(0);
		        d.remove(card,suite);
		    }
		    else 
		    {
		        int card=s.nextInt();
		        System.out.println(d.probability(card));
		    }
		    x=s.nextInt();
		}
	}
}
