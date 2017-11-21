package org.javacream.training.java9.calculator.app;

import org.javacream.training.java9.calculator.util.Calculator;

public class SimpleCalculatorApp {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.println(calculator.calculate("plus", 21, 21));
		System.out.println(calculator.calculate("perimeter", 21));
		
	}
}
