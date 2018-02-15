package dijkstra;

public class DistancePriorityQueue {

	private Vertex start;
	private int size;

	public boolean isEmpty() {
		return start == null;
	}

	public boolean addElement(String value) {
		boolean isAdded = false;
		if (start == null) {
			start = new Vertex(value);
			isAdded = true;
		} else {
			Vertex lastVertex = getLastVertex();
			Vertex newVertex = new Vertex(value);
			lastVertex.next = newVertex;
			newVertex.previous = lastVertex;
			isAdded = true;
		}
		if (isAdded)
			size++;
		return isAdded;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Vertex temp = start;
		while (temp != null) {
			builder.append(temp.value);
			temp = temp.next;
		}
		return builder.toString();
	}

	private Vertex getLastVertex() {
		Vertex temp = start;
		while (temp.next != null)
			temp = temp.next;
		return temp;
	}

	public boolean addUpdateElement(String value, int distance, String parent) {
		boolean isAdded = false;
		if (start == null) {
			start = new Vertex(value, distance, parent);
			isAdded = true;
		} else {

			Vertex ele = getElement(value);
			if (ele == null) {
				Vertex elemenWithGreaterDistance = getElemenWithGreaterDistance(distance);
				if (elemenWithGreaterDistance == null) {
					Vertex lastVertex = getLastVertex(value, distance);
					Vertex newVertex = new Vertex(value, distance, parent);
					lastVertex.next = newVertex;
					newVertex.previous = lastVertex;
				} else {
					if (elemenWithGreaterDistance.previous == null) {
						start = new Vertex(value, distance, parent);
						start.next = elemenWithGreaterDistance;
						elemenWithGreaterDistance.previous = start;
					} else {
						Vertex v = new Vertex(value, distance, parent);
						elemenWithGreaterDistance.previous.next = v;
						v.next = elemenWithGreaterDistance;
						elemenWithGreaterDistance.previous = v;
					}
				}
				isAdded = true;
			} else {
				if (ele.distance > distance) {
					ele.distance = distance;
					ele.parent = parent;
					removeElement(ele);
				}
			}
		}
		if (isAdded)
			size++;
		return isAdded;
	}

	private void removeElement(Vertex ele) {
		// remove first element
		if (ele.previous == null) {
			start = ele.next;
			if (start != null)
				start.previous = null;
		}
		// remove last element
		else if (ele.next == null) {
			if (ele.previous == null)
				start = null;
			else
				ele.previous.next = null;
		} else {
			// remove element in between
			Vertex pre = ele.previous;
			Vertex next = ele.next;
			pre.next = next;
			next.previous = pre;
		}
		addUpdateElement(ele.value, ele.distance, ele.parent);
	}

	private Vertex getElemenWithGreaterDistance(int distance) {
		Vertex temp = start;
		while (temp != null) {
			if (temp.distance > distance)
				break;
			temp = temp.next;
		}
		return temp;
	}

	/**
	 * returns an element for given value if elements exists else null.
	 * 
	 * @param value
	 * @return returns an element for given value
	 */
	private Vertex getElement(String value) {
		Vertex temp = start;
		while (temp != null) {
			if (temp.value.equals(value))
				break;
			temp = temp.next;
		}
		return temp;
	}

	private Vertex getLastVertex(String value, int distance) {
		Vertex temp = start;
		while (temp.next != null)
			temp = temp.next;
		return temp;
	}

	class Vertex implements Cloneable {
		Vertex previous;
		String value;
		int distance;
		String parent;
		Vertex next;

		public Vertex(String value) {
			this.value = value;
			this.distance = Integer.MAX_VALUE;
		}

		public Vertex(String value, int distance, String parent) {
			this.value = value;
			this.distance = distance;
			this.parent = parent;
		}

		@Override
		public String toString() {
			return value + "-" + distance + "-" + parent;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			Vertex object = (Vertex) super.clone();
			object.previous = null;
			object.next = null;
			return object;
		}
	}

	public int size() {
		return size;
	}

	public String getPreviousValue(String value) {
		Vertex temp = start;
		while (temp != null) {
			if (temp.value.equals(value))
				break;
			temp = temp.next;
		}
		return temp.previous == null ? null : temp.previous.value;
	}

	public String getNextValue(String value) {
		Vertex temp = start;
		while (temp != null) {
			if (temp.value.equals(value))
				break;
			temp = temp.next;
		}
		return temp.next == null ? null : temp.next.value;
	}

	public boolean verifyOrderWithPrevAndNext() {
		String arr[] = new String[size];
		Vertex tempNext = start;
		Vertex last = start;
		int i = 0;
		while (tempNext != null) {
			last = tempNext;
			arr[i++] = tempNext.value;
			tempNext = tempNext.next;
		}

		i = i - 1;
		while (last != null) {
			if (!last.value.equals(arr[i--]))
				return false;
			last = last.previous;
		}
		return true;
	}

	public Vertex remove() {
		if (start == null)
			return null;
		Vertex temp = start;
		start = start.next;
		if (start != null)
			start.previous = null;
		try {
			return (Vertex) temp.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
