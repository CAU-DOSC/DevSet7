package com.set.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.set.IntSetBins;

class IntSetBinsTest {

	@Test
	void smokeTest() {
        int[] num = {3, 2, 5, 4, 1};
        int m = num.length;

        IntSetBins set = new IntSetBins(5, 5);
        for (int i = 0; i < m; i++) {
            set.insert(num[i]);
        }
        
        int[] result = set.report();
        int[] expect = {1, 2, 3, 4, 5};
        assertArrayEquals(expect, result);
        assertEquals(m, set.size());
	}

}
