package org.javacream.training.java9.classlib;

import org.junit.Test;

public class StackwalkerTest {

	@Test public void testStackWalker() {
		StackWalker stackWalker = StackWalker.getInstance();
		stackWalker.forEach((stack) -> System.out.println(stack.getMethodName()));
	}
}
