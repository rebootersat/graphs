package graphs.bfs;

import graphs.Graph;
import graphs.Vertex;

import java.util.Deque;
import java.util.LinkedList;

public class BFS {

	private Graph graph;
	private Deque<Vertex> q;

	public BFS(Graph graph) {
		this.graph = graph;
		q = new LinkedList<>();
	}

	public static void main(String[] args) throws Exception {
		Graph graph = new Graph(5);
		graph.init();
		BFS bfs = new BFS(graph);
		bfs.traverse();
	}
	
	public void traverse() throws Exception {
		Vertex sourceNode = graph.getSourceVertex();
		graph.registerVisit(sourceNode);
		q.add(sourceNode);
		StringBuilder result = new StringBuilder();
		while (!q.isEmpty()) {
			sourceNode = q.remove();
			result.append(sourceNode.getValue());
			Vertex[] adjacentVertices = graph.getAdjacentVertices(sourceNode);
			for (int i = 0; i < adjacentVertices.length; i++) {
				graph.registerVisit(adjacentVertices[i]);
				adjacentVertices[i].setVisited(true);
				q.add(adjacentVertices[i]);
			}
		}
		System.out.println(result);
	}

}
