package main.java.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import main.java.exception.OverflowException;
import main.java.exception.UnderflowException;

public class UnorderedQueue<E> implements Queue<E>
{
	private QElement front;
	private int size;
	private int capacity;
	
	public UnorderedQueue()
	{
		this.capacity = Integer.MAX_VALUE;
	}
	
	public UnorderedQueue(int capacity)
	{
		if (capacity < 1)
			throw new IllegalArgumentException("Capacity can not be less than one " + capacity);
		this.capacity = capacity;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return front == null;
	}
	
	@Override
	public boolean contains(Object o) {
		return false;
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void clear() {
		size = 0;
		front = null;
	}
	
	@Override
	public boolean add(E e) {
		if (e == null)
			throw new NullPointerException("Element cannot be null");
		if (size == capacity)
			throw new OverflowException();
		if (front == null)
			front = new QElement(e);
		else
		{
			UnorderedQueue<E>.QElement lastQElement = getLastQElement();
			lastQElement.next = new QElement(e);
		}
		size++;
		return true;
	}
	
	private QElement getLastQElement() {
		QElement temp = front;
		while (temp.next != null)
		{
			temp = temp.next;
		}
		return temp;
	}
	
	@Override
	public boolean offer(E e) {
		if (e == null)
			throw new NullPointerException("Element cannot be null");
		if (size == capacity)
			return false;
		if (front == null)
			front = new QElement(e);
		else
		{
			UnorderedQueue<E>.QElement lastQElement = getLastQElement();
			lastQElement.next = new QElement(e);
		}
		size++;
		return true;
	}
	
	@Override
	public E remove() {
		if (front == null)
			throw new UnderflowException();
		E ele = front.value;
		front = front.next;
		return ele;
	}
	
	@Override
	public E poll() {
		if (front == null)
			return null;
		E ele = front.value;
		front = front.next;
		return ele;
	}
	
	@Override
	public E element() {
		return null;
	}
	
	@Override
	public E peek() {
		return null;
	}
	
	class QElement
	{
		private E value;
		private QElement next;
		
		public QElement(E value)
		{
			this.value = value;
		}
	}
}
