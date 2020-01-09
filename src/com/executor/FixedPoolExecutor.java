package com.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Inside thread: A
Inside thread: B
Completed thread: B
Completed thread: A
Inside thread: C
Inside thread: D
Completed thread: C
Completed thread: D
 * @author emathur
 *
 */
class ThreadForPool extends Thread {
	String name;

	ThreadForPool(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println("Inside thread: " + name);
			Thread.sleep(1000l);
			System.out.println("Completed thread: " + name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class FixedPoolExecutor {
	public static void main(String[] args) {
		//Fixed thread pool of size 2
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new ThreadForPool("A"));
		service.execute(new ThreadForPool("B"));
		service.execute(new ThreadForPool("C"));
		service.execute(new ThreadForPool("D"));
		
	}
}
