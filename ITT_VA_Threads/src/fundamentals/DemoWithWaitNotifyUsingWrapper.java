package fundamentals;

public class DemoWithWaitNotifyUsingWrapper {
	public static void main(String[] args) {
		Wrapper item = new Wrapper();
		Thread producer = new Thread(() -> {
			while (true) {
				item.addSomething();
			}
		});
		Thread consumer = new Thread(() -> {
			while (true) {
				item.removeSomething();
			}
		});
		producer.setName("Producer");
		consumer.setName("Consumer");
		producer.start();
		consumer.start();
	}
}
