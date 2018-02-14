package graphs.dfs;

import graphs.Graph;
import graphs.Vertex;

import java.util.Stack;

public class DFS {

	private Stack<Vertex> stack;
	private Graph graph;

	public DFS(Graph graph) {
		this.graph = graph;
		stack = new Stack<>();
	}

	public boolean isNodeVisited(Vertex node) {
		return graph.isNodeVisited(node);
	}

	public boolean hasLinkToNodes(Vertex node) {
		return graph.hasLinkedNode(node);
	}

	public String traverse() {
		StringBuilder result = new StringBuilder();
		Vertex currentVertex = graph.getSourceVertex();
		Vertex adjacentVertex = null;
		while (true) {
			if ((adjacentVertex = graph.getLinkedNode(currentVertex)) != null) {
				stack.push(currentVertex);
				graph.registerVisit(currentVertex);
				currentVertex.setVisited(true);
				result.append(currentVertex.getValue());
				currentVertex = adjacentVertex;
			} else {
				if (!graph.isNodeVisited(currentVertex)) {
					result.append(currentVertex.getValue());
					graph.registerVisit(currentVertex);
					currentVertex.setVisited(true);
				}
				if (stack.isEmpty())
					break;
				else {
					currentVertex = stack.pop();
				}
			}
		}
		return result.toString();
	}

}
