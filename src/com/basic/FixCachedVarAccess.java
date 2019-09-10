package com.basic;

public class FixCachedVarAccess extends Thread {
	// Declared Volatile to not maintain cached copy of variable
	private volatile boolean running = true;
	public void run() {
		while (running) {
			System.out.println("Inside loop");
		}
		System.out.println("Outside loop");
	}
	
	public void setRunning(boolean running){
		this.running = running;
	}

	public static void main(String[] args) throws InterruptedException {
		FixCachedVarAccess fixCachedVarAccess = new FixCachedVarAccess();
		fixCachedVarAccess.start();
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(3000);
				fixCachedVarAccess.setRunning(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("t1 woke up and now shutting down 'Inside loop' call");

		});
		t1.start();
		t1.join();
	}
}
