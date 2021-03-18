package edu.umb.cs681.primes;

import java.util.LinkedList;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}

	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) {

		LinkedList<Thread> threads = new LinkedList<Thread>();
		final long from = 1L;
		final long to = 2000000L;
		Thread t;

		long before1 = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			t = new Thread(() -> {
				RunnablePrimeGenerator gen1 = new RunnablePrimeGenerator(from, to);
				gen1.generatePrimes();
			});
			threads.add(t);
			t.start();
		}

		for (Thread a : threads) {
			try {
				a.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		long after1 = System.currentTimeMillis();
		System.out.println("Exec time on 1 thread: " + (after1 - before1) / 1000 + "s");
		
		
		long before2 = System.currentTimeMillis();
		for (int i = 0; i < 2; i++) {
			t = new Thread(() -> {
				RunnablePrimeGenerator gen1 = new RunnablePrimeGenerator(from, to);
				gen1.generatePrimes();
			});
			threads.add(t);
			t.start();
		}

		
		for (Thread a : threads) {
			try {
				a.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		long after2 = System.currentTimeMillis();
		System.out.println("Exec time on 2 threads: " + (after2 - before2) / 1000 + "s");
		
		
		long before4 = System.currentTimeMillis();
		for (int i = 0; i < 4; i++) {
			t = new Thread(() -> {
				RunnablePrimeGenerator gen1 = new RunnablePrimeGenerator(from, to);
				gen1.generatePrimes();
			});
			threads.add(t);
			t.start();
		}

		
		for (Thread a : threads) {
			try {
				a.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		long after4 = System.currentTimeMillis();
		System.out.println("Exec time on 4 threads: " + (after4 - before4) / 1000 + "s");
		
		long before8 = System.currentTimeMillis();
		for (int i = 0; i < 8; i++) {
			t = new Thread(() -> {
				RunnablePrimeGenerator gen1 = new RunnablePrimeGenerator(from, to);
				gen1.generatePrimes();
			});
			threads.add(t);
			t.start();
		}

		
		for (Thread a : threads) {
			try {
				a.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		long after8 = System.currentTimeMillis();
		System.out.println("Exec time on 8 threads: " + (after8 - before8) / 1000 + "s");
		
		
		long before16 = System.currentTimeMillis();
		for (int i = 0; i < 16; i++) {
			t = new Thread(() -> {
				RunnablePrimeGenerator gen1 = new RunnablePrimeGenerator(from, to);
				gen1.generatePrimes();
			});
			threads.add(t);
			t.start();
		}

		
		for (Thread a : threads) {
			try {
				a.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		long after16 = System.currentTimeMillis();
		System.out.println("Exec time on 16 threads: " + (after16 - before16) / 1000 + "s");
		

	}
}
