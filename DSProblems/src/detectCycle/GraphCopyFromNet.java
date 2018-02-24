package detectCycle;

//A Java Program to detect cycle in an undirected graph
import java.io.*;
import java.util.*;

//This class represents a directed graph using adjacency list
//representation
class GraphCopyFromNet
{
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency List Represntation

	// Constructor
	GraphCopyFromNet(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v,int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	// A recursive function that uses visited[] and parent to detect
	// cycle in subgraph reachable from vertex v.
	Boolean isCyclicUtil(int v, Boolean visited[], int parent)
	{
		System.out.println("isCyclicUtil called v : "+v+" parent : "+parent);
		printArray(visited);
		visited[v] = true;
		Integer i;
		System.out.println("v : "+v);
		printArray(visited);
		System.out.println();
		// Mark the current node as visited
		
		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext())
		{
			i = it.next();
			System.out.println("while loop I : "+i);

			// If an adjacent is not visited, then recur for that
			// adjacent
			System.out.println(" !visited["+i+"] "+!visited[i]);
			System.out.println("parent : "+parent+" I "+i+" i != parent "+(i != parent));
			if (!visited[i])
			{
				if (isCyclicUtil(i, visited, v))
					return true;
			}

			// If an adjacent is visited and not parent of current
			// vertex, then there is a cycle.
			else if (i != parent)
				return true;
		}
		return false;
	}

	private void printArray(Boolean visited[]) {
		for (int i = 0; i < visited.length; i++) {
			System.out.print(i+" : "+visited[i]+" ");
		}
	}
	
	// Returns true if the graph contains a cycle, else false.
	Boolean isCyclic()
	{
		// Mark all the vertices as not visited and not part of
		// recursion stack
		Boolean visited[] = new Boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Call the recursive helper function to detect cycle in
		// different DFS trees
		for (int u = 0; u < V; u++)
			if (!visited[u]) // Don't recur for u if already visited
				if (isCyclicUtil(u, visited, -1))
					return true;

		return false;
	}


	// Driver method to test above methods
	public static void main(String args[])
	{
		// Create a graph given in the above diagram
		GraphCopyFromNet g1 = new GraphCopyFromNet(4);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(0, 3);
		g1.addEdge(2, 3);
		if (g1.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contains cycle");

	
	}
}
//This code is contributed by Aakash Hasija
