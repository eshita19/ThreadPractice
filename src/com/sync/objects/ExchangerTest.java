package com.sync.objects;

import java.util.concurrent.Exchanger;

class ProdThread extends Thread{
	private Exchanger<String> exchanger;
	private  String str  = "";
	int maxSize = 10;
	ProdThread(Exchanger<String> exchanger){
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		try {
			while (true) {
				str += "a";
				if (str.length() == 10) {
					System.out.println("Prod thread set str: " + str);
					str = exchanger.exchange(str);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ConThread extends Thread{
	private Exchanger<String> exchanger;
	private  String str  = "";
	ConThread(Exchanger<String> exchanger){
		this.exchanger = exchanger;
	}
	@Override
	public void run() {
		try {
			while (true) {
					str = exchanger.exchange(new String());
					System.out.println("Consumer thread got str: "  + str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class ExchangerTest {
	private static Exchanger<String> exchanger = new Exchanger<String>();
	public static void main(String[] args) {
		new ProdThread(exchanger).start();
		new ConThread(exchanger).start();
	}
}
