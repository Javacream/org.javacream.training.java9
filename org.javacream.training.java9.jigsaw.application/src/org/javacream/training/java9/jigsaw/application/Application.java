package org.javacream.training.java9.jigsaw.application;

import java.util.List;

import org.javacream.training.java9.jigsaw.publisher.impl.MessagePublisher;

public class Application {

	public static void main(String[] args) {
		MessagePublisher messagePublisher = new MessagePublisher();
		List.of("A", "H", "C").forEach(messagePublisher::submit);
	}

}
