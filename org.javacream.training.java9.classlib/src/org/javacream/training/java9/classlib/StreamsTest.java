package org.javacream.training.java9.classlib;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamsTest {

	@Test
	public void testList() {
		List<String> names = List.of("Hugo", "Emil", "Fritz");
		process(names.stream());
	}
	@Test
	public void testOptionalNotNull() {
		Optional<String> value = Optional.of("Value");
		process(value.stream());
	}
	@Test
	public void testOptionalNull() {
		Optional<String> value = Optional.empty();
		process(value.stream());
	}

	private void process(Stream<String> stream) {
		stream.map((s)->s.toUpperCase()).forEach(System.out::println);
	}
	
}
