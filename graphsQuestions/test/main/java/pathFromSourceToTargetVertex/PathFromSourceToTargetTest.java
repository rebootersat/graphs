package main.java.pathFromSourceToTargetVertex;

import main.java.core.Graph;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * 
 * @author SANDEEP
 *
 */
public class PathFromSourceToTargetTest
{
	private PathFromSourceToTarget<String> path;
	@Rule
	public ExpectedException execption = ExpectedException.none();
	
	@Before
	public void setUp() {
		path = new PathFromSourceToTarget<String>(createGraph());
	}
	
	@Test
	public void getPath_whenNoVertexInGraphForGivenValue_shouldThrowException() {
		execption.expect(IllegalArgumentException.class);
		execption.expectMessage("Either K or M does not exist in the graph");
		path.getPath("K", "M");
	}
	
	@Test
	public void getPath_whenPathExistsForGivenValues_shouldReturnPathString() {
		String elePath = path.getPath("B", "C");
		assertEquals("BDFEC", elePath);
	}
	
	private Graph<String> createGraph() {
		Graph<String> graph = new Graph<>();
		/*graph.addEdge("2", "0");
		graph.addEdge("0", "2");
		graph.addEdge("0", "1");
		graph.addEdge("1", "2");
		graph.addEdge("2", "3");
		graph.addEdge("3", "3");*/
		
		graph.addEdge("A", "B");
		graph.addEdge("B", "D");
		graph.addEdge("D", "F");
		graph.addEdge("F", "E");
		graph.addEdge("E", "D");
		graph.addEdge("E", "C");
		graph.addEdge("A", "C");
		return graph;
	}
}
