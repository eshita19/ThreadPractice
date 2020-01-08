package com.sync.objects;

import java.util.concurrent.Semaphore;

class Producer extends Thread {
	private SemaphorePC semaphorePC;

	Producer(SemaphorePC semaphorePC) {
		this.semaphorePC = semaphorePC;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				semaphorePC.setCount();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Consumer extends Thread {
	private SemaphorePC semaphorePC;

	Consumer(SemaphorePC semaphorePC) {
		this.semaphorePC = semaphorePC;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				semaphorePC.getCount();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class SemaphorePC {
	int count = 0;
	private Semaphore semaphoreC = new Semaphore(1);
	private Semaphore semaphoreP = new Semaphore(0);

	public static void main(String[] args) throws InterruptedException {
		SemaphorePC semaphorePC = new SemaphorePC();
		Producer producer = new Producer(semaphorePC);
		Consumer consumer = new Consumer(semaphorePC);
		producer.start();
		consumer.start();
	}

	public Semaphore getSemaphoreC() {
		return semaphoreC;
	}

	public Semaphore getSemaphoreP() {
		return semaphoreP;
	}
	
	public void getCount() throws InterruptedException{
		semaphoreC.acquire(); //Decrement consumer semaphore count by 1
		System.out.println("Consumer count: " + this.count);
		semaphoreP.release();//Increment producer semaphore count by 1 - Producer  eligible
	}
	public void setCount() throws InterruptedException{
		semaphoreP.acquire(); // Decrement Producer semaphore count by 1
		System.out.println("Prodcuer count: " + ++this.count);
		semaphoreC.release(); // Increment consumer semaphore count by 1 - Consumer  eligible
	}
	
}
