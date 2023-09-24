package graphs;

import java.util.Scanner;

public class PrimsAlgorithm {
	
	/*
	 * Given an undirected, connected and weighted graph G(V, E) 
	 * with V number of vertices (which are numbered from 0 to V-1) 
	 * and E number of edges.
	 * 
	 * Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.
	 * 
	 * For printing MST follow the steps -
			1. In one line, print an edge which is part of MST in the format - 
			v1 v2 w
			where, v1 and v2 are the vertices of the edge which is 
			included in MST and whose weight is w. And v1  <= v2 i.e. 
			print the smaller vertex first while printing an edge.
			2. Print V-1 edges in above format in different lines.
	 * Note : Order of different edges doesn't matter.

	 * Input Format :
	   Line 1: Two Integers V and E (separated by space)
	   Next E lines : Three integers ei, ej and wi, denoting that 
	   there exists an edge between vertex ei and vertex ej with weight 
	   wi (separated by space)

	 * Output Format :
	   Print the MST, as described in the task.

	 * Constraints :
	   2 <= V, E <= 10^5
 	   1 <= Wi <= 10^5
	   Time Limit: 1 sec

	 * Sample Input 1 :
		4 4
		0 1 3
		0 3 5
		1 2 1
		2 3 8
		Sample Output 1 :
		0 1 3
		1 2 1
		0 3 5
	 */
	
	public static void printMST(int[][] adjMatrix){
		int v = adjMatrix.length;
		boolean[] isVisited = new boolean[v];
		int[] parent = new int[v];
		for(int i = 0; i<v; i++){
			parent[i] = -1;
		}
		int[] vertexWeight = new int[v];
		for(int i = 0; i<v; i++){
			if(i == 0){
				vertexWeight[i] = 0;
			}
			else{
				vertexWeight[i] = Integer.MAX_VALUE;
			}
		}
		for(int countVisited = 0; countVisited<v; countVisited++){
			// Finding unvisited vertex having min weight
			int minWeightVertex = -1;
			for(int i = 0; i<v; i++){
				if(isVisited[i] == false && (minWeightVertex == -1 || (vertexWeight[minWeightVertex] > vertexWeight[i]))){
					minWeightVertex = i;
				}
			}
			isVisited[minWeightVertex] = true;
			for (int i = 0; i < v; i++) {
				if (adjMatrix[minWeightVertex][i] != 0 && !isVisited[i]) {
					if (vertexWeight[i] > adjMatrix[minWeightVertex][i]) {
						vertexWeight[i] = adjMatrix[minWeightVertex][i];
						parent[i] = minWeightVertex;
					}
				}
			}
		}
		// Printing MST
		for(int i = 1; i<v; i++){
			System.out.println(Math.min(i, parent[i]) + " " + Math.max(i, parent[i]) + " " + vertexWeight[i]);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
		int[][] adjMatrix = new int[V][V];
		for(int i = 0; i<E; i++){
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int w = s.nextInt();
			adjMatrix[v1][v2] = w;
			adjMatrix[v2][v1] = w;
		}
		printMST(adjMatrix);
	}

}
