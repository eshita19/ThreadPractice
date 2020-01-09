package com.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class ThreadForSchdPool extends Thread {
	private String name;

	public ThreadForSchdPool(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println("Inside thread: " + this.name);
			Thread.sleep(1000l);
			System.out.println("Completed thread: " + this.name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ScheduledThreadPoolExecutor {
	public static void main(String[] args) {
		ScheduledExecutorService execService = Executors.newScheduledThreadPool(2);
		execService.schedule(new ThreadForSchdPool("A"), 1000l, TimeUnit.MINUTES);
	}
}
