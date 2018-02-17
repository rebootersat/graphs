package graphs.bellmanford;

public class BellmanFordTable {

	private int size;
	private BellMFordVertex start;

	public BellmanFordTable() {

	}

	public void createTable(String[] allVerticesValue) {
		if (allVerticesValue == null)
			throw new IllegalArgumentException("Vertices can not be null");
		if (allVerticesValue.length == 0)
			throw new IllegalArgumentException("Vertices count cannot be zero");
		start = new BellMFordVertex(allVerticesValue[0]);
		start.distance = 0;
		size++;
		BellMFordVertex lastVertex = start;
		for (int i = 1; i < allVerticesValue.length; i++) {
			lastVertex = lastVertex.next = new BellMFordVertex(allVerticesValue[i]);
			size++;
		}
	}

	public Object size() {
		return size;
	}

	public String getVertices() {
		if (start == null)
			return "";

		StringBuilder builder = new StringBuilder();
		BellMFordVertex vertex = start;
		while (vertex != null) {
			builder.append(vertex.value);
			vertex = vertex.next;
		}
		return builder.toString();
	}

	public BellMFordVertex[] toArray() throws CloneNotSupportedException {
		if (start == null)
			return new BellMFordVertex[0];

		BellMFordVertex[] builder = new BellMFordVertex[size];
		BellMFordVertex vertex = start;
		int i = 0;
		while (vertex != null) {
			builder[i++] = (BellMFordVertex) vertex;
			vertex = vertex.next;
		}
		return builder;
	}

	public boolean isAllVerticesInitialValueMaximum() {
		boolean hasMax = true;
		BellMFordVertex temp = start;
		while (temp != null) {
			if (temp.distance != Integer.MAX_VALUE) {
				hasMax = false;
				break;
			}
			temp = temp.next;
		}
		return hasMax;
	}

	public boolean contains(String value) {
		boolean hasMax = false;
		BellMFordVertex temp = start;
		while (temp != null) {
			if (temp.value.equals(value)) {
				hasMax = true;
				break;
			}
			temp = temp.next;
		}
		return hasMax;
	}

	class BellMFordVertex implements Cloneable {
		private String value;
		private int distance;
		private String parent;
		private BellMFordVertex next;

		public BellMFordVertex(String value) {
			this.value = value;
			distance = Integer.MAX_VALUE;
		}

		public BellMFordVertex(String value, int distance) {
			this.value = value;
			this.distance = distance;
		}

		public int getDistance() {
			return distance;
		}

		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "[" + value + "]" + "-" + "[" + distance + "]" + "-" + "[" + parent + "]";
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return new BellMFordVertex(value, distance);
		}
	}

	public boolean updateAdjacentVertex(String adjacentVertexValue, int distance, String parentValue) {
		if (!contains(adjacentVertexValue))
			throw new IllegalArgumentException("Vertex does not exist " + adjacentVertexValue);
		BellMFordVertex temp = start;
		while (temp != null) {
			if (temp.value.equals(adjacentVertexValue)) {
				if (distance < temp.distance) {
					temp.distance = distance;
					temp.parent = parentValue;
					return true;
				}
			}
			temp = temp.next;
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		BellMFordVertex temp = start;
		while (temp != null) {
			result.append(temp).append("\n");
			temp = temp.next;
		}
		return result.toString();
	}
}
