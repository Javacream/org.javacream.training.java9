package org.javacream.training.java9.jigsaw.helloworld.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.javacream.training.java9.jigsaw.helloworld.HelloMessage;
import org.javacream.training.java9.jigsaw.helloworld.HelloResponse;
import org.javacream.training.java9.jigsaw.helloworld.HelloWorld;

public class ConsoleHelloWorld implements HelloWorld {

	@Override
	public HelloResponse sayHello(HelloMessage message) {
		Log log = LogFactory.getLog(ConsoleHelloWorld.class);
		
		log.info(message);
		return new HelloResponse("OK");
	}

	
}
