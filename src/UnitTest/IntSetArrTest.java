package UnitTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import org.junit.jupiter.api.Test;
import IntSet.IntSetArr;

public class IntSetArrTest {

	static Random r = new Random();;
	IntSetArr arraySet = new IntSetArr();

	@Test
	public void testIntSetImp() {
		arraySet.intSetImp(10, 100);
		assertEquals(10, arraySet.arr.length);
		assertEquals(100, arraySet.maxval);
	}

	@Test
	public void testInsert() {
		int a = 0;
		arraySet.intSetImp(10, 10);
		while (arraySet.size() < 10) {
			arraySet.insert(a++);
		}
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		
		for(int i = 0; i < 10; i++) {
			assertEquals(arr[i], arraySet.arr[i]);
		}
	}

	@Test
	public void testSize() {
		arraySet.intSetImp(10, 100);
		while (arraySet.size() < 10) {
			arraySet.insert(r.nextInt(100));
		}
		assertEquals(10, arraySet.size());
	}

	@Test
	public void testReport() {
		arraySet.intSetImp(10, 100);
		while (arraySet.size() < 10) {
			arraySet.insert(r.nextInt(10));
		}
		arraySet.report();
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		for(int i = 0; i < 10; i++) {
			assertEquals(arr[i], arraySet.arr[i]);
		}
	}
}