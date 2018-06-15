package IntSet;

import java.util.Random;

public class Main {
	static int[] v;
	static int maxelems;
	static int maxval;
	static Random r;

	public static void main(String[] args) {
		maxelems = 100000;
		maxval = Integer.MAX_VALUE;
		r = new Random();

		long start_time = System.currentTimeMillis();
		IntSet arraySet = new IntSetArr();

		arraySet.intSetImp(maxelems, maxval);

		while (arraySet.size() < maxelems) {
			arraySet.insert(r.nextInt(maxval));
		}

		v = arraySet.report();
		long end_time = System.currentTimeMillis();
		long timeDiff = end_time - start_time;

		for (int i = 0; i < v.length; i++) {
			System.out.println("v[" + i + "] = " + v[i]);
		}
		System.out.println("Execution time = " + timeDiff / 1000 + "sec");
	}
}