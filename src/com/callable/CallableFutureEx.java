package com.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Sum implements Callable<Integer> {
	private int a, b;

	Sum(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Inside Sum thread");
		Thread.sleep(4000l);
		return a + b;
	}
}

class Subtract implements Callable<Integer> {
	private int a, b;

	Subtract(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Inside Sub thread");
		Thread.sleep(4000l);
		return a - b;
	}
}

public class CallableFutureEx {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService execService = Executors.newCachedThreadPool();
		Future<Integer> sumVal = execService.submit(new Sum(300, 400));
		Future<Integer> subVal = execService.submit(new Subtract(300, 400));
		System.out.println("Submitted threads...");
		System.out.println("Sum value: " + sumVal.get());
		System.out.println("Sub value: " + subVal.get());
		execService.shutdown();
	}
}
