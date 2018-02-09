package org.javacream.training.java9.jigsaw.subscriber1;

import java.util.concurrent.Flow.Subscription;

import org.javacream.training.java9.jigsaw.publisher.StringSubscriber;

public class SimpleSubscriber1 implements StringSubscriber{

	private Subscription subscription;

	@Override
	public void onComplete() {
		System.out.println("Completing...");
	}

	@Override
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@Override
	public void onNext(String message) {
		System.out.println(this + " receives message " + message);
		subscription.request(1);
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		subscription.request(1);
	}

}
