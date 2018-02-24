package main.java.core;

import java.util.Arrays;

/**
 * Adjacency list representation of the graph
 * 
 * @author SANDEEP
 *
 * @param <V>
 */
public class Graph<V>
{
	private Vertex<V>[] vertices;
	private boolean isDirected;
	
	@SuppressWarnings("unchecked")
	public Graph()
	{
		vertices = new Vertex[0];
		isDirected = true;
	}
	
	public Graph(boolean isDirected)
	{
		this();
		this.isDirected = isDirected;
	}
	
	/**
	 * Registers an edge for given values v1 and v2 in adjacency list
	 * 
	 * @param v1
	 * @param v2
	 * @throws CloneNotSupportedException
	 */
	@SuppressWarnings("unchecked")
	public boolean addEdge(V v1, V v2) {
		if (isEdgeExists(v1, v2))
			return true;
		// vertexIndex -1 means no vertex registered for given value else vertex
		// already exist for the value
		int vertexIndex = getVertexIndex(v1);
		if (vertexIndex == -1)
			addVertex(v1).next = createVertexForValue(v2);
		else
			getLastVertex(vertices[vertexIndex]).next = createVertexForValue(v2);
		
		if (!isDirected)
			try
			{
				getLastVertex(vertices[getVertexIndex(v2)]).next = (Vertex<V>) vertices[getVertexIndex(v1)].clone();
			}
			catch (CloneNotSupportedException e)
			{
				e.printStackTrace();
			}
		return true;
	}
	
	/**
	 * Returns true if edge exist for given values, false otherwise
	 * 
	 * @param v1
	 * @param v2
	 * @return Returns true if edge exist for given values, false otherwise
	 */
	public boolean isEdgeExists(V v1, V v2) {
		isNull(v1, v2);
		int vertexIndex = getVertexIndex(v1);
		if (vertexIndex != -1 && getVertexIndex(v2) != -1)
		{
			Vertex<V> vertex = vertices[vertexIndex];
			while (vertex != null)
			{
				if (vertex.getValue().equals(v2))
					return true;
				vertex = vertex.next;
			}
		}
		return false;
	}
	
	/**
	 * If Vertex exists for given value then sets the vertex visited flag to
	 * true, throws exception if Vertex does not exist for given value
	 * 
	 * @param value
	 */
	public void setVisted(V value) {
		int vertexIndex = getVertexIndex(value);
		if (vertexIndex == -1)
			throw new IllegalArgumentException("Vertex does not exist for given value " + value);
		vertices[vertexIndex].setVisited(true);
	}
	
	/**
	 * Return true if vertex visited for given value, false otherwise. Throws
	 * exception if Vertex does not exist for given value
	 * 
	 * @param value
	 *            given value
	 * @return Return true if vertex visited for given value, false otherwise
	 */
	public boolean isVisited(V value) {
		int vertexIndex = getVertexIndex(value);
		if (vertexIndex == -1)
			throw new IllegalArgumentException("Vertex does not exist for given value " + value);
		return vertices[vertexIndex].isVisited();
	}
	
	/**
	 * Return no of vertices in the graph
	 * 
	 * @return Return no of vertices in the graph
	 */
	public int size() {
		return vertices.length;
	}
	
	/**
	 * Represents the adjacency list
	 */
	public void printAdjacencyList() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < vertices.length; i++)
		{
			Vertex<V> vertex = vertices[i];
			result.append(vertex.getValue());
			vertex = vertex.next;
			while (vertex != null)
			{
				result.append(" -> ").append(vertex.getValue());
				vertex = vertex.next;
			}
			result.append("\n");
		}
		System.out.println(result);
	}
	
	/**
	 * Create a vertex for given value
	 * 
	 * @param v2
	 *            given value
	 * @return newly created vertex
	 * @throws CloneNotSupportedException
	 */
	@SuppressWarnings("unchecked")
	private Vertex<V> createVertexForValue(V v2) {
		int vertexIndex;
		Vertex<V> vertex2 = null;
		vertexIndex = getVertexIndex(v2);
		if (vertexIndex == -1)
			try
			{
				vertex2 = (Vertex<V>) addVertex(v2).clone();
			}
			catch (CloneNotSupportedException e)
			{
				e.printStackTrace();
			}
		else
			vertex2 = new Vertex<V>(v2);
		return vertex2;
	}
	
	/**
	 * Return the last vertex for the given vertex, sourceVertex is a starting
	 * point of the linked list.
	 * 
	 * @param sourceVertex
	 *            starting point of the list
	 * @return last vertex in the list
	 */
	private Vertex<V> getLastVertex(Vertex<V> sourceVertex) {
		Vertex<V> last = sourceVertex;
		while (last.next != null)
			last = last.next;
		return last;
	}
	
	/**
	 * create a vertex for given value and adds it in vertices list
	 * 
	 * @param v1
	 *            given value
	 * @return newly create vertex
	 */
	private Vertex<V> addVertex(V v1) {
		vertices = Arrays.copyOf(vertices, vertices.length + 1);
		vertices[vertices.length - 1] = new Vertex<>(v1);
		return vertices[vertices.length - 1];
	}
	
	/**
	 * Return index if vertex already exists for given value in the graph, -1
	 * otherwise
	 * 
	 * @param value
	 *            given value
	 * @return index of the vertex
	 */
	private int getVertexIndex(V value) {
		isNull(value);
		int vertexIndex = -1;
		for (int i = 0; i < vertices.length; i++)
		{
			if (value.equals(vertices[i].getValue()))
			{
				vertexIndex = i;
				break;
			}
		}
		return vertexIndex;
	}
	
	/**
	 * Throws NullPointer exception if any value is null
	 * 
	 * @param value
	 */
	private void isNull(Object... value) {
		for (int i = 0; i < value.length; i++)
			if (value[i] == null)
				throw new NullPointerException("Value cannot be null");
	}
	
	/**
	 * Returns adjacent values for given value, If value is null then null
	 * pointer exception is thrown. If value does not exist then illegal
	 * argument exception is thrown
	 * 
	 * @param value
	 *            given value
	 * @return Returns adjacent values for given value
	 */
	public Object[] getAdjacentValues(V value) {
		int vertexIndex = getVertexIndex(value);
		if (vertexIndex == -1)
			throw new IllegalArgumentException("Vertex does not exist for given value " + value);
		Object[] adjacentValues = new Object[0];
		Vertex<V> vertex = vertices[vertexIndex].next;
		int index = 0;
		while (vertex != null)
		{
			adjacentValues = Arrays.copyOf(adjacentValues, adjacentValues.length + 1);
			adjacentValues[index++] = vertex.getValue();
			vertex = vertex.next;
		}
		return adjacentValues;
	}
}
