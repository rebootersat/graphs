package main.java.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class GraphTest {

	private Graph<String> graph;

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() {
		graph = new Graph<String>();
	}

	@Test
	public void addEdge_whenValueNull_shouldThrowIllegalArgumentException() {
		exception.expectMessage("Value cannot be null");
		exception.expect(IllegalArgumentException.class);
		graph.addEdge("A", null);
	}

	@Test
	public void isEdgeExists_whenValueNull_shouldThrowIllegalArgumentException() {
		exception.expectMessage("Value cannot be null");
		exception.expect(IllegalArgumentException.class);
		graph.isEdgeExists(null,"B");
	}
	
	@Test
	public void isEdgeExists_whenEdgeExist_shouldReturnTrue() {
		graph.addEdge("A","B");
		boolean edgeExists = graph.isEdgeExists("A","B");
		assertEquals(edgeExists, true);
	}
	
	@Test
	public void isEdgeExists_whenEdgeNotExist_shouldReturnFalse() {
		graph.addEdge("A","B");
		graph.addEdge("D","B");
		graph.addEdge("D","C");
		boolean edgeExists = graph.isEdgeExists("A","C");
		assertEquals(edgeExists, false);
	}
	
	@Test
	public void setVisted_whenVertexNotExistForValue_shouldThrowException() {
		exception.expectMessage("Vertex does not exist for given value A");
		exception.expect(IllegalArgumentException.class);
		graph.setVisted("A");
	}
	
	@Test
	public void isVisited_whenNotVisited_shouldReturnFalse() {
		graph.addEdge("A","B");
		graph.addEdge("B","C");
		graph.addEdge("C","A");
		boolean visited = graph.isVisited("A");
		assertEquals(visited, false);
	}
	
	@Test
	public void isVisited_whenVisited_shouldReturnFalse() {
		graph.addEdge("A","B");
		graph.addEdge("B","C");
		graph.addEdge("C","A");
		graph.setVisted("A");
		boolean visited = graph.isVisited("A");
		assertEquals(visited, true);
	}
	
	@Test
	public void isVisited_whenValueNull_shouldThrowException() {
		graph.addEdge("A","B");
		graph.addEdge("B","C");
		graph.addEdge("C","A");
		graph.setVisted("A");
		exception.expectMessage("Value cannot be null");
		exception.expect(IllegalArgumentException.class);
		boolean visited = graph.isVisited(null);
		assertEquals(visited, true);
	}
	
	@Test
	public void size_whenNoVertexAdded_shouldReturnZero() {
		int size = graph.size();
		assertEquals(size, 0);
	}
	
	@Test
	public void size_whenTwoVertexAdded_shouldReturnThree() {
		graph.addEdge("A", "B");
		graph.addEdge("C", "B");
		int size = graph.size();
		assertEquals(size, 3);
	}
	
	@Test
	public void getAdjacentValues_whenValueNull_shouldThrowException() {
		exception.expectMessage("Value cannot be null");
		exception.expect(IllegalArgumentException.class);
		graph.getAdjacentValues(null);
	}
	
	@Test
	public void getAdjacentValues_whenValueNotExist_shouldThrowException() {
		exception.expectMessage("Vertex does not exist for given value A");
		exception.expect(IllegalArgumentException.class);
		graph.getAdjacentValues("A");
	}
	
	@Test
	public void getAdjacentValues_whenAdjacentValueExists_shouldReturnValues() {
		graph.addEdge("A", "B");
		graph.addEdge("B", "D");
		graph.addEdge("D", "F");
		graph.addEdge("F", "E");
		graph.addEdge("E", "D");
		graph.addEdge("E", "C");
		graph.addEdge("C", "A");
		Object[] adjacentValues = graph.getAdjacentValues("E");
		assertEquals(adjacentValues.length, 2);
	}
	
	@Test
	public void getVerticesValue_whenGraphEmpty_valueLengthShouldBeZero() {
		Object[] verticesValue = graph.getVerticesValue();
		assertEquals(verticesValue.length, 0);
	}
	
	@Test
	public void getVerticesValue_whenGraphNotEmpty_valueLengthShouldBeThree() {
		graph.addEdge("A", "B");
		graph.addEdge("C", "B");
		Object[] verticesValue = graph.getVerticesValue();
		assertEquals(verticesValue.length, 3);
	}
	
	@Test
	public void isConnected_whenNotConnected_shouldReturnFalse() {
		boolean isConnected = graph.isConnected();
		assertEquals(isConnected, false);
	}
}
