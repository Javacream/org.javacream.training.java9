package org.javacream.training.java8.language.functional;

public class SimpleImpl {

	public static void main(String[] args) {
		SimpleCallback sci = new SimpleCallbackImpl();
		new SimpleImpl().doSomething("Hello", sci);
		SimpleCallback sci2 = new InnerClassSimpleCallbackImpl();
		new SimpleImpl().doSomething("Hello", sci2);
		class MethodClassSimpleCallbackImpl implements SimpleCallback {

			@Override
			public boolean execSimpleCallback(String message, Integer counter) {
				System.out.println("Method Class: message: " + message + ", counter=" + counter);
				return (counter%2 ==0);
			}

		}
		SimpleCallback sci3 = new MethodClassSimpleCallbackImpl();
		new SimpleImpl().doSomething("Hello", sci3);
		SimpleCallback sci4 = new SimpleCallback() {
			
			@Override
			public boolean execSimpleCallback(String message, Integer counter) {
				System.out.println("Anonymous Class: message: " + message + ", counter=" + counter);
				return (counter%2 ==0);
			}
		};
		new SimpleImpl().doSomething("Hello", sci4);
		new SimpleImpl().doSomething("Hello", new SimpleCallback() {
			
			@Override
			public boolean execSimpleCallback(String message, Integer counter) {
				System.out.println("Anonymous2 Class: message: " + message + ", counter=" + counter);
				return (counter%2 ==0);
			}
		});
		SimpleCallback sci5 = (String message, Integer counter) -> {
			System.out.println("Functional: message: " + message + ", counter=" + counter);
			return (counter%2 ==0);
		};
		new SimpleImpl().doSomething("Hello", sci5);
		new SimpleImpl().doSomething("Hello", (String message, Integer counter) -> {
			System.out.println("Functional 2: message: " + message + ", counter=" + counter);
			return (counter%2 ==0);
		});
	
	}

	private void doSomething(String message, SimpleCallback cb) {
		for (int i = 0; i < 2; i++) {
			System.out.println(cb.execSimpleCallback(message, i));
		}
	}
	static class InnerClassSimpleCallbackImpl implements SimpleCallback {

		@Override
		public boolean execSimpleCallback(String message, Integer counter) {
			System.out.println("Inner Class: message: " + message + ", counter=" + counter);
			return (counter%2 ==0);
		}

	}

}
