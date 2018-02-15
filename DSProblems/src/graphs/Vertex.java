package graphs;

public class Vertex implements Cloneable{

	String value;
	boolean isVisited;
	Vertex next;
	public int distance;

	public Vertex(String first) {
		this.value = first;
	}
	
	public Vertex(String first, int distance) {
		this.value = first;
		this.distance = distance;
	}

	public String getValue() {
		return value;
	}

	public int getDistance() {
		return distance;
	}
	
	public void setNext(Vertex next) {
		this.next = next;
	}

	public Vertex getNext() {
		return next;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	@Override
	public boolean equals(Object obj) {
		Vertex node = (Vertex) obj;
		return node.value.equals(value);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		return "Value "+value+" isVisited : "+isVisited;
	}

}
