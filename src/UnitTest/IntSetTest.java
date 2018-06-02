package UnitTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import IntSet.IntSet;

class IntSetTest {

	@Test
	void test() {
		IntSet calculator = new IntSet();
		assertEquals(30, calculator.sum(10, 20), "10+20");
		assertEquals(40, calculator.sum(30, 10), "30+10");
		assertEquals(50, calculator.sum(40, 10), "40+10");
	}

}
