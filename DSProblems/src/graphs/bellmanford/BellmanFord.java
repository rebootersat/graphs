package graphs.bellmanford;

import graphs.Graph;
import graphs.Vertex;
import graphs.bellmanford.BellmanFordTable.BellMFordVertex;

public class BellmanFord {

	private Graph graph;
	private BellmanFordTable table;

	public BellmanFord(Graph graph, BellmanFordTable table) {
		this.graph = graph;
		this.table = table;
	}

	public void execute() throws CloneNotSupportedException {
		BellMFordVertex[] vertices = table.toArray();
		int noOfVertices = vertices.length;

		for (int i = 0; i < noOfVertices - 1; i++) {
			for (int j = 0; j < vertices.length; j++) {
				if (vertices[j].getDistance() != Integer.MAX_VALUE) {
					Vertex[] adjacentVertices = graph.getAdjacentVertices(vertices[j].getValue());
					for (int k = 0; k < adjacentVertices.length; k++) {
						table.updateAdjacentVertex(adjacentVertices[k].getValue(), vertices[j].getDistance() + adjacentVertices[k].getDistance(),
								vertices[j].getValue());
					}
				}
			}
		}
		System.out.println(table.toString());
	}

}
