package priorityQueues;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyTheTicket {
	
	/*
	 * You want to buy a ticket for a well-known concert 
	 * which is happening in your city. But the number of 
	 * tickets available is limited. Hence the sponsors of 
	 * the concert decided to sell tickets to customers based 
	 * on some priority.
	 * 
	 * A queue is maintained for buying the tickets and 
	 * every person is attached with a priority (an integer, 
	 * 1 being the lowest priority).
	 * 	
	 * The tickets are sold in the following manner -
				1. The first person (pi) in the queue requests 
				for the ticket.
				2. If there is another person present in the queue 
				who has higher priority than pi, then ask pi to move 
				at end of the queue without giving him the ticket.
				3. Otherwise, give him the ticket (and don't make 
				him stand in queue again).
				
	 * Giving a ticket to a person takes exactly 1 second and it 
	 * takes no time for removing and adding a person to the queue. 
	 * And you can assume that no new person joins the queue.
	 * 
	 * Given a list of priorities of N persons standing in the 
	 * queue and the index of your priority (indexing starts from 0). 
	 * Find and return the time it will take until you get the ticket.
	 */

	public static int buyTicket1(int input[], int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int totalTime = 0;
		int myPriorityIdx = k;
		for(int i = 0; i<input.length; i++){
			maxHeap.add(input[i]);
		}
		boolean gotTicket = false;
		while(!gotTicket){
			if(input[0] == maxHeap.peek()){
				maxHeap.poll();
				totalTime += 1;
				if(myPriorityIdx == 0){
					gotTicket = true;
				}
				else{
					int temp[] = input;
					input = new int[temp.length-1];
					for(int i = 1; i<temp.length; i++){
						input[i-1] = temp[i];
					}
					myPriorityIdx -= 1;
				}
			}
			else{
				if(myPriorityIdx == 0){
					myPriorityIdx = input.length - 1;
				}
				else{
					myPriorityIdx -= 1;
				}
				int firstEle = input[0];
				for(int i = 0; i<input.length-1; i++){
					input[i] = input[i+1];
				}
				input[input.length-1] = firstEle;
			}
		}
		return totalTime;
	}
	
	public static int buyTicket(int input[], int k) {
		Queue<Integer> q = new LinkedList<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int totalTime = 0;
		int myPriorityIdx = k;
		for(int i : input){
			q.add(i);
			maxHeap.add(i);
		}
		while(!maxHeap.isEmpty()){
			if(q.peek().equals(maxHeap.peek())){
				maxHeap.poll();
				q.poll();
				totalTime += 1;
				if(myPriorityIdx == 0){
					break;
				}
				myPriorityIdx -= 1;
			}
			else{
				q.add(q.peek());
				q.poll();
				if(myPriorityIdx == 0){
					myPriorityIdx = q.size() - 1;
				}
				else{
					myPriorityIdx -= 1;
				}
			}
		}
		return totalTime;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
