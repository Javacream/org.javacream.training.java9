package org.javacream.training.java9.classlib;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

public class CompletableFutureWorkflowTest {
	@Test
	public void doWorkflow() {
		CompletableFuture<Double> f1 = new CompletableFuture<>();
		CompletableFuture<Double> f2 = new CompletableFuture<>();
		CompletableFuture<Double> f3 = f1.thenApplyAsync(x -> x * x);
		CompletableFuture<Double> f4 = f2.thenApplyAsync(x -> x * x);
		CompletableFuture<Double> f5 = f3.thenCombine(f4, (x, y) -> x + y);
		CompletableFuture<Double> f6 = f5.thenApply(x -> Math.sqrt(x));
		f1.complete(3.0);
		f2.complete(4.0);
		try {
			double result = f6.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e);
		}
	}
}
