package fundamentals;

import java.util.concurrent.atomic.AtomicBoolean;

public class Wrapper {
	private AtomicBoolean something = new AtomicBoolean(true);

	public synchronized void addSomething() {
		if (!something.get()) {
			something.set(true);
			System.out.println(Thread.currentThread().getName() + " add item");
			notifyAll();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("interupted");
			}
		}
	}

	public synchronized void removeSomething() {
		if (something.get()) {
			something.set(false);
			System.out.println(Thread.currentThread().getName() + " remove item");
			notifyAll();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("interupted");
			}
		}
	}
}
