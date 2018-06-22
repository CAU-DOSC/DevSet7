package UnitTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Random;
import org.junit.jupiter.api.Test;
import IntSet.IntSetBitVec;


public class IntSetBitVecTest {
	final int BITSPERWORD = 32;
	final int SHIFT = 5;
	final int MASK = 0x1F;

	int maxelems;
	int maxval;
	int num;
	int n, m;
	int[] x;
	
	public IntSetBitVecTest(int maxelems, int maxval) {
		this.maxelems = maxelems;
		this.maxval = maxval;

		x = new int[1 + maxval/BITSPERWORD];  // space complexity : O(1)

		for (int i = 0; i < maxval; i++)
			clr(i);
		n = 0;
		m = 0;
	}
	
	
	@Test
	int size() { return n; }
	
	@Test
	public void insert(int t){
		if (test(t) > 0)
			return;
		
		set(t);
		n++;
	}
	
	@Test
	void report(int v[]) { // report time complexity : O(n)
		int j = 0;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < maxval; i++)
			if (test(i) > 0) {
				v[j++] = i;
			}
		long finishTime = System.currentTimeMillis() - startTime;
		System.out.println("The time elapsed for the 'report' operation is: " + finishTime + "ms");
		}
	
	@Test
	void set(int i) { x[i>>SHIFT] |= (1<<(i & MASK)); }

	@Test
	void clr(int i) { x[i>>SHIFT] &= ~(1<<(i & MASK)); }

	@Test
	int test(int i) { return x[i>>SHIFT] & (1<<(i & MASK)); }
		
	
	
	@Test
	public static void genSets(int maxelems, int maxval) {
		long startTimeForEntire = System.currentTimeMillis();

		Random r = new Random();
		int[] v = new int[maxelems];

		IntSetBitVecTest test = new IntSetBitVecTest(maxelems, maxval);
		
		assertEquals(maxelems, test.maxelems);
		assertEquals(maxval, test.maxval);

		long startTimeForInsert = System.currentTimeMillis();

		for (int i = 0; i < test.maxelems; i++) {
			test.insert(r.nextInt(test.maxval + 1));
		}
		long finishTimeForInsert = System.currentTimeMillis() - startTimeForInsert;
		System.out.println("The time elapsed for the 'insert' operation is: " + finishTimeForInsert + "ms");

		test.report(v);

		long finishTimeForEntire = System.currentTimeMillis() - startTimeForEntire;
		System.out.println("The time elapsed for the entire operation is: " + finishTimeForEntire + "ms");
	}
	
	@Test
	public static void main(String[] args) {
		genSets(10000, 1000000); // Test Numbers
	}

};
	


