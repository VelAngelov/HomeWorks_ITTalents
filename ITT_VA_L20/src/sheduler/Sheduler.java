package sheduler;

import java.util.LinkedList;
import java.util.Queue;

public class Sheduler {
	private Queue<Task> opashka;

	public void push(Task task) {
		opashka.offer(task);
	}

	public Sheduler() {
		opashka = new LinkedList<>();
	}

	public static void main(String[] args) {
		Sheduler workFlow = new Sheduler();
		Task[] tasks = new Task[4];
		tasks[0] = (s) -> System.out.println("Working on :" + s);
		tasks[1] = (s) -> System.out.println("Finish with task :" + s);
		tasks[2] = (s) -> {
			System.out.print("Start with task :" + s);
			System.out.println(" and ends it");
		};
		tasks[3] = new Task() {
			public void doWork(String s) {
				System.out.println("Final work :" + s + " is finished");
			}
		};
		workFlow.push(tasks[0]);
		workFlow.push(tasks[1]);
		workFlow.push(tasks[2]);
		workFlow.push(tasks[3]);
		workFlow.opashka.poll().doWork("finding solutions for the problem");
		workFlow.opashka.poll().doWork("choose the best solution");
		workFlow.opashka.poll().doWork("writing choosen solution");
		workFlow.opashka.poll().doWork("test the solution and make conclusions");
	}

}
