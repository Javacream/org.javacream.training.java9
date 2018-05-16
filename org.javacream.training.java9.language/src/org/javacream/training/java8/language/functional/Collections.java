package org.javacream.training.java8.language.functional;

import java.util.List;
import java.util.stream.Stream;

public class Collections {

	public static void main(String[] args) {
		List<String> names = List.of("Hugo", "Emil", "Franz");
		Stream<String> namesStream = names.stream();
		namesStream = namesStream.filter(element -> element.startsWith("H"));
		namesStream.forEach(System.out::println);
		
	}
}
