package IntSet;

import java.util.Random;

public class IntSetArr {
	public int[] arr;
	public int size;
	public int maxval;

	public IntSetArr() {
		size = 0;
		maxval = 0;
	}

	public void intSetImp(int maxelems, int maxval) {
		arr = new int[maxelems];
		this.maxval = maxval;
	}

	public void insert(int element) {
		if (size < arr.length && element < maxval) {
			for (int i = 0; i < size; i++) {
				if (element == arr[i]) {
					return;
				}
			}
			arr[size] = element;
			size++;
		}
	}

	public int size() {
		return size;
	}

	public int[] report() {
		quickSort(arr, 0, arr.length - 1);
		return arr;
	}

	public void quickSort(int[] data, int l, int r) {
		int left = l;
		int right = r;
		int pivot = data[(l + r) / 2];

		do {
			while (data[left] < pivot) {
				left++;
			}
			while (data[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
		} while (left <= right);

		if (l < right) {
			quickSort(data, l, right);
		}
		if (r > left) {
			quickSort(data, left, r);
		}
	}

	public static void genSets(int maxelems, int maxval) {
		Random r = new Random();
		int[] v = new int[maxelems];

		IntSetArr arraySet = new IntSetArr();
		arraySet.intSetImp(maxelems, maxval);

		while (arraySet.size() < maxelems) {
			arraySet.insert(r.nextInt(maxval));
		}

		v = arraySet.report();

		for (int i = 0; i < v.length; i++) {
			System.out.println("v[" + i + "] = " + v[i]);
		}
	}

	public static void main(String[] args) {
		genSets(100, 100); // Test Numbers
	}
}