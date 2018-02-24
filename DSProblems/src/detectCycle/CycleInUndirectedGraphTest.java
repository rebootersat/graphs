package detectCycle;

import static org.junit.Assert.assertEquals;
import graphs.Graph;

import org.junit.Before;
import org.junit.Test;

public class CycleInUndirectedGraphTest {

	private CycleInUndirectedGraph cUndirect;

	@Before
	public void setUp() {
		Graph graph = new Graph(4, true);
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "D");
		graph.addEdge("C", "D");
		
		System.out.println(graph);
		
		cUndirect = new CycleInUndirectedGraph(graph);
	}

	@Test
	public void isCyclic_whenNoCycleExistInGraph_shouldReturnFalse() throws Exception {
		boolean isCyclic = cUndirect.isCyclic();
		assertEquals(isCyclic, true);
	}

}
