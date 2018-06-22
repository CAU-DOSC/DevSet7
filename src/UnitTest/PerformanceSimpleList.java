package UnitTest;

import java.util.Random;
import IntSet.IntSetList;

public class PerformanceSimpleList {
	public static void tuning(int maxelems, int maxval) { // create an instance of a binary search tree

		long startTimeForEntire = System.currentTimeMillis();

		Random rand = new Random();
		
		System.out.println("------------------------------------------");
		System.out.println("SimpleListSet performance tuning:");
		System.out.println("Maxcal is " + maxval + ", Maxelem is " + maxelems);

		long startTimeForInitial = System.currentTimeMillis();
		
		IntSetList test = new IntSetList();
		test.intSetImp(maxelems, maxval);
		
		long finishTimeForInitial = System.currentTimeMillis() - startTimeForInitial;
		System.out.println("Initialize time is " + finishTimeForInitial + "ms.");


		long startTimeForInsert = System.currentTimeMillis();

		for (int i = 0; i < test.maxelems; i++) {
			test.insert(rand.nextInt(test.maxval)); // assign random numbers to the created array
		}
		long finishTimeForInsert = System.currentTimeMillis() - startTimeForInsert;
		System.out.println("Insert time is " + finishTimeForInsert + "ms.");

		long startTimeForReport = System.currentTimeMillis();
		int[] v = test.report();
		long finishTimeForReport = System.currentTimeMillis() - startTimeForReport;
		System.out.println("Report time is : " + finishTimeForReport + "ms.");

		long finishTimeForEntire = System.currentTimeMillis() - startTimeForEntire;
		System.out.println("\nTotal time is " + finishTimeForEntire + "ms.");

		System.out.println("------------------------------------------");
		System.out.println();
	}

	public static void main(String[] args) {
		int n = 1000000;
		tuning(n/100, n);
		tuning(n/50, n);
		tuning(n/25, n);
		/*
		 * Too slow
		n *= 100;
		tuning(n/100, n);
		tuning(n/50, n);
		tuning(n/25, n);
		*/
	}
}
