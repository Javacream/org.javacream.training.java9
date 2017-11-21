package org.javacream.training.java9.calculator.util.test;

import org.javacream.training.java9.calculator.util.impl.SimpleCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleCalculatorTest {

	@Before
	public void init() {
		simpleCalculator = new SimpleCalculator();
	}

	private SimpleCalculator simpleCalculator;

	@Test
	public void testSimpleCalculator() {
		Assert.assertEquals(42, simpleCalculator.plus(1, 41), 1e-9);

	}
}
