package dijkstra;

import graphs.Graph;
import dijkstra.DistancePriorityQueue.Vertex;

public class Dijkstra {
	private DistancePriorityQueue queue;
	private Graph graph;

	public Dijkstra(Graph graph, DistancePriorityQueue queue) throws Exception {
		this.queue = queue;
		this.graph = graph;
		queue.addUpdateElement(graph.getSourceVertex().getValue(), 0, "");
	}

	public String execute() {
		StringBuilder result = new StringBuilder();
		while (!queue.isEmpty()) {
			Vertex temp = queue.remove();
			result.append(temp).append("\n");
			graphs.Vertex[] adjacentVertices = graph.getAdjacentVertices(temp.value);
			for (int i = 0; i < adjacentVertices.length; i++) {
				if (result.indexOf(adjacentVertices[i].getValue()) == -1)
					queue.addUpdateElement(adjacentVertices[i].getValue(), temp.distance + adjacentVertices[i].getDistance(), temp.value);
			}
		}
		return result.toString();
	}

}
