package org.javacream.training.java8.language.functional;

import java.util.HashMap;

public class StringTransformer {

	HashMap<String, StringTransformerAlgorithm> algorithms;

	{
		algorithms = new HashMap<>();
		algorithms.put("identity", (String input) -> {
			return input;
		});
		algorithms.put("toLower", (String input) -> {
			return input.toLowerCase();
		});
		algorithms.put("complex", new ComplexStringTransformer());
	}

	public String transform(String algorithName, String input) {
		return algorithms.get(algorithName).transform(input);
	}

	public void register(String algorithName, StringTransformerAlgorithm algorithm) {
		algorithms.put(algorithName, algorithm);
	}

	public static void main(String[] args) {
		StringTransformer st = new StringTransformer();
		st.register("toUpper", input -> input.toUpperCase());
	}
}
