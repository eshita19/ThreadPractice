package com.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Shared {
	int count = 0;
}

class LockTestThread extends Thread {
	private Lock lock = new ReentrantLock();
	private Shared shared ;
	private String name;

	LockTestThread(String name, Shared shared) {
		this.name = name;
		this.shared = shared;
	}

	@Override
	public void run() {
		try {
			System.out.println("Thread : " + name + " Waiting to acquire lock... ");
			lock.lock();
			shared.count++;
			System.out.println("Thread : " + name + "Increment count.. " + shared.count);
			Thread.sleep(1000l);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
}

public class ReentrantLockEx {
	public static void main(String[] args) {
		System.out.println("Starting 15 threads to increment count, Count value should be 15");
		Shared shared = new Shared();
		for(int i=0;i<15;i++){
			new LockTestThread(i + "", shared).start(); 
		}
	}

}
