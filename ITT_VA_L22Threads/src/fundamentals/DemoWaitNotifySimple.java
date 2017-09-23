package fundamentals;

import java.util.concurrent.ConcurrentLinkedQueue;

public class DemoWaitNotifySimple {
	public static class Store {
		public static final int MAX = 50;
		public static final int MIN = 0;
		private ConcurrentLinkedQueue<Object> items = new ConcurrentLinkedQueue<>();

		public synchronized void addItem(Object o) {
			if (items.size() >= MAX) {
				try {
					System.out.println("Store is full!");
					wait();
				} catch (InterruptedException e) {
					System.out.println("Interupted!");
				}
			}
			System.out.println(Thread.currentThread().getName()+" add item!");
			items.add(o);
			notifyAll();
		}

		public synchronized Object removeItem() {
			if (items.size() == MIN) {
				try {
					System.out.println("Store is empty!");
					wait();
				} catch (InterruptedException e) {
					System.out.println("Interupted!");
				}
			}
			System.out.println(Thread.currentThread().getName()+" remove item!");
			Object o = items.poll();
			notifyAll();
			return o;
		}
	}

	public static void main(String[] args) {
		Store store = new Store();
		
		Thread producer = new Thread(()->{
			while(true) {
				store.addItem(new Object());
			}
		},"Producer");
		Thread consumer = new Thread(()->{
			while(true) {
				@SuppressWarnings("unused")
				Object o =store.removeItem();
			}
		},"Consumer");
		producer.start();
		consumer.start();
	}
}
