/** Part of Problem 3 **/

public class BST {

	private class Node {
		private int value;
		private Node left, right;

		// Node constructor
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	Node root;

	// BST constructor
	public BST() {
		root = null;
	}

	// add value to the BST
	public void add(int value) {
		root = add(root, value);

	}

	public Node add(Node x, int value) {
		if (x == null) {
			x = new Node(value, null, null);
		}
		if (value < x.value) {
			x.left = add(x.left, value);
		} else if (value > x.value) {
			x.right = add(x.right, value);
		} else {
			x.value = value;
		}
		return x;
	}

}
