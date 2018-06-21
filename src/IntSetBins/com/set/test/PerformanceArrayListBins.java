package com.set.test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.set.IntSetBins;

class PerformanceArrayListBins {

	public static void tuning(int element_div, int maxval) {
		int maxelem = maxval/element_div;
		long init_time = 0;
		long insert_time = 0;
		long report_time = 0;
		
		// Initial part
		long startTime = System.currentTimeMillis();
		IntSetBins set = new IntSetBins(maxelem, maxval);
		long stopTime = System.currentTimeMillis();
		init_time = stopTime - startTime;
		
		// Insert part
		startTime = System.currentTimeMillis();
		//int random;
		Random random = new Random();
		while (set.size() < maxelem) {
			//random = ThreadLocalRandom.current().nextInt(0, maxval);
			set.insert(random.nextInt(maxval));
		}
		stopTime = System.currentTimeMillis();
		insert_time = stopTime - startTime;
		
		// Report part
		startTime = System.currentTimeMillis();
		set.report();
		stopTime = System.currentTimeMillis();
		report_time = stopTime - startTime;
		
		System.out.println("------------------------------------------");
		System.out.println("ArrayListBinsSet performance tuning:");
		System.out.println("Maxval is " + maxval + ", Maxelem is " + maxelem);
		System.out.println("Initialize time is " + init_time + "ms.");
		System.out.println("Insert time is " + insert_time + "ms.");
		System.out.println("Report time is " + report_time + "ms.\n");
		System.out.println("Total time is " + (init_time + insert_time + report_time) + "ms.");
		System.out.println("------------------------------------------\n");
	}

	public static void main (String args[]) {
		final int MAXVALUE_6 = 1000000;
		final int MAXVALUE_8 = 100000000;
		
		//tuning(100, MAXVALUE_6);
		//tuning(50, MAXVALUE_6);
		//tuning(25, MAXVALUE_6);

		tuning(100, MAXVALUE_8);
		tuning(50, MAXVALUE_8);
		tuning(25, MAXVALUE_8);
	}
}