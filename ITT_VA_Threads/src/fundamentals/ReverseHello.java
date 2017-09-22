package fundamentals;

import java.util.concurrent.atomic.AtomicInteger;

public class ReverseHello implements Runnable {
	public static final int MAX_THREADS = 50;
	private AtomicInteger numberOfThreads = new AtomicInteger();

	@Override
	public void run() {
		if (numberOfThreads.get() >= MAX_THREADS) {
			return;
		} else {
			numberOfThreads.addAndGet(1);
			Thread newThread = new Thread(() -> {
				System.out.print("Hello form thread ");
			});
			run();
			synchronized (this) {
				newThread.start();
				try {
					newThread.join();
					System.out.println(newThread.getName());
				} catch (InterruptedException e) {
					System.out.println("oops");
				}
			}
		}
	}

	public static void main(String[] args) {
		Thread t = new Thread(new ReverseHello());
		t.start();
	}
}
