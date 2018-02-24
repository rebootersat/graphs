package graphs;

import java.util.Arrays;

public class Graph {

	private Vertex[] vertices;
	private int index = 0;
	private boolean isUndirectedGraph;

	public Graph(int noOfNodes) {
		vertices = new Vertex[noOfNodes];
	}

	public Graph(int noOfNodes, boolean isUndirectedGraph) {
		vertices = new Vertex[noOfNodes];
		this.isUndirectedGraph = isUndirectedGraph;
	}

	private boolean isAdded;

	public void addEdge(String first, String second) {
		Vertex firstEle = new Vertex(first);
		Vertex secondEle = new Vertex(second);
		int eleIndex = hasNode(first);
		if (eleIndex == -1) {
			firstEle.next = secondEle;
			vertices[index++] = firstEle;
		} else {
			Vertex lastNode = getLastNode(eleIndex);
			lastNode.setNext(secondEle);
		}
		eleIndex = hasNode(second);
		if (eleIndex == -1) {
			try {
				vertices[index++] = (Vertex) secondEle.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		if (isUndirectedGraph && !isAdded) {
			isAdded = true;
			addEdge(second, first);
		}
		isAdded = false;
	}

	public void addEdge(String first, String second, int distance) {
		Vertex firstEle = new Vertex(first);
		Vertex secondEle = new Vertex(second, distance);
		int eleIndex = hasNode(first);
		if (eleIndex == -1) {
			firstEle.next = secondEle;
			vertices[index++] = firstEle;
		} else {
			Vertex lastNode = getLastNode(eleIndex);
			lastNode.setNext(secondEle);
		}
		eleIndex = hasNode(second);
		if (eleIndex == -1) {
			try {
				vertices[index++] = (Vertex) secondEle.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Returns true if pair exists for given values, false otherwise
	 * 
	 * @param firstValue
	 * @param secondValue
	 * @return Returns true if pair exists for given values, false otherwise
	 */
	public boolean isPairExist(String firstValue, String secondValue) {
		int index = hasNode(firstValue);
		return index != -1 ? indexOf(index, secondValue) != -1 : false;
	}

	/**
	 * Returns source Vertex
	 * 
	 * @return
	 * @throws Exception
	 */
	public Vertex getSourceVertex() throws Exception {
		if (index == 0)
			throw new Exception("Graph is empty");
		return vertices[0];
	}

	public void init() {
		addEdge("A", "B");
		addEdge("B", "E");
		addEdge("E", "D");
		addEdge("D", "B");
		addEdge("D", "C");
		addEdge("A", "C");
	}

	/**
	 * Returns index for second value in the pair if exist, -1 otherwise
	 * 
	 * @param nodeIndex
	 *            index of first vertex in the pair
	 * @param pairValue
	 *            second vertex value
	 * @return Returns index for second value in the pair if exist, -1 otherwise
	 */
	private int indexOf(int nodeIndex, String pairValue) {
		Vertex temp = vertices[nodeIndex];
		int i = 0;

		while (temp != null) {
			if (temp.value.equals(pairValue))
				return i;
			temp = temp.next;
			i++;
		}
		return -1;
	}

	/**
	 * Returns index of the vertex if exists, otherwise -1
	 * 
	 * @param value
	 *            vertex value
	 * @return Returns index of the vertex if exists, otherwise -1
	 */
	private int hasNode(String value) {
		for (int i = 0; i < index; i++) {
			if (value.equals(vertices[i].getValue()))
				return i;
		}
		return -1;
	}

	private Vertex getLastNode(int index) {
		Vertex temp = vertices[index];
		while (temp.next != null)
			temp = temp.next;
		return temp;
	}

	/**
	 * Represents adjacency List
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < index; i++) {
			Vertex temp = vertices[i];
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

	/**
	 * Returns true if vertex is visited, false otherwise
	 * 
	 * @param vertex
	 *            given vertex
	 * @return Returns true if vertex is visited, false otherwise
	 */
	public boolean isNodeVisited(Vertex vertex) {
		boolean isNodeExist = false;
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i].equals(vertex)) {
				isNodeExist = true;
				return vertices[i].isVisited;
			}
		}
		if (!isNodeExist)
			throw new IllegalArgumentException("No such node exist..." + vertex.value);
		return false;
	}

	/**
	 * Mark Vertex as a visited vertex
	 * 
	 * @param vertex
	 */
	public void registerVisit(Vertex vertex) {
		for (int i = 0; i < index; i++) {
			if (vertices[i].equals(vertex)) {
				vertices[i].setVisited(true);
			}
		}
	}

	public boolean hasLinkedNode(Vertex node) {
		for (int i = 0; i < index; i++) {
			if (vertices[i].equals(node)) {
				return vertices[i].next != null ? true : false;
			}
		}
		return false;
	}

	public Vertex getLinkedNode(Vertex node) {
		for (int i = 0; i < index; i++) {
			if (vertices[i].equals(node)) {
				return getNonVisitedNode(vertices[i]);
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

	/**
	 * Returns adjacent vertices for a given vertex
	 * 
	 * @param sourceNode
	 *            given vertex
	 * @return Returns adjacent vertices for a given vertex
	 */
	public Vertex[] getAdjacentVertices(Vertex sourceNode) {
		Vertex[] adjVertices = new Vertex[0];
		for (int i = 0; i < index; i++) {
			if (vertices[i].equals(sourceNode)) {
				Vertex adjacentVertex = getNonVisitedNode(vertices[i]);
				int z = 0;
				while (adjacentVertex != null) {
					if (!adjacentVertex.isVisited) {
						adjVertices = Arrays.copyOf(adjVertices, z + 1);
						adjVertices[z++] = adjacentVertex;
					}
					adjacentVertex = adjacentVertex.next;
				}
				break;
			}
		}
		return adjVertices;
	}

	/**
	 * Returns adjacent vertices for a given vertex which are not visited
	 * 
	 * @param sourceNode
	 *            given vertex
	 * @return array of adjacent Vertices
	 */
	public Vertex[] getAdjacentVertices(String sourceNode) {
		Vertex[] adjVertices = new Vertex[0];
		for (int i = 0; i < index; i++) {
			if (vertices[i].getValue().equals(sourceNode)) {
				Vertex adjacentVertex = getNonVisitedNode(vertices[i]);
				int z = 0;
				while (adjacentVertex != null) {
					if (!adjacentVertex.isVisited) {
						adjVertices = Arrays.copyOf(vertices, z + 1);
						adjVertices[z++] = adjacentVertex;
					}
					adjacentVertex = adjacentVertex.next;
				}
				break;
			}
		}
		return adjVertices;
	}

	/**
	 * Returns adjacent vertices for a given vertex
	 * 
	 * @param sourceNode
	 *            given vertex
	 * @return array of adjacent Vertices
	 */
	public Vertex[] getAllAdjacentVertices(String sourceNode) {
		Vertex[] adjVertices = new Vertex[0];
		for (int i = 0; i < index; i++) {
			if (vertices[i].getValue().equals(sourceNode)) {
				Vertex adjacentVertex = null;
				if (vertices[i].next != null)
					adjacentVertex = vertices[i].next;
				int z = 0;
				while (adjacentVertex != null) {
					adjVertices = Arrays.copyOf(adjVertices, z + 1);
					adjVertices[z++] = adjacentVertex;
					adjacentVertex = adjacentVertex.next;
				}
				break;
			}
		}
		return adjVertices;
	}

	/**
	 * Return all the vertices of the graph
	 * 
	 * @return
	 */
	public String[] getAllVerticesValue() {
		String arr[] = new String[index];
		for (int i = 0; i < index; i++) {
			arr[i] = vertices[i].getValue();
		}
		return arr;
	}

	public Vertex[] getAllVertices() {
		Vertex arr[] = new Vertex[index];
		for (int i = 0; i < index; i++) {
			arr[i] = vertices[i];
		}
		return arr;
	}

	/**
	 * set all node of the graph non visited
	 */
	public void reset() {
		for (int i = 0; i < index; i++) {
			vertices[i].isVisited = false;
			Vertex adjacentVertex = null;
			if (vertices[i].next != null)
				adjacentVertex = vertices[i].next;
			while (adjacentVertex != null) {
				adjacentVertex.isVisited = false;
				adjacentVertex = adjacentVertex.next;
			}
		}
	}
}
