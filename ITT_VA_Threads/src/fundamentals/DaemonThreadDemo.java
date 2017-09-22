package fundamentals;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class DaemonThreadDemo {
	public static class Bills {
		private AtomicBoolean isPayed = new AtomicBoolean(false);

		public synchronized void payBill() {
			if (isPayed.get()) {
				try {
					wait();
				} catch (InterruptedException e) {
					System.out.println("Somebody interrupt me!");
				}
			}
			isPayed.set(true);
			System.out.println(Thread.currentThread().getName() + ": I have payed my Bills today");
		}

		public synchronized void addBill() {
			if (!isPayed.get()) {
				System.out.println(Thread.currentThread().getName() + ": You haven't paid your bills!");
			}
			isPayed.set(false);
			notifyAll();
		}
	}

	public static class Person implements Runnable {
		private Bills bills = new Bills();
		private String name;

		public Person(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			while (true) {
				bills.payBill();
			}
		}
		public String getName() {
			return name;
		}
	}

	public static class Nap implements Runnable {
		private ArrayList<Person> citizens = new ArrayList<>();
		private static final int PERIOD = 5000;

		public Nap(Person... persons) {
			for (Person p : persons) {
				citizens.add(p);
			}
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(PERIOD);
				} catch (InterruptedException e) {
					System.out.println("who the hell dares to break NAP work?!");
				}
				System.out.println("A new month is coming...");
				for (Person p : citizens) {
					p.bills.addBill();
				}
			}
		}
	}

	public static void main(String[] args) {
		Person ivancho = new Person("Ivan");
		Person mariika = new Person("Maria");
		Thread ivan = new Thread(ivancho, ivancho.getName());
		Thread maria = new Thread(mariika, mariika.getName());
		Thread nap = new Thread(new Nap(ivancho, mariika), "Nap");
		nap.setDaemon(true);
		ivan.start();
		maria.start();
		nap.start();
	}
}
