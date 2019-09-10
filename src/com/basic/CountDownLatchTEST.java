package com.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{
	private CountDownLatch latch;
	private int id;
	
	public Processor(CountDownLatch latch, int id) {
		this.latch = latch;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Creating thread");
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
	}
	
	
}

public class CountDownLatchTEST {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService service = Executors.newFixedThreadPool(2);
		for(int i=0 ; i <2; i++){
			service.submit(new Processor(latch, i));
		}
		latch.await();
		System.out.println("Latch became 0");
	}
}
