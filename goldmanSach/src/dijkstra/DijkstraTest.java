package dijkstra;

import graphs.Graph;

import org.junit.Before;
import org.junit.Test;

public class DijkstraTest {
	private Dijkstra dijkstra;

	@Before
	public void setUp() throws Exception {
		Graph graph = new Graph(6);
		graph.addEdge("A", "B", 5);
		graph.addEdge("A", "F", 10);
		graph.addEdge("B", "F", 4);
		graph.addEdge("B", "C", 1);
		graph.addEdge("F", "B", 3);
		graph.addEdge("F", "C", 7);
		graph.addEdge("C", "D", 6);
		graph.addEdge("C", "E", 2);
		graph.addEdge("E", "D", 3);
		graph.addEdge("E", "F", 1);
		
		DistancePriorityQueue queue = new DistancePriorityQueue();
		dijkstra = new Dijkstra(graph, queue);
	}

	@Test
	public void execute() {
		String result = dijkstra.execute();
		System.out.println(result);
	}

}
