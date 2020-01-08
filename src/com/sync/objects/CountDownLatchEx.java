package com.sync.objects;

import java.util.concurrent.CountDownLatch;

class MyThread  extends Thread{
	private CountDownLatch latch;
	
	MyThread(CountDownLatch latch){
		this.latch = latch;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println("Inside thread iteration" + i);
			latch.countDown();
		}
	}
}

public class CountDownLatchEx {
	private static CountDownLatch latch = new CountDownLatch(2);
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatchEx countDownLatchEx = new CountDownLatchEx();
		MyThread myThread = new MyThread(latch);
		myThread.start();
		latch.await(); // Wait till latch counter becomes zero
		System.out.println("Completed waiting");
	}

}
