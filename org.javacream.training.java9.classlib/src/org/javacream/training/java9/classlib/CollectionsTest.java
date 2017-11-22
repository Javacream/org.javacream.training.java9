package org.javacream.training.java9.classlib;

import java.util.List;

import org.junit.Test;

public class CollectionsTest {

	@Test public void testFactoryMethods() {
		List<String> names = List.of("This", "and", "That");
		names.forEach((e) -> System.getLogger("").log(System.Logger.Level.INFO, e));
	}

}
