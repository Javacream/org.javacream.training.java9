package org.javacream.training.java9.classlib.flow;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;


public class SimpleSubscriber<T> implements Subscriber<T> {
	
	private final CountDownLatch done = new CountDownLatch(1);

	private final int sleeptime;
	private Subscription subscription;

	public SimpleSubscriber(int sleeptime) {
		this.sleeptime = sleeptime;
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		System.out.println("onSubscribe " + subscription);
		this.subscription = subscription;
		subscription.request(1); 
	}

	@Override
	public void onNext(T item) {
		System.out.println("onNext " + item);
//		if (item.equals(45))
//			this.subscription.cancel();
	    try {
			Thread.sleep(this.sleeptime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	this.subscription.request(1); 
	}

	@Override
	public void onError(Throwable t) {
		System.out.println("onError " + t);
		done.countDown();
	}

	@Override
	public void onComplete() {
		System.out.println("onComplete");
		done.countDown();
	}
	
	public void await() {
		try {
			done.await();
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}