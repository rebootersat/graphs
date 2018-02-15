package graphs;

import java.util.Arrays;

public class Graph {

	private Vertex[] nodes;
	private int index = 0;

	public Graph(int noOfNodes) {
		nodes = new Vertex[noOfNodes];
	}

	public void addEdge(String first, String second) {
		Vertex firstEle = new Vertex(first);
		Vertex secondEle = new Vertex(second);
		int eleIndex = hasNode(first);
		if (eleIndex == -1) {
			firstEle.next = secondEle;
			nodes[index++] = firstEle;
		} else {
			Vertex lastNode = getLastNode(eleIndex);
			lastNode.setNext(secondEle);
		}
		eleIndex = hasNode(second);
		if (eleIndex == -1) {
			try {
				nodes[index++] = (Vertex) secondEle.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addEdge(String first, String second, int distance) {
		Vertex firstEle = new Vertex(first);
		Vertex secondEle = new Vertex(second, distance);
		int eleIndex = hasNode(first);
		if (eleIndex == -1) {
			firstEle.next = secondEle;
			nodes[index++] = firstEle;
		} else {
			Vertex lastNode = getLastNode(eleIndex);
			lastNode.setNext(secondEle);
		}
		eleIndex = hasNode(second);
		if (eleIndex == -1) {
			try {
				nodes[index++] = (Vertex) secondEle.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isPairExist(String firstValue, String secondValue) {
		int index = hasNode(firstValue);
		return index != -1 ? indexOf(index, secondValue) != -1 : false;
	}

	public Vertex getSourceVertex() throws Exception {
		if(index == 0)
			throw new Exception("Graph is empty");
		return nodes[0];
	}

	public void init() {
		addEdge("A", "B");
		addEdge("B", "E");
		addEdge("E", "D");
		addEdge("D", "B");
		addEdge("D", "C");
		addEdge("A", "C");
	}

	private int indexOf(int nodeIndex, String pairValue) {
		Vertex temp = nodes[nodeIndex];
		int i = 0;

		while (temp != null) {
			if (temp.value.equals(pairValue))
				return i;
			temp = temp.next;
			i++;
		}
		return -1;
	}

	private int hasNode(String value) {
		for (int i = 0; i < index; i++) {
			if (value.equals(nodes[i].getValue()))
				return i;
		}
		return -1;
	}

	private Vertex getLastNode(int index) {
		Vertex temp = nodes[index];
		while (temp.next != null)
			temp = temp.next;
		return temp;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < index; i++) {
			Vertex temp = nodes[i];
			while (temp != null) {
				result.append(temp.value).append(" ");
				temp = temp.next;
			}
			result.append("\n");
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.init();
		System.out.println(g);
	}

	public boolean isNodeVisited(Vertex node) {
		boolean isNodeExist = false;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].equals(node)) {
				isNodeExist = true;
				return nodes[i].isVisited;
			}
		}
		if (!isNodeExist)
			throw new IllegalArgumentException("No such node exist..."
					+ node.value);
		return false;
	}

	public void registerVisit(Vertex node) {
		for (int i = 0; i < index; i++) {
			if (nodes[i].equals(node)) {
				nodes[i].setVisited(true);
			}
		}
	}

	public boolean hasLinkedNode(Vertex node) {
		for (int i = 0; i < index; i++) {
			if (nodes[i].equals(node)) {
				return nodes[i].next != null ? true : false;
			}
		}
		return false;
	}

	public Vertex getLinkedNode(Vertex node) {
		for (int i = 0; i < index; i++) {
			if (nodes[i].equals(node)) {
				return getNonVisitedNode(nodes[i]);
			}
		}
		return null;
	}

	private Vertex getNonVisitedNode(Vertex node) {
		Vertex temp = node.next;
		while (temp != null) {
			if (!isNodeVisited(temp))
				return temp;
			temp = temp.next;
		}
		return null;
	}

	public Vertex[] getAdjacentVertices(Vertex sourceNode) {
		Vertex[] vertices = new Vertex[0];
		for (int i = 0; i < index; i++) {
			if (nodes[i].equals(sourceNode)) {
				Vertex adjacentVertex = getNonVisitedNode(nodes[i]);
				int z = 0;
				while (adjacentVertex != null) {
					if (!adjacentVertex.isVisited) {
						vertices = Arrays.copyOf(vertices, z + 1);
						vertices[z++] = adjacentVertex;
					}
					adjacentVertex = adjacentVertex.next;
				}
			}
		}
		return vertices;
	}
	
	public Vertex[] getAdjacentVertices(String sourceNode) {
		Vertex[] vertices = new Vertex[0];
		for (int i = 0; i < index; i++) {
			if (nodes[i].getValue().equals(sourceNode)) {
				Vertex adjacentVertex = getNonVisitedNode(nodes[i]);
				int z = 0;
				while (adjacentVertex != null) {
					if (!adjacentVertex.isVisited) {
						vertices = Arrays.copyOf(vertices, z + 1);
						vertices[z++] = adjacentVertex;
					}
					adjacentVertex = adjacentVertex.next;
				}
			}
		}
		return vertices;
	}
}
