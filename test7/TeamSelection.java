package test7;

import java.util.Scanner;

public class TeamSelection {

	/*
	 * CodingNinjasLand is hosting this edition of Kabaddi 
	 * World Cup. Selection committee of CodingNinjasLand 
	 * needs your help. They want to select a 12-membered team. 
	 * You have to print all possible combinations of the team, 
	 * so, that selectors can select any one combination for World 
	 * Cup at GitNagar, CodingNinjasLand.
	 */
	
	public static void printTeams(int[] arr, int size, int teamSize, String ans){
        if(size == 0 && teamSize != 0){
            return;
        }
        if(teamSize == 0){
            System.out.println(ans);
            return;
        }
        printTeams(arr, size-1, teamSize-1, arr[size-1] + " " + ans);
        printTeams(arr, size-1, teamSize, ans);
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        printTeams(arr, n, 12, "");
	}
	
}
