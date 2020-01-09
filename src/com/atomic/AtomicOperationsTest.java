package com.atomic;

import java.util.concurrent.atomic.AtomicInteger;

class ThreadForAtomicOp extends Thread {
	private AtomicInteger atomicInteger;
	private String name;

	public ThreadForAtomicOp(AtomicInteger atomicInteger, String name) {
		this.atomicInteger = atomicInteger;
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("name:" + name + "  Got:  " + atomicInteger.getAndSet(i));
		}
	}
}

public class AtomicOperationsTest {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		for (int i = 0; i < 15; i++) {
			new ThreadForAtomicOp(atomicInteger, i + "").start();
		}
	}

}
