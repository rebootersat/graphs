package detectCycle;

import graphs.Graph;
import graphs.Vertex;

public class CycleInUndirectedGraph {

	private Graph graph;

	public CycleInUndirectedGraph(Graph graph) {
		this.graph = graph;
	}

	public boolean isCyclic() throws Exception {
		Vertex[] allVerticesValue = graph.getAllVertices();
		for (int i = 0; i < allVerticesValue.length; i++) {
			if (!graph.isNodeVisited(allVerticesValue[i])) {
				boolean hasCycle = hasCycle(allVerticesValue[i], "");
				if (hasCycle)
					return true;
			}
		}
		return false;
	}

	public boolean hasCycle(Vertex vertex, String parentValue) {
		boolean isCycle = false;
		graph.registerVisit(vertex);
		Vertex[] adjacentVertices = graph.getAllAdjacentVertices(vertex.getValue());
		for (int i = 0; i < adjacentVertices.length; i++) {
			if (!graph.isNodeVisited(adjacentVertices[i]))
				isCycle = hasCycle(adjacentVertices[i], vertex.getValue());
			else if (!adjacentVertices[i].getValue().equals(parentValue)) {
				isCycle = true;
				break;
			}
		}
		return isCycle;
	}

}
