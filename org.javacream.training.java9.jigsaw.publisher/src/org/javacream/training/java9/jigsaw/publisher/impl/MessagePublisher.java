package org.javacream.training.java9.jigsaw.publisher.impl;

import java.util.ServiceLoader;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;

import org.javacream.training.java9.jigsaw.publisher.StringSubscriber;

public class MessagePublisher {
	private SubmissionPublisher<String> publisher;

	{
		Executor executor = Executors.newFixedThreadPool(2);
		publisher = new SubmissionPublisher<>(executor, 100);
		ServiceLoader<StringSubscriber> loader = ServiceLoader.load(StringSubscriber.class);
		loader.forEach(publisher::subscribe);
	}
	public int submit(String message) {
		return publisher.submit(message);
	}

//	public void subscribe(Subscriber<? super String> stringSubscriber) {
//		publisher.subscribe(stringSubscriber);
//	}

}
