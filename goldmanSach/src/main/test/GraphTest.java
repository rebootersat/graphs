package main.test;

import static org.junit.Assert.*;
import graphs.Graph;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	private Graph graph;
	
	@Before
	public void setUp() {
		graph = new Graph(5);
	}
	
	@Test
	public void insert_whenFirstElementInserted_shouldReturnTrue() {
		graph.addEdge("A","B");
	}
	
	@Test
	public void isPairExist_whenPairDoesNotExist_shouldReturnFalse() {
		boolean hasPair = graph.isPairExist("A","C");
		assertFalse(hasPair);
	}
	
	@Test
	public void isPairExist_whenPairExist_shouldReturnTrue() {
		graph.addEdge("A","B");
		graph.addEdge("B","E");
		graph.addEdge("E","D");
		graph.addEdge("D","B");
		graph.addEdge("D","C");
		graph.addEdge("A","C");
		assertTrue(graph.isPairExist("A","B"));
		assertTrue(graph.isPairExist("B","E"));
		assertTrue(graph.isPairExist("E","D"));
		assertTrue(graph.isPairExist("D","B"));
		assertTrue(graph.isPairExist("D","C"));
		assertTrue(graph.isPairExist("A","C"));
	}
	
}
