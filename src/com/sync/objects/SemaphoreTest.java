package com.sync.objects;

import java.util.concurrent.Semaphore;

/**
 * Semaphore accepts a count. When semaphore's acquire method is called by a
 * thread, it will acquire the monitor on all shared resources if the current
 * semaphore count is >0. After acquiring the monitor, the semaphore count is
 * decrement by 1. Thread can release the access to shared resource by releasing
 * semaphore, cauing the semaphore count to be incremented.
 * 
 * @author emathur
 */
class Shared {
	static int count = 0;
}

class IncrementShared extends Thread {
	Semaphore sem;

	public IncrementShared(Semaphore sem) {
		this.sem = sem;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				sem.acquire();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			++Shared.count;
			System.out.println("IncrementShared: " + Shared.count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sem.release();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class DecrementShared extends Thread {
	Semaphore sem;

	public DecrementShared(Semaphore sem) {
		this.sem = sem;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				sem.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			--Shared.count;
			System.out.println("DecrementShared: " + Shared.count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sem.release();
		}
	}
}

public class SemaphoreTest {

	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(1);
		IncrementShared incShared = new IncrementShared(semaphore);
		DecrementShared decShared = new DecrementShared(semaphore);
		decShared.start();
		incShared.start();
	}
}
