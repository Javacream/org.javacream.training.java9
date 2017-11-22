package org.javacream.training.java9.classlib.flow;

import java.util.concurrent.Executor;
import java.util.concurrent.Flow;

public final class RangePublisher implements Flow.Publisher<Integer> {

	static final class RangeSubscription implements Flow.Subscription, Runnable {

		private final Flow.Subscriber<? super Integer> subscriber;
		private final int end;
		private final int start;
		private final Executor executor;
		private boolean isCanceled = false;

		private RangeSubscription(Flow.Subscriber<? super Integer> subscriber, int start, int end, Executor executor) {
			this.subscriber = subscriber;
			this.start = start;
			this.end = end;
			this.executor = executor;
			this.executor.execute(this);
		}

		@Override
		public void request(long nItems) {
			assert nItems == 1; // restriction of this simple solution!
			System.out.println("request " + 1);

		}

		@Override
		public void cancel() {
			this.isCanceled = true;
		}

		@Override
		public void run() {
			System.out.println(">> run");
			this.subscriber.onSubscribe(this);
			for (int value = this.start; value <= this.end; value++) {
				if (this.isCanceled)
					break;
				this.subscriber.onNext(value);
			}
			this.subscriber.onComplete();
			System.out.println("<< run");
		}
	}

	private final int start;
	private final int end;
	private final Executor executor;

	public RangePublisher(int start, int end, Executor executor) {
		this.start = start;
		this.end = end;
		this.executor = executor;
	}

	@Override
	public void subscribe(Flow.Subscriber<? super Integer> subscriber) {
		new RangeSubscription(subscriber, this.start, this.end, this.executor);
	}
}