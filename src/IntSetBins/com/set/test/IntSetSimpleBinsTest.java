package com.set.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Random;

import com.set.IntSetSimpleBins;

class IntSetSimpleBinsTest {

	// smoke test
	@Test
	void smokeTestSpecific() {
        int[] num = {3, 2, 5, 4, 1};
        int m = num.length;

        IntSetSimpleBins set = new IntSetSimpleBins(5, 6);
        for (int i = 0; i < m; i++) {
            set.insert(num[i]);
        }
        
        int[] result = set.report();
        int[] expect = {1, 2, 3, 4, 5};
        assertArrayEquals(expect, result);
        assertEquals(m, set.size());
	}
	
	@Test
	void smokeTestRandom() {
		int maxelem = 10;
		int maxval = 1000;
		
		IntSetSimpleBins set = new IntSetSimpleBins(maxelem, maxval);
		Random random = new Random();
		for (int i = 0; i < maxelem; i++) {
			set.insert(random.nextInt(maxval));
		}
		int[] result = set.report();

		assertTrue(set.size() <= maxelem);
		assertTrue(result[set.size()-1] <= maxval);
	}
	
	@Test
	void smokeTestDuplicateInsert() {
        int[] num = {1, 2, 3, 3, 2, 1};
        int m = num.length;

        IntSetSimpleBins set = new IntSetSimpleBins(6, 4);
        for (int i = 0; i < m; i++) {
            set.insert(num[i]);
        }
        
        int[] result = set.report();
        int[] expect = {1, 2, 3};
        assertArrayEquals(expect, result);
        assertEquals(expect.length, set.size());
		
	}
	
	// boundary test
	@Test
	void boundaryTestEmpty() {
		int maxelem = 0;
		int maxval = 10;
		
		IntSetSimpleBins set = new IntSetSimpleBins(maxelem, maxval);
		int[] result = set.report();
		assertEquals(0, set.size());
		assertNull(result);
	}
	
	@Test
	void boundaryTestMinVal() {
		int maxelem = 10;
		int maxval = 1;
		
		IntSetSimpleBins set = new IntSetSimpleBins(maxelem, maxval);
		set.insert(0);
		int[] result = set.report();

		assertEquals(1, set.size());
		assertEquals(result[0], 0);
	}
	
	@Test
	void boundaryTestMaxVal() {
		int maxelem = 10;
		int maxval = 10;
		
		IntSetSimpleBins set = new IntSetSimpleBins(maxelem, maxval);
		set.insert(maxval - 1);
		int[] result = set.report();

		assertEquals(1, set.size());
		assertEquals(result[0], maxval-1);
	}
	
	@Test
	void boundaryTestOverBound() {
		int maxelem = 10;
		int maxval = 10;

		IntSetSimpleBins set = new IntSetSimpleBins(maxelem, maxval);
		set.insert(maxval + 1);
		
		assertEquals(0, set.size());
	}

	@Test
	void boundaryTestUnderBound() {
		int maxelem = 10;
		int maxval = 10;

		IntSetSimpleBins set = new IntSetSimpleBins(maxelem, maxval);
		set.insert(-1);
		
		assertEquals(0, set.size());
	}
	
	@Test
	void boundaryTestHugeElement() {
		int maxelem = 1000000;
		int maxval = 100000000;
		
		IntSetSimpleBins set = new IntSetSimpleBins(maxelem, maxval);
		Random random = new Random();
		while(set.size() < maxelem) {
			set.insert(random.nextInt(maxval));
		}
		
		assertEquals(1000000, set.size());
		
	}
	
}
