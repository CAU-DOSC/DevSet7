package com.set;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IntSetTreeMapBins {
	/* A set implementation by simple bins.
	 * 
	 * @Attributes:
	 *	maxval: the maxval will be insert into the set.
	 *	maxelem: the size of the set.
	 *	element_num: number of elements in the set.
	 *	bucket: a list that each element is a arraylist to store element.
	 *
	 * @Method:
	 * IntSetTreeMapBins(): Constructor. Build the initial empty set.
	 * insert(): insert an integer into the set if there is not same one. 
	 * report(): sort the elements in the set.
	 */
	
    private List<TreeMap<Integer, Integer>> bucket;
    private int element_num;
    private int maxval;
    private int maxelem;
    private int bucket_size;


    public IntSetTreeMapBins(int maxelements, int maxval) {
    	/* Set initialization.
    	 * 
    	 * Use number of maxelem buckets to store the inserted elements.
    	 * Each bucket contains a int array.
    	 * 
    	 * @Para:
    	 * 	maxelements, maxval must greater than 0.
    	 */

    	if (maxval < 1 || maxelements < 1) {
    		System.out.println("Maxvalue and Maxelem must greater than 0.");
    		return;
    	}

        this.element_num = 0;
    	this.maxval = maxval;
        this.maxelem = maxelements;
        
		this.bucket_size = maxval/1000;
		if (bucket_size == 0)
			bucket_size = 1;
        
        this.bucket = new ArrayList<TreeMap<Integer, Integer>>(1000);
        for (int i = 0; i < 1000; i++)
        	bucket.add(new TreeMap<Integer, Integer>());
    }

    public void insert(int element) {
    	/* Insert int into set.
    	 * 
    	 * Use range of (maxval/maxelem) as key.
    	 */

    	if (element >= this.maxval)
    		return;
    	else if (element < 0)
    		return;
    	else if (this.element_num >= this.maxelem)
    		return;

    	int index = element / bucket_size;
    	TreeMap<Integer, Integer> bucket_elem = bucket.get(index);
    	if (bucket_elem.containsKey(element))
    		return;
    	bucket_elem.put(element, element);
    	this.element_num++;
	}

    public int[] report() {
    	/* Traverse the TreeMap to get the ordered elements.
    	 *  
    	 * @Return:
    	 * 	int array which contains sorted set elements.
    	 */

        int[] array = new int[this.element_num];
        int pos = 0;
        for (TreeMap<Integer, Integer> list : this.bucket) {
        	if (list.isEmpty())
        		continue;
        	for (Map.Entry<Integer, Integer> entry : list.entrySet())
        		array[pos++] = entry.getValue();
        }
        if (array.length == 0)
        	return null;
        return array;
    }

    public int size() {
    	// return the number of elements in the set.
        return this.element_num;
    }

}
