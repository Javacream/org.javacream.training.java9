package org.javacream.training.java8.language.functional;

public class SimpleCallbackImpl implements SimpleCallback {

	@Override
	public boolean execSimpleCallback(String message, Integer counter) {
		System.out.println("TOP-LEVEL: message: " + message + ", counter=" + counter);
		return (counter%2 ==0);
	}

}
