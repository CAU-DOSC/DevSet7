package IntSet;

public interface IntSet {
	/*
	 * intSetImp(int maxelems, int maxval)
	 * initializes the set to empty
	 * maxelems : maximum number of elements
	 * maxval : maximum value of any element
	 */
	void intSetImp(int maxelems, int maxval);

	/*
	 * insert(int element)
	 * adds a new integer to the set, if it is not already present
	 */
	void insert(int element);

	/*
	 * size()
	 * tells the current number of elements
	 */
	int size();

	/*
	 * report(int *v)
	 * returns elements in sorted order
	 */
	int[] report();
}