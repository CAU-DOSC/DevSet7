package IntSet;

import java.util.Random;

public class IntSetBitVec {	
	final int BITSPERWORD = 32;
	final int SHIFT = 5;
	final int MASK = 0x1F;

	int maxelems;
	int maxval;
	int num;
	int n, m;
	int[] x;
	
	public IntSetBitVec(int maxelems, int maxval) {
		this.maxelems = maxelems;
		this.maxval = maxval;

		x = new int[1 + maxval/BITSPERWORD];  // space complexity : O(1)

		for (int i = 0; i < maxval; i++)
			clr(i);
		n = 0;
		m = 0;
	}

	public int size() { return n; }

	public void insert(int t) { // insert time complexity : O(1)
	// System.out.println("T : " + t);
	
	if (t > this.maxval)
		return;
	else if (t < 0)
		return;
	else if (n >= this.maxelems)
		return;
	
	if (test(t) > 0)
		return;
	
	set(t);
	n++;
	}

	public void report(int v[]) { // report time complexity : O(n)
	int j = 0;
	long startTime = System.currentTimeMillis();
	for (int i = 0; i < maxval; i++)
		if (test(i) > 0) {
			v[j++] = i;
		}
	long finishTime = System.currentTimeMillis() - startTime;
	System.out.println("The time elapsed for the 'report' operation is: " + finishTime + "ms");
	}
	
	void set(int i) { x[i>>SHIFT] |= (1<<(i & MASK)); }

	void clr(int i) { x[i>>SHIFT] &= ~(1<<(i & MASK)); }

	int test(int i) { return x[i>>SHIFT] & (1<<(i & MASK)); } // Check Duplicate
	
	
	public static void genSets(int maxelems, int maxval) {
		long startTimeForEntire = System.currentTimeMillis();

		Random r = new Random();
		int[] v = new int[maxelems];

		IntSetBitVec test = new IntSetBitVec(maxelems, maxval);

		long startTimeForInsert = System.currentTimeMillis();

		for (int i = 0; i < test.maxelems; i++) {
			test.insert(r.nextInt(test.maxval + 1));
		}
		test.insert(1);
		long finishTimeForInsert = System.currentTimeMillis() - startTimeForInsert;
		System.out.println("The time elapsed for the 'insert' operation is: " + finishTimeForInsert + "ms");

		test.report(v);

		long finishTimeForEntire = System.currentTimeMillis() - startTimeForEntire;
		System.out.println("The time elapsed for the entire operation is: " + finishTimeForEntire + "ms");
	}
	
	public static void main(String[] args) {
		genSets(10000, 1000000); // Test Numbers
	}

};