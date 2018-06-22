package UnitTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Random;
import java.util.ArrayList;
import IntSet.IntSetBST;

public class IntSetBSTTest{
	static Random r = new Random();
	int maxelems = 10;
	int maxval = 10;
	
	@Test
	public void testIntSetImp() {
		IntSetBST bstSet = new IntSetBST(maxelems, maxval);
		assertEquals(10, bstSet.maxelems);
		assertEquals(10, bstSet.maxval);
	}

	@Test
	public void testInsert() {
		IntSetBST bstSet = new IntSetBST(maxelems, maxval);
		ArrayList<Integer> v = new ArrayList<Integer>();
		int a = 0;
		while(bstSet.size() < maxelems) {
			bstSet.insert(a++);
		}
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		bstSet.report(v);

		for (int i = 0; i < 10; i++) {
			a = v.get(i);
			assertEquals(arr[i], a);
		}
	}

	@Test
	public void testSize() {
		IntSetBST bstSet = new IntSetBST(maxelems, maxval);
		while (bstSet.size() < 10) {
			bstSet.insert(r.nextInt(10));
		}
		assertEquals(10, bstSet.size());
	}

	@Test
	public void testReport() {
		IntSetBST bstSet = new IntSetBST(maxelems, maxval);
		ArrayList<Integer> v = new ArrayList<Integer>();
		int a = 0;
		
		while (bstSet.size() < 10) {
			bstSet.insert(a++);
		}
		
		bstSet.report(v);
		
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		
		for (int i = 0; i < 10; i++) {
			a = v.get(i);
			assertEquals(arr[i], a);
		}
	}
}
