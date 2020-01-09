package com.sync.objects;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Cyclic barrier can be used when all the threads reaches an event, when they
 * need to wait for other threads. When all other threads have reached their
 * events, the threads can resume from there. CyclicBarrier takes number of
 * threads as argument. Each thread notifies "event reached" by calling
 * barrier.await()
 * 
 * @author emathur
 */

class MyBarrierThread extends Thread {
	String name;
	CyclicBarrier barrier;

	public MyBarrierThread(String name, CyclicBarrier barrier) {
		this.name = name;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		System.out.println(this.name);
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("Completed " + this.name); // this will be reached
														// only when all threads
														// have reached barrier
	}
}

public class CyclicBarrierTest {
	public static void main(String[] args) {
		System.out.println("Starting barrier..");
		CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("Barrier reached"));
		new MyBarrierThread("A", barrier).start();
		new MyBarrierThread("B", barrier).start();
		new MyBarrierThread("C", barrier).start();
		new MyBarrierThread("D", barrier).start();
		new MyBarrierThread("E", barrier).start();
		new MyBarrierThread("F", barrier).start();

	}
}
