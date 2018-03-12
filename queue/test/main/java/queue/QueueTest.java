package main.java.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Queue;

import main.java.exception.OverflowException;
import main.java.exception.UnderflowException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class QueueTest
{
	private Queue<String> queue;
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() {
		queue = new UnorderedQueue<String>();
	}
	
	@Test
	public void size_whenNoElelementAdded_shouldReturnZero() {
		assertEquals(queue.size(), 0);
	}
	
	@Test
	public void isEmpty_whenNoElelementAdded_shouldReturnTrue() {
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void capacity_whenCapacityLessThanOne_shouldThrowIllegalArgumentException() {
		exception.expectMessage("Capacity can not be less than one 0");
		exception.expect(IllegalArgumentException.class);
		new UnorderedQueue<>(0);
	}
	
	@Test
	public void add_whenElementAdded_shouldreturnTrue() {
		boolean isAdded = queue.add("A");
		assertTrue(isAdded);
	}
	
	@Test
	public void add_whenCapacityIsFull_shouldThrowException() {
		exception.expectMessage("Queue is full");
		exception.expect(OverflowException.class);
		queue = new UnorderedQueue<>(1);
		queue.add("B");
		boolean isAdded = queue.add("A");
		assertTrue(isAdded);
	}
	
	@Test
	public void remove_TwoElementsAdded_shouldreturnTwoElement() {
		queue.add("B");
		queue.add("A");
		assertEquals(queue.remove(), "B");
		assertEquals(queue.remove(), "A");
	}
	
	@Test
	public void add_whenElementNull_shouldThrowNullPointerException() {
		exception.expectMessage("Element cannot be null");
		exception.expect(NullPointerException.class);
		boolean isAdded = queue.add(null);
		assertTrue(isAdded);
	}
	
	@Test
	public void remove_whenQueueEmpty_shouldThrowNullPointerException() {
		exception.expectMessage("Queue is empty");
		exception.expect(UnderflowException.class);
		queue.remove();
	}
	
	@Test
	public void remove_whenQueueNotEmpty_shouldReturnElement() {
		queue.add("A");
		String ele = queue.remove();
		assertEquals(ele, "A");
	}
	
	@Test
	public void offer_whenQueueFull_shouldreturnFalse() {
		queue = new UnorderedQueue<>(1);
		assertTrue(queue.offer("A"));
		assertFalse(queue.offer("B"));
	}
	
	@Test
	public void poll_whenQueueEmpty_shouldreturnFalse() {
		assertNull(queue.poll());
	}
	
	@Test
	public void poll_whenQueueContainsTwoEle_shouldReturnBothEle() {
		queue.offer("A");
		queue.offer("B");
		assertEquals(queue.poll(), "A");
		assertEquals(queue.poll(), "B");
	}
}
