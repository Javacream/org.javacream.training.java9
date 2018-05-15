package org.javacream.training.java9.jigsaw.demo;

import java.util.ServiceLoader;

import org.javacream.training.java9.jigsaw.helloworld.HelloMessage;
import org.javacream.training.java9.jigsaw.helloworld.HelloWorld;

public class HelloWorldActor {

	public static void main(String[] args) {
		ServiceLoader<HelloWorld> loader = ServiceLoader.load(HelloWorld.class);
		for(HelloWorld hw : loader) {
			hw.sayHello(new HelloMessage("Hello"));
		}
	}

}
