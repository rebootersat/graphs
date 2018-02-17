package graphs.bellmanford;

import static org.junit.Assert.*;
import graphs.Graph;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BellmanFordTableTest {

	private BellmanFordTable table;
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	
	@Before
	public void setUp() {
		table = new BellmanFordTable();
	}
	
	@Test
	public void createTable_whenVerticesArrayNull_shouldThrowException() {
		expected.expectMessage("Vertices can not be null");
		expected.expect(IllegalArgumentException.class);
		table.createTable(null);
	}
	
	@Test
	public void createTable_whenGraphHasNoVrtex_shouldThrowException() {
		Graph graph = new Graph(6);
		expected.expectMessage("Vertices count cannot be zero");
		expected.expect(IllegalArgumentException.class);
		table.createTable(graph.getAllVerticesValue());
	}
	
	@Test
	public void getVertices_whenTableNotCreated_shouldReturnEmptyString() {
		String vertices = table.getVertices();
		assertEquals(vertices, "");
	}
	
	@Test
	public void getVertices_whenTableCreated_shouldReturnEmptyString() {
		table.createTable(new String[]{"S","A","B","C","D","E"});
		String vertices = table.getVertices();
		assertEquals(vertices, "SABCDE");
	}
	
	@Test
	public void size_whenVetexNotAddedInTable_shouldReturnZero() {
		assertEquals(table.size(), 0);
	}
	
	@Test
	public void size_whenAllGraphVeticesAddedInTable_shouldReturnZero() {
		table.createTable(new String[]{"S","A","B","C","D","E"});
		assertEquals(table.size(), 6);
	}
	
	@Test
	public void isAllVerticesInitialValueMaximum_shouldReturnTrue() {
	boolean hasAllMax = table.isAllVerticesInitialValueMaximum();	
	assertEquals(hasAllMax, true);
	}

	@Test
	public void contains_whenValueNotPresentInTable_shouldReturnFalse() {
		table.createTable(new String[]{"S","A","B","C","D","E"});
		boolean isContains = table.contains("U");
		assertEquals(isContains, false);
	}
	
	@Test
	public void contains_whenValuePresentInTable_shouldReturnFalse() {
		table.createTable(new String[]{"S","A","B","C","D","E"});
		boolean isContains = table.contains("A");
		assertEquals(isContains, true);
	}
	
	@Test
	public void updateAdjacentVertex_whenVertexNotPresent_shouldThrowException() {
		expected.expectMessage("Vertex does not exist W");
		expected.expect(IllegalArgumentException.class);
		table.updateAdjacentVertex("W",8,"S");
	}
	
	@Test
	public void updateAdjacentVertex_whenVertexDistanceLessThanExistingDistance_shouldUpdateAndreturntrue() {
		table.createTable(new String[]{"S","A","B","C","D","E"});
		boolean isUpdated = table.updateAdjacentVertex("A",10,"S");
		assertTrue(isUpdated);
	}
	
	@Test
	public void updateAdjacentVertex_whenVertexDistanceGreaterThanExistingDistance_shouldNotUpdateAndreturnFalse() {
		table.createTable(new String[]{"S","A","B","C","D","E"});
		table.updateAdjacentVertex("A",10,"S");
		boolean isUpdated = table.updateAdjacentVertex("A",30,"S");
		assertFalse(isUpdated);
	}
	
	
	
}
