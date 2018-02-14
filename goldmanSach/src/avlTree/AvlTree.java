package avlTree;

public class AvlTree {

	private Node root;

	public void insert(int data) {
		if (root == null)
			root = new Node(data);
		else
			root = insert(data, root);
	}

	public Node insert(int data, Node root) {
		if (root == null)
			return new Node(data);

		if (data < root.data) {
			root.left = insert(data, root.left);
			if (height(root.left) - height(root.right) == 2) {
				if (data < root.left.data)
					root = singleRotateLeft(root);
				else
					root = doubleRotateLeft(root);
			}
		} else if (data > root.data) {
			root.right = insert(data, root.right);
			if (height(root.right) - height(root.left) == 2) {
				if (data > root.right.data)
					root = singleRotateRight(root);
				else
					root = doubleRotateRight(root);
			}
		}
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		return root;
	}

	public Node singleRotateLeft(Node root) {
		Node temp = root.left;
		root.left = temp.right;
		temp.right = root;
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		temp.height = Math.max(height(temp.left), root.height) + 1;
		return temp;
	}

	public Node singleRotateRight(Node root) {
		Node temp = root.right;
		root.right = temp.left;
		temp.left = root;
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		temp.height = Math.max(root.height, height(root.right));
		return temp;
	}

	public Node doubleRotateLeft(Node root) {
		root.left = singleRotateRight(root.left);
		return singleRotateLeft(root);
	}

	public Node doubleRotateRight(Node root) {
		root.right = singleRotateLeft(root.right);
		return singleRotateRight(root);
	}

	private int height(Node root) {
		return root == null ? -1 : root.height;
	}

	private class Node {
		private int data;
		private Node left;
		private Node right;
		private int height;

		public Node(int data) {
			this.data = data;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("["); 
		preOrderTraversal(root, builder);
		builder.append("]");
		return builder.toString();
	}
	
	public void preOrderTraversal(Node root, StringBuilder builder) {
		if (root != null) {
			preOrderTraversal(root.left, builder);
			builder.append(root.data).append("-").append(root.height).append(" ");
			preOrderTraversal(root.right, builder);
		}
	}

}
