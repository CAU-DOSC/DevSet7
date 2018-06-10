package com.set;
import java.util.Arrays;

public class IntSetBins {
	/* A set implementation by simple bins.
	 * 
	 * @Attributes:
	 *	maxval: the maxval will be insert into the set.
	 *	maxelem: the size of the set.
	 *	element_num: number of elements in the set.
	 *	bucket: the empty bin which size depends on maxval.
	 *
	 * @Method:
	 * IntSetBins(): Constructor. Build the initial empty set.
	 * insert(): insert an integer into the set if there is not same one. 
	 * report(): sort the elements in the set.
	 */
	
    private int[] bucket;
    private int element_num;
    private int maxval;
    private int maxelem;


    public IntSetBins(int maxelements, int maxval) {
    	/* Set initialization.
    	 * 
    	 * Use simple bucket that is a array which have maxval+1 elements.
    	 */

        this.maxelem = maxelements;
        this.maxval = maxval;
        this.element_num = 0;
        this.bucket = new int[this.maxval+1];
        Arrays.fill(bucket, 0);
    }

    public void insert(int element) {
    	/* Insert int into set.
    	 * 
    	 * Use each int's value as its key.
    	 */

        if (this.bucket[element] == 0) {
            this.bucket[element]++;
            this.element_num++;
        }
    }

    public int[] report() {
    	/* Sort the element in the set.
    	 * 
    	 * @Return:
    	 * 	int array which contains sorted set elements.
    	 */

        int[] array = new int[this.maxelem];
        int pos = 0;
        for (int i = 0; i < this.bucket.length; i++) {
            if (this.bucket[i] != 0) {
                array[pos++] = i; 
            }
        }
        return array;
    }

    public int size() {
    	// return the number of elements in the set.
        return this.element_num;
    }

 /*
    public static void main(String[] args) {
        int[] num = {3, 2, 5, 4, 1};
        int m = num.length;

        IntSetBins S = new IntSetBins(5, 5);
        for (int i = 0; i < m; i++) {
            S.insert(num[i]);
        }
        
        System.out.println(S.size());
        int[] result = S.report();
        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j] + " ");
        }
    }
    */
}