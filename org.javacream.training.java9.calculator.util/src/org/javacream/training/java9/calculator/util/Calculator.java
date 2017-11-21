package org.javacream.training.java9.calculator.util;

import org.javacream.training.java9.calculator.util.impl.CircleCalculator;
import org.javacream.training.java9.calculator.util.impl.SimpleCalculator;

public class Calculator {

	private SimpleCalculator simpleCalculator;
	private CircleCalculator circleCalculator;
	{
		simpleCalculator = new SimpleCalculator();
		circleCalculator = new CircleCalculator();
	}

	public double calculate(String operation, double... params) {
		switch (operation) {
		case "plus":
			return simpleCalculator.plus(params[0], params[1]);
		case "minus":
			return simpleCalculator.minus(params[0], params[1]);
		case "area":
			return circleCalculator.area(params[0]);
		case "perimeter":
			return circleCalculator.perimeter(params[0]);
		default:
			throw new UnsupportedOperationException(operation);
		}
	}
}
