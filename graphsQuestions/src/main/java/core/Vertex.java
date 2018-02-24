package main.java.core;

public class Vertex<V> implements Cloneable
{
	private V value;
	Vertex<V> next;
	private boolean visited;
	
	public Vertex(V value)
	{
		this.value = value;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public Vertex<V> getNext() {
		return next;
	}
	
	public void setNext(Vertex<V> next) {
		this.next = next;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Vertex))
			return false;
		Vertex<V> vertex = (Vertex<V>) obj;
		if (vertex == this)
			return true;
		return vertex.getValue().equals(value);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Vertex<>(value);
	}
}
