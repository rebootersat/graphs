package main.java.BFS;

import java.util.Queue;

import main.java.core.Graph;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BFSTest
{
	private BFS bfs;
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() {
		Graph<String> graph = new Graph<>();
		graph.addEdge("A", "B");
		graph.addEdge("A", "D");
		graph.addEdge("B", "C");
		graph.addEdge("B", "E");
		graph.addEdge("C", "F");
		graph.addEdge("C", "D");
		graph.addEdge("F", "E");
		graph.addEdge("E", "D");
		bfs = new BFS(graph);
	}
	
	@Test
	public void isGraphNull_whenGraphNull_shouldThrowException() {
		exception.expectMessage("Graph cannot be null");
		exception.expect(NullPointerException.class);
		new BFS(null);
	}
	
	@Test
	public void execute_shouldReturnQueue() {
		Queue<String> resultQ = bfs.execute();
		assertEquals("A B D C E F", resultQ.toString());
	}
	@Test
	public void isConnectedGraph_whenConnected_shouldreturnTrue() {
		Graph<String> graph = new Graph<>();
		graph.addEdge("A", "B");
		graph.addEdge("A", "D");
		graph.addEdge("B", "C");
		graph.addEdge("B", "E");
		graph.addEdge("C", "F");
		graph.addEdge("C", "D");
		graph.addEdge("F", "E");
		graph.addEdge("E", "D");
		bfs = new BFS(graph);
		bfs.execute();
		assertTrue(graph.isConnected());
	}
	
	@Test
	public void isConnectedGraph_whenNotConnected_shouldreturnTrue() {
		Graph<String> graph = new Graph<>();
		graph.addEdge("A", "B");
		graph.addEdge("A", "D");
		graph.addEdge("B", "C");
		graph.addEdge("B", "E");
		graph.addEdge("C", "F");
		graph.addEdge("C", "D");
		graph.addEdge("F", "E");
		graph.addEdge("E", "D");
		graph.addEdge("K", "M");
		bfs = new BFS(graph);
		bfs.execute();
		assertFalse(graph.isConnected());
	}
}

