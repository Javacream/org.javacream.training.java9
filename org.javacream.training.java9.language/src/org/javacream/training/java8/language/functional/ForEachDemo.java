package org.javacream.training.java8.language.functional;

import java.util.List;
import java.util.function.Consumer;

public class ForEachDemo {

	public static void main(String[] args) {
		List<String> names = List.of("Hugo", "Emil", "Franz");
		System.out.println(names.getClass().getName());
		for (String name: names) {
			//OLD
		}
		names.forEach((String element) -> System.out.println(element));
		names.forEach(element -> System.out.println(element));
		Consumer<String> c = System.out::println;
		names.forEach(c);
		
		
		
	}
}
