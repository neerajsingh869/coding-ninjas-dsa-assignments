package optionalGraphs;

public class GraphQueries {
	
	/*
	 * A connected graph G, with N vertices and M undirected weighted edges is given. You have to perform Q queries on the graph and the queries can be of the following types:
1. Assignzero(u,v): This will change the weight of the edge between vertices u and v to 0.
2.Assignoriginal(u, v): This will change the weight of edge between vertices u and v to its original weight.
3.MstWeight() : This will return the weight of Minimal Spanning Tree of G.
Input Format:
First line of the input contains three space separated integers N, M and Q, denoting the number of vertices in G, the number of edges in G, and the number of queries to perform, respectively.
Next following M lines, each consisting of three space separated integers u, v and w, denoting that there is an edge between vertices u and v in G of weight w.
The i-th of the following Q lines corresponds to the i-th query. It starts with a single integer qtype denoting the type of the query. If qtype = 1 or 2, it is followed by two space separated integers u, v denoting the arguments of the query.
Output Format:
For each query of type 3, output is an integer in a single line corresponding to the answer to this query.
Constraints:
1 ≤ v, u ≤ N
v ≠ u
1 ≤ w ≤ 10^9
1 ≤ qtype ≤ 3
There are no multi-edges and no self loops in the graph G.
For every query of types 1 and 2, it is guaranteed that there is an edge between vertices u and v in G.
Sample Input:
5 5 5
1 2 1
2 3 1
3 4 1
4 5 1
5 1 1
3
1 1 2
3
2 1 2
3
Sample Output:
4
3
4
	 */
	
	public static void main(String[] args) {
		/* Your class should be named Main.
 			* Read input as specified in the question.
 			* Print output as specified in the question.
		*/

		// Write your code here

	}

}
