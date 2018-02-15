package graphs.dfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import graphs.Graph;
import graphs.Vertex;

import org.junit.Before;
import org.junit.Test;

public class DfsTest {

	private DFS dfs;

	@Before
	public void setUp() {
		Graph graph = new Graph(5);
		graph.init();
		dfs = new DFS(graph);
	}

	@Test
	public void isNodeVisited_whenNodeNotVisited_shouldReturnTrue() {
		boolean isNodeVisited = dfs.isNodeVisited(new Vertex("A"));
		assertFalse(isNodeVisited);
	}

	/*
	 * @Test public void pushNode_whenNodeNotVisited_shouldReturnTrue() {
	 * boolean isNodeInStack = dfs.pushNode(new Node("A"));
	 * assertFalse(!isNodeInStack); }
	 * 
	 * @Test public void pushNode_whenNodeVisited_shouldReturnFalse() {
	 * dfs.pushNode(new Node("A")); boolean isNodeInStack = dfs.pushNode(new
	 * Node("A")); assertTrue(!isNodeInStack); }
	 */

	@Test
	public void hasLinkToNodes_whenLinkNotExist_shouldReturnFalse() {
		boolean hasLink = dfs.hasLinkToNodes(new Vertex("C"));
		assertFalse(hasLink);
	}

	@Test
	public void hasLinkToNodes_whenLinkExist_shouldReturnTrue() {
		boolean hasLink = dfs.hasLinkToNodes(new Vertex("A"));
		assertTrue(hasLink);
	}

	@Test
	public void traverse_shouldPrintSequence() throws Exception {
		String order = dfs.traverse();
		assertEquals("ABEDC", order);
	}
}
