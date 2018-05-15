package org.javacream.training.java9.jigsaw.helloworld.impl2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.javacream.training.java9.jigsaw.helloworld.HelloMessage;
import org.javacream.training.java9.jigsaw.helloworld.HelloResponse;
import org.javacream.training.java9.jigsaw.helloworld.HelloWorld;

public class AlternativeConsoleHelloWorld implements HelloWorld {

	@Override
	public HelloResponse sayHello(HelloMessage message) {
		Log log = LogFactory.getLog(AlternativeConsoleHelloWorld.class);
		
		log.info(new StringBuilder(message.getMessage()).reverse().toString());
		return new HelloResponse("OK");
	}

	
}
