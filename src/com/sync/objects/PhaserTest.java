package com.sync.objects;

import java.util.concurrent.Phaser;

/**
 * Phaser allows synchronization of threads which have multiple phases. All the
 * threads will be paused untill a phase of all threads is completed.
 * 
 * @author emathur
 *
 */
class PhaserThread extends Thread {
	Phaser phaser;
	String name;

	PhaserThread(Phaser phaser, String name) {
		this.name = name;
		this.phaser = phaser;
		phaser.register(); // Register to phaser
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 2; i++) {
				System.out.println("Inside " + this.name + " Phase: " + phaser.getPhase());
				Thread.sleep(1000);
				phaser.arriveAndAwaitAdvance();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class PhaserTest {

	public static void main(String[] args) throws InterruptedException {
		Phaser phaser = new Phaser();
		phaser.register();

		new PhaserThread(phaser, "A").start();
		new PhaserThread(phaser, "B").start();
		new PhaserThread(phaser, "C").start();

		for (int i = 0; i < 2; i++) {
			System.out.println("Main thread: Phase: " + phaser.getPhase());
			Thread.sleep(1000);
			phaser.arriveAndAwaitAdvance();
		}

	}
}
