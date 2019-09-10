package com.basic;

import java.util.LinkedList;
import java.util.List;

/*Synchronized on a method will obtain an object lock to this object. But we don't need 
 * a common lock on methods accessing different instance variables.
 * Hence create multiple lock objects.
 */
class Worker {
	List<Integer> list1 = new LinkedList<>();
	List<Integer> list2 = new LinkedList<>();
	Object lock1 = new Object();
	Object lock2 = new Object();

	public void processList1() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lock1) {
				list1.add(100);
			}
		}
	}

	public void processList2() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lock2) {
				list2.add(100);
			}
		}
	}

	public void processList() {
		processList1();
		processList2();
	}

	public void display() {
		System.out.println("List size: " + list1.size() + " " + list2.size());
	}
}

public class FixThreadInterLeaving2 {
	public static void main(String[] args) {
		Worker worker = new Worker();
		Runnable r1 = () -> worker.processList();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		Long before = System.currentTimeMillis();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Time taken to complete: " + (System.currentTimeMillis() - before));
		worker.display();
	}
}
