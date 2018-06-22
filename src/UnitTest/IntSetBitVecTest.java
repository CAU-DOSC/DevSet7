package UnitTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import IntSet.IntSetBitVec;

class IntSetBitVecTest {

   // smoke test
   @Test
   void smokeTestSpecific() {
        int[] num = {3, 3, 5, 1, 2};

        IntSetBitVec set = new IntSetBitVec(5, 5);
        for (int i = 0; i < num.length; i++) {
            set.insert(num[i]);
        }
        
        int result = set.size();
        int expect = 4;
        assertEquals(expect, result);
   }
   
   @Test
   void smokeTestRandom() {
      int maxelem = 10;
      int maxval = 10;
      
      IntSetBitVec set = new IntSetBitVec(maxelem, maxval);
      for (int i = 0; i < maxelem; i++) {
         int randomN = ThreadLocalRandom.current().nextInt(0, maxval);
         set.insert(randomN);
      }

      assertTrue(set.size() <= maxelem);
   }
   
   @Test
   void boundaryTestHugeElement() {
      int maxelem = 1000000;
      int maxval = 100000000;
      
      IntSetBitVec set = new IntSetBitVec(maxelem, maxval);
      Random random = new Random();
      while(set.size() < maxelem) {
         set.insert(random.nextInt(maxval));
      }
      
      assertTrue(set.size() <= 1000000);
   }
}