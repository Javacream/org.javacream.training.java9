package org.javacream.training.java9.classlib.flow;

import java.util.concurrent.ForkJoinPool;

public class Application {
	public static void main(String[] args) throws Exception {
		demoOneSubscriber();
		demoTwoSubscribers();
	}

	static void demoOneSubscriber() {

		RangePublisher publisher = new RangePublisher(42, 46, ForkJoinPool.commonPool());

		SimpleSubscriber<Integer> subsriber = new SimpleSubscriber<>(1000);

		System.out.println("subscribe");
		publisher.subscribe(subsriber);

		System.out.println("await");
		subsriber.await();
		System.out.println("terminating");
	}

	static void demoTwoSubscribers() {

		RangePublisher publisher = new RangePublisher(42, 46, ForkJoinPool.commonPool());

		SimpleSubscriber<Integer> subsriber1 = new SimpleSubscriber<>(1000);
		SimpleSubscriber<Integer> subsriber2 = new SimpleSubscriber<>(1500);

		System.out.println("subscribe");
		publisher.subscribe(subsriber1);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("subscribe");
		publisher.subscribe(subsriber2);

		System.out.println("await");
		subsriber1.await();
		System.out.println("await");
		subsriber2.await();
		System.out.println("terminating");
	}
}
