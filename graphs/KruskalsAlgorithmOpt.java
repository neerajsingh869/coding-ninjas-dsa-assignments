package graphs;

import java.util.Scanner;
import java.util.Arrays;

class Edge implements Comparable<Edge>{
	int vertex1;
	int vertex2;
	int weight;
	Edge(int vertex1, int vertex2, int weight){
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge edge){
		return this.weight - edge.weight;
	}
}

public class KruskalsAlgorithmOpt {
	
	/*
	 * Given an undirected, connected and weighted graph G(V, E) 
	 * with V number of vertices (which are numbered from 0 to V-1) 
	 * and E number of edges.
	 * 
	 * Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
	 * 
	 * For printing MST follow the steps -
			1. In one line, print an edge which is part of MST in the format - 
			v1 v2 w
			where, v1 and v2 are the vertices of the edge which is included 
			in MST and whose weight is w. And v1  <= v2 i.e. print the 
			smaller vertex first while printing an edge.
			2. Print V-1 edges in above format in different lines.
	 * Note : Order of different edges doesn't matter.

	 * Input Format :
	   Line 1: Two Integers V and E (separated by space)
	   Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
	 
	 * Output Format :
	   Print the MST, as described in the task.
	 
	 * Constraints :
		2 <= V, E <= 10^5
		Time Limit: 1 sec
	 
	 * Sample Input 1 :
		4 4
		0 1 3
		0 3 5
		1 2 1
		2 3 8
		Sample Output 1 :
		1 2 1
		0 1 3
		0 3 5
	 */
	
	// Time Complexity -> O(e*v + e*log(e))
	public static void printMST(Edge[] edges, int v){
		Arrays.sort(edges);
		Edge[] ans = buildMST(edges, v);
		for(int i = 0; i<ans.length; i++){
			int v1 = ans[i].vertex1;
			int v2 = ans[i].vertex2;
			int w = ans[i].weight;
			System.out.println(Math.min(v1, v2) + " " + Math.max(v1, v2) + " " + w);
		}
	}

	private static Edge[] buildMST(Edge[] edges, int v){
		int e = edges.length;
		Edge[] outputEdges = new Edge[v-1];
		int[] parentVertex = new int[v];
		for(int i = 0; i<v; i++){
			parentVertex[i] = i;
		}
		int edgeCountMST = 0;
		for(int i = 0; i<e; i++){
			Edge tempEdge = edges[i];
			// Applying Union find algorithm to 
			// check for cycles
			int v1 = tempEdge.vertex1;
			int v2 = tempEdge.vertex2;
			int p1 = parentVertex[v1];
			while(parentVertex[p1] != p1){
				p1 = parentVertex[p1];
			}
			int p2 = parentVertex[v2];
			while (parentVertex[p2] != p2) {
				p2 = parentVertex[p2];
			}
			if(p1 != p2){
				outputEdges[edgeCountMST++] = tempEdge;
				parentVertex[p1] = p2;
				if(edgeCountMST == v-1){
					break;
				}
			}
		}
		return outputEdges;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		Edge[] edges = new Edge[E];
		for(int i = 0; i<E; i++){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int w = sc.nextInt();
			edges[i] = new Edge(v1, v2, w);
		}
		printMST(edges, V);
	}
}
