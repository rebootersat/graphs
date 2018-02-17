package graphs.bellmanford;

import static org.junit.Assert.*;
import graphs.Graph;

import org.junit.Before;
import org.junit.Test;

public class BellmanFordTest {

	private BellmanFord bellManFord;

	@Before
	public void setUp() {
		Graph graph = new Graph(5);
		graph.addEdge("A", "B",-1);
		graph.addEdge("A", "C",4);
		graph.addEdge("B", "C",3);
		graph.addEdge("B", "D",2);
		graph.addEdge("B", "E",2);
		graph.addEdge("D", "B",1);
		graph.addEdge("D", "C",5);
		graph.addEdge("E", "D",-3);
		BellmanFordTable table = new BellmanFordTable();
		table.createTable(graph.getAllVerticesValue());
		bellManFord = new BellmanFord(graph, table);
	}
	

	@Test
	public void execute() throws CloneNotSupportedException {
		bellManFord.execute();
	}

}
