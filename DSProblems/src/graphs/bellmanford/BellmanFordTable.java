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

	class BellMFordVertex {
		private String value;
		private int distance;
		private String parent;
		private BellMFordVertex next;

		public BellMFordVertex(String value) {
			this.value = value;
			distance = Integer.MAX_VALUE;
		}
	}

}
