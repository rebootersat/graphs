package dijkstra;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dijkstra.DistancePriorityQueue.Vertex;

public class DistancePriorityQueueTest {
	private DistancePriorityQueue q;

	@Before
	public void setUp() {
		q = new DistancePriorityQueue();
	}

	@Test
	public void isQueueEmpty_whenQEmpty_shouldReturnTrue() {
		boolean isEmpty = q.isEmpty();
		assertTrue(isEmpty);
	}

	@Test
	public void isQueueEmpty_whenQNotEmpty_shouldReturnTrue() {
		q.addElement("A");
		boolean isEmpty = q.isEmpty();
		assertFalse(isEmpty);
	}

	@Test
	public void addElement_whenElementAdded_shouldReturnTrue() {
		boolean isAdded = q.addElement("A");
		assertTrue(isAdded);
	}

	@Test
	public void size_whenEmpty_shouldReturnZero() {
		assertEquals(q.size(), 0);
	}

	@Test
	public void size_whenTwoElementsAdded_shouldReturnTwo() {
		q.addElement("A");
		q.addElement("B");
		assertEquals(q.size(), 2);
	}

	@Test
	public void toString_whenThreeElementsAdded_shouldReturnTheElementsValueInSameOrders() {
		q.addElement("A");
		q.addElement("B");
		q.addElement("C");
		assertEquals(q.toString(), "ABC");
	}

	@Test
	public void toString_whenElementsAreInAscendingOrder_shouldReturnTheElementsValueInSameOrders() {
		q.addUpdateElement("A", 0,null);
		q.addUpdateElement("B", 3,null);
		q.addUpdateElement("C", 4,null);
		assertEquals(q.toString(), "ABC");
	}

	@Test
	public void toString_whenElementsDistanceDisercendingOrder_shouldReturnTheElementsValueInSameOrders() {
		q.addUpdateElement("A", 6,null);
		q.addUpdateElement("B", 5,null);
		q.addUpdateElement("C", 4,null);
		assertEquals(q.toString(), "CBA");
	}

	@Test
	public void toString_whenElementsDistanceRandomOrder_shouldReturnTheElementsValueInSameOrders() {
		q.addUpdateElement("A", 6,null);
		q.addUpdateElement("B", 8,null);
		q.addUpdateElement("C", 4,null);
		assertEquals(q.toString(), "CAB");
	}

	@Test
	public void getPreviousElementValue_whenQSizeOne_shouldReturnNull() {
		q.addElement("A");
		String preValue = q.getPreviousValue("A");
		assertEquals(preValue, null);
	}

	@Test
	public void getPreviousElementValue_whenAandBInQ_shouldReturnA() {
		q.addElement("A");
		q.addElement("B");
		String preValue = q.getPreviousValue("B");
		assertEquals(preValue, "A");
	}

	@Test
	public void getPreviousElementValue_whenABandCInQ_shouldReturnB() {
		q.addElement("A");
		q.addElement("B");
		q.addElement("C");
		String preValue = q.getPreviousValue("C");
		assertEquals(preValue, "B");
	}

	@Test
	public void getNextElementValue_whenQSizeOne_shouldReturnNull() {
		q.addElement("A");
		String preValue = q.getNextValue("A");
		assertEquals(preValue, null);
	}

	@Test
	public void getNextElementValue_whenAandBInQ_shouldReturnA() {
		q.addElement("A");
		q.addElement("B");
		String preValue = q.getNextValue("A");
		assertEquals(preValue, "B");
	}

	@Test
	public void getNextElementValue_whenABandCInQ_shouldReturnC() {
		q.addElement("A");
		q.addElement("B");
		q.addElement("C");
		String preValue = q.getNextValue("B");
		assertEquals(preValue, "C");
	}

	@Test
	public void verifyOrderWithPrevAndNext_shouldReturnTrue() {
		q.addUpdateElement("A", 6,null);
		q.addUpdateElement("B", 8,null);
		q.addUpdateElement("C", 4,null);
		boolean isSame = q.verifyOrderWithPrevAndNext();
		assertTrue(isSame);
	}

	@Test
	public void remove_whenEmpty_shouldReturnNull() {
		Vertex v = q.remove();
		assertNull(v);
	}
	
	@Test
	public void remove_whenNotEmpty_shouldReturnElement() {
		q.addUpdateElement("A", 6,null);
		q.addUpdateElement("B", 8,null);
		q.addUpdateElement("C", 4,null);
		assertEquals(q.remove().value, "C");
		assertEquals(q.remove().value, "A");
		assertEquals(q.remove().value, "B");
		assertNull(q.remove());
	}
}
