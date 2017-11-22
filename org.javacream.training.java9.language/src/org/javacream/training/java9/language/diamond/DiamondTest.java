package org.javacream.training.java9.language.diamond;

import java.util.ArrayList;
import java.util.function.Function;

import org.junit.Test;

public class DiamondTest {
	@Test
	public void demo() {
		ArrayList<String> names = new ArrayList<>();
		System.out.println(names);
		ArrayList<String> names2 = new ArrayList<>() {
			private static final long serialVersionUID = 1L;
			
		};
		System.out.println(names2);
		demoProvider(new Function<>() {

			@Override
			public String apply(String s) {
				return s.toUpperCase();
			}
		});

		demoProvider((s) -> s.toUpperCase());
	}
	
	private void demoProvider(Function<String, String> f) {
		System.out.println(f.apply("Hugo"));
	}
}
