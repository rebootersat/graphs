package graphs.bfs;

import graphs.Graph;

import org.junit.Before;
import org.junit.Test;

public class BFSTest {
	private BFS bfs;

	@Before
	public void setUp() {
		Graph graph = new Graph(5);
		graph.init();
		bfs = new BFS(graph);
	}

	@Test
	public void traverse() throws Exception {
		bfs.traverse();
	}

}
