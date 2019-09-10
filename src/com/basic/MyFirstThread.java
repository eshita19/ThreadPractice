package com.basic;

class Runner extends Thread{
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			System.out.println("Hello: " + i);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public class MyFirstThread {

	public static void main(String[] args) {
		Runner t1 = new Runner();
		t1.start();
		
		Runner t2 = new Runner();
		t2.start();
		
		Thread t3 = new Thread(() -> {
			for(int i=0;i<10 ;i++){
				System.out.println("Hi from runnable " + i);
			}
		});
		t3.start();
	}
}
