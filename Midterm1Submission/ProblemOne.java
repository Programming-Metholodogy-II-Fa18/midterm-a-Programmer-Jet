
public class ProblemOne {

	/**
	 * Implementing merge sort, which is a stable algorithm that runs O(NlogN)
	 * in the best and worst case.
	 **/

	/* a is the array to be sorted. size is the size of the array. */
	public static int[] ExamSort(int[] a, int size) {
		// array of size 1 is already sorted
		if (size <= 1) {
			return a;
		}
		// split the input array in half
		int[] left = new int[size / 2];
		int[] right = new int[size - (size / 2)];
		// populate the arrays
		for (int i = 0; i < left.length; i++) {
			left[i] = a[i];
		}
		for (int i = 0; i < right.length; i++) {
			right[i] = a[i + left.length];
		}
		return merge(ExamSort(left, left.length), ExamSort(right, right.length));
	}

	public static int[] merge(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i = 0;
		int j = 0;
		for (int k = 0; k < c.length; k++) {
			if (i >= a.length) {
				c[k] = b[j++];
			} else if (j >= b.length) {
				c[k] = a[i++];
			} else if (a[i] <= b[j]) {
				c[k] = a[i++];
			} else {
				c[k] = b[j++];
			}
		}
		return c;
	}

	public static void main(String[] args) {
		int[] input = { 15, 9, 60, 44, 12, 1, 4 };
		input = ExamSort(input, input.length);
		// print the array contents after finishing the sort
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

}
