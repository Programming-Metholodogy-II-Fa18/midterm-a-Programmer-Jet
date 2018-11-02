public class Data {
	/**
	 * Problem 2: Implementing a queue, which is a first-in first-out data
	 * structure.
	 **/

	private class Node {
		int value;
		Node next;

		// Node constructor
		public Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	Node first; // least recently added
	Node last; // most recently added

	// constructor
	public Data() {
		first = null;
		last = null;
	}

	// adds an integer 'a' to the end of the queue
	public void add(int a) {
		// if empty queue
		if (first == null) {
			first = new Node(a, null);
			last = first;
			return;
		}
		Node oldlast = last;
		last = new Node(a, null);
		oldlast.next = last;
	}

	/*
	 * Remove the value according to the FIFO rule and return it. Print the
	 * removed value to the console.
	 */
	public int remove() {
		// if empty queue
		if (first == null) {
			System.out.println("Can't remove from an empty queue!");
			return 0;
		}
		int data = first.value;

		// if more than one value in the queue
		if (first.next != null) {
			// update first
			first = first.next;
		} else {
			// if only one value in the queue
			first = null;
			last = null;
		}

		System.out.println("Removed value: " + data);
		return data;

	}

	/*
	 * retrieve the i-th element in the data structure, where i=0 corresponds to
	 * the first element in the queue
	 */
	public int getValue(int index) {
		int i = 0;
		Node ptr = first;
		while (ptr != null) {
			if (index == i) {
				return ptr.value;
			}
			ptr = ptr.next;
			i++;
		}
		return -1;
	}
	
	public static void main(String[] args){
		//create our queue
		Data queue = new Data();
		queue.add(1);
		queue.add(9);
		queue.add(4);
		queue.add(5);
		queue.add(10);
		queue.add(0);
		System.out.println(queue.getValue(0)); //should return 1
		System.out.println(queue.getValue(3)); //should return 5
	}

}
