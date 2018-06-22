package IntSet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Random;

import IntSet.IntSetList;

public class IntSetListTest {

	static Random r = new Random();;
	IntSetList set = new IntSetList();

	@Test
	public void testIntSetImp() {
		set.intSetImp(10, 100);
		assertEquals(10, set.maxelems());
		assertEquals(100, set.maxval());
	}

	@Test
	public void testInsert() {
		int a = 0;
		set.intSetImp(10, 10);
		while (set.size() < 10) {
			set.insert(a++);
		}
		int[] arr = {0,1,2,3,4,5,6,7,8,9};

		IntSetList.Node temp = set.head();
		int[] report = set.report();
		for(int i = 0; i < 10; i++) {
			assertEquals(arr[i], temp.value());
			temp = temp.next();
		}
	}

	@Test
	public void testSize() {
		set.intSetImp(10, 100);
		while (set.size() < 10) {
			set.insert(r.nextInt(100));
		}
		assertEquals(10, set.size());
	}

	@Test
	public void testReport() {
		set.intSetImp(10, 100);
		while (set.size() < 10) {
			set.insert(r.nextInt(10));
		}
		int[] report = set.report();
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		for(int i = 0; i < 10; i++) {
			assertEquals(arr[i], report[i]);
		}
	}

}
