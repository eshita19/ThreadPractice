package com.basic;

public class FixThreadInterleaving {
	private int count = 0;

	public static void main(String[] args) throws InterruptedException {
		FixThreadInterleaving f1 = new FixThreadInterleaving();
		f1.doWork();
	}

	public synchronized void incrementCount() {
		count++;
	}

	private void doWork() throws InterruptedException {
		Runnable r1 = () -> {
			for (int i = 0; i < 10000; i++) {
				incrementCount();
			}
		};

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Count : " + count);
	}
}
