package org.javacream.training.java8.language.functional;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ClosuresDemo {

	public static void main(String[] args) {
		new ClosuresDemo();
	}
	
	{
		Supplier<String> result = doSomething();
		System.out.println("Result: " + result.get());
		ArrayList<Supplier<String>> fns = new ArrayList<>();
		for (Integer i = 0; i < 5; i++) {
			fns.add(doSomething(i));
		}
		for (Supplier<String> fn: fns) {
			System.out.println(fn.get());
		}
		
		System.out.println(fns.get(3).get());
	}
	
	public Supplier<String> doSomething() {
		String message = "OK";
		Supplier<String>  fn = () -> {System.out.println("In function: "); return "Inner: " + message;};
		return fn;
	}
	
	public Supplier<String> doSomething(Integer i) {
		Supplier<String>  fn = () -> {System.out.println("In function: "); return "Inner: " + i;};
		return fn;
	}
	
}
